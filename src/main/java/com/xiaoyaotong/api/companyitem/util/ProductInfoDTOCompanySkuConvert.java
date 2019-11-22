package com.xiaoyaotong.api.companyitem.util;

import com.xiaoyaotong.api.companyitem.dto.ProductInfoDTO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/12 20:44
 */
public class ProductInfoDTOCompanySkuConvert {

    public static CompanySku dtoToEntity(ProductInfoDTO pdto){
        CompanySku csku = new CompanySku();
        csku.setCompayId(Integer.parseInt(pdto.getEnterpriseId()));//设置企业id
        csku.setCommonName(pdto.getProductName()); //设置通用名
        csku.setApprovalCode(pdto.getApprovalNumber());//设置批准文号
        csku.setSpec(pdto.getSpec());//设置规格
        csku.setFactoryName(pdto.getFactory());//设置生产厂家
        csku.setBarCode(pdto.getBarCode());//设置条码
        csku.setProductCode(pdto.getProductCode());//设置企业的的ERP编码
        return  csku;
    }

    public static ProductInfoDTO entityToDto(CompanySku csku){
        ProductInfoDTO dtoResult = new ProductInfoDTO();
        dtoResult.setApprovalNumber(csku.getApprovalCode());
        dtoResult.setProductCode(csku.getErpProductCode()); //本公司商品编码
        dtoResult.setEnterpriseId((String.valueOf(csku.getCompayId())));//企业ID
        dtoResult.setFactory(csku.getFactoryName());//生产厂家
        dtoResult.setSpec(csku.getSpec());//规格
        dtoResult.setProductName(csku.getCommonName());//通用名
        dtoResult.setBarCode(csku.getBarCode());//条码
        return  dtoResult;
    }
}
