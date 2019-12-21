package com.xiaoyaotong.api.search.vo;

import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/15 8:14 PM
 */
public class ReturnSpuVO {

    private List<EsMedicineSpu> spus;
    private long count;
    private int pageNum;
    private int pageSize;


    public List<EsMedicineSpu> getSpus() {
        return spus;
    }

    public void setSpus(List<EsMedicineSpu> spus) {
        this.spus = spus;
    }

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
}
