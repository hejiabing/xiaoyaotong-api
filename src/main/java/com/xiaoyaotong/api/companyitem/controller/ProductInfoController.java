package com.xiaoyaotong.api.companyitem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoyaotong.api.companyitem.dto.ProductInfoDTO;
import com.xiaoyaotong.api.companyitem.dto.ProductInfoRequestDTO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.companyitem.util.ProductInfoDTOCompanySkuConvert;
import com.xiaoyaotong.api.util.JsonUtil;

@RestController
@RequestMapping("/productinfo")
public class ProductInfoController {
    @Autowired
    private CompanySkuService companySkuService;

    //@RequestMapping(value = "/add", method = RequestMethod.POST)
    //@Authorization
    public int  addProdutInfo(@RequestBody ProductInfoDTO pdto) {
        Assert.notNull(pdto, "username can not be empty");
        int result = 0;
        CompanySku csku = ProductInfoDTOCompanySkuConvert.dtoToEntity(pdto);
        result = companySkuService.insertCompanySku(csku);
        return  result;
    }


    @RequestMapping(value = "/addlist", method = RequestMethod.POST)
   // @Authorization(way = Constants.SIGN)
    public ResponseEntity<HashMap> addProdutInfo1(@RequestBody ProductInfoRequestDTO requestDTO) {
        Assert.notNull(requestDTO, "username can not be empty");
        int total = requestDTO.getProductDTOList().size();
        int successresult = 0;
        for (ProductInfoDTO pdto: requestDTO.getProductDTOList()){
        	CompanySku csku = ProductInfoDTOCompanySkuConvert.dtoToEntity(pdto);
        	if(requestDTO.getIsAll() == 1){
        		Integer id = companySkuService.getCompanySkuId(csku.getCompanyId(), csku.getProductCode());
        		if(id != null){
        			csku.setId(id);
        			successresult += companySkuService.updateCompanySkuById(csku);
        		}else{
        			successresult += companySkuService.insertCompanySku(csku);
        		}
            }else{
            	successresult += companySkuService.insertCompanySku(csku);
            }
        }
        HashMap map = new HashMap();
        map.put("all",total);
        map.put("success",successresult);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    public ResponseEntity<HashMap> addProdutInfo(@RequestBody String dtosJson) {
        Assert.notNull(dtosJson, "username can not be empty");
        List<ProductInfoDTO> pdtos = JsonUtil.jsonToList(dtosJson,ProductInfoDTO.class);

        int total = pdtos.size();
        int successresult = 0;
        for (ProductInfoDTO pdto: pdtos){
            CompanySku csku = ProductInfoDTOCompanySkuConvert.dtoToEntity(pdto);
            int result = companySkuService.insertCompanySku(csku);
            successresult=successresult + companySkuService.insertCompanySku(csku);
        }
        HashMap map = new HashMap();
        map.put("all",total);
        map.put("success",successresult);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    //@Authorization
    public ResponseEntity<ProductInfoDTO> getProdutInfo(@RequestBody ProductInfoDTO pdto) {
        Assert.notNull(pdto, "username can not be empty");
        CompanySku csku = null;
        int enterpriseId = Integer.parseInt(pdto.getEnterpriseId());
        String erpProductCode = pdto.getProductCode();


        csku = companySkuService.getCompanySkuById(enterpriseId, erpProductCode);
        /*
        ProductInfoDTO dtoResult = new ProductInfoDTO();
        dtoResult.setApprovalNumber(csku.getApprovalCode());
        dtoResult.setProductCode(csku.getErpProductCode()); //本公司商品编码
        dtoResult.setEnterpriseId((String.valueOf(csku.getCompayId())));//企业ID
        dtoResult.setFactory(csku.getFactoryName());//生产厂家
        dtoResult.setSpec(csku.getSpec());//规格
        dtoResult.setProductName(csku.getCommonName());//通用名
        dtoResult.setBarCode(csku.getBarCode());//条码
         */
        ProductInfoDTO dtoResult = ProductInfoDTOCompanySkuConvert.entityToDto(csku);
        return new ResponseEntity<ProductInfoDTO>(dtoResult, HttpStatus.OK);
    }
}
