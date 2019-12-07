package com.xiaoyaotong.api.standardproduct.controller;

import com.xiaoyaotong.api.standardproduct.entity.MedicineSPU;
import com.xiaoyaotong.api.standardproduct.service.MedicineSPUService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/4 11:25 PM
 */
@RestController
@RequestMapping("/medicinespu")
public class TestMedineSPUController  {
    private static Logger logger = Logger.getLogger(TestMedineSPUController.class.getName()); // 日志打印类

    @Autowired
    MedicineSPUService medicineSPUService;

    //@RequestMapping(value="/test", method = RequestMethod.GET)
    void testInsertItemFromExcel() {
        try {
            // 获取Excel文件
            File excelFile = new File("/Users/tangliyan/data/spu.xlsx");
            if (!excelFile.exists()) {
                logger.warning("指定的Excel文件不存在！");
                return;
            }
            FileInputStream inputStream = new FileInputStream(excelFile);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                logger.warning("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = 62137;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }

                //构造对象MedicineSpu对象
                MedicineSPU medicineSPU = new MedicineSPU();

                Cell cell;
                // 获取国药准字
                cell = row.getCell(1);
                if(null == cell){
                    continue;
                }
                medicineSPU.setApprovalCode(cell.getStringCellValue());

                //获取通用名
                cell = row.getCell(4);
                if(null == cell){
                    continue;
                }
                medicineSPU.setCommonName(cell.getStringCellValue());

                //获取规格
                cell = row.getCell(5);
                if(null == cell){
                    continue;
                }
                medicineSPU.setSpec(cell.getStringCellValue());
                //生产厂家
                cell=row.getCell(6);
                if(null == cell){
                    continue;
                }
                medicineSPU.setFactoryName(cell.getStringCellValue());
                //条形码
                cell=row.getCell(11);
                if(null==cell || null == cell.getStringCellValue()){
                    medicineSPU.setBarCode("");
                }else {
                    medicineSPU.setBarCode(cell.getStringCellValue());
                }

                medicineSPUService.addMedicineSPU(medicineSPU);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
