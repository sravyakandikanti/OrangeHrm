package com.qa.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;


import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public  ExtentHtmlReporter htmlreporter;
	public ExtentReports exreports;
	public ExtentTest xtest;
	
	
	  public void onStart(ITestContext testContext) {
		  
		  String DateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String repName = "Test-Report-"+DateStamp+".html"; 
		  htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		  exreports = new ExtentReports();
		  exreports.attachReporter(htmlreporter);
		  exreports.setSystemInfo("HostName", "localhost");
		  exreports.setSystemInfo("QA", "Sravya");
		  exreports.setSystemInfo("OS", "Windows10");
		  htmlreporter.config().setDocumentTitle("OrangeHRM");
		  htmlreporter.config().setReportName("Function test report");
		  htmlreporter.config().setTheme(Theme.DARK);		  
		  htmlreporter.config().setAutoCreateRelativePathMedia(true);
  
	  }		  
		  
	  public void onFinish(ITestContext testContext) {
	 
		  exreports.flush();
		}
	  public void onTestSuccess(ITestResult tr) {
	 
		  xtest = exreports.createTest(tr.getName());
		  xtest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		  xtest.log(Status.PASS,"Test is passed");
		  String SSName=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName() + ".png";
		  File file = new File(SSName);
		  if(file.exists())
		  {
			 try {
				 xtest.pass("ScreenShot for the test failed is :"+ xtest.addScreenCaptureFromPath(SSName));
		  }catch(Exception e) {
			  		e.printStackTrace();
		  }
		  

		  
		  }  
	  }
	  public void onTestFailure(ITestResult tr) {
		  xtest = exreports.createTest(tr.getName());
		  xtest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  xtest.log(Status.FAIL,"Test is Failed");
		  
		  
		  
		  String SSName=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName() + ".png";
		  File file = new File(SSName);
		  if(file.exists())
		  {
			 try {
				 xtest.fail("ScreenShot for the test failed is :"+ xtest.addScreenCaptureFromPath(SSName));
		  }catch(Exception e) {
			  		e.printStackTrace();
		  }
		  
		  
		  
		  
		  }  
	  }
	  public void onTestSkipped(ITestResult tr) {
		  xtest = exreports.createTest(tr.getName());
		  xtest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		  xtest.log(Status.SKIP,"Test is Skiped");
	  }
}

