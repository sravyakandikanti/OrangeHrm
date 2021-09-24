package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AddMyInfoPage;
import com.qa.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	WebDriver driver=null;
	AddMyInfoPage info;
	Actions act;
	@Parameters({ "OrangeHrmURL","Browser"})
	@BeforeClass
	public void Setup(String OrangeHrmURL,String browserName) throws IOException, InterruptedException {


		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();

		}		
		else if (browserName.equalsIgnoreCase("Edge")) 
		{

			WebDriverManager.edgedriver().setup();

			driver =new EdgeDriver();



		}
		info = new AddMyInfoPage(driver);
		driver.get(OrangeHrmURL);
		driver.manage().window().maximize();
		Properties properties= new Properties();
		String projectPath=System.getProperty("user.dir");
		InputStream input= new FileInputStream(projectPath+"\\src\\test\\java\\com\\qa\\testData\\login.properties");
		properties.load(input);
		driver.manage().window().maximize();
		info.userName().sendKeys(properties.getProperty("UserName"));
		info.password().sendKeys(properties.getProperty("Password"));
		info.login().click();


		
		String ExpTitle="OrangeHRM";
		Assert.assertEquals(ExpTitle, driver.getTitle());
		info.getPIM().click();
		Thread.sleep(3000);
		info.getEmployeeList().click();
		Thread.sleep(3000);
		info.getEmployeeName().sendKeys("Kim Smith");
		Thread.sleep(3000);
		info.getSearch().click();
		Thread.sleep(3000);
		act=new Actions(driver);

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void capturescreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(Source, Target);
		System.out.println("Screenshot captured");
	}
	public String[][] getExcelData(String sheet) throws IOException
	{
		String path="C:\\Users\\kandi\\eclipse-workspace\\OrangeHrm\\src\\test\\java\\com\\qa\\testdata\\InputData.xlsx"; 
		ExcelUtility excelUtils =new ExcelUtility(path,sheet);

		int rowCount=excelUtils.getRowCount();
		int colCount=excelUtils.getColCount();

		String data[][] = new String[rowCount-1][colCount];

		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				if(excelUtils.getCellType(i, j))
				{
					String cellData= excelUtils.getCellDataString(i, j);

					data[i-1][j]=cellData;
				}	else {
					double cellData= excelUtils.getCellNumericString(i, j);

					int intVal=(int)cellData;
					String s=Integer.toString(intVal);
					data[i-1][j]=s;

				}

			}
		}


		return data;



	}

}
