package com.xiaoyaotong.api.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoyaotong.api.company.entity.Company;
import com.xiaoyaotong.api.company.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value ="/getCompanyInfo",method = RequestMethod.POST)
    public Company getCompanyInfo( Integer companyId){
		return companyService.getCompanyByCompanyId(companyId);
	}
}
