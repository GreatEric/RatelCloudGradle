package com.ratel.common.core.mybatishelper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.collections4.CollectionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * RatelCloud
 * @ClassName: PageUtils
 * @Package: com.ratel.common.core.mybatishelper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 分页工具
 * @Version: 1.0
 */
public class PageUtils<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /*
     * 总记录数
     */
    private long totalCount;
    /*
     * 每页记录数
     */
    private long pageSize;
    /*
     * 总页数
     */
    private long totalPage;
    /*
     * 当前页数
     */
    private long currPage;
    /*
     * 列表 Data
     */
    private List list;

     /**
      * @Author: Eric
      * @Date: 11:01 AM 17/09/20
      * @Description: 分页构造器
      * @Param totalCount 总记录数
      * @Param pageSize 每页记录数
      * @Param currPage 当前页数
      * @Return:
      */
    public PageUtils(List<T> list, long totalCount, long pageSize, long currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (long) Math.ceil((double) totalCount / pageSize);
    }

    /**
     * @Author: Eric
     * @Date: 11:01 AM 17/09/20
     * @Description: 分页构造器
     * @Param
     * @Return:
     */
    public PageUtils(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = page.getPages();
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getCurrPage() {
        return currPage;
    }

    public void setCurrPage(long currPage) {
        this.currPage = currPage;
    }

    public List<T> getList() {
        return list;
    }

    public <U> PageUtils<U> setList(List<U> list) {
        this.list = list;
        return (PageUtils<U>) this;
    }

    public <U> PageUtils<U> map(Function<T, U> converter) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<U> r = new ArrayList(list.size());
            ((List<T>) list).stream().map(converter).forEachOrdered((u) -> {
                r.add(u);
            });
            list = r;
        }
        return (PageUtils<U>) this;
    }
}