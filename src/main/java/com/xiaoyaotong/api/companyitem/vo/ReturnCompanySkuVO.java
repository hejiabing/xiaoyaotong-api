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
    private Integer pageSize = 10;
    /**
     * 当前的页面Num，默认为0
     */
    private Integer pageNum = 0;
    /**
     * 总共的数量
     */
    private Long count = 0L;


    public List<CompanySkuDTO> getCompanySkuList() {
        return companySkuList;
    }

    public void setCompanySkuList(List<CompanySkuDTO> companySkuList) {
        this.companySkuList = companySkuList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
