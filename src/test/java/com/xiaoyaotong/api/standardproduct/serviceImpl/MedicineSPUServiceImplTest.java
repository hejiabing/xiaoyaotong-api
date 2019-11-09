package com.xiaoyaotong.api.standardproduct.serviceImpl;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPUPic;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MedicineSPUServiceImplTest {

    @Autowired
    MedicineSPUService medicineSPUService;

    @Test
    void getAllspuids() {
        System.out.println(medicineSPUService.getAllSPUid());
    }

    @Test
    void getSPUbyID(){
        MedicineSPU m = medicineSPUService.getSPUByspuid(1);
        List<MedicineSPUPic> ll = m.getPics();
        for(MedicineSPUPic e:ll){
           System.out.println(e.getId());
        }
        System.out.println(medicineSPUService.getSPUByspuid(1));
    }

    @Test
    void testGetSPUList(){
        List<MedicineSPU> spus = medicineSPUService.getSPUList(0,12);
        for (MedicineSPU m:spus) {
            System.out.println();
            System.out.println(m);
        }
    }


    void testInsertItem(){
        MedicineSPU spu = new MedicineSPU();
        spu.setId(0);
        spu.setSpuId(5);
        spu.setCommonName("武汉");
        spu.setSpec("12s*6");
        spu.setFactoryName("湖北武汉");
        spu.setApprovalCode("国A5432");
        medicineSPUService.insertMedicineSPU(spu);
    }
}