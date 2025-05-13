package com.wechatapp.mengyao.poetry.core;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author yanghuaxu
 * @date 2025/5/11 21:08
 */
public class PageResult<T> {
    private int pageNum;     // 当前页
    private int pageSize;    // 每页数量
    private long total;      // 总记录数
    private int pages;       // 总页数
    private List<T> list;    // 分页数据

    public static <T> PageResult<T> build(List<T> list) {
        return build(new PageInfo<>(list));
    }

    // 通过PageInfo构建分页结果
    public static <T> PageResult<T> build(PageInfo<T> pageInfo) {
        PageResult<T> result = new PageResult<>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setPages(pageInfo.getPages());
        result.setList(pageInfo.getList());
        return result;
    }

    // Getter and Setter
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}