package DemoMaven.Tests.DashBoard;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;


import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.CommonAction.CommonScript;
import DemoMaven.CommonActions.CommonAction.ExcelReader;
import DemoMaven.CommonActions.DashBoard.DashBoardActions;
import DemoMaven.CommonActions.DashBoard.LipidActions;
import DemoMaven.DataBase.DashBoard.DashBoardTestsDB;
import DemoMaven.DataBase.DashBoard.LipidTestsDB;
import DemoMaven.Utilities.SuiteBase;

public class LipidTests extends SuiteBase {
	
	
	 String reportUrl ="";
	 String methodName;
	 static String servername;
	 static String dbname;
	 static String practiceid;
	 
	 @BeforeClass
	    public void setReport()
	    {
		  reportUrl= generateReport("Lipid","Lipid","Lipid","Lipid");
	    }
//--------------------------------------------------------------------------------------	 
	 @BeforeMethod
	 public void getMethodName(Method method)
	 {
		 methodName = method.getName();
	 } 
	 private ExcelReader ex= new ExcelReader();
	 private String getDataFromDataproviderLipidPathway= System.getProperty("user.dir")+rd.read_Configfile("SmokeLipid");
	 private String getDataFromDataproviderPasswordFileLocation = System.getProperty("user.dir")+rd.read_Configfile("login_excel");
	 private String getDataFromDataproviderMeasureCaseFileLocation = System.getProperty("user.dir")	+ rd.read_Configfile("SmokeACC");
	 
//--------------------------------------------------------------------------------------
	  
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
	 
//------------------------------------------------------------------------------------
		
		

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
			
			String servernamequery = TC_verifySelectPractice_data.get("ServerName");
			String dbnamequery = TC_verifySelectPractice_data.get("DBName");
			
			servernamequery=servernamequery.replaceAll("@practiceid", result);
			dbnamequery = dbnamequery.replaceAll("@practiceid", result);
			
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			servername = dashBoardTestsDB.getServerDetail(servernamequery);
			dbname = dashBoardTestsDB.getLipidPartitionDetails(dbnamequery );
			practiceid = result;
			
			
			System.out.println(servername + dbname + result);
			
			ca.verifyAssertEquals(result, TC_verifySelectPractice_data.get("PracticeID"), "User is not able to select the practice", "Practice selected successfully", methodName, logger, "TC_02",driver);
			
		}
		
		
//-------------------------------------------------------------------------------------
		 
	 
	 @DataProvider(name = "TC_NavigateToLipid")
		public Object[][] getDataTC_NavigateToLipid() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] data = ex.getDataingrid(getDataFromDataproviderLipidPathway, "TC_NavigateToLipid");
			log.info("Dataprovider Ends");
			return data;
		}

		@Test(dataProvider = "TC_NavigateToLipid", priority = 3,dependsOnMethods={"VerifyValidLogin","TC_verifySelectPractice"})
		public void verifyNavigateToLipid(Hashtable<String, String> data) throws Exception {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			LipidActions lipidAction = new LipidActions(driver, wait);
			
			// Taking UI verification point
			String actual= lipidAction.navigateToLipid(logger);
			
			// Taking Excel sheet verification point
			String expected = data.get("WebPageName");
			

			
			ca.verifyAssertEquals(actual,expected,
					"User is not able to navigate on \" " + data.get("WebPageName") + "\" module",
					"User is navigated on \" " +data.get("WebPageName")+ " \" ",
					methodName, logger, "verifyNavigateToLipidPathway", driver);
		}
		
  		
 //---------------------------------------------------------------------------------------
		
		   @DataProvider
			public Object[][] getDataLipid2018()throws IOException, InvalidFormatException {
				log.info("Dataprovider Start");
				Object[][] data = ex.getDataingrid(getDataFromDataproviderLipidPathway, "Lipid_2018");
				log.info("Dataprovider Ends");
				return data;
			}
					
			
			@Test(dataProvider="getDataLipid2018",priority=4,dependsOnMethods={"VerifyValidLogin","TC_verifySelectPractice","verifyNavigateToLipid"})
			public void verify2018BothAllAll(Hashtable<String, String> data) throws Exception {

				WebDriverWait wait = new WebDriverWait(driver, 60);
				LipidActions lipidAction = new LipidActions(driver, wait);
				LipidTestsDB lipidTestsDB= new LipidTestsDB();
				
				// Taking UI count of TC_DetailedPPDrillDownCountNR
				String actual = lipidAction.TC_verifyAllCount_2018(methodName,data, logger);

				// Taking DB count of TC_DetailedPPDrillDownCountNR
				/*String query = data.get("Query");
				
				query = query.replaceAll("@practice", "151780");*/
				
		String[][] replacements = { {"@servername",servername}, {"@dbname",dbname },{"@practice", practiceid} };

		// loop over the array and replace
		String query = data.get("Query");
		for (String[] replacement : replacements) {
			query = query.replace(replacement[0], replacement[1]);
		}
		if(data.get("Year").equals("2018")){
			query = query.replace("@quarter", "2018-12-31");
		}
		else if(data.get("Year").equals("2017")){
			query = query.replace("@quarter","2017-12-31");
		}
				
				
				System.out.println(query);
				
				String expected = lipidTestsDB.TC_verifyAllCount_2018(query);
				
				ca.verifyAssertEqual(actual, "1001", "Records are not matching", "Records are matching", methodName, logger);
						
			}
 //----------------------------------------------------------------------------------------
			
			
			
		
			
			@AfterMethod
			public void check(ITestResult result, Method method) throws InvalidFormatException, IOException, InterruptedException {
				if(result.getStatus() == ITestResult.SUCCESS){
					System.out.println("\n *****************************************************************************************");
				}
				
				else if (result.getStatus() == ITestResult.FAILURE) {
					captureFailureScreen(method.getName());
					driver.navigate().refresh();
					Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_verifySelectPractice");
					Hashtable<String, String> hst=new Hashtable<String, String>();
					hst.putAll((Hashtable<String, String>)TC_verifySelectPractice_getdata()[0][0]);
					WebDriverWait wait = new WebDriverWait(driver, 60);
					new DashBoardActions(driver, wait).verifySelectPractice﻿(logger, hst);
					System.out.println("***********************************************************************************************");
					// ca.assertFailWithOutException("Fail: Method -"+methodName+" has
					// been failed...");
				}
			}
			
		
//----------------------------------------------------------------------------------------			
			
			@AfterClass 
			public void TearDown() {
				report.endTest(logger);
				report.flush();
			}
			
			
}
		
	 
	 


