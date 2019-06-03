package DemoMaven.Tests.Login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import com.relevantcodes.extentreports.LogStatus;
import  DemoMaven.Utilities.SuiteBase;
import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.CommonAction.CommonScript;
import DemoMaven.CommonActions.CommonAction.ExcelReader;
import  DemoMaven.CommonActions.Login.LoginActions;
import DemoMaven.Utilities.*;
public class LoginTest extends SuiteBase
{
	
	 CommonAction ca = new CommonAction();
	 String reportUrl ="";
	 String methodName;
	 
	 @BeforeClass
	    public void setReport()
	    {
		  reportUrl= generateReport("ACC","ACC","ACC","ACC");
	    }
	 
	 @BeforeMethod
	 public void getMethodName(Method method)
	 {
		 methodName = method.getName();
	 }
	 /* Test Case ID - AUI_Login_01
		 * Test case Details - Verification user login successfully or not
		 * Author -  Amol
		 * */ 
	 
	 private ExcelReader ex= new ExcelReader();
	 private String getDataFromDataproviderPasswordFileLocation = System.getProperty("user.dir")+rd.read_Configfile("login_excel");
	 
	 	/* Test Case ID - AUI_Login_01
	 	 * Copyright 2018 FIGmd.in © 2018.
		 * All rights reserved.
		 * The Displayer class displays text 
		 * on the computer screen.
		 * Test case Details - Verification user login successfully or not
		 * Author -  Amol Bande
		 * Date 18/07/2018
		 * */ 
	 	@DataProvider(name="TC_AutoLogin")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
			log.info("Dataprovider Start");
	        Object[][] object=ex.getDataingrid(getDataFromDataproviderPasswordFileLocation,"TC_AutoLogin_Data");
	        
			log.info("Dataprovider Ends");
			return object;
	    }
	    
	 	@Test(dataProvider="TC_AutoLogin",priority=1)
		public void VerifyValidLogin(Hashtable <String,String> LoginExcelSheetData) throws Exception{
			WebDriverWait wait = new WebDriverWait(driver,60);				
			CommonScript loginAction =  new CommonScript(driver, wait);
			
			/*
			 *  Test case Details - Login to the application and verified user name
			 */
			String GetUserName = loginAction.VerifyValidLoginUser(methodName,LoginExcelSheetData,logger);
			ca.verifyAssertEquals(
					GetUserName,LoginExcelSheetData.get("login_user"), 
					"Unable to verify \" "+LoginExcelSheetData.get("login_user")+"\" message for username.",
					"\" "+LoginExcelSheetData.get("login_user")+"\" message for username verified successfully..", 
					methodName,logger,"TC_Login_01",driver);
		}
	    
	 @AfterMethod
	 public void check(ITestResult result,Method method) {
		 if (result.getStatus() == ITestResult.FAILURE) {
			   captureFailureScreen(method.getName());
			   ca.assertFailWithOutException("Fail: Method -"+methodName+" has been failed...");
		   }  
	 }
	 
	@AfterClass
	public void TearDown(){		
		report.endTest(logger);
		report.flush();		
	}
	  	
}
