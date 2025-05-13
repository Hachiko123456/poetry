package com.wechatapp.mengyao.poetry.core;

/**
 * @author yanghuaxu
 * @date 2025/5/11 21:08
 */
public class PageRequest {

    private int pageNum = 1;    // 当前页（默认第1页）
    private int pageSize = 10;  // 每页条数（默认10条）

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

}
