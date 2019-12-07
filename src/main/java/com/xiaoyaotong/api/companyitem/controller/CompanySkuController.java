package com.xiaoyaotong.api.companyitem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyaotong.api.companyitem.dto.CompanySkuDTO;
import com.xiaoyaotong.api.companyitem.vo.QueryCompanySkuVO;
import com.xiaoyaotong.api.companyitem.vo.ReturnCompanySkuVO;
import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import com.xiaoyaotong.api.platform.dto.PlatformSkuDTO;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：billHe
 * @description：公司商品的信息
 * @date ：2019/12/7 8:17 PM
 */
@RestController
@RequestMapping(value = "companysku")
public class CompanySkuController {
    @Autowired
    CompanySkuService companySkuService;

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
        String spu = queryCompanySkuVO.getSpu();

        if(companyId>0 &&companySkuCode!=null && companySkuCode !=""){ //确保能找到一个商品
            List<CompanySku> companySkus = companySkuService.getSkuByCompanyIdAndSkuCode(companyId,companySkuCode);
            if(companySkus!=null && companySkus.size()>0){
                CompanySku sku = companySkus.get(0);
                if(spu !=null && spu !=""){ //判断传入的spu是否存在
                    MedicineSPU standardSpu = medicineSPUService.getBySpuCode(spu);
                    if(null != standardSpu && standardSpu.getId()>0){ //spu有效
                        sku.setSpuCode(spu);
                        int result = companySkuService.updateByCompanyIdAndSkuCode(sku);
                        if(result>0){return true;}
                    }
                }
            }
        }
        return  false;

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
            int companyIdQ = queryCompanySkuVO.getCompanyId(); //公司id
            String companySkuQ = queryCompanySkuVO.getCompanySkuCode();//公司的sku代码
            int startPageQ = queryCompanySkuVO.getStartPage(); //查询的开始页面
            int pageSizeQ = queryCompanySkuVO.getPageSize(); //每页的数量

            PageInfo<CompanySku> page; //分页的辅助

            if (companyIdQ > 0) { //可转换为数字
                if (null != companySkuQ && companySkuQ != "") { //根据企业id和公司sku查询
                    PageHelper.startPage(startPageQ, pageSizeQ);
                    skus = companySkuService.getSkuByCompanyIdAndSkuCode(companyIdQ, companySkuQ);
                    page = new PageInfo<>(skus);

                } else {//根据企业id查询
                    PageHelper.startPage(startPageQ, pageSizeQ);
                    skus = companySkuService.getSkuByCompanyId(companyIdQ);
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
}//end of the clase