package com.xiaoyaotong.api.companyitem.serviceImpl;

import com.xiaoyaotong.api.companyitem.service.CompanySkuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CompanySkuServiceImplTest {

    @Autowired
    private CompanySkuService companySkuService;
    @Test
    void insertCompanySku() {
        /*
        CompanySku cs = new CompanySku();
        cs.setErpId("s00001");
        cs.setApprovalCode("国B1243");
        cs.setCommonName("阿司匹林");
        cs.setSpec("1s");
        cs.setFactoryName("华中药品");
        cs.setCompayId(2);
        cs.setBarCode("234343");
        companySkuService.insertCompanySku(cs);
        */

    }

    @Test
    void deleteCompanySku() {
    }

    @Test
    void getCompanySkuById() {
    }

    @Test
    void getCompanySkuList() {
        List ll = companySkuService.getCompanySkuList(0,100);
        System.out.println(ll.size());
    }
}