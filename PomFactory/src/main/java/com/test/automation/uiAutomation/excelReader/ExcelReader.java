package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public FileInputStream fis;
	public FileOutputStream fos;
	public String path;
	public XSSFWorkbook aBook1;
	public XSSFSheet aSheet1;
	public XSSFRow aRow1;
	public XSSFCell aCell1;

	public ExcelReader(String path1) {
		path = path1;
		try {
			fis = new FileInputStream(path);
			aBook1 = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getDataFromSheet(String sheetName, String excelName) throws Exception {
		String[][] dataSets = null;
		try {
			XSSFSheet aSheet1 = aBook1.getSheet(sheetName);
			int totalRow = aSheet1.getLastRowNum() + 1;
			int totalCol = aSheet1.getRow(0).getLastCellNum();
			dataSets = new String[totalRow-1][totalCol];
			for (int i = 1; i < totalRow; i++) {
				XSSFRow bRow = aSheet1.getRow(i);
				for (int j = 0; j < totalCol; j++) {
					dataSets[i-1][j] = bRow.getCell(j).toString();
				}
			}
		} catch (Exception e) {
			System.out.println("Excel Read Error");
			e.printStackTrace();
		}
		fis.close();
		aBook1.close();
		System.out.println(dataSets[0][0]);
		return dataSets;
	}
}
