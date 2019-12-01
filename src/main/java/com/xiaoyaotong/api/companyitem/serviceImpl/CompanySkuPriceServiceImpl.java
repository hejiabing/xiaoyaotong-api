package com.xiaoyaotong.api.companyitem.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyaotong.api.companyitem.entity.CompanySkuPrice;
import com.xiaoyaotong.api.companyitem.mapper.CompanySkuPriceMapper;
import com.xiaoyaotong.api.companyitem.service.CompanySkuPriceService;
@Service
public class CompanySkuPriceServiceImpl implements CompanySkuPriceService{

	@Autowired
	private CompanySkuPriceMapper  companySkuPriceMapper;
	
	@Override
	public Integer getCompanySkuPriceId(CompanySkuPrice csku) {
		return companySkuPriceMapper.getCompanySkuPriceId(csku);
	}

	@Override
	public int updateCompanySkuPriceById(CompanySkuPrice csku) {
		return companySkuPriceMapper.updateByPrimaryKeySelective(csku);
	}

	@Override
	public int insertCompanySkuPrice(CompanySkuPrice csku) {
		csku.setCreateTime(new Date());
		csku.setCreateUser("sysSync");
		return companySkuPriceMapper.insertSelective(csku);
	}

	@Override
	public int updateByCompanyIdAndSkuCode(CompanySkuPrice csku) {
		return companySkuPriceMapper.updateByCompanyIdAndSkuCode(csku);
	}

}
