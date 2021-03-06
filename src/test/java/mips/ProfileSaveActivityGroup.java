package mips;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import DemoMaven.Utilities.EmailReportManager;
import DemoMaven.Utilities.SuiteBase;
import DemoMaven.CommonActions.CommonAction.ExcelReader;
import DemoMaven.CommonActions.DashBoard.DashBoardActions;
import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.CommonAction.CommonScript;
import DemoMaven.CommonActions.Login.LoginActions;
import DemoMaven.DataBase.DashBoard.DashBoardTestsDB;


public class ProfileSaveActivityGroup extends SuiteBase {

	CommonAction ca = new CommonAction();
	String reportUrl = "";
	String methodName;
	
	

	@BeforeClass
	public void setReport() {
		
		reportUrl = generateReport("ACCProfileSaveReportGroup", "ReportGroup", "ReportGroup", "ACC_ProfileSaveGroup");
		
	}

	@BeforeMethod
	public void getMethodName(Method method) {
		methodName = method.getName();
	}

	private ExcelReader ex = new ExcelReader();
	private String getDataFromDataproviderPasswordFileLocation = System.getProperty("user.dir")
			+ rd.read_Configfile("login_excel");
	
	
	public String getFileLoc = System.getProperty("user.dir")+rd.read_Configfile("GroupList");
	

	
	@DataProvider(name = "TC_AutoLogin")
	public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] LoginData = ex.getDataingrid(getDataFromDataproviderPasswordFileLocation, "TC_AutoLogin_Data");
		log.info("Dataprovider Ends");
		return LoginData;
	}

	@Test(dataProvider = "TC_AutoLogin", priority = 1)
	public void VerifyValidLogin(Hashtable<String, String> LoginExcelSheetData) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		CommonScript loginAction = new CommonScript(driver, wait);

		/*
		 * Test case Details - Login to the application and verified user name
		 */
		String GetUserName = loginAction.VerifyValidLoginUser(methodName, LoginExcelSheetData, logger);
		ca.verifyAssertEquals(GetUserName, LoginExcelSheetData.get("login_user"),
				"Unable to verify \" " + LoginExcelSheetData.get("login_user") + "\" message for username.",
				"\" " + LoginExcelSheetData.get("login_user") + "\" message for username verified successfully..",
				methodName, logger, "TC_Login_01", driver);
	}
	
	

	// -------------------------------------------------------------------------------------------------------------------------
	
	
	
	 /*	 * Test Case ID - TC_verifySelectPractice Copyright 2018 FIGmd.in © 2018. All rights
	 * reserved.  Test case Details - Selection of practice from practice dropdown - Amol
	 * Pawal Date 11/13/2018
     */
	
	
		
  
	@Test(priority = 2)
	public void TC_switchToMIPSWindow() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		LoginActions loginAction = new LoginActions(driver, wait);
		DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);

		// Taking UI count of TC_DetailedPPDrillDownCountNR
		String result = DashBoardActions.navigateToMips(logger);
		System.out.println(result);	
	}
	
	@DataProvider(name="groupList")
    public Object[][] groupList() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] object=ex.getDataingrid(getFileLoc,"GroupListSheet");
  
		log.info("Dataprovider Ends");
		return object;
    }
	
	
	@Test(dataProvider="groupList",priority = 3)
	public void TC_selectPractice(Hashtable <String,String> data) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		LoginActions loginAction = new LoginActions(driver, wait);
		DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
		String s = data.get("Practice");
		System.out.println(s);
		
		 String result = DashBoardActions.selectPractice(data, logger);
		 
		 ca.verifyAssertEquals(result,"Quality Details saved successfully.",
					"Unable to save the data", " Data saved for this practice",
					methodName, logger, data.get("Practice"), driver);
		 
		
	}

	@AfterMethod
	public void check(ITestResult result, Method method) throws InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
		if(result.getStatus() == ITestResult.SUCCESS){
			System.out.println("\n *****************************************************************************************");
		}
		
		else if (result.getStatus() == ITestResult.FAILURE) {
			captureFailureScreen(method.getName());
			//driver.navigate().refresh();
			DashBoardActions.afterFailureGroup(logger);
			System.out.println("\n #########################################################################################");
			// ca.assertFailWithOutException("Fail: Method -"+methodName+" has
			// been failed...");
		}

	}
	@AfterClass
	public void TearDown() {
		report.endTest(logger);
		report.flush();
	}
}
