package com.xiaoyaotong.api.search.vo;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/21 6:04 PM
 */
public class ReturnCompanyItemVO {
    private long count;
    private int pageNum;
    private int pageSize;
    private List<CompanyItemVO> companyItemVOList;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

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

    public List<CompanyItemVO> getCompanyItemVOList() {
        return companyItemVOList;
    }

    public void setCompanyItemVOList(List<CompanyItemVO> companyItemVOList) {
        this.companyItemVOList = companyItemVOList;
    }
}
