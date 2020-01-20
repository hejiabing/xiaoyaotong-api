package com.xiaoyaotong.api.search.controller;

import com.alibaba.fastjson.JSON;
import com.xiaoyaotong.api.companyitem.dto.CompanySkuDTO;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.companyitem.vo.ReturnCompanySkuVO;
import com.xiaoyaotong.api.platform.dto.PlatformSkuDTO;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import com.xiaoyaotong.api.platform.vo.ReturnPlatformVO;
import com.xiaoyaotong.api.search.dto.CompanyItemDTO;
import com.xiaoyaotong.api.search.entity.EsCompanyItem;
import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.entity.EsPlatformSku;
import com.xiaoyaotong.api.search.service.EsCompanyItemSearchService;
import com.xiaoyaotong.api.search.service.EsMedicineSpuService;
import com.xiaoyaotong.api.search.service.EsSkuSearchService;
import com.xiaoyaotong.api.search.service.EsSpuSearchService;
import com.xiaoyaotong.api.search.vo.*;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：billHe
 * @description：搜索的controller类
 * @date ：2019/12/2 9:10 PM
 */
@RestController
@RequestMapping("/search")
public class SearchController {
	
	private static Logger log = LoggerFactory.getLogger(SearchController.class);
    @Autowired
    private EsMedicineSpuService eSMedicineSpuService;

    @Autowired
    EsSpuSearchService esSpuSearchService;

    @Autowired
    EsSkuSearchService esSkuSearchService;

    @Autowired
    EsCompanyItemSearchService esCompanyItemSearchService;

    @Autowired
    CompanySkuService companySkuService;

    @Autowired
    MedicineSPUService medicineSPUService;

    @Autowired
    PlatformSkuService platformSkuService;

    /**
     * 通过controller向搜索里面批量同步标品库的数据
     * 目前供测试使用
     */
    //@RequestMapping("/addSpuList")
    public void addSpu(List<EsMedicineSpu> spuList) {
        for (EsMedicineSpu esMedicineSpu : spuList) {
            eSMedicineSpuService.addMedicineSpu(esMedicineSpu);
        }
    }

    @RequestMapping(value = "/spu", method = RequestMethod.POST)
    public ReturnSpuVO searchSpu(@RequestBody QuerySpuVO querySpuVO) {
    	log.info("查询/search/spu，参数："+JSON.toJSONString(querySpuVO));
        ReturnSpuVO returnSpuVO = new ReturnSpuVO();
        List<EsMedicineSpu> spus = esSpuSearchService.searchSpuList(querySpuVO);
        returnSpuVO.setSpus(spus);
        returnSpuVO.setPageNum(querySpuVO.getStartPage());
        returnSpuVO.setPageSize(querySpuVO.getPageSize());
        return returnSpuVO;
    }

    @RequestMapping(value = "/sku", method = RequestMethod.POST)
    public ReturnPlatformVO searchSku(@RequestBody QuerySkuVO querySkuVO) {
    	log.info("查询/search/sku，参数："+JSON.toJSONString(querySkuVO));
        ReturnPlatformVO returnPlatformVO = new ReturnPlatformVO();
        ReturnSkuVO skus = esSkuSearchService.searchSkuList(querySkuVO);
        List<PlatformSkuDTO> lists = new ArrayList<>();
        for(EsPlatformSku item: skus.getSkus()){
            PlatformSku platformSku = platformSkuService.getSkuBySkuCode(item.getSkuCode());
            MedicineSPU medicineSPU = medicineSPUService.getBySpuCode(item.getSpuCode());
            PlatformSkuDTO platformSkuDTO = new PlatformSkuDTO();
            platformSkuDTO.setSku(platformSku);
            platformSkuDTO.setSpu(medicineSPU);
            platformSkuDTO.setSkuCode(item.getSkuCode());
            lists.add(platformSkuDTO);
        }
        returnPlatformVO.setPageNum(querySkuVO.getStartPage());
        returnPlatformVO.setPageSize(querySkuVO.getPageSize());
        returnPlatformVO.setCount(skus.getCount());
        returnPlatformVO.setProductList(lists);
        return returnPlatformVO;
    }

    @RequestMapping(value = "/companyitem", method = RequestMethod.POST)
    public ReturnCompanySkuVO searchCompanyItem(@RequestBody QueryCompanyItemVO queryCompanyItemVO) {
    	log.info("查询/search/companyitem，参数："+JSON.toJSONString(queryCompanyItemVO));
        ReturnCompanySkuVO returnCompanySkuVO = new ReturnCompanySkuVO();
        //搜索出符合条件的list
        CompanyItemDTO companyItemDTO = esCompanyItemSearchService.searchCompanyItemList(queryCompanyItemVO);
        List<CompanySkuDTO> dtoList = new ArrayList<>();

        for(EsCompanyItem item : companyItemDTO.getItems()){
            CompanySkuDTO companySkuDTO = new CompanySkuDTO();
            String companySkuCode = item.getCompanySkuCode();
            int companyId = item.getCompanyId();
            companySkuDTO.setCompanyId(companyId);
            companySkuDTO.setCompanySkuCode(companySkuCode);
            companySkuDTO.setApprovalCode(item.getApprovalCode());
            companySkuDTO.setCommonName(item.getCommonName());
            companySkuDTO.setFactoryName(item.getFactoryName());
            companySkuDTO.setBarCode(item.getBarCode());
            companySkuDTO.setSpec(item.getSpec());
            String spuCode = item.getSpuCode();

            if(spuCode!=null && spuCode!="") {
                MedicineSPU medicineSPU = medicineSPUService.getBySpuCode(spuCode);
                companySkuDTO.setMedicineSPU(medicineSPU);
            }
            dtoList.add(companySkuDTO);
        }

        returnCompanySkuVO.setPageNum(queryCompanyItemVO.getStartPage());
        returnCompanySkuVO.setPageSize(queryCompanyItemVO.getPageSize());
        returnCompanySkuVO.setCompanySkuList(dtoList);
        returnCompanySkuVO.setCount(companyItemDTO.getCount());

            return returnCompanySkuVO;
    }
}
