package com.xiaoyaotong.api.company.serviceImpl;

import com.xiaoyaotong.api.company.entity.Company;
import com.xiaoyaotong.api.company.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyServiceImplTest {

    @Autowired
    CompanyService companyService;

    @Test
    public void testGetCompanyById(){
    Company company = companyService.getCompanyByCompanyId(1212);
    System.out.println(company.getId());
    }

}