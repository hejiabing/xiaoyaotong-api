package com.xiaoyaotong.api.matchspu.controller;

import com.xiaoyaotong.api.matchspu.entity.ESMedicineSpu;
import com.xiaoyaotong.api.matchspu.service.ESMedicineSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/2 9:10 PM
 */
@RestController
@RequestMapping("/matchspu")
public class MatchSpuController {
    @Autowired
    private ESMedicineSpuService esMedicineSpuService;

    @RequestMapping("/add")
    public void addSpu(){
        for(int i=0;i<99;i++){
            ESMedicineSpu esMedicineSpu = new ESMedicineSpu();
            esMedicineSpu.setId(i);
            esMedicineSpu.setCommonName("测试"+i);
            esMedicineSpuService.addMedicineSpu(esMedicineSpu);
        }

    }
}
