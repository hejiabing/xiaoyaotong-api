package com.xiaoyaotong.api.standardproduct.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicineSPUMapperTest {

    @Autowired
    MedicineSPUMapper medicineSPUMapper;

    @Test
    void getAllSPUids() {
        System.out.println(medicineSPUMapper.getAllSPUIds());
    }
    @Test
    void getSPUByid() {
        System.out.println(medicineSPUMapper.findMedicineSPUByID(1));
    }


}