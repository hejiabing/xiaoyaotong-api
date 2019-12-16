package com.xiaoyaotong.api.companyitem.mapper;

import org.apache.ibatis.annotations.Param;

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

	CompanySkuPrice getCompanySkuPrice(@Param("companyId") Integer companyId,
			@Param("companySkuCode") String companySkuCode);
}