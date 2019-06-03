package DemoMaven.CommonActions.DashBoard;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.UI_Map.DashBoard.DashBoardLocators;
import DemoMaven.UI_Map.DashBoard.LipidLocators;
import DemoMaven.UI_Map.Login.LoginUI;
import DemoMaven.Utilities.SuiteBase;

public class LipidActions extends SuiteBase {
	
	private static final int webCount = 0;
	WebDriver driver;
	WebDriverWait wait;
	String callerClassName = Thread.currentThread().getStackTrace()[2].getMethodName();
	LoginUI loginUI = new LoginUI();
	LipidLocators lipidui = new LipidLocators();
	CommonAction  ca= new CommonAction();
	
	public LipidActions(WebDriver driver,WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
	}
	
	public String navigateToLipid(ExtentTest logger) throws InterruptedException{
		
		ca.ElementToClickWithLogger(lipidui.lipidmenu, driver, wait, logger, "Step1");
		String breadcrumvalue=ca.ElementGetTextLogger(lipidui.breadcrum, driver, wait, logger, "Step2");
		return breadcrumvalue;
		
	}

	public String TC_verifyAllCount_2018(String methodName, Hashtable<String, String> data, ExtentTest logger) throws InterruptedException {
		
	
		ca.selectYearDropDown(driver, wait, logger, data.get("Year"), "Step1");
		ca.selectASCVDOrDiabetes(driver, wait, logger, data.get("ASCVD/Diabetes"), "Step2");
		ca.selectLDL(driver, wait, logger, data, "Step3");
		ca.selectPathway(driver, wait, logger, data.get("Pathway"), "Step4");
		ca.clickOnSearchBtn(driver, wait, logger,"Step5");
		String tblRecords= ca.getTableRecords(wait);
		return tblRecords;
		
		
	}

	public String verifyLipidDoc(WebDriver driver,WebDriverWait wait) {
		 String result =ca.clickOnLipidLinks(driver,wait);
		 return result;
		
	}

	
	
}
