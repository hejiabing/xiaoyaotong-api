package com.xiaoyaotong.api.platform.dto;

import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/7 3:11 PM
 */
public class PlatformSkuDTO implements Serializable {

    private String skuCode;

    private MedicineSPU spu;

    private PlatformSku sku;


    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public MedicineSPU getSpu() {
        return spu;
    }

    public void setSpu(MedicineSPU spu) {
        this.spu = spu;
    }

    public PlatformSku getSku() {
        return sku;
    }

    public void setSku(PlatformSku sku) {
        this.sku = sku;
    }
}
