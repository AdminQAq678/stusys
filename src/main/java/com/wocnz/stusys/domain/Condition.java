package com.wocnz.stusys.domain;

import java.util.List;

/**
 * 分页查询对象
 * @param <E>
 */
public class Condition<E> {
    private int currentPage;
    //每页显示的条数
    private int pageSize;
    //记录总数
    private int totalCount;
    //数据
    private List<E>   data;

    @Override
    public String toString() {
        return "Condition{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", data=" + data +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
