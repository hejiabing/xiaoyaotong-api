package com.xiaoyaotong.api.search.controller;

import com.xiaoyaotong.api.platform.vo.QueryPlatformSkuVO;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsMedicineSpuService;
import com.xiaoyaotong.api.search.service.EsSkuSearchService;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import com.xiaoyaotong.api.search.vo.QuerySkuVO;
import com.xiaoyaotong.api.search.vo.QuerySpuVO;
import com.xiaoyaotong.api.search.vo.ReturnSkuVO;
import com.xiaoyaotong.api.search.vo.ReturnSpuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/2 9:10 PM
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private EsMedicineSpuService eSMedicineSpuService;

    @Autowired
    EsSpuSearchService esSpuSearchService;

    @Autowired
    EsSkuSearchService esSkuSearchService;

    /**
     * 通过controller向搜索里面批量同步标品库的数据
     * 目前供测试使用
     */
    //@RequestMapping("/addSpuList")
    public void addSpu(List<EsMedicineSpu> spuList){
        for(EsMedicineSpu esMedicineSpu: spuList){
            eSMedicineSpuService.addMedicineSpu(esMedicineSpu);
        }
    }

    @RequestMapping(value = "/spu",method = RequestMethod.POST)
    public ReturnSpuVO searchSpu(@RequestBody QuerySpuVO querySpuVO){
        ReturnSpuVO returnSpuVO = new ReturnSpuVO();
        List<EsMedicineSpu> spus = esSpuSearchService.searchSpuList(querySpuVO);
        returnSpuVO.setSpus(spus);
        returnSpuVO.setPageNum(querySpuVO.getStartPage());
        returnSpuVO.setPageSize(querySpuVO.getPageSize());
        return returnSpuVO;
    }

    @RequestMapping(value = "/sku",method = RequestMethod.POST)
    public ReturnSkuVO searchSku(@RequestBody QuerySkuVO querySkuVO){
        ReturnSkuVO skus = esSkuSearchService.searchSkuList(querySkuVO);
        skus.setPageNum(querySkuVO.getStartPage());
        skus.setPageSize(querySkuVO.getPageSize());
        return skus;
    }
}
