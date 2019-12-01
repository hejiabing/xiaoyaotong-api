package com.xiaoyaotong.api.companyitem.service;

import com.xiaoyaotong.api.companyitem.entity.CompanySkuPrice;

public interface CompanySkuPriceService {

	Integer getCompanySkuPriceId(CompanySkuPrice csku);

	int updateCompanySkuPriceById(CompanySkuPrice csku);

	int insertCompanySkuPrice(CompanySkuPrice csku);

	int updateByCompanyIdAndSkuCode(CompanySkuPrice csku);

}
