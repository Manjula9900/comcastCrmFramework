package MockPreparation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testdata/data.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
	    String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
	    
	    return data;	 
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("/testdat/data.xlsx");
		 Workbook  wb= WorkbookFactory.create(fis);
		   int     rowCount = wb.getSheet(sheetName).getLastRowNum();
		   return rowCount;
	}
	public void setDataIntoExcel(String sheetName, int rowNum, int CelNum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testadata/data.xlsx");
		         Workbook    wb =  WorkbookFactory.create(fis);
		          wb.getSheet(sheetName).getRow(rowNum).createCell(CelNum);
		          FileOutputStream fos = new FileOutputStream("./testdata/data.xlsx");
		          wb.write(fos);
		          wb.close();
	}

}
