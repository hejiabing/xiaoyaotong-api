package com.xiaoyaotong.api.companyitem.vo;

import java.util.List;

import com.xiaoyaotong.api.companyitem.entity.CompanySku;
import com.xiaoyaotong.api.companyitem.entity.CompanySkuBatch;
import com.xiaoyaotong.api.companyitem.entity.CompanySkuPrice;

public class CompanySkuInfo extends CompanySku {

	private List<CompanySkuBatch> skuBatchList;
	
	private CompanySkuPrice skuPirce;

	public List<CompanySkuBatch> getSkuBatchList() {
		return skuBatchList;
	}

	public void setSkuBatchList(List<CompanySkuBatch> skuBatchList) {
		this.skuBatchList = skuBatchList;
	}

	public CompanySkuPrice getSkuPirce() {
		return skuPirce;
	}

	public void setSkuPirce(CompanySkuPrice skuPirce) {
		this.skuPirce = skuPirce;
	}

	 

	 
}
