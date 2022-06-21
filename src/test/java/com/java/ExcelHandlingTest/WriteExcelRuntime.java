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

public class WriteExcelRuntime {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\LENOVO\\Desktop\\DataBook3.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.createSheet("Numbers");

	//	DataFormatter df = new DataFormatter();

		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ABC");
		row.createCell(1).setCellValue("BC");
		row.createCell(2).setCellValue("C");

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		System.out.println("Done!!");
	}

}
