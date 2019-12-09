package com.xiaoyaotong.api.platform.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyaotong.api.platform.dto.PlatformSkuDTO;
import com.xiaoyaotong.api.platform.dto.QueryPlatformSkuVO;
import com.xiaoyaotong.api.platform.dto.ReturnPlatformVO;
import com.xiaoyaotong.api.platform.entity.PlatformSku;
import com.xiaoyaotong.api.platform.service.PlatformSkuService;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    MedicineSPUService medicineSPUService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public ReturnPlatformVO getPlatformSku(@RequestBody QueryPlatformSkuVO queryPlatformSkuVO) {
        Assert.notNull(queryPlatformSkuVO, "dto can not be empty");
        //返回值的集合
        ReturnPlatformVO returnPlatformVO = new ReturnPlatformVO();
        //返回类型的集合
        List<PlatformSkuDTO> dtos = new ArrayList<>();
        //查询的公司sku集合，分页后的数量
        List<PlatformSku> skus = new ArrayList<>();

        if (null != queryPlatformSkuVO) {//如果对象为空，返回空
            int companyIdV = queryPlatformSkuVO.getCompanyId(); //公司id
            String companySkuV = queryPlatformSkuVO.getCompanySkuCode();//公司的sku代码
            int startPage = queryPlatformSkuVO.getStartPage(); //查询的开始页面
            int pageSize = queryPlatformSkuVO.getPageSize(); //每页的数量

            PageInfo<PlatformSku> page; //分页的辅助

            if (companyIdV > 0) { //可转换为数字
                if (null != companySkuV && companySkuV != "") { //根据企业id和公司sku查询
                    PageHelper.startPage(startPage, pageSize);
                    skus = platformSkuService.getSkuByCompanyIdAndSkuCode(companyIdV, companySkuV);
                    page = new PageInfo<>(skus);

                } else {//根据企业id查询
                    PageHelper.startPage(startPage, pageSize);
                    skus = platformSkuService.getSkuByCompanyId(companyIdV);
                    page = new PageInfo<>(skus);
                }
                //组装信息
                returnPlatformVO.setCount(page.getTotal());
                returnPlatformVO.setPageNum(page.getPageNum());
                returnPlatformVO.setPageSize(page.getPageSize());
                for (PlatformSku sku : skus) {//增加上标品的字段
                    MedicineSPU spu = medicineSPUService.getBySpuCode(sku.getSpuCode());
                    PlatformSkuDTO dto = new PlatformSkuDTO();
                    dto.setSkuCode(sku.getSkuCode());
                    dto.setCompanyId(sku.getCompanyId());
                    dto.setCommonName(spu.getCommonName());
                    dto.setSpec(spu.getSpec());
                    dto.setCompanySkuCode(sku.getCompanySkuCode());
                    dto.setFactoryName(spu.getFactoryName());
                    dto.setBarCode(spu.getBarCode());
                    dto.setApprovalCode(spu.getApprovalCode());
                    dto.setSpuCode(spu.getSpuCode());
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
}//end of the clase
