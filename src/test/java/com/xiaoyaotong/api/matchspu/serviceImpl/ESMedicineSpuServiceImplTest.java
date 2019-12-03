package com.xiaoyaotong.api.matchspu.serviceImpl;

import com.xiaoyaotong.api.search.entity.ESMedicineSpu;
import com.xiaoyaotong.api.search.serviceImpl.ESMedicineSpuServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ESMedicineSpuServiceImplTest {

    @Autowired
    ESMedicineSpuServiceImpl medicineSpuService;

    @Test
    void testAddMedicineSpu(){
        //System.setProperty("es.set.netty.runtime.available.processors", "false");

        ESMedicineSpu medicineSpu = new ESMedicineSpu();
        medicineSpu.setCommonName("1111");
        medicineSpuService.addMedicineSpu(medicineSpu);
    }

}