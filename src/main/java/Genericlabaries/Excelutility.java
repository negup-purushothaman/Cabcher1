package Genericlabaries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelutility {
 
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
	    FileInputStream fis = new FileInputStream("G:\\\\\\\\My Drive\\\\\\\\CabcherTestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheetName);
	    Row row = sh.getRow(rowNum);

	    if (row == null || row.getCell(cellNum) == null) {
	        wb.close();
	        return ""; // return blank if cell is empty
	    }

	    String data = row.getCell(cellNum).toString();
	    wb.close();
	    return data;
	}
	
	
	public Object[][] getExcelData(String sheetName) throws Exception {
	    FileInputStream fis = new FileInputStream("G:\\My Drive\\CabcherTestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet(sheetName);
	    
	    int rowCount = sheet.getPhysicalNumberOfRows();
	    int colCount = sheet.getRow(0).getLastCellNum();

	    Object[][] data = new Object[rowCount - 1][colCount];

	    for (int i = 1; i < rowCount; i++) { // Skip header row
	        for (int j = 0; j < colCount; j++) {
	            data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
	        }
	    }
	    wb.close();
	    return data;
	    
	    
	    
	    
	}

	
	
	
	
	
	
		
  public int getRowcount(String sheetName) throws Throwable		{
	  
	  FileInputStream fis=new FileInputStream("\"G:\\My Drive\\CabcherTestData.xlsx\"");
		
		
		Workbook wb=WorkbookFactory.create(fis);
		int rowNum=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowNum; 
		
		}
  public void SetDataIntoExcel(String sheetName, int rowIndex, int cellIndex, String value) throws IOException {
	    // Correct path without extra quotes
	    String filePath = "G:\\My Drive\\CabcherTestData.xlsx";

	    FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    // Create row if it doesn't exist
	    Row row = sheet.getRow(rowIndex);
	    if (row == null) {
	        row = sheet.createRow(rowIndex);
	    }

	    // Create cell and set value
	    Cell cell = row.createCell(cellIndex);
	    cell.setCellValue(value);

	    // Close input before writing
	    fis.close();

	    // Save changes
	    FileOutputStream fos = new FileOutputStream(filePath);
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
  


 


}
	
	
