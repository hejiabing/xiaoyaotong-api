package com.xiaoyaotong.api.companyitem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyaotong.api.companyitem.dto.CompanySkuDTO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.companyitem.vo.CompanySkuInfo;
import com.xiaoyaotong.api.companyitem.vo.QueryCompanySkuVO;
import com.xiaoyaotong.api.companyitem.vo.ReturnCompanySkuVO;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;

/**
 * @author ：billHe
 * @description：公司商品的信息
 * @date ：2019/12/7 8:17 PM
 */
@RestController
@RequestMapping(value = "companysku")
public class CompanySkuController {
	
	private static Logger log = LoggerFactory.getLogger(CompanySkuController.class);
    @Autowired
    CompanySkuService companySkuService;
    @Autowired
    PlatformSkuService platformSkuService;
    @Autowired
    MedicineSPUService medicineSPUService;

    /**
     * 更新公司对应的标准码
     * @param queryCompanySkuVO
     * @return
     */
    @RequestMapping(value = "updatespu", method = RequestMethod.POST)
    public Boolean updateCompanySku(@RequestBody QueryCompanySkuVO queryCompanySkuVO){
        Assert.notNull(queryCompanySkuVO, "dto can not be empty");
        int companyId = queryCompanySkuVO.getCompanyId();
        String companySkuCode = queryCompanySkuVO.getCompanySkuCode();
        String spu = queryCompanySkuVO.getSpuCode();

        if(companyId>0 &&companySkuCode!=null && companySkuCode !=""){ //确保能找到一个商品
            List<CompanySku> companySkus = companySkuService.getSkuByCompanyIdAndSkuCode(companyId,companySkuCode,0);
            if(companySkus!=null && companySkus.size()>0){
                CompanySku sku = companySkus.get(0);
                if(spu !=null && spu !=""){ //判断传入的spu是否存在
                    MedicineSPU standardSpu = medicineSPUService.getBySpuCode(spu);
                    if(null != standardSpu && standardSpu.getId()>0){ //spu有效
                        sku.setSpuCode(spu);
                        sku.setMatched(queryCompanySkuVO.getMatched());
                        companySkuService.updateByCompanyIdAndSkuCode(sku);
                    }
                }
            }
            List<PlatformSku> platSkuList = platformSkuService.getPlatformSkuByCompanyIdAndCompanySkuCode(companyId, companySkuCode);
            for(PlatformSku platform : platSkuList){
            	platform.setSpuCode(spu);
            	platformSkuService.updatePlatformSkuById(platform);
            }
            return true;
        }
        return  false;

    }

    /**
     * 更新公司对应的标准码
     * @param queryCompanySkuVO
     * @return
     */
    @RequestMapping(value = "removeBinding", method = RequestMethod.POST)
    public Boolean removeBinding(@RequestBody QueryCompanySkuVO queryCompanySkuVO){
    	log.info("解除对码绑定，参数："+JSON.toJSONString(queryCompanySkuVO));
        Assert.notNull(queryCompanySkuVO, "dto can not be empty");
        int companyId = queryCompanySkuVO.getCompanyId();
        String companySkuCode = queryCompanySkuVO.getCompanySkuCode();

        if(companyId>0 &&companySkuCode!=null && companySkuCode !=""){ // 
        	CompanySku sku = new CompanySku();
        	sku.setCompanyId(companyId);
        	sku.setCompanySkuCode(companySkuCode);
            sku.setMatched(-1);
            sku.setSpuCode("");
            companySkuService.updateByCompanyIdAndSkuCode(sku);
                 
            platformSkuService.deleteByCompanyIdAndCompanySkuCode(companyId, companySkuCode);
            return true;
        }
        return  false;

    }
    
    /**
     * 返回所有，未匹配和已匹配的数量
     * @return
     */
    @RequestMapping(value = "/getcounts", method = RequestMethod.POST)
    public Map<String,Integer> getCompanyItemTypeCount(){
        Integer allCount = companySkuService.getCompanyItemCount(0);
        Integer matchedCount = companySkuService.getCompanyItemCount(1);
        Integer unMatchedCount = companySkuService.getCompanyItemCount(-1);

        Map<String,Integer> counts = new HashMap<>();
        counts.put("all",allCount);
        counts.put("matched",matchedCount);
        counts.put("unmatched",unMatchedCount);

        return counts;
    }

