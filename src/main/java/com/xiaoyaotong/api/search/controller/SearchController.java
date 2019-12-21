package com.xiaoyaotong.api.search.controller;

import com.xiaoyaotong.api.companyitem.dto.CompanySkuDTO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.companyitem.vo.ReturnCompanySkuVO;
import com.xiaoyaotong.api.platform.vo.QueryPlatformSkuVO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Autowired
    EsCompanyItemSearchService esCompanyItemSearchService;

    @Autowired
    CompanySkuService companySkuService;

    @Autowired
    MedicineSPUService medicineSPUService;

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
        ReturnSpuVO returnSpuVO = new ReturnSpuVO();
        List<EsMedicineSpu> spus = esSpuSearchService.searchSpuList(querySpuVO);
        returnSpuVO.setSpus(spus);
        returnSpuVO.setPageNum(querySpuVO.getStartPage());
        returnSpuVO.setPageSize(querySpuVO.getPageSize());
        return returnSpuVO;
    }

    @RequestMapping(value = "/sku", method = RequestMethod.POST)
    public ReturnSkuVO searchSku(@RequestBody QuerySkuVO querySkuVO) {
        ReturnSkuVO skus = esSkuSearchService.searchSkuList(querySkuVO);
        skus.setPageNum(querySkuVO.getStartPage());
        skus.setPageSize(querySkuVO.getPageSize());
        return skus;
    }

    @RequestMapping(value = "/companyitem", method = RequestMethod.POST)
    public ReturnCompanySkuVO searchCompanyItem(@RequestBody QueryCompanyItemVO queryCompanyItemVO) {
        ReturnCompanySkuVO returnCompanySkuVO = new ReturnCompanySkuVO();
        //搜索出符合条件的list
        CompanyItemDTO companyItemDTO = esCompanyItemSearchService.searchCompanyItemList(queryCompanyItemVO);
        List<CompanySkuDTO> dtolist = new ArrayList<>();

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
            dtolist.add(companySkuDTO);
        }

        returnCompanySkuVO.setPageNum(queryCompanyItemVO.getStartPage());
        returnCompanySkuVO.setPageSize(queryCompanyItemVO.getPageSize());
        returnCompanySkuVO.setCompanySkuList(dtolist);

            return returnCompanySkuVO;
    }
}
