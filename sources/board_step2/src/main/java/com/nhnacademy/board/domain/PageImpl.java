package com.nhnacademy.board.domain;

import java.util.List;

public class PageImpl<T> implements Page<T> {

    private int pageNumber = 1; // 1부터 시작
    private final int pageSize = 10; // 한 페이지에 보여줄 게시물 갯수
    private int totalPageCount; // 총 페이지 수
    private long totalCount;
    private List<T> list;

    public PageImpl(int pageNumber, long totalCount, List<T> list) {
        this.pageNumber = pageNumber;
        this.totalCount = totalCount;
        this.list = list;
        this.totalPageCount = (int) (((totalCount - 1) / this.pageSize) + 1);
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getTotalPageCount() {
        return this.totalPageCount;
    }

    @Override
    public long getTotalCount() {
        return this.totalCount;
    }

    @Override
    public List<T> getList() {
        return this.list;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    @Override
    public String toString() {
        return "PageImpl{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalPageCount=" + totalPageCount +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}
