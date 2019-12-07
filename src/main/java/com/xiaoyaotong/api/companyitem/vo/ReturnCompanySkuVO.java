package com.xiaoyaotong.api.companyitem.vo;

import com.xiaoyaotong.api.companyitem.dto.CompanySkuDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：billHe
 * @description：返回给前端的数据
 * @date ：2019/12/7 3:43 PM
 */
public class ReturnCompanySkuVO implements Serializable {

    /**
     * 返回给前端的对象list
     */
    private List<CompanySkuDTO> companySkuList;
    /**
     * 每页包含的数量，默认为10
     */
    private int pageSize = 10;
    /**
     * 当前的页面Num，默认为0
     */
    private int pageNum = 0;
    /**
     * 总共的数量
     */
    private long count = 0;

    public List<CompanySkuDTO> getCompanySkuList() {
        return companySkuList;
    }

    public void setCompanySkuList(List<CompanySkuDTO> companySkuList) {
        this.companySkuList = companySkuList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
