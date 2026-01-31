package Genericlabaries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {

	Workbook wb;
	DataFormatter formatter = new DataFormatter();

	public Excelutility() throws Throwable {
		FileInputStream fis = new FileInputStream("G:\\My Drive\\CabcherTestData.xlsx");
		wb = WorkbookFactory.create(fis);
	}

	// ✅ Always return clean String (NO .0 issue)
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) {

		Sheet sh = wb.getSheet(sheetName);
		if (sh == null)
			return "";

		Row row = sh.getRow(rowNum);
		if (row == null)
			return "";

		Cell cell = row.getCell(cellNum);
		if (cell == null)
			return "";

		return formatter.formatCellValue(cell).trim();
	}

	public int getRowCount1(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}

	public int getRowcount(String sheetName) throws Throwable {

		FileInputStream fis = new FileInputStream("\"G:\\My Drive\\CabcherTestData.xlsx\"");

		Workbook wb = WorkbookFactory.create(fis);
		int rowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowNum;

	}
	public void SetDataIntoExcel(String sheetName, int rowIndex, int cellIndex, String value) throws IOException {

	    String filePath = "G:\\My Drive\\CabcherTestData.xlsx";
	    File file = new File(filePath);

	    Workbook workbook;
	    Sheet sheet;

	    // If file exists, read it
	    if (file.exists()) {
	        FileInputStream fis = new FileInputStream(file);
	        workbook = new XSSFWorkbook(fis);
	        fis.close();
	    } 
	    // If file does NOT exist, create new workbook
	    else {
	        workbook = new XSSFWorkbook();
	    }

	    // Get sheet or create it
	    sheet = workbook.getSheet(sheetName);
	    if (sheet == null) {
	        sheet = workbook.createSheet(sheetName);
	    }

	    // Get row or create it
	    Row row = sheet.getRow(rowIndex);
	    if (row == null) {
	        row = sheet.createRow(rowIndex);
	    }

	    // Create cell and set value
	    Cell cell = row.createCell(cellIndex);
	    cell.setCellValue(value);

	    // Write data to file
	    FileOutputStream fos = new FileOutputStream(file);
	    workbook.write(fos);

	    fos.close();
	    workbook.close();
	}


	public int getNextEmptyRow(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("G:\\\\My Drive\\\\CabcherTestData.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			workbook.close();
			return 0;
		}

		int rowCount = sheet.getLastRowNum();
		for (int i = 0; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			if (row == null || row.getCell(0) == null || row.getCell(0).getCellType() == CellType.BLANK) {
				workbook.close();
				return i;
			}
		}
		workbook.close();
		return rowCount + 1;
	}

	public int getRowCount(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream("G:\\\\\\\\My Drive\\\\\\\\CabcherTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum(); // skip header
		wb.close();
		fis.close();
		return rowCount;
	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws Exception {
		FileInputStream fis = new FileInputStream("G:\\\\\\\\My Drive\\\\\\\\CabcherTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String cellData = sh.getRow(rowNum).getCell(colNum).toString();
		wb.close();
		fis.close();
		return cellData;
	}

	private static final String EXCEL_PATH = "G:\\My Drive\\CabcherTestData.xlsx";

	/**
	 * Returns number of cells (columns) in a given row
	 */
	public int getCellCount(String sheetName, int rowNum) throws Throwable {

		FileInputStream fis = new FileInputStream(EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNum);

		int cellCount = row.getLastCellNum(); // index starts from 1

		workbook.close();
		fis.close();

		return cellCount;
	}

}
