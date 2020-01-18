package com.xiaoyaotong.api.platform.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyaotong.api.platform.dto.PlatformSkuDTO;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import com.xiaoyaotong.api.platform.service.SkuSyncDataUpdate;
import com.xiaoyaotong.api.platform.vo.CopyPlatformSkuVO;
import com.xiaoyaotong.api.platform.vo.OnsalePlatformSkuVO;
import com.xiaoyaotong.api.platform.vo.QueryPlatformSkuVO;
import com.xiaoyaotong.api.platform.vo.ReturnPlatformVO;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import com.xiaoyaotong.api.util.GenerateUniqueIdUtil;

/**
 * @author ：billHe
 * @description：主要提供商品资料的页面
 * @date ：2019/12/1 8:06 PM
 */
@RestController
@RequestMapping("/platformsku")
public class PlatformSkuController {

    @Autowired
    PlatformSkuService platformSkuService;
    @Autowired
    SkuSyncDataUpdate skuSyncDataUpdate;
    @Autowired
    MedicineSPUService medicineSPUService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public ReturnPlatformVO getPlatformSku(@RequestBody QueryPlatformSkuVO queryPlatformSkuVO) {
        Assert.notNull(queryPlatformSkuVO, "dto can not be empty");
        //返回值的集合
        ReturnPlatformVO returnPlatformVO = new ReturnPlatformVO();
        //返回类型的集合
        List<PlatformSkuDTO> dtos = new ArrayList<>();
        //查询的公司sku集合，分页后的数量

        if (null != queryPlatformSkuVO) {//如果对象为空，返回空
        	PlatformSku platformSku =new PlatformSku();
        	BeanUtils.copyProperties(queryPlatformSkuVO, platformSku);
            int startPage = queryPlatformSkuVO.getStartPage(); //查询的开始页面
            int pageSize = queryPlatformSkuVO.getPageSize(); //每页的数量

            if(pageSize<2) pageSize = 10;
            if(startPage< 0 ) startPage = 0;

            PageInfo<PlatformSku> page; //分页的辅助
            PageHelper.startPage(startPage, pageSize);
            if (platformSku.getCompanyId() > 0) { //可转换为数字
                List<PlatformSku> skus = platformSkuService.getPlatformSkuBySelective(platformSku);
                page = new PageInfo<>(skus);

                //组装信息
                returnPlatformVO.setCount(page.getTotal());
                returnPlatformVO.setPageNum(page.getPageNum());
                returnPlatformVO.setPageSize(page.getPageSize());
                for (PlatformSku sku : skus) {//增加上标品的字段
                    MedicineSPU spu = medicineSPUService.getBySpuCode(sku.getSpuCode());
                    PlatformSkuDTO dto = new PlatformSkuDTO();
                    dto.setSkuCode(sku.getSkuCode());
                    dto.setSpu(spu);
                    dto.setSku(sku);
                    dtos.add(dto);
                }
                returnPlatformVO.setProductList(dtos);//设置组装后的dto
                return returnPlatformVO;
            }//正常的结束
        } else {
            returnPlatformVO.setCount(10);
            returnPlatformVO.setPageNum(0);
            returnPlatformVO.setPageSize(10);
            returnPlatformVO.setProductList(dtos);
            return returnPlatformVO;
        }
        return returnPlatformVO;
    }// end of getPlatformSku

    @RequestMapping(value ="/copy",method = RequestMethod.POST)
    public PlatformSku insertPlatformSku(@RequestBody CopyPlatformSkuVO copyPlatformSkuVo ){
        Assert.notNull(copyPlatformSkuVo, "dto can not be empty");

         String skuId = copyPlatformSkuVo.getSkuCode(); //需要copy的skuid
         int validMonthStart = copyPlatformSkuVo.getValidMonthStart(); //效期的开始时间
         int validMonthEnd = copyPlatformSkuVo.getValidMonthEnd(); //效期的结束时间
         BigDecimal price = copyPlatformSkuVo.getPrice(); //价格

        PlatformSku basicPlatformSku = platformSkuService.getSkuBySkuCode(skuId);//查询到的原始
        PlatformSku newPlatformSku = new PlatformSku();

        String newSkuId = GenerateUniqueIdUtil.getUniqueSkuid();
        newPlatformSku.setSkuCode(newSkuId);//设置skuid
        newPlatformSku.setCompanyId(basicPlatformSku.getCompanyId()); //设置companyid
        newPlatformSku.setCompanySkuCode(basicPlatformSku.getCompanySkuCode()); //设置companyskucode
        newPlatformSku.setCompanyName(basicPlatformSku.getCompanyName()); //设置公司名称
        newPlatformSku.setValidMonthStart(validMonthStart); //设置效期开始时间
        newPlatformSku.setValidMonthEnd(validMonthEnd); //设置效期结束时间
        newPlatformSku.setCommonPrice(price);
        newPlatformSku.setSpuCode(basicPlatformSku.getSpuCode());
        newPlatformSku.setStatus(1);//克隆默认上架
        newPlatformSku.setCreateTime(new Date());
        newPlatformSku.setCreateUser(basicPlatformSku.getCompanyId().toString());
        platformSkuService.insertPlatformSku(newPlatformSku);
        skuSyncDataUpdate.stockProducer(basicPlatformSku.getCompanySkuCode(), basicPlatformSku.getCompanyId());
        return platformSkuService.getSkuBySkuCode(newSkuId);
    }

    @RequestMapping(value ="/onsale",method = RequestMethod.POST)
    public int onSalePlatformSku(@RequestBody OnsalePlatformSkuVO onsalePlatformSkuVO){
        Assert.notNull(onsalePlatformSkuVO, "dto can not be empty");
        int onsale = onsalePlatformSkuVO.getStatus();
        int result = 0 ;

        if(CollectionUtils.isNotEmpty(onsalePlatformSkuVO.getCompanySkuCodes())){
        	for(String companySkuCode : onsalePlatformSkuVO.getCompanySkuCodes()){
                PlatformSku platformSku = new PlatformSku();
                platformSku.setCompanySkuCode(companySkuCode);
                platformSku.setStatus(onsale);
                platformSku.setCompanyId(onsalePlatformSkuVO.getCompanyId());
                int re = platformSkuService.updatePlatformSku(platformSku);
                if(re>0){
                    result++;
                }
            }
        }
        if(CollectionUtils.isNotEmpty(onsalePlatformSkuVO.getSkuCodes())){
        	for(String skuCode : onsalePlatformSkuVO.getSkuCodes()){
                PlatformSku platformSku = new PlatformSku();
                platformSku.setSkuCode(skuCode);
                platformSku.setStatus(onsale);
                platformSku.setCompanyId(onsalePlatformSkuVO.getCompanyId());
                int re = platformSkuService.updatePlatformSku(platformSku);
                if(re>0){
                    result++;
                }
            }
        }
        
        return result;
    }

}//end of the clase

