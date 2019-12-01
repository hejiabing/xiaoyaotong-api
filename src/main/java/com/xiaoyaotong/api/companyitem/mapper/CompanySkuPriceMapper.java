package com.xiaoyaotong.api.companyitem.mapper;

import com.xiaoyaotong.api.companyitem.entity.CompanySkuPrice;

public interface CompanySkuPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanySkuPrice record);

    int insertSelective(CompanySkuPrice record);

    CompanySkuPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanySkuPrice record);

    int updateByPrimaryKey(CompanySkuPrice record);

	Integer getCompanySkuPriceId(CompanySkuPrice csku);

	int updateByCompanyIdAndSkuCode(CompanySkuPrice csku);
}