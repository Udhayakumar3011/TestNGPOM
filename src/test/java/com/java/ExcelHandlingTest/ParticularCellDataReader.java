package com.java.ExcelHandlingTest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ParticularCellDataReader {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File file = new File("C:\\Users\\LENOVO\\Desktop\\DataBook.xlsx");

		Workbook workbook = WorkbookFactory.create(file);

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

		Iterator<Row> rowWise = sheet.iterator();
		while (rowWise.hasNext()) {
			Row row = (Row) rowWise.next();

			for (int i = 0; i < totalRows; i++) {

				// (0,1) (0,2)
				Cell cr = workbook.getSheetAt(0).getRow(0).getCell(2);

				String str = df.formatCellValue(cr);
				System.out.print(str + " ");
				break;
			}
			break;
		}

	}

}
