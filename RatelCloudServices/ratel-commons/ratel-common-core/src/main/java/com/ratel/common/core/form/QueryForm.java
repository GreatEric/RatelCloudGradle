package com.ratel.common.core.form;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.ratel.common.core.mybatishelper.WrapperUtil;
import java.util.List;

/**
 * RatelCloud
 * @ClassName: QueryForm
 * @Package: com.ratel.common.core.form
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 查询表单
 * @Version: 1.0
 */
public abstract class QueryForm<T> extends BaseForm<T> {
    
    private transient String sqlFilter;

    /*
     * 排序字段
     */
    private String sidx;

    /*
     * 排序方式:ASC/DESC
     */
    private String order;

    private TableInfo tableInfo;

    public String getSqlFilter() {
        return sqlFilter;
    }

    public void setSqlFilter(String sqlFilter) {
        this.sqlFilter = sqlFilter;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public QueryWrapper<T> buildWrapper() {
        return WrapperUtil.toWrapper(this);
    }

    protected TableInfo getTableInfo() {
        if (null == tableInfo) {
            this.tableInfo = TableInfoHelper.getTableInfo(domain);
        }
        return this.tableInfo;
    }

    protected String getColumn(String property) {
        List<TableFieldInfo> fieldList = getTableInfo().getFieldList();
        for (TableFieldInfo tableFieldInfo : fieldList) {
            if (tableFieldInfo.getProperty().equalsIgnoreCase(property)) {
                return tableFieldInfo.getColumn();
            }
            if (tableFieldInfo.getColumn().equals(property)) {
                return tableFieldInfo.getColumn();
            }
        }
        return null;
    }
}
