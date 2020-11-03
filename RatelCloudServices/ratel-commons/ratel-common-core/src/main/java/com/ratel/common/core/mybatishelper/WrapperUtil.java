package com.ratel.common.core.mybatishelper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import java.lang.reflect.Field;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.ratel.common.core.constants.SqlConstant;
import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.enums.StatusCodeEnum;
import com.ratel.common.core.exception.BizException;
import com.ratel.common.core.form.ObjectPair;
import com.ratel.common.core.form.QueryForm;
import com.ratel.common.core.utils.DateUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * RatelCloud
 * @ClassName: WrapperUtil
 * @Package: com.ratel.common.core.mybatishelper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: TODO
 * @Version: 1.0
 */
public class WrapperUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WrapperUtil.class);

    public static final String SIDX_SEPARATOR = ",";

    public static <T> QueryWrapper<T> toWrapper(QueryForm<T> form) {
        return toWrapper(form, false);
    }

    public static <T> QueryWrapper<T> toWrapper(QueryForm<T> form, boolean allowSqlFilter) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        List<ObjectPair<Field, QueryField>> fields = getQueryFields(form.getClass());
        fields.forEach((pair) -> {
            QueryField queryField = pair.getRight();
            String fieldName = pair.getLeft().getName();
            Object fieldValue = getFieldValueByName(fieldName, form);
            if (!(isBlank(fieldValue))) {
                String tableAlias = queryField.tableAlias();
                String column = StringUtils.isEmpty(queryField.column()) ? fieldName : queryField.column();
                column = StringUtils.camelToUnderline(column);
                if (StringUtils.isNotEmpty(tableAlias)) {
                    column = tableAlias + "." + column;
                }
                appendWrapper(wrapper, column, fieldValue, queryField.condition());
            }
        });
        if (allowSqlFilter) {
            wrapper.apply(StringUtils.isNotEmpty(form.getSqlFilter()), form.getSqlFilter());
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(form.getSidx())
                && org.apache.commons.lang3.StringUtils.isNotBlank(form.getOrder())) {
            String[] sidxArr = form.getSidx().split(SIDX_SEPARATOR);
            for (int i = 0; i < sidxArr.length; i++) {
                String sidx = sidxArr[i];
                sidxArr[i] = StringUtils.camelToUnderline(sidx);
            }
            if ("ASC".equalsIgnoreCase(form.getOrder())) {
                wrapper.orderByAsc(sidxArr);
            } else {
                wrapper.orderByDesc(sidxArr);
            }
        }
        return wrapper;
    }

    public static <T> QueryWrapper<T> toWrapper(Map<String, Object> params, Class<T> clz, boolean allowSqlFilter) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(clz);
        //createTimeRange(wrapper, params);

        if (allowSqlFilter) {
            String dataFilter = (String) params.remove(SqlConstant.SQL_FILTER);
            wrapper.apply(org.apache.commons.lang3.StringUtils.isNotBlank(dataFilter), dataFilter);
        }

        params.entrySet().forEach((entry) -> {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!isBlank(value)) {
                String property = key;
                RelationEnum relationEnum = RelationEnum.EQUAL;
                if (key.startsWith("params[begin")) {
                    relationEnum = RelationEnum.GREATER_THAN_OR_EQUAL;
                    property = key.substring(12, key.length() - 1);
                    try {
                        value = DateUtil.parseStartOfDay(String.valueOf(value));
                    } catch (Exception ex) {
                        LOGGER.warn("Date param error:" + value);
                    }
                } else if (key.startsWith("params[end")) {
                    relationEnum = RelationEnum.LESS_THAN_OR_EQUAL;
                    property = key.substring(10, key.length() - 1);
                    try {
                        value = DateUtil.parseEndOfDay(String.valueOf(value));
                    } catch (Exception ex) {
                        LOGGER.warn("Date param error:" + value);
                    }
                } else if (key.endsWith("NE")) {
                    relationEnum = RelationEnum.NOT_EQUAL;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("IN")) {
                    relationEnum = RelationEnum.IN;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("GT")) {
                    relationEnum = RelationEnum.GREATER_THAN;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("GE")) {
                    relationEnum = RelationEnum.GREATER_THAN_OR_EQUAL;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("LT")) {
                    relationEnum = RelationEnum.LESS_THAN;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("LE")) {
                    relationEnum = RelationEnum.LESS_THAN_OR_EQUAL;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("LK")) {
                    relationEnum = RelationEnum.LIKE;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("LL")) {
                    relationEnum = RelationEnum.LIKE_LEFT;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("LR")) {
                    relationEnum = RelationEnum.LIKE_RIGHT;
                    property = key.substring(0, key.length() - 2);
                } else if (key.endsWith("FD")) {
                    relationEnum = RelationEnum.FIND_IN_SET;
                    property = key.substring(0, key.length() - 2);
                }
                String column = getColumn(tableInfo, property);
                if (null != column) {
                    appendWrapper(wrapper, column, value, relationEnum);
                }
            }
        });
        return wrapper;
    }

    /**
     * 根据属性名获取属性值
     *
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(o.getClass(), fieldName);
        Object value = null;
        try {
            value = pd.getReadMethod().invoke(o, new Object[0]);
        } catch (Exception ex) {
            LOGGER.debug(ex.getMessage(), ex);
        }
        return value;
    }

    private static List<ObjectPair<Field, QueryField>> getQueryFields(Class<?> cls) {
        List<ObjectPair<Field, QueryField>> list = new ArrayList<>();
        Class<?> clazz = cls;
        while (clazz != null && clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            if (null != fields && fields.length > 0) {
                for (Field field : fields) {
                    QueryField t;
                    if (null != (t = field.getAnnotation(QueryField.class))) {
                        list.add(new ObjectPair<>(field, t));
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
        return list;
    }

    public static String getColumn(TableInfo tableInfo, String property) {
        if (tableInfo.getKeyColumn().equals(property)
                || tableInfo.getKeyProperty().equalsIgnoreCase(property)) {
            return tableInfo.getKeyColumn();
        }
        List<TableFieldInfo> fieldList = tableInfo.getFieldList();
        for (TableFieldInfo tableFieldInfo : fieldList) {
            if (tableFieldInfo.getProperty().equalsIgnoreCase(property)
                    || tableFieldInfo.getColumn().equals(property)) {
                return tableFieldInfo.getColumn();
            }
        }
        return null;
    }

    private static boolean isBlank(Object obj) {
        return null == obj
                || (obj instanceof String && org.apache.commons.lang3.StringUtils.isBlank((String) obj))
                || (obj instanceof Collection && CollectionUtils.isEmpty((Collection) obj));
    }

    private static <T> void createTimeRange(QueryWrapper<T> wrapper, Map<String, Object> params) {
        Date beginTime = null;
        Date endTime = null;
        Object val;
        if (null != (val = params.remove("beginTime"))) {
            try {
                beginTime = DateUtil.parseStartOfDay(String.valueOf(val));
            } catch (Exception ex) {
                LOGGER.warn("beginTime param error:" + val);
            }
        }
        if (null != (val = params.remove("endTime"))) {
            try {
                endTime = DateUtil.parseEndOfDay(String.valueOf(val));
            } catch (Exception ex) {
                LOGGER.warn("endTime param error:" + val);
            }
        }
        if (null != beginTime) {
            if (null != endTime) {
                wrapper.between("create_time", beginTime, endTime);
            } else {
                wrapper.ge("create_time", beginTime);
            }
        } else if (null != endTime) {
            wrapper.le("create_time", endTime);
        }
    }

    private static <T> void appendWrapper(QueryWrapper<T> wrapper, String column, Object value,
                                          RelationEnum relationEnum) {
        switch (relationEnum) {
            case EQUAL:
                wrapper.eq(column, value);
                break;
            case NOT_EQUAL:
                wrapper.ne(column, value);
                break;
            case IN:
                wrapper.in(column, (Collection) value);
                break;
            case NOT_IN:
                wrapper.notIn(column, (Collection) value);
                break;
            case GREATER_THAN:
                wrapper.gt(column, value);
                break;
            case GREATER_THAN_OR_EQUAL:
                wrapper.ge(column, value);
                break;
            case LESS_THAN:
                wrapper.lt(column, value);
                break;
            case LESS_THAN_OR_EQUAL:
                wrapper.le(column, value);
                break;
            case LIKE:
                wrapper.like(column, value);
                break;
            case LIKE_LEFT:
                wrapper.likeLeft(column, value);
                break;
            case LIKE_RIGHT:
                wrapper.likeRight(column, value);
                break;
            case FIND_IN_SET:
                wrapper.apply("find_in_set({0}, " + column + ")", value);
                break;
            default:
                throw new BizException(StatusCodeEnum.UndefinedQueryRelationship.getValue());
        }
    }
}
