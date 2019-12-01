package com.xiaoyaotong.api.platform.mapper;

import com.xiaoyaotong.api.platform.entity.PlatformSku;

import java.util.List;

public interface PlatformSkuMapper {
    //根据skuid查询商品
    public List<PlatformSku> getPlatformSkuById(String skuid);

    //根据公司的skuid查询商品
    public List<PlatformSku> getPlatformSkuByCompanySkuCode(String companySkuCode);

    //根据公司id和spucode查询商品
    public List<PlatformSku> getPlatformSkyByCompanyIdAndSpuCode(int companyId, String SpuCode);

    //根据公司Id查询所有商品
    public List<PlatformSku> getPlatformSkyByCompanyId(int companyId);


    //插入
    public void insertPlatformSku(PlatformSku platformSku);


    //更新
    public void updatePlatformSku(PlatformSku platformSku);

    //删除
    public void deletePlatformSku(String skuId);



}
