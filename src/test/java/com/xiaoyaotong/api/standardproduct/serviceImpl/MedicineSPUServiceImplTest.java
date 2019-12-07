package com.xiaoyaotong.api.standardproduct.serviceImpl;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.entity.MedicineSPUPic;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class MedicineSPUServiceImplTest {
    private static Logger logger = Logger.getLogger(MedicineSPUServiceImplTest.class.getName()); // 日志打印类


    @Autowired
    MedicineSPUService medicineSPUService;

    void getAllspuids() {
        System.out.println(medicineSPUService.getAllSPUCode());
    }

    void getSPUbyID(){
        MedicineSPU m = medicineSPUService.getBySpuCode("1");
        List<MedicineSPUPic> ll = m.getPics();
        for(MedicineSPUPic e:ll){
           System.out.println(e.getId());
        }
        System.out.println(medicineSPUService.getBySpuCode("1"));
    }


    void testGetSPUList(){
        List<MedicineSPU> spus = medicineSPUService.getSPUList(0,12);
        for (MedicineSPU m:spus) {
            System.out.println();
            System.out.println(m);
        }
    }

    @Test
    void testInsertItem(){


    }
}