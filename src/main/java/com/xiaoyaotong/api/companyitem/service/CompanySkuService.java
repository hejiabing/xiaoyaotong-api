package com.xiaoyaotong.api.companyitem.service;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;

import java.util.List;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 10:33
 */
public interface CompanySkuService {
    public int insertCompanySku(CompanySku companySku);
    public int deleteCompanySku(CompanySku companySku);
    public CompanySku getCompanySkuById(int companyId, String erpProductCode);
    public List<CompanySku> getCompanySkuList(int itemBegin, int itemNum);
    public int addCompanySkuList(List<CompanySku> skus);
}
