package avactis_util;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.String;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import avactis_base.TestBase;

public class TestUtil extends TestBase{
    public static long PAGE_LOAD_TIMEOUT=40;
    public static long IMPLICIT_WAIT=20;
    WebDriver driver;
    
    public void pageDown() {
   	 JavascriptExecutor js = (JavascriptExecutor) driver;
  	 js.executeScript("window.scrollBy(0,300)");
    }
    public void pageUp() throws AWTException {
    	Robot robot=new Robot();
  	  robot.keyPress(KeyEvent.VK_PAGE_UP);
    }
    File file;
	FileInputStream fis;
	HSSFWorkbook wb;
	HSSFSheet sheet;
	HSSFRow rw;
	HSSFCell cl;
	int rowCount, colCount, row, col;
   String sheetName="address_Details";
  
   public Object[][] getData(String sheetName) throws Exception {
	   file=new File("F:\\Selenium\\AddressDetails.xls");
		  fis=new FileInputStream(file);
		  wb=new HSSFWorkbook(fis);
		  sheetName=wb.getSheetName(0);
		  sheet=wb.getSheet(sheetName);
	      rowCount=sheet.getPhysicalNumberOfRows();
	      System.out.println("No of rows- "+rowCount);
	 	  colCount=sheet.getRow(0).getPhysicalNumberOfCells();
	 	  System.out.println("No. Of Column - " + colCount);
	 	  Object[][] data=new Object[rowCount-1][colCount];
	 	  for(row=0; row<rowCount-1; row++ ) {
	 		  rw=sheet.getRow(row+1);
	 		  for(col=0; col<colCount; col++) {
	 			  cl=rw.getCell(col);
	 			 //System.out.println( cl.getCellType());
	 			  data[row][col]=cl.getStringCellValue();
	 		 }
	 	  }
	 	  return data;  
	   }
}
    
    
    
    
    
    
    
    
    
    