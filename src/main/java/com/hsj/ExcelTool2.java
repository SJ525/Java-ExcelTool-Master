package com.hsj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTool2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\hsj\\Desktop\\20201028\\1emp.xlsx");
        XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
        //获取sheet
        XSSFSheet sheet = sheets.getSheet("Sheet1");
        //获取表的总行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        String indexValue1=new String();
        for (int i=0;i<rowNum;i++){
            indexValue1=getExcelDateByIndex(sheet,i,0);
            list1.add(indexValue1);
        }
        String indexValue2=new String();
        for (int i=0;i<rowNum;i++){
            try {
                indexValue2=getExcelDateByIndex(sheet,i,1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(indexValue2!=null){
                list2.add(indexValue2);
            }
        }
        List<String> diff=getDifferent(list1,list2);
        String select="select * from SKJTOYW_INV_BF where HISTID in(";
        for (String str:diff) {
            System.out.println(str);
            select+=","+str;
            //System.out.println("delete from PUB_SALERANGE where COMPANYSALRANGEID="+str+";");
        }
        System.out.println(select+");");
    }


     //根据行和列的索引获取单元格的数据
    public static String getExcelDateByIndex(XSSFSheet sheet, int row, int column){
        XSSFRow row1 = sheet.getRow(row);
        String cell = null;
        try {
            cell = row1.getCell(column).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cell;
    }

    //获取两个list对象不同
    private static List<String> getDifferent(List<String> list1, List<String> list2) {
        List<String> diff = new ArrayList<String>();
        for(String str:list1)
        {
            if(!list2.contains(str))
            {
                diff.add(str);
            }
        }
        return diff;
    }
}

