package com.java.ExcelHandlingTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\LENOVO\\Desktop\\DataBook2.xlsx");

		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);

		// Sheet Name Based
		Sheet sheet = workbook.getSheet("Sheet1");

		// Index Position
		// Sheet sheet=workbook.getSheetAt(0);

		DataFormatter df = new DataFormatter();

		int totalRows = sheet.getLastRowNum() + 1;
		System.out.println("Total No.of Rows:" + " " + totalRows);

		Row rows = sheet.getRow(0);

		int totalColumn = rows.getLastCellNum();
		System.out.println("Total No.of Columns:" + " " + totalColumn);

		sheet.getRow(0).getCell(3).setCellValue("Pass");
		fis.close();

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);

		fos.close();
		System.out.println("Done!!");

	}

}
