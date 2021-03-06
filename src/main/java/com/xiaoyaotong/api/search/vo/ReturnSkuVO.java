package com.xiaoyaotong.api.search.vo;

import com.xiaoyaotong.api.search.entity.EsPlatformSku;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/15 8:14 PM
 */
public class ReturnSkuVO {

    private List<EsPlatformSku> skus;
    private long count;
    private int pageNum;
    private int pageSize;


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

    public List<EsPlatformSku> getSkus() {
        return skus;
    }

    public void setSkus(List<EsPlatformSku> skus) {
        this.skus = skus;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
