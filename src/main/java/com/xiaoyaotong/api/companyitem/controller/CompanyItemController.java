package com.xiaoyaotong.api.companyitem.controller;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.login.annotation.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 11:09
 */
@RestController
@RequestMapping("/companyitem")
public class CompanyItemController {

    @Autowired
    private CompanySkuService companySkuService;

    /**
     * 通过json格式进行sku导入
     **/
    @RequestMapping(value = "/addlist", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<HashMap> addItems(@RequestBody List<CompanySku> items) {
        Assert.notNull(items, "username can not be empty");
        int allItems = items.size();
        int result = 0;
        result = companySkuService.addCompanySkuList(items);
        HashMap map = new HashMap();
        map.put("all",allItems);
        map.put("success",result);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    /**
     * 通过json格式进行sku导入
     **/
    @RequestMapping(value = "/addone", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<HashMap> addItem(@RequestBody CompanySku item) {
        Assert.notNull(item, "username can not be empty");
        int result = 0;
        result = companySkuService.insertCompanySku(item);
        HashMap map = new HashMap();
        map.put("all",1);
        map.put("success",result);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/getitems", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<List<CompanySku>> getItems() {
        List<CompanySku> result = companySkuService.getCompanySkuList(1,10);
        return new ResponseEntity<List<CompanySku>>(result, HttpStatus.OK);
    }
}
