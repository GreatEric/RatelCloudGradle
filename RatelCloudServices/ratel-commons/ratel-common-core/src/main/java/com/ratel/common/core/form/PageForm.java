package com.ratel.common.core.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.WrapperUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * RatelCloud
 * @ClassName: PageForm
 * @Package: com.ratel.common.core.form
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 分页查询表单
 * @Version: 1.0
 */
public class PageForm<T> extends QueryForm<T> {
    /*
     * 当前页数
     */
    private long pageNum = 1L;
    /*
     * 每页条数
     */
    private long pageSize = 10L;

    public Page<T> buildPage() {
        Page<T> page = new Page<>(pageNum, pageSize);

        //Order
        if (StringUtils.isNotBlank(getSidx()) && StringUtils.isNotBlank(getOrder())) {
            String[] sidxArr = getSidx().split(WrapperUtil.SIDX_SEPARATOR);
            for (int i = 0; i < sidxArr.length; i++) {
                String sidx = sidxArr[i];
                sidxArr[i] = com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(sidx);
            }
            if ("ASC".equalsIgnoreCase(getOrder())) {
                page.setAsc(sidxArr);
            } else {
                page.setDesc(sidxArr);
            }
        }
        return page;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
}
