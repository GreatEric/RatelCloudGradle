package com.ratel.common.core.mybatishelper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Query<T> extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private long currPage = 1;
    /**
     * 每页条数
     */
    private long limit = 10;

    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    private QueryWrapper<T> wrapper;

    public Query(Map<String, Object> params, Class<T> clz) {
        this(params, clz, false);
    }

    public Query(Map<String, Object> params, Class<T> clz, boolean allowSqlFilter) {
        putAll(params);
        Object val;
        //分页参数
        if (null != (val = params.remove("pageNum")) && !"NaN".equals(val)) {
            currPage = Integer.parseInt((String) val);
        }
        if (null != (val = params.remove("pageSize")) && !"NaN".equals(val)) {
            limit = Integer.parseInt((String) val);
        }

        //Order
        //防止SQL注入（因为sidx、order是通过拼接SQL实现Order的，会有SQL注入风险）
        String sidx = SQLFilter.sqlInject((String) params.remove("sidx"));
        List<String> sidxList = new ArrayList<>();
        if (StringUtils.isNotBlank(sidx)) {
            String[] sidxArr = sidx.split(WrapperUtil.SIDX_SEPARATOR);
            for (String str : sidxArr) {
                String aSidx = null;
                if (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(aSidx
                        = WrapperUtil.getColumn(TableInfoHelper.getTableInfo(clz), str))) {
                    sidxList.add(aSidx);
                }
            }
        }

        String order = (String) params.remove("order");

        this.wrapper = WrapperUtil.toWrapper(params, clz, allowSqlFilter);

        this.put("offset", (currPage - 1) * limit);
        this.put("pageNum", currPage);
        this.put("pageSize", limit);

        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        if (!sidxList.isEmpty() && StringUtils.isNotBlank(order)) {
            this.put("sidx", sidx);
            String[] sidxs = sidxList.toArray(new String[sidxList.size()]);
            if ("DESC".equalsIgnoreCase(order)) {
                this.put("order", "DESC");
                this.page.setDesc(sidxs);
            } else {
                this.put("order", "ASC");
                this.page.setAsc(sidxs);
            }
        }

    }

    public Page<T> getPage() {
        return page;
    }

    public QueryWrapper<T> getWrapper() {
        return wrapper;
    }

    public long getCurrPage() {
        return currPage;
    }

    public long getLimit() {
        return limit;
    }
}
