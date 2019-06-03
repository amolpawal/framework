package DemoMaven.Tests.DashBoard;

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
import DemoMaven.Utilities.EmailReportManager;
import DemoMaven.Utilities.SuiteBase;
import DemoMaven.CommonActions.CommonAction.ExcelReader;
import DemoMaven.CommonActions.DashBoard.DashBoardActions;
import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.CommonAction.CommonScript;
import DemoMaven.CommonActions.Login.LoginActions;
import DemoMaven.DataBase.DashBoard.DashBoardTestsDB;

@Listeners(value=EmailReportManager.class)
public class DashBoardTests extends SuiteBase {

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
	

	
	
	@DataProvider(name = "TC_DetailedPPDrillDownCountNR")
	public Object[][] getDataFromDataproviderTC_DetailedPPDrillDownCountNR()
			throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
				"TC_DetailedPPDrillDownCountNR_D");
		log.info("Dataprovider Ends");
		return object;
	}

	@Test(dataProvider = "TC_DetailedPPDrillDownCountNR", priority = 3,dependsOnMethods={"VerifyValidLogin","TC_verifySelectPractice"})
	public void getDataFromDataproviderTC_DetailedPPDrillDownCountNR(
			Hashtable<String, String> TC_DetailedPPDrillDownCountNR) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		LoginActions loginAction = new LoginActions(driver, wait);
		DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
		DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

		// Taking UI count of TC_DetailedPPDrillDownCountNR
		String DetailedPPDrillDownCount = DashBoardActionsActions.TC_DetailedPPDrillDownCountNR(methodName,
				TC_DetailedPPDrillDownCountNR, logger);

		// Taking DB count of TC_DetailedPPDrillDownCountNR
		HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = dashBoardTestsDB
				.TC_DetailedPPDrillDownCountNR(TC_DetailedPPDrillDownCountNR.get("Query"));

		ca.verifyAssertEquals(DetailedPPDrillDownCount,
				databseCountCrossCuttingMeasuresForMeasureSet2018.get("PracticeUid_Count"),
				"Unable to verify \" " + DetailedPPDrillDownCount
						+ " \" message Detailed PP Drill Down Count Non Rolling from Database and UI is not getting matched.",
				"\" " + DetailedPPDrillDownCount
						+ "\" Detailed PP Drill Down Count Non Rolling from Database and UI getting matched..",
				methodName, logger, "TC_0002", driver);

		// Logiut the application
		// loginAction.logOutApplication();
		//System.out.println("User logout successfully..");
	}

	/*
	 * Testcase ID- TC_0003 : TC_DetailedPPDrillDownCountR" Copyright 2018
	 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
	 * on the computer screen.
	 *
	 * @author Amol Bande
	 * 
	 * @version 1.0 01/06/18
	 * 
	 * @throws SQLException
	 * 
	 * @see java.lang.System*/
	 

	@DataProvider(name = "TC_DetailedPPDrillDownCountR")
	public Object[][] getDataFromDataproviderTC_DetailedPPDrillDownCountR() throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
				"TC_DetailedPPDrillDownCountR_D");
		log.info("Dataprovider Ends");
		return object;
	}

        @Test(dataProvider = "TC_DetailedPPDrillDownCountR", priority = 4,dependsOnMethods={"VerifyValidLogin","TC_verifySelectPractice"})
	public void TC_DetailedPPDrillDownCountR(Hashtable<String, String> TC_DetailedPPDrillDownCountR) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
		DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

		// Taking UI count of TC_DetailedPPDrillDownCountR
		String DetailedPPDrillDownCount = DashBoardActionsActions.TC_DetailedPPDrillDownCountR(methodName,
				TC_DetailedPPDrillDownCountR, logger);

		// Taking DB count of TC_DetailedPPDrillDownCountR
		HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = dashBoardTestsDB
				.TC_DetailedPPDrillDownCountR(TC_DetailedPPDrillDownCountR.get("Query"));

		ca.verifyAssertEquals(DetailedPPDrillDownCount,
				databseCountCrossCuttingMeasuresForMeasureSet2018.get("PracticeUid_Count"),
				"Unable to verify \" " + DetailedPPDrillDownCount
						+ "\" message Detailed PP Drill Down Count Rolling from Database and UI is not getting matched.",
				"\" " + DetailedPPDrillDownCount
						+ "\"Detailed PP Drill Down Count Rolling from Database and UI getting matched..",
				methodName, logger, "TC_0003", driver);
	}

	
	/* * Testcase ID- TC_0004 : TC_PracticeMeasureCountR" Copyright 2018 FIGmd.in
	 * © 2018. All rights reserved. The Displayer class displays text on the
	 * computer screen.
	 *
	 * @author Amol Bande
	 * 
	 * @version 1.0 01/06/18
	 * 
	 * @throws SQLException
	 * 
	 * @see java.lang.System
	 */

	@DataProvider(name = "TC_PracticeMeasureCountR")
	public Object[][] getDataFromDataproviderTC_PracticeMeasureCountR() throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
				"TC_PracticeMeasureCountR_Data");
		log.info("Dataprovider Ends");
		return object;
	}

	/*@Test(dataProvider = "TC_PracticeMeasureCountR", priority = 5)//priority = 5
	public void TC_PracticeMeasureCountR(Hashtable<String, String> TC_DetailedPPDrillDownCountR) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
		DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

		// Taking UI count of TC_DetailedPPDrillDownCountR
		String DetailedPPDrillDownCount = DashBoardActionsActions.TC_PracticeMeasureCountR(methodName,
				TC_DetailedPPDrillDownCountR, logger);

		// Taking DB count of TC_DetailedPPDrillDownCountR
		HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = dashBoardTestsDB
				.TC_PracticeMeasureCountR(TC_DetailedPPDrillDownCountR.get("Query"));

		ca.verifyAssertEquals(DetailedPPDrillDownCount,
				databseCountCrossCuttingMeasuresForMeasureSet2018.get("QualityMeasureUid_Count"),
				"Unable to verify \" " + DetailedPPDrillDownCount
						+ "\" message Practice Measure Count Rolling from Database and UI is not getting matched.",
				"\" " + DetailedPPDrillDownCount
						+ "\"Practice Measure Count Rolling from Database and UI getting matched..",
				methodName, logger, "TC_0004", driver);
	}

	
	 * Testcase ID- TC_0005 : TC_PracticeMeasureCountNR" Copyright 2018 FIGmd.in
	 * © 2018. All rights reserved. The Displayer class displays text on the
	 * computer screen.
	 *
	 * @author Amol Bande
	 * 
	 * @version 1.0 01/06/18
	 * 
	 * @throws SQLException
	 * 
	 * @see java.lang.System
	 

	@DataProvider(name = "TC_PracticeMeasureCountNR")
	public Object[][] getDataFromDataproviderTC_PracticeMeasureCountNR() throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
				"TC_PracticeMeasureCountNR_Data");
		log.info("Dataprovider Ends");
		return object;
	}

	@Test(dataProvider = "TC_PracticeMeasureCountNR", priority = 6)//priority = 6
	public void TC_PracticeMeasureCountNR(Hashtable<String, String> TC_DetailedPPDrillDownCountR) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
		DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

		// Taking UI count of TC_DetailedPPDrillDownCountR
		String DetailedPPDrillDownCount = DashBoardActionsActions.TC_PracticeMeasureCountNR(methodName,
				TC_DetailedPPDrillDownCountR, logger);

		// Taking DB count of TC_DetailedPPDrillDownCountR
		HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = dashBoardTestsDB
				.TC_PracticeMeasureCountR(TC_DetailedPPDrillDownCountR.get("Query"));

		ca.verifyAssertEquals(DetailedPPDrillDownCount,
				databseCountCrossCuttingMeasuresForMeasureSet2018.get("QualityMeasureUid_Count"),
				"Unable to verify \" " + DetailedPPDrillDownCount
						+ "\" message Practice Measure Count non Rolling from Database and UI is not getting matched.",
				"\" " + DetailedPPDrillDownCount
						+ "\"Practice Measure Count non Rolling from Database and UI getting matched..",
				methodName, logger, "TC_0005", driver);
	}
	
	
	
	
		* Testcase ID- TC_0006 : TC_PracticeFavoritesMeasureCountR" Copyright 2018
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
	 

	@DataProvider(name = "TC_PracticeFavoritesMeasureCountR")
	public Object[][] getDataFromDataproviderTC_PracticeFavoritesMeasureCountR()
			throws IOException, InvalidFormatException {
		log.info("Dataprovider Start");
		Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
				"TC_PracticeFavoritesCountR_Data");
		log.info("Dataprovider Ends");
		return object;
	}

	@Test(dataProvider = "TC_PracticeFavoritesMeasureCountR", priority = 7)//priority = 6
	public void TC_PracticeFavoritesMeasureCountR(Hashtable<String, String> TC_PracticeFavoritesMeasureCountR)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
		DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

		// Taking UI count of TC_DetailedPPDrillDownCountR
		String DetailedPPDrillDownCount = DashBoardActionsActions.TC_PracticeFavoritesMeasureCountR(methodName,
				TC_PracticeFavoritesMeasureCountR, logger);

		// Taking DB count of TC_DetailedPPDrillDownCountR
		HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = dashBoardTestsDB
				.TC_PracticeFavoritesMeasureCountR(TC_PracticeFavoritesMeasureCountR.get("Query"));

		ca.verifyAssertEquals(DetailedPPDrillDownCount,
				databseCountCrossCuttingMeasuresForMeasureSet2018.get("inactive"),
				"Unable to verify \" " + DetailedPPDrillDownCount
						+ "\" message Practice Favorites Measure Count Rolling from Database and UI is not getting matched.",
				"\" " + DetailedPPDrillDownCount
						+ "\" Practice Favorites Measure Count Rolling from Database and UI getting matched..",
				methodName, logger, "TC_0006", driver);
	}
	
	
	
	
	// Awadhesh

	
		 * Testcase ID- TC_0007 : TC" Copyright 2018 FIGmd.in Â© 2018. All rights
		 * reserved. The Displayer class displays text on the computer screen.
		 *
		 * @author Awadhesh Sengar
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_PracticeFavoritesMeasureCountNR")
		public Object[][] getDataFromDataproviderTC_PracticeFavoritesMeasureCountNR()
				throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"PFavoritesMeasureCountNR_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_PracticeFavoritesMeasureCountNR", priority = 8)//priority = 7
		public void TC_PracticeFavoritesMeasureCountNR(Hashtable<String, String> data) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);

			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			String webCount = DashBoardActionsActions.TC_PracticeFavoritesMeasureCountNR(methodName, data, logger);

			HashMap<String, String> databseCountFavouriteMeasureSet2017 = dashBoardTestsDB
					.TC_Favourites2017MeasureSet(data.get("Query"));
			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + databseCountFavouriteMeasureSet2017.get("inactive"));
			System.out.println("Active measureset2018 Db_Count:" + databseCountFavouriteMeasureSet2017.get("inactive"));

			ca.verifyAssertEquals(webCount, databseCountFavouriteMeasureSet2017.get("inactive"),
					"Unable to verify \" " + webCount
							+ "\" message Favourite Measures from Database and UI for Measure Set IRIS is not getting matched.",
					"\" " + webCount
							+ "\"Favourite Measures from Database and UI for Measure Set IRIS  from Database and UI getting matched..",
					methodName, logger, "TC_0033");
		}

		// -------------------------------------------------

		
		 * Testcase ID- TC_0009 : TC" Copyright 2018 FIGmd.in Â© 2018. All rights
		 * reserved. The Displayer class displays text on the computer screen.
		 *
		 * @author Awadhesh Sengar
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "PMCountOfHigherScore")
		public Object[][] getDataFromDataproviderPMCountOfHigherScore() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PMCountOfHigherScore_data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "PMCountOfHigherScore", priority = 9)
		public void PMCountOfHigherScore(Hashtable<String, String> data) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			String webCount = DashBoardActionsActions.TC_PMCountOfHigherScore(methodName, data, logger);
			HashMap<String, String> databseCountPMHigherCount = dashBoardTestsDB.TC_PMCountOfHigherScore(data.get("Query"));
			System.out.println("Measures with higher score better UI_Count:" + webCount);
			System.out.println("Measures with higher score better Db_Count:" + databseCountPMHigherCount.get("inactive"));

			ca.verifyAssertEquals(webCount, databseCountPMHigherCount.get("inactive"),
					"Unable to verify \" " + webCount
							+ "\" message Higher  Score is  Better measures from Database and UI for Measure Set IRIS is not getting matched.",
					"\" " + webCount
							+ "\"Higher  Score is  Better from Database and UI for "+data.get("MeasureSet")+"  from Database and UI getting matched..",//Added data.get("MeasureSet". Old value-IRIS(hardcode)
					methodName, logger, "TC_009");

		}

	
	
	
		
		
		
		
		
		// -----------------------------------------------------------
		
		 * Testcase ID- TC_0009 : TC" Copyright 2018 FIGmd.in Â© 2018. All rights
		 * reserved. The Displayer class displays text on the computer screen.
		 *
		 * @author Awadhesh Sengar
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "PMCountOfHigherScoreNR")
		public Object[][] getDataFromDataproviderPMCountOfHigherScoreNR() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PMCountOfHigherScore_data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "PMCountOfHigherScoreNR", priority = 10)
		public void PMCountOfHigherScoreNR(Hashtable<String, String> data) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			String webCount = DashBoardActionsActions.TC_PMCountOfHigherScore(methodName, data, logger);

			HashMap<String, String> databseCountPMHigherCount = dashBoardTestsDB.TC_PMCountOfHigherScore(data.get("Query"));
			System.out.println("Measures with higher score better UI_Count:" + webCount);
			System.out.println("Measures with higher score better Db_Count:" + databseCountPMHigherCount.get("inactive"));

			ca.verifyAssertEquals(webCount, databseCountPMHigherCount.get("inactive"),
					"Unable to verify \" " + webCount
							+ "\" message Higher  Score is  Better measures from Database and UI for Measure Set IRIS is not getting matched.",
					"\" " + webCount
							+ "\"Higher  Score is  Better from Database and UI for Measure Set IRIS  from Database and UI getting matched..",
					methodName, logger, "TC_009");

		}

		/// ---------------------------------

		
		 * Testcase ID- TC_0011 : TC" Copyright 2018 FIGmd.in Â© 2018. All rights
		 * reserved. The Displayer class displays text on the computer screen.
		 *
		 * @author Awadhesh Sengar
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "PMCountOfLowerScore")
		public Object[][] getDataFromDataproviderPMCountOfLowerScore() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PMCountOfLowerScore_data");
			log.info("Dataprovider Ends");
			return object;
		}
		
		// This testcase is not applicable for ACC 

		//@Test(dataProvider = "PMCountOfLowerScore", priority = 11)//priority = 11
		public void PMCountOfLowerScore(Hashtable<String, String> data) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			String webCount = DashBoardActionsActions.TC_PMCountOfLowerScore(methodName, data, logger);

			HashMap<String, String> databseCountPMLowerCount = dashBoardTestsDB.PMCountOfLowerScore(data.get("Query"));
			System.out.println("Measures with Lower score better UI_Count:" + webCount);
			System.out.println("Measures with Lower score better Db_Count:" + databseCountPMLowerCount.get("inactive"));

			ca.verifyAssertEquals(webCount, databseCountPMLowerCount.get("inactive"),
					"Unable to verify \" " + webCount
							+ "\" message Lower  Score is  Better measures from Database and UI for Measure Set IRIS is not getting matched.",
					"\" " + webCount
							+ "\"Lower  Score is  Better from Database and UI for Measure Set IRIS  from Database and UI getting matched..",
					methodName, logger, "TC_10");

		}

		//// ----------------------------------------------------------------------------

		
		 * Testcase ID- TC_0011 : TC" Copyright 2018 FIGmd.in Â© 2018. All rights
		 * reserved. The Displayer class displays text on the computer screen.
		 *
		 * @author Awadhesh Sengar
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System*
		 

		@DataProvider(name = "PMCountOfLowerScoreNR")
		public Object[][] getDataFromDataproviderPMCountOfLowerScoreNR() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PMCountOfLowerScore_data");
			log.info("Dataprovider Ends");
			return object;
		}

		// This testcase is not applicable for ACC 
		
		//@Test(dataProvider = "PMCountOfLowerScoreNR", priority = 12)
		public void PMCountOfLowerScoreNR(Hashtable<String, String> data) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			String webCount = DashBoardActionsActions.TC_PMCountOfLowerScore(methodName, data, logger);
			HashMap<String, String> databseCountPMLowerCount = dashBoardTestsDB.PMCountOfLowerScore(data.get("Query"));
			System.out.println("Measures with Lower score better UI_Count:" + webCount);
			System.out.println("Measures with Lower score better Db_Count:" + databseCountPMLowerCount.get("inactive"));

			ca.verifyAssertEquals(webCount, databseCountPMLowerCount.get("inactive"),
					"Unable to verify \" " + webCount
							+ "\" message Lower  Score is  Better measures from Database and UI for Measure Set IRIS is not getting matched.",
					"\" " + webCount
							+ "\"Lower  Score is  Better from Database and UI for Measure Set IRIS  from Database and UI getting matched..",
					methodName, logger, "TC_11");
		}
		
		
		
		
		
		
		
		
		// --------------------------------------------------------------------------------

		
		 * Testcase ID- TC_0019s : TC_LocationBubbleCountR" Copyright 2018 FIGmd.in
		 * © 2018. All rights reserved. The Displayer class displays text on the
		 * computer screen.
		 *
		 * @author Ankita Gaur
		 * 
		 * @version 1.0 09/04/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_LocationBubbleCountR")
		public Object[][] getDataFromDataproviderCount() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation, "TC_LocationCountNR_Data");
			log.info("Dataprovider Ends");
			return object;
		}
		// This Testcase is not applicable as Bubble count is not displayed for the All practice user
		

		//@Test(dataProvider = "TC_LocationBubbleCountR", priority = 13)//priority = 13
	   public void VerifyLocationcount(Hashtable<String, String> TC_LocationBubbleCountR) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of Active Location Quarterly Bubble Count

			String webCount = DashBoardActionsActions.TC_LocationBubbleCountR(methodName, TC_LocationBubbleCountR, logger);

			// Taking DB count of Active Location Quarterly Bubble Count
			HashMap<String, String> TC_LocationBubbleCountRt = dashBoardTestsDB
					.TC_LocationBubbleCountR(TC_LocationBubbleCountR.get("Query"));

			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + TC_LocationBubbleCountRt.get("TotalCount"));

			ca.verifyAssertEquals((webCount), TC_LocationBubbleCountRt.get("TotalCount"),
					"Unable to verify \" " + (webCount)
							+ "\"Location bubble count rolling from Database and UI data is not getting matched..",
					"\" " + (webCount) + "\"Location bubble count rolling from Database and UI data is getting matched..",
					methodName, logger, "TC_12", driver);

		}

		
		 * Testcase ID- TC_0018 : TC_LocationCountNR" Copyright 2018 FIGmd.in ©
		 * 2018. All rights reserved. The Displayer class displays text on the
		 * computer screen.
		 *
		 * @author Ankita Gaur
		 * 
		 * @version 1.0 09/04/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_LocationCountNR")
		public Object[][] getDataFromDataTC_LocationCountNR() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation, "TC_LocationCountNR_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_LocationCountNR", priority = 14)//priority = 14
		public void TC_LocationCountNR(Hashtable<String, String> TC_LocationCountNR) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of Active Location Quarterly Non Rolling
			String webCount = DashBoardActionsActions.TC_LocationCountNR(methodName, TC_LocationCountNR, logger);
			// Taking DB count of Active Location Quarterly Non Rolling
			HashMap<String, String> TC_LocationCountNRt = dashBoardTestsDB
					.TC_LocationCountNR(TC_LocationCountNR.get("Query"));

			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + TC_LocationCountNRt.get("TotalCount"));
			ca.verifyAssertEquals((webCount), TC_LocationCountNRt.get("TotalCount"),
					"Unable to verify \" " + (webCount)
							+ "\"Location count non-rolling data from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Location count non-rolling data count from Database and UI getting matched..",
					methodName, logger, "TC_13", driver);
		}

		
		 *//** Testcase ID- TC_0020 : TC_LocationCountR" Copyright 2018 FIGmd.in © 2018.
		 * All rights reserved. The Displayer class displays text on the computer
		 * screen.
		 *
		 * @author Ankita Gaur
		 * 
		 * @version 1.0 09/04/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System*//*
		 
		@DataProvider(name = "TC_LocationCountR")
		public Object[][] getDataFromDataTC_LocationCountR() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation, "TC_LocationCountR_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_LocationCountR", priority = 15)
		public void TC_LocationCountR(Hashtable<String, String> TC_LocationCountR) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of Active Location Quarterly Rolling
			String webCount = DashBoardActionsActions.TC_LocationCountR(methodName, TC_LocationCountR, logger);
			// Taking DB count of Active Location Quarterly Rolling
			HashMap<String, String> TC_LocationCountRt = dashBoardTestsDB.TC_LocationCountR(TC_LocationCountR.get("Query"));
			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + TC_LocationCountRt.get("TotalCount"));
			ca.verifyAssertEquals((webCount), TC_LocationCountRt.get("TotalCount"),
					"Unable to verify \" " + (webCount)
							+ "\"Location count rolling data from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Location count rolling data from Database and UI getting matched..", methodName,
					logger, "TC_14", driver);
		}

		
		 * Testcase ID- TC_0012 : TC_VerifyLastUpdatedDate" Copyright 2018 FIGmd.in
		 * © 2018. All rights reserved. The Displayer class displays text on the
		 * computer screen.
		 *
		 * @author Ankita Gaur
		 * 
		 * @version 1.0 09/05/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_VerifyLastUpdatedDate")
		public Object[][] getDataFromDataTC_VerifyLastUpdatedDate() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			System.out.println("Last Update");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_VerifyLastUpdatedDate_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_VerifyLastUpdatedDate", priority = 16)
		public void TC_VerifyLastUpdatedDate(Hashtable<String, String> TC_VerifyLastUpdatedDate) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			// Taking UI data of Last Updated Date
			String webCount = DashBoardActionsActions.TC_VerifyLastUpdatedDate(methodName, TC_VerifyLastUpdatedDate,
					logger);
			// Taking DB data of Last Updated Date
			HashMap<String, String> TC_VerifyLastUpdatedDatet = dashBoardTestsDB
					.TC_VerifyLastUpdatedDate(TC_VerifyLastUpdatedDate.get("Query"));
			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + TC_VerifyLastUpdatedDatet.get("EndTime"));
			ca.verifyAssertEquals((webCount), TC_VerifyLastUpdatedDatet.get("EndTime"),
					"Unable to verify \" " + (webCount)
							+ "\"Last Updated date from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Last Updated date from Database and UI getting matched..", methodName, logger,
					"TC_15", driver);
		}
		
		
		
		
		
		
		
		
	
	
	
		 * Testcase ID- TC_0025 : TC_ProviderCountR" Copyright 2018 FIGmd.in © 2018.
		 * All rights reserved. The Displayer class displays text on the computer
		 * screen.
		 *
		 * @author Surabhi Shah
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System*
		 
		@DataProvider(name = "TC_ProviderCountR")
		public Object[][] TC_ProviderCountR() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation, "TC_ProviderCountR_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_ProviderCountR", priority = 17)
		public void VerifyProvidercount(Hashtable<String, String> TC_ProviderCountR) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			// Taking UI count of Active MeasureSet2018
			String webCount = DashBoardActionsActions.TC_ProviderCountR(methodName, TC_ProviderCountR, logger);
			// Taking DB count of Active MeasureSet2018
			HashMap<String, String> TC_ProviderCountRt = dashBoardTestsDB.TC_ProviderCountR(TC_ProviderCountR.get("Query"));
			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + TC_ProviderCountRt.get("inactive"));

			ca.verifyAssertEquals((webCount), TC_ProviderCountRt.get("inactive"),
					"Unable to verify \" " + (webCount)
							+ "\"Provider rolling count from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Provider rolling count from Database and UI getting matched..", methodName,
					logger, "TC_16", driver);
		}

		
		 * Testcase ID- TC_0027 : TC_ProviderPatient DrillDownCountR" Copyright 2018
		 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
		 * on the computer screen.
		 *
		 * @author Surabhi Shah
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 
		@DataProvider(name = "TC_ProviderPatientCount")
		public Object[][] getDataFromDatadrillCount() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_ProviderPatientCount_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_ProviderPatientCount", priority = 18)
		public void Verifydrilldowncount(Hashtable<String, String> TC_ProviderPatientCount) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			// Taking UI count of Active MeasureSet2018
			String webCount = DashBoardActionsActions.TC_ProviderPatientCount(methodName, TC_ProviderPatientCount, logger);
			// Taking DB count of Active MeasureSet2018
			HashMap<String, String> databaseproviderdrilldowncount = dashBoardTestsDB
					.TC_ProviderPatientCount(TC_ProviderPatientCount.get("Query"));
			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + databaseproviderdrilldowncount.get("TotalPatient"));

			ca.verifyAssertEquals((webCount), databaseproviderdrilldowncount.get("TotalPatient"),
					"Unable to verify \" " + (webCount)
							+ "\" message provider patient count from Database and UI is not getting matched.",
					"\" " + (webCount) + "\" provider patient count from Database and UI getting matched..", methodName,
					logger, "TC_17", driver);
		}

		
		 * Testcase ID- TC_0028 : TC_ProviderCountNR" Copyright 2018 FIGmd.in ©
		 * 2018. All rights reserved. The Displayer class displays text on the
		 * computer screen.
		 *
		 * @author Surabhi Shah
		 * 
		 * @version 1.0 08/29/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_ProviderCountNR")
		public Object[][] getDataFromDataproviderNRCount() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation, "TC_ProviderCountNR_Data");
			log.info("Dataprovider Ends");
			return object;
		}

		@Test(dataProvider = "TC_ProviderCountNR", priority = 19)
		public void ProviderCountNR(Hashtable<String, String> data) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			DashBoardActions DashBoardActionsActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
			// Taking UI count of Active MeasureSet2018
			String webCount = DashBoardActionsActions.TC_ProviderCountNR(methodName, data, logger);

			// Taking DB count of Active MeasureSet2018
			HashMap<String, String> TC_ProviderCountNRTest = dashBoardTestsDB.TC_ProviderCountNR(data.get("Query"));
			System.out.println("Active measureset2018 UI_Count:" + webCount);
			System.out.println("Active measureset2018 Db_Count:" + TC_ProviderCountNRTest.get("inactive"));
			ca.verifyAssertEquals((webCount), TC_ProviderCountNRTest.get("inactive"),
					"Unable to verify \" " + webCount
							+ "\" message Provider count for NR from database and UI is not getting matched.",
					"\" " + (webCount) + "\"Provider count for NR from database and UI is  matched...", methodName, logger,
					"TC_0033");
		}
		
		
		
		
		
		
		
		
		
		// ------------------------------------------------------------------------------------------------------------------------------

		
		 

		// Poonam
		
		 * Testcase ID- TC_0021 : TC_PracticePerformanceTrendPatientDrillDownCountR"
		 * Copyright 2018 FIGmd.in © 2018. All rights reserved. The Displayer class
		 * displays text on the computer screen.
		 *
		 * @author PoonamZambare
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_PracticePerformanceTrendPatientDrillDownCountR")
		public Object[][] getDataFromDataproviderPracticePerformanceTrendPatientDrillDownCountR()
				throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PracticePTrendPatientDDCTRD");
			log.info("Dataprovider Ends");
			System.out.println("*************");
			System.out.println("object :" + object);
			System.out.println("*************");
			return object;
		}

		@Test(dataProvider = "TC_PracticePerformanceTrendPatientDrillDownCountR", priority = 20)
		public void TC_PracticePerformanceTrendPatientDrillDownCountR(
				Hashtable<String, String> TC_PracticePerformanceTrendPatientDrillDownCountR) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of PracticePerformanceTrendPatientDrillDownCountR
			String webCount = DashBoardActions.TC_PracticePerformanceTrendPatientDrillDownCountR(methodName,
					TC_PracticePerformanceTrendPatientDrillDownCountR, logger);

			// Taking DB count of PracticePerformanceTrendPatientDrillDownCountR
			HashMap<String, String> PracticePerformanceTrendPatientDrillDownCountR = dashBoardTestsDB
					.TC_PracticePerformanceTrendPatientDrillDownCountR(
							TC_PracticePerformanceTrendPatientDrillDownCountR.get("Query"));

			System.out.println("PracticePerformanceTrendPatientDrillDownCountR :"
					+ PracticePerformanceTrendPatientDrillDownCountR.get("TotalPatient"));

			ca.verifyAssertEquals((webCount), PracticePerformanceTrendPatientDrillDownCountR.get("TotalPatient"),
					"Unable to verify \" " + (webCount)
							+ "\" message Active patients from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Active patients from Database and UI getting matched..", methodName, logger,
					"TC_0021");

		}

		
		 * Testcase ID- TC_0013 : TC_PracticeProvidersPopUpCountR Copyright 2018
		 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
		 * on the computer screen.	
		 *
		 * @author Poonamzmbare
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_PracticeProvidersPopUpCountR")
		public Object[][] getDataFromDataPracticeProvidersPopUpCountR() throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PracticeProvidersPUCTRDataD");
			log.info("Dataprovider Ends");
			System.out.println("*************");
			System.out.println("object :" + object);
			System.out.println("*************");
			return object;
		}

		@Test(dataProvider = "TC_PracticeProvidersPopUpCountR", priority = 21)//priority = 21
		public void TC_PracticeProvidersPopUpCountR(Hashtable<String, String> TC_PracticeProvidersPopUpCountR)
				throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of PracticeProvidersPopUpCountR
			String webCount = DashBoardActions.TC_PracticeProvidersPopUpCountR(methodName, TC_PracticeProvidersPopUpCountR,
					logger);

			// Taking DB count of PracticeProvidersPopUpCountR
			HashMap<String, String> PracticeProvidersPopUpCountR = dashBoardTestsDB
					.TC_PracticeProvidersPopUpCountR(TC_PracticeProvidersPopUpCountR.get("Query"));

			System.out.println("TC_PracticeProvidersPopUpCountNR :" + PracticeProvidersPopUpCountR.get("TotalProviders"));

			ca.verifyAssertEquals((webCount), PracticeProvidersPopUpCountR.get("TotalProviders"),
					"Unable to verify \" " + (webCount)
							+ "\" message Active Providers from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Active providers from Database and UI getting matched..", methodName, logger,
					"TC_0013");

		}

		
		 * Testcase ID- TC_0023 : TC_PracticeAllProvidersPopUpCountR" Copyright 2018
		 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
		 * on the computer screen.
		 *
		 * @author Poonamzmbare
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_PracticeAllProvidersPopUpCountR")
		public Object[][] getDataFromDataproviderPracticeAllProvidersPopUpCountR()
				throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PracticeAllProvidersPUCTRD");
			log.info("Dataprovider Ends");
			System.out.println("*************");
			System.out.println("object :" + object);
			System.out.println("*************");
			return object;
		}

		@Test(dataProvider = "TC_PracticeAllProvidersPopUpCountR", priority = 22)//priority = 22
		public void TC_PracticeAllProvidersPopUpCountR(Hashtable<String, String> TC_PracticeAllProvidersPopUpCountR)
				throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of PracticePerformanceTrendPatientDrillDownCountR
			String webCount = DashBoardActions.TC_PracticeAllProvidersPopUpCountR(methodName,
					TC_PracticeAllProvidersPopUpCountR, logger);

			// Taking DB count of PracticePerformanceTrendPatientDrillDownCountR
			HashMap<String, String> databaseCountForPracticeAllProvidersPopUpCountR = dashBoardTestsDB
					.TC_PracticeAllProvidersPopUpCountR(TC_PracticeAllProvidersPopUpCountR.get("Query"));

			System.out.println("TC_PracticeAllProvidersPopUpCountR :"
					+ databaseCountForPracticeAllProvidersPopUpCountR.get("TotalProviders"));

			ca.verifyAssertEquals((webCount), databaseCountForPracticeAllProvidersPopUpCountR.get("TotalProviders"),
					"Unable to verify \" " + (webCount)
							+ "\" message Active Providers from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Active providers from Database and UI getting matched..", methodName, logger,
					"TC_0023");

		}

		
		 * Testcase ID- TC_0022 :
		 * TC_PracticePerformanceTrendPatientDrillDownCountNR" Copyright 2018
		 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
		 * on the computer screen.
		 *
		 * @author Poonamzmbare
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_PracticePerformanceTrendPatientDrillDownCountNR")
		public Object[][] getDataFromDataproviderPracticePerformanceTrendPatientDrillDownCountNR()
				throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PracticePTrendPatientDDCTNRD");
			log.info("Dataprovider Ends");
			System.out.println("*************");
			System.out.println("object :" + object);
			System.out.println("*************");
			return object;
		}

		@Test(dataProvider = "TC_PracticePerformanceTrendPatientDrillDownCountNR", priority = 23)//priority = 23
		public void TC_PracticePerformanceTrendPatientDrillDownCountNR(
				Hashtable<String, String> TC_PracticePerformanceTrendPatientDrillDownCountNR) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of PracticePerformanceTrendPatientDrillDownCountR
			String webCount = DashBoardActions.TC_PracticePerformanceTrendPatientDrillDownCountNR(methodName,
					TC_PracticePerformanceTrendPatientDrillDownCountNR, logger);

			// Taking DB count of PracticePerformanceTrendPatientDrillDownCountR
			HashMap<String, String> PracticePerformanceTrendPatientDrillDownCountR = dashBoardTestsDB
					.TC_PracticePerformanceTrendPatientDrillDownCountNR(
							TC_PracticePerformanceTrendPatientDrillDownCountNR.get("Query"));

			System.out.println("PracticePerformanceTrendPatientDrillDownCountR :"
					+ PracticePerformanceTrendPatientDrillDownCountR.get("TotalPatient"));

			ca.verifyAssertEquals((webCount), PracticePerformanceTrendPatientDrillDownCountR.get("TotalPatient"),
					"Unable to verify \" " + (webCount)
							+ "\" message Active patients from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Active patients from Database and UI getting matched..", methodName, logger,
					"TC_0022");

		}

		
		
		
		
		 * Testcase ID- TC_0024 : TC_PracticeAllProvidersPopUpCountNR" Copyright
		 * 2018 FIGmd.in © 2018. All rights reserved. The Displayer class displays
		 * text on the computer screen.
		 *
		 * @author Poonamzmbare
		 * 
		 * @version 1.0 01/06/18
		 * 
		 * @throws SQLException
		 * 
		 * @see java.lang.System
		 

		@DataProvider(name = "TC_PracticeAllProvidersPopUpCountNR")
		public Object[][] getDataFromDataproviderPracticeAllProvidersPopUpCountNR()
				throws IOException, InvalidFormatException {
			log.info("Dataprovider Start");
			Object[][] object = ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,
					"TC_PracticeAllProvidersPUCTNRD");
			log.info("Dataprovider Ends");
			System.out.println("*************");
			System.out.println("object :" + object);
			System.out.println("*************");
			return object;
		}

		@Test(dataProvider = "TC_PracticeAllProvidersPopUpCountNR", priority = 24)//priority = 24
		public void TC_PracticeAllProvidersPopUpCountNR(Hashtable<String, String> TC_PracticeAllProvidersPopUpCountNR)
				throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			LoginActions loginAction = new LoginActions(driver, wait);
			DashBoardActions DashBoardActions = new DashBoardActions(driver, wait);
			DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

			// Taking UI count of PracticePerformanceTrendPatientDrillDownCountR
			String webCount = DashBoardActions.TC_PracticeAllProvidersPopUpCountNR(methodName,
					TC_PracticeAllProvidersPopUpCountNR, logger);

			// Taking DB count of PracticePerformanceTrendPatientDrillDownCountR
			HashMap<String, String> databaseCountForPracticeAllProvidersPopUpCountNR = dashBoardTestsDB
					.TC_PracticeAllProvidersPopUpCountNR(TC_PracticeAllProvidersPopUpCountNR.get("Query"));

			System.out.println("TC_PracticeAllProvidersPopUpCountNR :"
					+ databaseCountForPracticeAllProvidersPopUpCountNR.get("TotalProviders"));

			ca.verifyAssertEquals((webCount), databaseCountForPracticeAllProvidersPopUpCountNR.get("TotalProviders"),
					"Unable to verify \" " + (webCount)
							+ "\" message Active Providers from Database and UI is not getting matched.",
					"\" " + (webCount) + "\"Active providers from Database and UI getting matched..", methodName, logger,
					"TC_0024");
		}
		
		
		
	 

	
	

	

	
	
	//----------------------------------------------------------------------------------------------------------------
	
	 Test Case ID - AAO_TC_0031
 	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	  * Test case Details - To verify copyright year is present after logging into dash-board 
	 * Author -  Akshay Pandav
	 * Date 31/08/2018
	   
 	
 	@DataProvider(name="TC_CopyrightyearCntent")
    public Object[][] getDataCopyrightyearCntent() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] LoginData=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_CopyrightyearCntent");
		log.info("Dataprovider Ends");
		return LoginData;
    }
    
 	@Test(dataProvider="TC_CopyrightyearCntent",priority=24)
	public void verifyCopyrightyearCntent(Hashtable <String,String> exceldata) throws Exception{
	  
		WebDriverWait wait = new WebDriverWait(driver,60);				
		DashBoardActions dash =  new DashBoardActions(driver, wait);
		
//		 *  Test case Details - Login to the application and verified user name
		 
		String Getcopyrightname = dash.TC_CopyrightyearCntent(logger);
						
		ca.verifyAssertEquals(
				Getcopyrightname,exceldata.get("copyrightname"), 
				"Unable to verify \" "+exceldata.get("copyrightname")+"\".",
				"\" "+exceldata.get("copyrightname")+"\" is present on screen..", 
				methodName,logger,"TC_0031",driver);
		 	}
 	
 	
 	@DataProvider(name="TC_CopyrightyearContenttabs")
    public Object[][] getDataCopyrightyearContenttabs() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] LoginData=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_Copyright_tabnames");
		log.info("Dataprovider Ends");
		return LoginData;
    }
    
 	@Test(dataProvider="TC_CopyrightyearContenttabs",priority=25)//priority=25
	public void verifyCpyrightTabs(Hashtable <String,String> exceldata) throws Exception{
	  
		WebDriverWait wait = new WebDriverWait(driver,60);				
		DashBoardActions tabs =  new DashBoardActions(driver, wait);
		String GetUserName = tabs.TC_verifyCpyrightTabsnames(logger);
		System.out.println("tabname:"+GetUserName);
		String exceldataa=exceldata.get("alltab");
		System.out.println("totaltable:"+exceldata);
		System.out.println("Excelsheet data:"+exceldataa);
		ca.verifyAssertEquals(
				GetUserName,exceldata.get("alltab"), 
				"Unable to verify \" "+exceldata.get("alltab")+"\".",
				"\" "+exceldata.get("alltab")+"\"  verified successfully..", 
				methodName,logger,"TC_0032",driver);
 	}
 	
 	@DataProvider(name="TC_ProviderPatientDrillDownCountNR")
    public Object[][] getDataProviderPatientDrillDownCountNR() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] LoginData=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_ProviderPatientDrillDownCoun");
		log.info("Dataprovider Ends");
		return LoginData;
    }
    
 	@Test(dataProvider="TC_ProviderPatientDrillDownCountNR",priority=26)
	public void verifyProviderPatientDrillDownCountNR(Hashtable <String,String> data) throws Exception{
	  
		WebDriverWait wait = new WebDriverWait(driver,60);				
		DashBoardActions dash =  new DashBoardActions(driver, wait);
		DashBoardTestsDB db= new DashBoardTestsDB();
		LoginActions loginAction =  new LoginActions(driver, wait);
		
		HashMap<String, String> patientprovidercountNR = 
				db.TC_patientprovidercountNRDB(data.get("Query"));
		
		String Getpatientcount = dash.TC_ProviderPatientDrillDownCountNR(logger,data);
						
		ca.verifyAssertEquals(
				Getpatientcount,patientprovidercountNR.get("TotlaPatient"), 
				"Unable to verify \" "+patientprovidercountNR.get("TotlaPatient")+"\" with db.",
				"\" "+patientprovidercountNR.get("TotlaPatient")+"\" count of met patients verfied successfully.", 
				methodName,logger,"TC_0030",driver);
 	}
 	
 	
 	
 	
 	
 	@DataProvider(name="TC_ProviderPatientDrillDownCountPQRSmeasureSet")
    public Object[][] getDataProviderPatientDrillDownCountPQRSmeasureSet() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] LoginData=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_ProviderPatientDrillDownpqrs");
		log.info("Dataprovider Ends");
		return LoginData;
    }
    
 	@Test(dataProvider="TC_ProviderPatientDrillDownCountPQRSmeasureSet",priority=27)
	public void verifyProviderPatientDrillDownCountPQRSmeasureSet(Hashtable <String,String> data) throws Exception{
	  
		WebDriverWait wait = new WebDriverWait(driver,60);				
		DashBoardActions dash =  new DashBoardActions(driver, wait);
		DashBoardTestsDB db= new DashBoardTestsDB();
		LoginActions loginAction =  new LoginActions(driver, wait);
		HashMap<String, String> patientprovidercountpqrs = 
				db.TC_patientprovidercountpqrsDB(data.get("Query"));
		
		String Getpatientcount = dash.TC_ProviderPatientDrillDownCountpqrs(logger,data);
						
		ca.verifyAssertEquals(
				Getpatientcount,patientprovidercountpqrs.get("TotlaPatient"), 
				"Unable to verify \" "+patientprovidercountpqrs.get("TotlaPatient")+"\".",
				"\" "+patientprovidercountpqrs.get("TotlaPatient")+"\" verified successfully..", 
				methodName,logger,"TC_0029",driver);
 	}
 	
	 Test Case ID - AAO_TC_0014
 	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * Test case Details - To verify copyright popup tabs
	 * Author -  Akshay Pandav
	 * Date 31/08/2018
	 *  
 	
 	@DataProvider(name="TC_PracticeProvidersPatientDrillDownCountR")
    public Object[][] getDataFromDataproviderTC_PracticeProvidersPatientDrillDownCountR() throws IOException, InvalidFormatException
	{
		log.info("Dataprovider Start");
        Object[][] LoginData=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_PracticeProvidersPatientDril");
		log.info("Dataprovider Ends");
		return LoginData;
    }
    
 	@Test(dataProvider="TC_PracticeProvidersPatientDrillDownCountR",priority=28)
	public void TC_PracticeProvidersPatientDrillDownCountR(Hashtable <String,String> data) throws Exception{
	  
		WebDriverWait wait = new WebDriverWait(driver,60);				
		DashBoardActions dash =  new DashBoardActions(driver, wait);
		DashBoardTestsDB db= new DashBoardTestsDB();
		LoginActions loginAction =  new LoginActions(driver, wait);
		
		HashMap<String, String> patientprovidercountNR = 
				db.TC_patientprovidercountNRDB(data.get("Query"));
		
		String Getpatientcount = dash.TC_PracticeProvidersPatientDrillDownCountR(logger,data);
						
		ca.verifyAssertEquals(
				Getpatientcount,patientprovidercountNR.get("TotlaPatient"), 
				"Unable to verify \" "+patientprovidercountNR.get("TotlaPatient")+"\" with db.",
				"\" "+patientprovidercountNR.get("TotlaPatient")+"\" count of met patients verfied successfully.", 
				methodName,logger,"TC_0014",driver);
 	}
 	
 	
 	
 	            *   Rupesh Devlekar
 	 				
					 * Testcase ID- TC_0034 : TC_CrossCuttingMeasuresForMeasureSet2018"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Rupesh Devlekar
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 
				 	
				 	@DataProvider(name="TC_CrossCuttingMeasuresForMeasureSet2018")
				    public Object[][] getDataFromDataproviderCrossCuttingMeasuresForMeasureSet2018() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_MeasureSetDDWithActive_Data");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	//Not applicable as Cross cutting column is not available
				 	
				 	@Test(dataProvider="TC_CrossCuttingMeasuresForMeasureSet2018",priority=29)
					public void TC_CrossCuttingMeasuresForMeasureSet2018(Hashtable <String,String> data) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						//LoginActions loginAction =  new LoginActions(driver, wait);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						// Taking UI count of Active MeasureSet2018
						int webCount = DashBoardActionsActions.TC_CrossCuttingMeasuresForMeasureSet2018();
						// Taking DB count of Active MeasureSet2018
						HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = 
								dashBoardTestsDB.TC_CrossCuttingMeasuresForMeasureSet2018DB(data.get("Query"));
						System.out.println("Active measureset2018 UI_Count:" +webCount);
						System.out.println("Active measureset2018 Db_Count:" +databseCountCrossCuttingMeasuresForMeasureSet2018.get("inactive"));
						System.out.println("Active measureset2018 Db_Count:" +databseCountCrossCuttingMeasuresForMeasureSet2018.get("inactive"));
						
						ca.verifyAssertEquals(
								 Integer.toString(webCount),databseCountCrossCuttingMeasuresForMeasureSet2018.get("inactive"), 
								"Unable to verify \" "+Integer.toString(webCount)+"\" message Active measureset2018 from Database and UI is not getting matched.",
								"\" "+Integer.toString(webCount)+"\"Active measureset2018 from Database and UI getting matched..", 
								methodName,logger,"TC_0033");
						
				 	}
				 	
				 	
					
					 * Testcase ID- TC_0035 : TC_OutcomeMeasuresForMeasureSet2018"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Rupesh Devlekar
					 * @version 1.0 01/06/18
					 * @see java.lang.System
					 
				 	
				 	
				 	
				 	@DataProvider(name="TC_OutcomeMeasuresForMeasureSet2018")
				    public Object[][] getDataFromDataproviderOutcomeMeasuresForMeasureSet2018() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_OutcomeForMeasureSet_Data");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	@Test(dataProvider="TC_OutcomeMeasuresForMeasureSet2018",priority=30)
					public void TC_OutcomeMeasuresForMeasureSet2018(Hashtable <String,String> TC_OutcomeMeasuresForMeasureSet2018) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						//LoginActions loginAction =  new LoginActions(driver, wait);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						
						// Taking UI count of Outcome Measures
						int webCount = DashBoardActionsActions.TC_OutcomeMeasuresForMeasureSet2018(methodName,TC_OutcomeMeasuresForMeasureSet2018,logger);
						// Taking DB count of Outcome Measures
						HashMap<String, String> databseCountOutcomeMeasuresForMeasureSet2018= 
								dashBoardTestsDB.TC_OutcomeMeasuresForMeasureSet2018(TC_OutcomeMeasuresForMeasureSet2018.get("Query"));
						
						System.out.println("Outcome Measures UI_Count:" +webCount);
						System.out.println("Outcome Measures Db_Count:" +databseCountOutcomeMeasuresForMeasureSet2018.get("Outcome"));
						
						ca.verifyAssertEquals(
								 Integer.toString(webCount),databseCountOutcomeMeasuresForMeasureSet2018.get("Outcome"), 
								"Unable to verify \" "+Integer.toString(webCount)+"\" Outcome Measures  from Database and UI is not getting matched.",
								"\" "+Integer.toString(webCount)+"\"Outcome Measures from Database and UI getting matched..", 
								methodName,logger,"TC_0035",driver);
					}
				 		
				 	
				 	
					 * Testcase ID- TC_0034 :TC_HighpriorityMeasuresForMeasureSet2018"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Rupesh Devlekar
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 
				 	
				 	
				 	
				 	@DataProvider(name="TC_HighpriorityMeasuresForMeasureSet2018")
				    public Object[][] getDataFromDataproviderHighpriorityMeasuresForMeasureSet2018() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_HighpriorityForMeasureSet_Da");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	@Test(dataProvider="TC_HighpriorityMeasuresForMeasureSet2018",priority=31)
					public void TC_HighpriorityMeasuresForMeasureSet2018(Hashtable <String,String> TC_HighpriorityMeasuresForMeasureSet2018) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						//LoginActions loginAction =  new LoginActions(driver, wait);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						// Taking UI count of HighpriorityMeasures
						int webCount = DashBoardActionsActions.TC_HighpriorityMeasuresForMeasureSet2018(methodName,TC_HighpriorityMeasuresForMeasureSet2018,logger);
						System.out.println(TC_HighpriorityMeasuresForMeasureSet2018.get("Query"));
						// Taking DB count of HighpriorityMeasures
						HashMap<String, String> databseCountHighpriorityMeasuresForMeasureSet2018= 
								dashBoardTestsDB.TC_HighpriorityMeasuresForMeasureSet2018(TC_HighpriorityMeasuresForMeasureSet2018.get("Query"));
						System.out.println("HighpriorityMeasures UI_Count:" +webCount);
						System.out.println("HighpriorityMeasures Db_Count:" +databseCountHighpriorityMeasuresForMeasureSet2018.get("HighPriority"));
						ca.verifyAssertEquals(
								 Integer.toString(webCount),databseCountHighpriorityMeasuresForMeasureSet2018.get("HighPriority"), 
								"Unable to verify \" "+Integer.toString(webCount)+"\" message HighPriority measures measureset2018 from Database and UI is not getting matched.",
								"\" "+Integer.toString(webCount)+"\"HighPriority measures  from Database and UI getting matched..", 
								methodName,logger,"TC_0034",driver);
				 	}
				 	
				 	
					 * Testcase ID- TC_0036 :TC_VerifyHeaderDetailsforPatientDDWhenOpenedForProvider"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Rupesh Devlekar
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 
				 	
				 	
					@DataProvider(name="TC_VerifyHeaderDetailsforPatientDDWhenOpenedForProvider")
				    public Object[][] getDataFromHeaderDetailsforPatientDDWhenOpenedForProvider() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_VerifyHeaderDetails");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	@Test(dataProvider="TC_VerifyHeaderDetailsforPatientDDWhenOpenedForProvider",priority=32)
					public void TC_HeaderDetailsforPatientDDWhenOpenedForProvider(Hashtable <String,String> TC_HeaderDetailsforPatientDDWhenOpenedForProvider) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						LoginActions loginAction =  new LoginActions(driver, wait);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						// Taking UI count of Outcome Measures
						ArrayList<String>  providername = DashBoardActionsActions.TC_HeaderDetailsforPatientDDWhenOpenedForProvider(methodName,TC_HeaderDetailsforPatientDDWhenOpenedForProvider,logger);
						System.out.println("Provider Name on lannding Page:" +providername.get(1));
						System.out.println("Provider Name on Drill-Down Pop-up:" +providername.get(0));
						ca.verifyAssertEquals(
								providername.get(0).toLowerCase().trim(),providername.get(1).toLowerCase().trim(), 
								"Unable to verify \" "+providername.get(0)+"\" Provider Name on lannding Page and Drill-Down Pop-up is not getting matched.",
								"\" "+providername.get(0)+"\"Provider Name on lannding Page and Drill-Down Pop-up is  getting matched..", 
								methodName,logger,"TC_0037",driver);
				 	}
				 	
				 	
					 * Testcase ID- TC_0040 :TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Rupesh Devlekar
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 
				 	
				 	
				 	@DataProvider(name="TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice")
				    public Object[][] getRegistryAvgOnPerformanceTrendModalForPractice() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_VerifyHeaderDetails");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	//This Testcase is not understandable
				 	
				 	@Test(dataProvider="TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice",priority=33)//priority=33
					public void TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice(Hashtable <String,String> TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						LoginActions loginAction =  new LoginActions(driver, wait);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						// Taking UI count of Outcome Measures
						ArrayList<String>  RegistryAverage = DashBoardActionsActions.TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice(methodName,TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice,logger);
						
						System.out.println("RegistryAverage on landingpage:" +RegistryAverage.get(0));
						System.out.println("RegistryAverage on drilldown:" +RegistryAverage.get(1));
						
						
						ca.verifyAssertEquals(
								RegistryAverage.get(0).toLowerCase().trim(),RegistryAverage.get(1).toLowerCase().trim(), 
								"Unable to verify \" "+RegistryAverage.get(0)+"\" RegistryAverage on landingpage and drilldown is not getting matched.",
								"\" "+RegistryAverage.get(0)+"\"RegistryAverage on landingpage and drilldown is getting matched..", 
								methodName,logger,"TC_0040",driver);
						
				 	}
				 	

	
				 	

				 	
					 * Testcase ID- TC_0015 : TC_PracticeLocationPopUpCountR"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Amol Bande
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 
				 	
				 	@DataProvider(name="TC_PracticeLocationPopUpCountR")
				    public Object[][] getDataFromDataproviderTC_PracticeLocationPopUpCountR() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_PracticeLocationPPCountR_Dat");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	@Test(dataProvider="TC_PracticeLocationPopUpCountR",priority=34)//priority=34
					public void TC_PracticeLocationPopUpCountR(Hashtable <String,String> data) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						
						// Taking UI count of Active MeasureSet2018
						String webCount = DashBoardActionsActions.TC_PracticeLocationPopUpCountR(logger, data);
						
						System.out.println("Location web Count :"+webCount);
						// Taking DB count of TC_PracticeLocationPopUpCountR
						HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = 
								dashBoardTestsDB.TC_PracticeLocationPopUpCountR(data.get("Query"));
						System.out.println("Location web Count:" +webCount);
						System.out.println("Active measureset2018 Db_Count:" +databseCountCrossCuttingMeasuresForMeasureSet2018.get("Location_Name"));
						
						ca.verifyAssertEquals(
								 webCount,databseCountCrossCuttingMeasuresForMeasureSet2018.get("Location_Name"), 
								"Unable to verify \" "+webCount+"\" message Practice Location PopUp Count Rolling from Database and UI is not getting matched.",
								"\" "+webCount+"\"Active Practice Location PopUp Count Rolling from Database and UI getting matched..", 
								methodName,logger,"TC_0015");
						
				 	}
				 	
				 	
				 	
					 * Testcase ID- TC_0016 : TC_PracticeLocationPopUpCountNR"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Amol Bande
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 
				 	
				 	
				 	
				 	@DataProvider(name="TC_PracticeLocationPopUpCountNR")
				    public Object[][] getDataFromDataproviderTC_PracticeLocationPopUpCountNR() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_PracticeLocationPPCTNR_Dat");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	
				 	@Test(dataProvider="TC_PracticeLocationPopUpCountNR",priority=35)//priority=35
					public void TC_PracticeLocationPopUpCountNR(Hashtable <String,String> data) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						// Taking UI count of Active MeasureSet2018
									String webCount = DashBoardActionsActions.TC_PracticeLocationPopUpCountNR(logger, data);
									System.out.println("Location web Count :"+webCount);
									// Taking DB count of TC_PracticeLocationPopUpCountNR
									HashMap<String, String> databseCountCrossCuttingMeasuresForMeasureSet2018 = 
											dashBoardTestsDB.TC_PracticeLocationPopUpCountNR(data.get("Query"));
									System.out.println("Location web Count Non rolling:" +webCount);
									System.out.println("Location web Count Non rolling Db_Count:" +databseCountCrossCuttingMeasuresForMeasureSet2018.get("Location_Name"));
									ca.verifyAssertEquals(
											 webCount,databseCountCrossCuttingMeasuresForMeasureSet2018.get("Location_Name"), 
											"Unable to verify \" "+webCount+"\" message Practice Location PopUp Count Non Rolling from Database and UI is not getting matched.",
											"\" "+webCount+"\"Active Practice Location PopUp Count Non Rolling from Database and UI getting matched..", 
											methodName,logger,"TC_0016");
				 	}
	
	
	
	
	
				 	

				 	
					 * Testcase ID- TC_0034 : TC_CrossCuttingMeasuresForMeasureSet2018"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Amol Bande
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 

				 	  
				 	@DataProvider(name="TC_VerifyMeasureNameHeaderPerformaceTrendForPractice")
				    public Object[][] getDataFromDataproviderTC_VerifyMeasureNameHeaderPerformaceTrendForPractice() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_VerifyHeaderDetailsforPatie");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	@Test(dataProvider="TC_VerifyMeasureNameHeaderPerformaceTrendForPractice",priority=36)//priority=36
					public void TC_verifyPracticeName(Hashtable <String,String> TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticep) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();

						
						String practice= DashBoardActionsActions.TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPractice(methodName, TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticep, logger);
						
						// Taking DB count of Active MeasureSet2018
						System.out.println(TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticep.get("Query"));
						HashMap<String, String> TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticeDB = 
								dashBoardTestsDB.TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticeDB(TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticep.get("Query"));
						System.out.println("Actual Practice name:" +practice);
						System.out.println("Expected Practice name:" +TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticeDB.get("Listname"));

						ca.verifyAssertEquals(
								 (practice.replaceAll("\\s+","")),(TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticeDB.get("Listname").replaceAll("\\s+","")), 
								"Unable to verify \" "+ practice +"\" message Practice name from Database and UI is not getting matched.",
								"\" "+(practice)+"\"Practice name from Database and UI getting matched..", 
								methodName,logger,"TC_0038");
						
						
				 	}
				 	
				 	
				 	
					 * Testcase ID- TC_0034 : TC_CrossCuttingMeasuresForMeasureSet2018"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Bhagyshri
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
					 

				 	  
				 	@DataProvider(name="TC_VerifyHeaderDetails")
				    public Object[][] getDataFromDataproviderTC_VerifyHeaderDetails() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_VerifyMeasureName_data");
				  
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	// This testcase is not understandable 
				 	
				 	@Test(dataProvider="TC_VerifyHeaderDetails",priority=37)//priority=37
					public void TC_VerifyHeaderDetails(Hashtable <String,String> TC_VerifyMeasureNameHeaderPerformaceTrendForPracticep) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						LoginActions loginAction =  new LoginActions(driver, wait);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						
						String measure1= DashBoardActionsActions.TC_VerifyMeasureNameHeaderPerformaceTrendForPractice(methodName, TC_VerifyMeasureNameHeaderPerformaceTrendForPracticep, logger);
						String measure = measure1.trim();
						HashMap<String, String> TC_VerifyMeasureNameHeaderPerformaceTrendForPracticeDB = 
								dashBoardTestsDB.TC_VerifyMeasureNameHeaderPerformaceTrendForPracticeDB(TC_VerifyMeasureNameHeaderPerformaceTrendForPracticep.get("Query"));
						System.out.println("Actual measure name:" +measure);
						System.out.println("Expected Practice name:" +TC_VerifyMeasureNameHeaderPerformaceTrendForPracticeDB.get("Description"));
						ca.verifyAssertEquals(
								 (measure),TC_VerifyMeasureNameHeaderPerformaceTrendForPracticeDB.get("Description"), 
								"Unable to verify \" "+ measure +"\" message measure name from Database and UI is not getting matched.",
								"\" "+(measure)+"\"Practice name from Database and UI getting matched..", 
								methodName,logger,"TC_0039");
				 	}
				 	
				 	
				 	
				 	
					 * Testcase ID- TC_0034 : TC_CrossCuttingMeasuresForMeasureSet2018"
					 * Copyright 2018 FIGmd.in © 2018.
					 * All rights reserved.
					 * The Displayer class displays text 
					 * on the computer screen.
					 *
					 * @author  Amol Bande
					 * @version 1.0 01/06/18
					 * @throws SQLException 
					 * @see java.lang.System
				 	
				 
					 
*/
				 	  
				 	@DataProvider(name="TC_VerifytooltipAgainstMeasures")
				    public Object[][] getDataFromDataproviderTC_VerifytooltipAgainstMeasures() throws IOException, InvalidFormatException
					{
						log.info("Dataprovider Start");
				        Object[][] object=ex.getDataingrid(getDataFromDataproviderMeasureCaseFileLocation,"TC_tooltipAgainstMeasuresData");
						log.info("Dataprovider Ends");
						return object;
				    }
				 	
				 	// Not applicable for ACC 
				 	
				 //	@Test(dataProvider="TC_VerifytooltipAgainstMeasures",priority=38)//priority=38
					public void TC_VerifytooltipAgainstMeasures(Hashtable <String,String> TC_VerifytooltipAgainstMeasuresp) throws Exception{
						WebDriverWait wait = new WebDriverWait(driver,60);	
						DashBoardActions DashBoardActionsActions =  new DashBoardActions(driver, wait);	
						//DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
						String tooltip= DashBoardActionsActions.TC_VerifytooltipAgainstMeasures(methodName, TC_VerifytooltipAgainstMeasuresp, logger);
						System.out.println("Tool-tip display result:" +tooltip);
						if (tooltip.equals("Higher score for this measure is Better"))
						{
						System.out.println( "TC:43: Test Passed") ;
						logger.log(LogStatus.PASS, "TC:43: Pass: Tooltip Against Measures");
						}
						else if (tooltip.equals("Higher score for this measure is Better"))
						{
							System.out.println("TC:43: Lower score for this measure is Better");
							logger.log(LogStatus.PASS, "TC:43: Pass: Tooltip Against Measures");
						}
						else
						{
						System.out.println( "TC:43: Test Failed" );
						logger.log(LogStatus.FAIL,"TC:43: Fail: Tooltip Against Measures");
				
						}
				 	}
					
	
					
					
					
					
				
					
					
	

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
			hst.putAll((Hashtable<String, String>)object[0][0]);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			new DashBoardActions(driver, wait).verifySelectPractice﻿(logger, hst);
			System.out.println("***********************************************************************************************");
			// ca.assertFailWithOutException("Fail: Method -"+methodName+" has
			// been failed...");
		}
	}
	
	

	

	@AfterClass
	public void TearDown() {
		report.endTest(logger);
		report.flush();
		
		System.out.println("I ma here");
	}
	

}
