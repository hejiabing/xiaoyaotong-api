package com.xiaoyaotong.api.search.controller;

import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import com.xiaoyaotong.api.search.service.ESMedicineSpuService;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/2 9:10 PM
 */
@RestController
@RequestMapping("/search/match")
public class MatchSpuController {
    @Autowired
    private ESMedicineSpuService eSMedicineSpuService;

    @Autowired
    EsSpuSearchService esSpuSearchService;

    /**
     * 通过controller向搜索里面批量同步标品库的数据
     * 目前供测试使用
     */
    @RequestMapping("/addSpuList")
    public void addSpu(List<ESMedicineSpu> spuList){
        for(ESMedicineSpu esMedicineSpu: spuList){
            eSMedicineSpuService.addMedicineSpu(esMedicineSpu);
        }
    }

    @RequestMapping("/testsearch")
    public List<ESMedicineSpu> testSearch(@RequestBody ESMedicineSpu esMedicineSpu){
        List<ESMedicineSpu> spus = esSpuSearchService.searchSpuList(esMedicineSpu);
        return spus;
    }

}
