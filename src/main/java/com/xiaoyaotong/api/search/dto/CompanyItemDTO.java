package com.xiaoyaotong.api.search.dto;

import com.xiaoyaotong.api.search.entity.EsCompanyItem;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 8:04 PM
 */
public class CompanyItemDTO {
    private List<EsCompanyItem> items;

    private int startPage;

    private int pageSize;

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<EsCompanyItem> getItems() {
        return items;
    }

    public void setItems(List<EsCompanyItem> items) {
        this.items = items;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