    /**
     * 本方法根据QueryCompanySkuVO返回企业的商品信息
     * @param queryCompanySkuVO
     * @return
     */
    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public ReturnCompanySkuVO getCompanySku(@RequestBody QueryCompanySkuVO queryCompanySkuVO) {
        Assert.notNull(queryCompanySkuVO, "dto can not be empty");

        //返回值
        ReturnCompanySkuVO returnCompanySkuVO = new ReturnCompanySkuVO();
        //返回类型的集合
        List<CompanySkuDTO> dtos = new ArrayList<>();
        //查询的公司sku集合，分页后的数量
        List<CompanySku> skus = new ArrayList<>();

        //如果传输进来的参数为空，直接返回空
        if(null==queryCompanySkuVO) {
            return returnCompanySkuVO;
        }

        if (null != queryCompanySkuVO) {//如果对象为空，返回空
            Integer companyIdQ = queryCompanySkuVO.getCompanyId(); //公司id
            String companySkuQ = queryCompanySkuVO.getCompanySkuCode();//公司的sku代码
            Integer startPageQ = queryCompanySkuVO.getStartPage(); //查询的开始页面
            Integer pageSizeQ = queryCompanySkuVO.getPageSize(); //每页的数量
            Integer matchedQ = queryCompanySkuVO.getMatched();//是否匹配，-1表示没匹配上的，1匹配上，0表示所有

            if(null == matchedQ){matchedQ = 0;}

            PageInfo<CompanySku> page; //分页的辅助

            if (companyIdQ > 0) { //可转换为数字
                if (null != companySkuQ && companySkuQ != "") { //根据企业id和公司sku查询
                    PageHelper.startPage(startPageQ, pageSizeQ);
                    skus = companySkuService.getSkuByCompanyIdAndSkuCode(companyIdQ, companySkuQ,matchedQ);
                    page = new PageInfo<>(skus);

                } else {//根据企业id查询
                    PageHelper.startPage(startPageQ, pageSizeQ);
                    skus = companySkuService.getSkuByCompanyId(companyIdQ,matchedQ);
                    page = new PageInfo<>(skus);
                }
                //组装信息
                returnCompanySkuVO.setCount(page.getTotal());
                returnCompanySkuVO.setPageNum(page.getPageNum());
                returnCompanySkuVO.setPageSize(page.getPageSize());
                for (CompanySku sku : skus) {//增加上标品的字段
                    MedicineSPU spu = medicineSPUService.getBySpuCode(sku.getSpuCode());
                    CompanySkuDTO dto = new CompanySkuDTO();
                    dto.setCompanyId(sku.getCompanyId());//公司id
                    dto.setCompanySkuCode(sku.getCompanySkuCode());//公司的药品编码
                    dto.setCommonName(sku.getCommonName());
                    dto.setSpec(sku.getSpec());
                    dto.setFactoryName(sku.getFactoryName());
                    dto.setBarCode(sku.getBarCode());
                    dto.setApprovalCode(sku.getApprovalCode());
                    dto.setMedicineSPU(spu);
                    dtos.add(dto);
                }
                returnCompanySkuVO.setCompanySkuList(dtos);//设置组装后的dto
                return returnCompanySkuVO;
            }//正常的结束
        } else {
            return returnCompanySkuVO;
        }
        return returnCompanySkuVO;
    }// end of getPlatformSku
    
    /**
     * 返回sku信息，包含库存、价格
     * @return
     */
    @RequestMapping(value = "/getSkuInfo", method = RequestMethod.POST)
    public PageInfo<CompanySkuInfo> getSkuInfo(@RequestBody QueryCompanySkuVO queryCompanySkuVO){
    	PageHelper.startPage(queryCompanySkuVO.getStartPage(), queryCompanySkuVO.getPageSize());
		List<CompanySkuInfo> list = companySkuService.getCompanySkuInfoList(queryCompanySkuVO);
		PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}//end of the clase