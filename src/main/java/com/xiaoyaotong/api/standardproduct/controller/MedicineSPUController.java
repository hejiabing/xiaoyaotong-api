package com.xiaoyaotong.api.standardproduct.controller;

import com.xiaoyaotong.api.login.annotation.Authorization;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：billHe
 * @description：标品库对外提供服务的控制页面
 * @date ：2019/11/8 12:37
 */
@RestController
@RequestMapping("/medicinespu")
public class MedicineSPUController {

    @Autowired
    private MedicineSPUService medicineSPUService;

    @RequestMapping(value="/getbyspucode", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<MedicineSPU> getSPUByid(@RequestParam String spuCode) {
        Assert.notNull(spuCode, "spuid can not be empty");
        MedicineSPU medicineSPU = medicineSPUService.getBySpuCode(spuCode);
        if (null != medicineSPU && (medicineSPU.getId()>0)){
            return  new ResponseEntity<MedicineSPU>(medicineSPU, HttpStatus.OK);
        }else{
            return new ResponseEntity<MedicineSPU>((MedicineSPU)null, HttpStatus.OK);
        }
    }

    @RequestMapping(value="/getspulist", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<List<MedicineSPU>> getSPUList(@RequestParam("pagebegin") int pageBegin ,@RequestParam("pagenum") int pageNum) {
        Assert.notNull(pageBegin, "pageid can not be empty");
        Assert.notNull(pageNum, "pageNum can not be empty");
        List<MedicineSPU> spus = medicineSPUService.getSPUList(pageBegin,pageNum);
        if (null != spus && (spus.size()>0)){
            return  new ResponseEntity<List<MedicineSPU>>(spus, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<MedicineSPU>>((List<MedicineSPU>)null, HttpStatus.OK);
        }
    }


    @RequestMapping(value="/getspubykeyparameters", method = RequestMethod.POST)
    //@Authorization
    public ResponseEntity<List<MedicineSPU>> getSpuByAll(@RequestBody MedicineSPU spu) {
        Assert.notNull(spu, "pageid can not be empty");
        List<MedicineSPU> lists = new ArrayList<>();
        if(spu != null){
            String commonName = spu.getCommonName();
            String approvalCode = spu.getApprovalCode();
            String barCode = spu.getBarCode();
            String spuCode = spu.getSpuCode();
            lists = medicineSPUService.getSpuByKeyParameters(spuCode,commonName,approvalCode,barCode);
            return new ResponseEntity<List<MedicineSPU>>(lists, HttpStatus.OK);
        }
        return new ResponseEntity<List<MedicineSPU>>((List<MedicineSPU>)null, HttpStatus.OK);
    }

    @RequestMapping(value="/updatespu", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<Boolean> updateSPU(@RequestParam("spu") MedicineSPU spu) {
        Assert.notNull(spu, "pageid can not be empty");
        boolean result = medicineSPUService.updateMedicineSPU(spu);
        if(result == true){
            MedicineSPU newspu = medicineSPUService.getBySpuCode(spu.getSpuCode());
            return  new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
        }else{
            return  new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
        }
    }

    @RequestMapping(value="/addspu", method = RequestMethod.POST)
    @Authorization
    public ResponseEntity<Boolean> addSPU(@RequestParam("spu") MedicineSPU spu) {
        Assert.notNull(spu, "pageid can not be empty");
        boolean result = medicineSPUService.insertMedicineSPU(spu);
        if(result == true){
            return  new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
        }else{
            return  new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
        }
    }

    }
