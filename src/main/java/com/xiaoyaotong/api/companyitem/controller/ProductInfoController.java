package com.xiaoyaotong.api.companyitem.controller;

import com.xiaoyaotong.api.companyitem.dto.ProductInfoDTO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.login.annotation.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/productinfo")
public class ProductInfoController {
    @Autowired
    private CompanySkuService companySkuService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<HashMap> addProdutInfo(@RequestBody ProductInfoDTO pdto) {
        Assert.notNull(pdto, "username can not be empty");
        int result = 0;
        CompanySku csku = new CompanySku();
        csku.setCompayId(Integer.parseInt(pdto.getEnterpriseId()));//设置企业id
        csku.setCommonName(pdto.getProductName()); //设置通用名
        csku.setApprovalCode(pdto.getApprovalNumber());//设置批准文号
        csku.setSpec(pdto.getSpec());//设置规格
        csku.setFactoryName(pdto.getFactory());//设置生产厂家
        csku.setBarCode(pdto.getBarCode());//设置条码
        csku.setErpProductCode(pdto.getProductCode());//设置企业的的ERP编码

        result = companySkuService.insertCompanySku(csku);
        HashMap map = new HashMap();
        map.put("all",1);
        map.put("success",result);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }


}
