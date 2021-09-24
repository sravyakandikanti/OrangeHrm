package com.qa.testscripts;


import java.io.IOException;
import org.testng.annotations.Test;

public class TC_DeleteEmpRecord_001 extends TestBase
{

	@Test
	public void DeleteEmpRecord() throws InterruptedException, IOException
	{

		info.getCheckBox().click();
		Thread.sleep(3000);
		info.getdeleteEmpRecord().click();
		Thread.sleep(3000);
		//Pop window is generated
		act.moveToElement(info.getConfirmationPopup()).build().perform();
		Thread.sleep(3000);
		info.getOkBtn().click();
		Thread.sleep(3000);
		
		


	}
	}

