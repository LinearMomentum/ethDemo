package com.example.demo.web.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUpload {


    public static ArrayList<ArrayList<String>> analysis(MultipartFile file) {
        ArrayList<ArrayList<String>> row = new ArrayList<>();
        //获取文件名称
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        try {
            //获取输入流
            InputStream in = file.getInputStream();
            //判断excel版本
            Workbook workbook = null;
            workbook = new XSSFWorkbook(in);


            //获取第一张工作表
            Sheet sheet = workbook.getSheetAt(0);
            //从第二行开始获取
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                //循环获取工作表的每一行
                Row sheetRow = sheet.getRow(i);
                //循环获取每一列
                ArrayList<String> cell = new ArrayList<>();
                for (int j = 0; j < sheetRow.getPhysicalNumberOfCells(); j++) {
                    //将每一个单元格的值装入列集合
                    cell.add(sheetRow.getCell(j).getStringCellValue());
                    System.out.println(sheetRow.getCell(j).getStringCellValue());
                }
                //将装有每一列的集合装入大集合
                row.add(cell);

                //关闭资源
                workbook.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("===================未找到文件======================");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===================上传失败======================");
        }
        return row;
    }

//    public static void main(String[] args) throws IOException {
//        File file = new File("test.xlsx");
//        FileInputStream excel = new FileInputStream(file);
//        MockMultipartFile mockMultipartFile = new MockMultipartFile(file.getName() + "22", excel);
//        analysis(mockMultipartFile);
//    }



}
