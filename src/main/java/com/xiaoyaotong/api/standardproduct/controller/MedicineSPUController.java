package com.xiaoyaotong.api.standardproduct.controller;

import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/8 12:37
 */
@RestController
@RequestMapping("/medicinespu")
public class MedicineSPUController {

    @Autowired
    private MedicineSPUService medicineSPUService;

    @RequestMapping(value="/getspubyid", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<MedicineSPU> getSPUByid(@RequestParam int spuid) {
        Assert.notNull(spuid, "spuid can not be empty");
        MedicineSPU medicineSPU = medicineSPUService.getSPUByspuid(spuid);
        if (null != medicineSPU && (medicineSPU.getId()>0)){
            return  new ResponseEntity<MedicineSPU>(medicineSPU, HttpStatus.OK);
        }else{
            return new ResponseEntity<MedicineSPU>((MedicineSPU)null, HttpStatus.OK);
        }
    }

    @RequestMapping(value="/getspulist", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<List<MedicineSPU>> getAllSPU(@RequestParam("pagebegin") int pageBegin ,@RequestParam("pagenum") int pageNum) {
        Assert.notNull(pageBegin, "pageid can not be empty");
        Assert.notNull(pageNum, "pageNum can not be empty");
        List<MedicineSPU> spus = medicineSPUService.getSPUList(pageBegin,pageNum);
        if (null != spus && (spus.size()>0)){
            return  new ResponseEntity<List<MedicineSPU>>(spus, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<MedicineSPU>>((List<MedicineSPU>)null, HttpStatus.OK);
        }
    }

    }
