package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFromMultipleRows {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Book1Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("MobileMultipleRow");
	int lastrow = sh.getLastRowNum();
	for(int i=1;i<=lastrow;i++) {
	 Row rw = sh.getRow(i);
	String mobilecompany = rw.getCell(0).getStringCellValue();
	String mobiletype = rw.getCell(1).getStringCellValue();
	System.out.println(mobilecompany+"=="+mobiletype);
	
		
	}
	System.out.println(lastrow);
	
	
	

	}

}
