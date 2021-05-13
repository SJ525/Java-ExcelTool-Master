package com.hsj;

import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    //字符串过滤
    public static List<String> getStr(List<String> list){
        List<String> list1 = new ArrayList<String>();
        for (String str:list) {
            int length=str.length();
            String getStr = new String();
            for (int i=0;i<length;i++){
                if (str.charAt(i)=='【'){
                    getStr=str.substring(0,i);
                }
            }
            list1.add(getStr);
        }
        return list1;
    }
    public static void main(String[] args) throws IOException {
        String filePath="C:\\Users\\hsj\\Desktop\\广西瑞迅\\瑞迅基础资料\\基础资料瑞迅2nd20200716\\1、库区管理-瑞迅2nd-20200716.xlsx";
        String sheetName="区域管理（基础资料）";
        FileInputStream fileInputStream=new FileInputStream(filePath);
        XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
        List<XSSFName> list=sheets.getAllNames();
        for (XSSFName str:list) {
            System.out.println(str.getSheetName());
        }
    }
}
