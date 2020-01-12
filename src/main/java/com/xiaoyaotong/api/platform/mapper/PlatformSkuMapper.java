package com.xiaoyaotong.api.platform.mapper;

import com.xiaoyaotong.api.platform.entity.PlatformSku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlatformSkuMapper {
    //根据skuid查询商品
    public PlatformSku getPlatformBySkuCode(String skuCode);

    //根据公司的skuid查询商品
    public List<PlatformSku> getPlatformSkuByCompanySkuCode(String companySkuCode);

    //根据公司id和spucode查询商品
    public List<PlatformSku> getPlatformSkuByCompanyIdAndSpuCode(int companyId, String SpuCode);

    //根据公司id和skucode查询商品
    public List<PlatformSku> getPlatformSkuByCompanyIdAndCompanySkuCode(@Param("companyId") int companyId, @Param("companySkuCode") String companySkuCode);


    //根据公司Id查询所有商品
    public List<PlatformSku> getPlatformSkuByCompanyId(int companyId);


    //插入
    public int insertPlatformSku(PlatformSku platformSku);


    //更新
    public int updatePlatformSku(PlatformSku platformSku);

    //删除
    public int deletePlatformSku(String skuId);

    //获取所有sku的数量
    public int getAllPlatformSkuCount();

    //分页获取
    public List<PlatformSku> getPlatformSkuList(@Param("beginPage") int beginPage, @Param("pageSize")int pageSize);

	public int updatePlatformSkuById(PlatformSku platSku);

	public List<PlatformSku> getPlatformSkuBySelective(PlatformSku platformSku);


	public int getChangedPlatformCounts(String beginTime);

    public List<PlatformSku> getChangedPlatformSkuList(@Param("beginTime")String beginTime,@Param("beginPage") int beginPage, @Param("pageSize")int pageSize);


}
