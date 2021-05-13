package com.hsj;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelTool3 {
    //根据行和列的索引获取单元格的数据
    public String getMsgByIndex(XSSFSheet sheet, int row, int column){
        XSSFRow row1 = sheet.getRow(row);
        String cell = null;
        try {
            cell = row1.getCell(column).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cell;
    }
    //写入单元格的值
    public void setMsgByIndex(XSSFSheet sheet, int row, int column,String value){
        XSSFRow row1 = sheet.getRow(row);
        
    }
}
