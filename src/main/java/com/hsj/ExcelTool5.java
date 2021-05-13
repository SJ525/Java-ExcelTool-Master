package com.hsj;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ExcelTool5 {
    public static void main(String[] args) throws IOException {
        String filePath="C:\\Users\\hsj\\Desktop\\广西瑞迅\\瑞迅基础资料\\基础资料瑞迅2nd20200716\\14、车辆管理-瑞迅2nd-20200716.xlsx";
        FileInputStream fileInputStream=new FileInputStream(filePath);
        XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
        for (Sheet sheet : sheets){
            System.out.println(sheet.getSheetName());
        }
    }
}
