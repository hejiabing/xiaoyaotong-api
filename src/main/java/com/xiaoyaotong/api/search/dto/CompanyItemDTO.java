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

    private Integer startPage;

    private Integer pageSize;

    private Long count;

    public List<EsCompanyItem> getItems() {
        return items;
    }

    public void setItems(List<EsCompanyItem> items) {
        this.items = items;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
