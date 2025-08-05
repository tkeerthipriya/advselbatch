package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readDataFRomExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Book1Selenium.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		Row rw = sh.getRow(1);
		String campname = rw.getCell(2).toString();
		System.out.println(campname);
		String target = rw.getCell(3).toString();
		System.out.println(target);
		

	}

}
