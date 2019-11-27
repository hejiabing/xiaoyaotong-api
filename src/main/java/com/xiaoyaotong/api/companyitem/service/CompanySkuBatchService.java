package com.xiaoyaotong.api.companyitem.service;

import java.util.List;

import com.xiaoyaotong.api.companyitem.entity.CompanySkuBatch;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/11/9 10:33
 */
public interface CompanySkuBatchService {
    public int insertCompanySkuBatch(CompanySkuBatch companySkuBatch);
    public int addCompanySkuBatchList(List<CompanySkuBatch> skus);
	public Integer getCompanySkuBatchId(int companyId, String productCode);
	public int updateCompanySkuBatchById(CompanySkuBatch csku);
	public int updateByCompanyIdAndProductCode(CompanySkuBatch csku);
	
}
