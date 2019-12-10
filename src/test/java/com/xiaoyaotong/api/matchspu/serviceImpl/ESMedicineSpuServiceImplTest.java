package com.xiaoyaotong.api.matchspu.serviceImpl;

import com.xiaoyaotong.api.search.entity.EsMedicineSpu;
import com.xiaoyaotong.api.search.serviceImpl.EsMedicineSpuServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ESMedicineSpuServiceImplTest {

    @Autowired
    EsMedicineSpuServiceImpl medicineSpuService;

    @Test
    void testAddMedicineSpu(){
        //System.setProperty("es.set.netty.runtime.available.processors", "false");

        EsMedicineSpu medicineSpu = new EsMedicineSpu();
        medicineSpu.setCommonName("1111");
        medicineSpuService.addMedicineSpu(medicineSpu);
    }

}