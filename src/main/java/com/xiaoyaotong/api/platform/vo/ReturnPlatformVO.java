package com.xiaoyaotong.api.platform.vo;

import com.xiaoyaotong.api.platform.dto.PlatformSkuDTO;
import com.xiaoyaotong.api.platform.entity.PlatformSku;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/7 3:43 PM
 */
public class ReturnPlatformVO {
    public List<PlatformSkuDTO> getProductList() {
        return productList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public long getCount() {
        return count;
    }

    private List<PlatformSkuDTO> productList;
    private Integer pageSize;

    public void setProductList(List<PlatformSkuDTO> productList) {
        this.productList = productList;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setCount(long count) {
        this.count = count;
    }

    private Integer pageNum;
    private long count;


}
