package DemoMaven.Tests.DashBoard;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.CommonAction.CommonScript;
import DemoMaven.CommonActions.CommonAction.ExcelReader;
import DemoMaven.CommonActions.DashBoard.DashBoardActions;
import DemoMaven.CommonActions.DashBoard.NewDashBoardActions;
import DemoMaven.Utilities.SuiteBase;

public class NewDashBoardTest extends SuiteBase {
	
	CommonAction ca = new CommonAction();
	String reportUrl = "";
	String methodName;
	
	

	@BeforeClass
	public void setReport() {
		
		reportUrl = generateReport("ACCSmokeTestReport", "DashBoardDocTitle", "DashBoardreportName", "ACC_DashBoard");
		// System.out.println("ReportUrl :"+reportUrl);
	}

	@BeforeMethod
	public void getMethodName(Method method) {
		methodName = method.getName();
	}

	private ExcelReader ex = new ExcelReader();
	private String getDataFromDataproviderPasswordFileLocation = System.getProperty("user.dir")
			+ rd.read_Configfile("login_excel");
	private String getDataFromDataproviderMeasureCaseFileLocation = System.getProperty("user.dir")
			+ rd.read_Configfile("SmokeACC");

	
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

	
	/* * Testcase ID- TC_0002 : TC_DetailedPPDrillDownCountNR" Copyright 2018
	 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
	 * on the computer screen.
	 *
	 * @author Amol Bande
	 * 
	 * @version 1.0 01/06/18
	 * 
	 * @throws SQLException
	 * 
	 * @see java.lang.System
	 */
	
	
	
	 /*	 * Test Case ID - TC_verifySelectPractice Copyright 2018 FIGmd.in © 2018. All rights
	 * reserved.  Test case Details - Selection of practice from practice dropdown - Amol
	 * Pawal Date 11/13/2018
     */
	
	
	@DataProvider(name="TC_verifySelectPractice")
    public Object[][] TC_verifySelectPractice_getdata() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_verifySelectPractice");
		log.info("Dataprovider Ends");
		return object;
    }
	
	
	@Test(dataProvider="TC_verifySelectPractice",priority=2)
	public void TC_verifySelectPractice(Hashtable <String,String> TC_verifySelectPractice_data ) throws Exception {
		WebDriverWait wait =new WebDriverWait(driver, 60);
		DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
		
		String result=DashBoardActionsActions.verifySelectPractice﻿(logger,TC_verifySelectPractice_data);
		ca.verifyAssertEquals(result, TC_verifySelectPractice_data.get("PracticeID"), "User is not able to select the practice", "Practice selected successfully", methodName, logger, "TC_02",driver);
		
	}
	
	
	@DataProvider(name = "ProviderPatientDrillDownCountNR")
	public Object[][] getDataFromDataproviderTC_DetailedPPDrillDownCountNR()
			throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
				"TC_DetailedPPDrillDownCountNR_D");
		log.info("Dataprovider Ends");
		return object;
	}
	
	
	@Test(dataProvider="ProviderPatientDrillDownCountNR",priority=3)
	public void TC_ProviderPatientDrillDown(Hashtable <String,String> TC_verifySelectPractice_data){
		WebDriverWait wait =new WebDriverWait(driver, 60);
		NewDashBoardActions newDashBoardActionsActions = new NewDashBoardActions(driver, wait);
	    String res	=newDashBoardActionsActions.TC_DetailedPPDrillDownCountNR(TC_verifySelectPractice_data);
	    System.out.println(res);
		
		
	}
	
	// -------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	

}
