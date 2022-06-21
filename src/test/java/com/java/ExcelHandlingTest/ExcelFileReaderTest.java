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

public class ExcelFileReaderTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Excel File Structure

		// File-Input Stream
		// Workbook-Sheet-Row-Column-Cell
		// DataFormatter

		File file = new File("C:\\Users\\LENOVO\\Desktop\\DataBook.xlsx");

		Workbook workbook = WorkbookFactory.create(file);

		// Sheet Name Based
		Sheet sheet = workbook.getSheet("Sheet1");

		// Index Position
		// Sheet sheet=workbook.getSheetAt(0);

		DataFormatter df = new DataFormatter();

		Iterator<Row> rows = sheet.iterator();
		while (rows.hasNext()) {
			Row row = (Row) rows.next();

			Iterator<Cell> column = row.iterator();
			while (column.hasNext()) {
				Cell cell = (Cell) column.next();

				System.out.print(df.formatCellValue(cell));
				System.out.print("|");

			}
			System.out.println(" ");
		}

	}

}
