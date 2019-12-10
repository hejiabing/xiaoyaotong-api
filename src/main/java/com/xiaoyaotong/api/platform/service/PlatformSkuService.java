package com.xiaoyaotong.api.platform.service;

import com.xiaoyaotong.api.platform.entity.PlatformSku;

import java.util.List;

public interface PlatformSkuService {

    public int getAllPlatformSkuCount();

    //根据SKUid获取
    public PlatformSku getSkuBySkuId(String skuId);

    //根据公司ID获取SKU列表
    public List<PlatformSku> getSkuByCompanyId(int companyId);

    public List<PlatformSku> getPlatformSkuList(int beginPage, int pageSize);

    //根据companyid & companyskucode查询
    public List<PlatformSku> getSkuByCompanyIdAndSkuCode(int companyId, String companySkucode);

    //插入sku
    public int insertPlatformSku(PlatformSku platformSku);

    //更新sku
    public int updatePlatformSku(PlatformSku platformSku);

    //根据Skuid删除SKU
    public int deletePlatformSku(String skuId);
    
}
