package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String togetDataFromExcelFile(String Sheetname,int RowNum,int CellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1Selenium.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(Sheetname).getRow(RowNum).getCell(CellNum).getStringCellValue();
	wb.close();
	return data;	
		
		
	}
	public int togetLastRowCount(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int count = wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return count;
		
		
	}
	
	
	

}
