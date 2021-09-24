package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_AddMyInfo_001 extends TestBase {
	
	
	@Test(priority=0,dataProvider="MyInformation")
	public void AddMyInformation(String[] inputData) throws InterruptedException, IOException
	{
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(4000);
		info.getKimsid().click();
		Thread.sleep(2000);
		
		 JavascriptExecutor ps = (JavascriptExecutor) driver;
		  ps.executeScript("window.scrollBy(0,200)");
		  info.getEditInfo().click();
		  Thread.sleep(2000);
		  info.getaddDOB().click();
		 info.getYear().selectByValue(inputData[1]);
		  Thread.sleep(2000);
		  info.getMonth().selectByVisibleText(inputData[2]);
		  Thread.sleep(2000);
		  info.getDate().click();
		  Thread.sleep(2000);
		  info.getSelectGender().click();
		  Thread.sleep(2000);
		 info.getSelectNationality().selectByVisibleText(inputData[3]);
		  Thread.sleep(2000);
		  info.getSavebtn().click();
		  
		  String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains("viewPersonalDetails")) {
				Reporter.log("Employee details are saved successfully and personal information page is displayed");
				Assert.assertTrue(true);
			}
			else {
				capturescreenShot(driver,"MyInformation");
				Reporter.log("Failed to save!!");
				Assert.assertTrue(false);
			}

			Thread.sleep(3000);
		  
		
	}
	
	  @DataProvider(name = "MyInformation") public String[][] AddMyInformation()
	 throws IOException
	  {
	  
	 
	  String sheet="MyInformation"; String[][] data= getExcelData(sheet);
	  
	  return data; }
	 
}
