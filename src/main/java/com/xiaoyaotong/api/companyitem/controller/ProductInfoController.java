package com.xiaoyaotong.api.companyitem.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoyaotong.api.companyitem.dto.ProductSyncRequestDTO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.entity.CompanySkuBatch;
import com.xiaoyaotong.api.companyitem.entity.CompanySkuPrice;
import com.xiaoyaotong.api.companyitem.service.CompanySkuBatchService;
import com.xiaoyaotong.api.companyitem.service.CompanySkuPriceService;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.login.config.Constants;

@RestController
@RequestMapping("/product")
public class ProductInfoController {
    @Autowired
    private CompanySkuService companySkuService;
    @Autowired
    private CompanySkuBatchService companySkuBatchService;
    @Autowired
    private CompanySkuPriceService companySkuPriceService;
    
    @RequestMapping(value = "/addInfoList", method = RequestMethod.POST)
    @Authorization(way = Constants.SIGN)
    public ResponseEntity<HashMap> addProdutInfoList(@RequestBody ProductSyncRequestDTO<CompanySku> requestDTO) {
        Assert.notNull(requestDTO, "username can not be empty");
        int total = requestDTO.getProductDTOList().size();
        int successresult = 0;
        for (CompanySku csku: requestDTO.getProductDTOList()){
        	if(requestDTO.getIsAll() == 1){
        		Integer id = companySkuService.getCompanySkuId(csku.getCompanyId(), csku.getSkuCode());
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

     @RequestMapping(value = "/updateInfoList", method = RequestMethod.POST)
     @Authorization(way = Constants.SIGN)
     public ResponseEntity<HashMap> updateProdutInfoList(@RequestBody ProductSyncRequestDTO<CompanySku> requestDTO) {
         Assert.notNull(requestDTO, "username can not be empty");
         int total = requestDTO.getProductDTOList().size();
         int successresult = 0;
         for (CompanySku csku: requestDTO.getProductDTOList()){
         	successresult += companySkuService.updateByCompanyIdAndSkuCode(csku);
         }
         HashMap map = new HashMap();
         map.put("all",total);
         map.put("success",successresult);
         return new ResponseEntity<HashMap>(map, HttpStatus.OK);
     }

     @RequestMapping(value = "/addStockList", method = RequestMethod.POST)
     @Authorization(way = Constants.SIGN)
     public ResponseEntity<HashMap> addProductStockList(@RequestBody ProductSyncRequestDTO<CompanySkuBatch> requestDTO) {
         Assert.notNull(requestDTO, "username can not be empty");
         int total = requestDTO.getProductDTOList().size();
         int successresult = 0;
         for (CompanySkuBatch csku: requestDTO.getProductDTOList()){
         	if(requestDTO.getIsAll() == 1){
         		Integer id = companySkuBatchService.getCompanySkuBatchId(csku);
         		if(id != null){
         			csku.setId(id);
         			successresult += companySkuBatchService.updateCompanySkuBatchById(csku);
         		}else{
         			successresult += companySkuBatchService.insertCompanySkuBatch(csku);
         		}
             }else{
             	successresult += companySkuBatchService.insertCompanySkuBatch(csku);
             }
         }
         HashMap map = new HashMap();
         map.put("all",total);
         map.put("success",successresult);
         return new ResponseEntity<HashMap>(map, HttpStatus.OK);
     }
    
     @RequestMapping(value = "/updateStockList", method = RequestMethod.POST)
     @Authorization(way = Constants.SIGN)
     public ResponseEntity<HashMap> updateProductStockList(@RequestBody ProductSyncRequestDTO<CompanySkuBatch> requestDTO) {
         Assert.notNull(requestDTO, "username can not be empty");
         int total = requestDTO.getProductDTOList().size();
         int successresult = 0;
         for (CompanySkuBatch csku: requestDTO.getProductDTOList()){
         	successresult += companySkuBatchService.updateByCompanyIdAndSkuCode(csku);
         }
         HashMap map = new HashMap();
         map.put("all",total);
         map.put("success",successresult);
         return new ResponseEntity<HashMap>(map, HttpStatus.OK);
     }
     
     @RequestMapping(value = "/addPriceList", method = RequestMethod.POST)
     @Authorization(way = Constants.SIGN)
     public ResponseEntity<HashMap> addProductPriceList(@RequestBody ProductSyncRequestDTO<CompanySkuPrice> requestDTO) {
         Assert.notNull(requestDTO, "username can not be empty");
         int total = requestDTO.getProductDTOList().size();
         int successresult = 0;
         for (CompanySkuPrice csku: requestDTO.getProductDTOList()){
         	if(requestDTO.getIsAll() == 1){
         		Integer id = companySkuPriceService.getCompanySkuPriceId(csku);
         		if(id != null){
         			csku.setId(id);
         			successresult += companySkuPriceService.updateCompanySkuPriceById(csku);
         		}else{
         			successresult += companySkuPriceService.insertCompanySkuPrice(csku);
         		}
             }else{
             	successresult += companySkuPriceService.insertCompanySkuPrice(csku);
             }
         }
         HashMap map = new HashMap();
         map.put("all",total);
         map.put("success",successresult);
         return new ResponseEntity<HashMap>(map, HttpStatus.OK);
     }
    
     @RequestMapping(value = "/updatePriceList", method = RequestMethod.POST)
     @Authorization(way = Constants.SIGN)
     public ResponseEntity<HashMap> updatePriceList(@RequestBody ProductSyncRequestDTO<CompanySkuPrice> requestDTO) {
         Assert.notNull(requestDTO, "username can not be empty");
         int total = requestDTO.getProductDTOList().size();
         int successresult = 0;
         for (CompanySkuPrice csku: requestDTO.getProductDTOList()){
         	successresult += companySkuPriceService.updateByCompanyIdAndSkuCode(csku);
         }
         HashMap map = new HashMap();
         map.put("all",total);
         map.put("success",successresult);
         return new ResponseEntity<HashMap>(map, HttpStatus.OK);
     }
}
