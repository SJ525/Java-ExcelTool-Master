package com.hsj;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTool4 {
    //根据行和列的索引获取单元格的数据
    public static String getMsgByIndex(XSSFSheet sheet, int row, int column){
        XSSFRow row1 = sheet.getRow(row);
        String cell = null;
        try {
            cell = row1.getCell(column).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cell;
    }
    public static void main(String[] args) throws IOException {
        String filePath="C:\\Users\\hsj\\Desktop\\广西瑞迅\\瑞迅基础资料\\基础资料瑞迅2nd20200716\\14、车辆管理-瑞迅2nd-20200716.xlsx";
        String sheetName="基础资料";
        FileInputStream fileInputStream=new FileInputStream(filePath);
        XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);

        //获取sheet
        XSSFSheet sheet = sheets.getSheet(sheetName);
        //获得总列数
        int coloumNum=sheet.getRow(0).getPhysicalNumberOfCells();
        String indexValue=new String();
        List<String> list = new ArrayList<String>();
        for (int i=0;i<coloumNum+1;i++){
            try {
                indexValue=getMsgByIndex(sheet,0,i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(indexValue!=null){
                list.add(indexValue);
            }
        }
        String select="select";
        String table="";
        for (Sheet s : sheets){
            System.out.println(s.getSheetName());
        }
        for (String str:list) {
            if (str.contains("【")){
                str=str.substring(0,str.indexOf("【"));
            }
            select+=",t."+str;
        }
        System.out.println(select+",t.rowid from"+table);
    }
}
