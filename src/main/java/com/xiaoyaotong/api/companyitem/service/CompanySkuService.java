package com.xiaoyaotong.api.companyitem.service;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 10:33
 */
public interface CompanySkuService {
    public int insertCompanySku(CompanySku companySku);

    public int deleteCompanySku(CompanySku companySku);

    /**
     * 根据企业id和企业的sku编码查询商品
     * @param companyId
     * @param skuCode
     * @return
     */
    public List<CompanySku> getSkuByCompanyIdAndSkuCode(int companyId, String skuCode,int matched);

    public List<CompanySku> getCompanySkuList(int itemBegin, int itemNum);

    /**
     * 根据企业id查询本公司的商品
     * @param companyId
     * @return
     */
    public List<CompanySku> getSkuByCompanyId(int companyId,int matached);

    public int addCompanySkuList(List<CompanySku> skus);

    public int updateCompanySkuById(CompanySku csku);

    public int updateByCompanyIdAndSkuCode(CompanySku csku);

	public int insertCompanySkuBySelective(CompanySku csku);

	public int getCompanyItemCount(int matched);

    public int getIncrementCompanyItemCount(Date beginTime);

    public List<CompanySku> getIncrementCompanyItemList(Date beginTime,int beginPage,int pageSize);
}
