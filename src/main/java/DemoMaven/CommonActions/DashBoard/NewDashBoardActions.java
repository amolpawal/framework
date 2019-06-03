package DemoMaven.CommonActions.DashBoard;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.CommonAction.NewCommonAction;

public class NewDashBoardActions {
	WebDriver driver;
	WebDriverWait wait;
	NewCommonAction nca = new NewCommonAction();
	CommonAction ca = new CommonAction();

	public NewDashBoardActions(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public String TC_DetailedPPDrillDownCountNR(Hashtable data) {
		nca.IsmenuSelected((String)data.get("Menu"),"Step1");
		nca.IsSubmenuSelected((String)(data.get("SubMenu")),"Step2");
		//ca.SelectMeasureSet(driver, wait, logger, MeasureSet, Steps)
		return "Pass";
	}

}
