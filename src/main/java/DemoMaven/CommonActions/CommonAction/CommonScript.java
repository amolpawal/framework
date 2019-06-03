package DemoMaven.CommonActions.CommonAction;


import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.UI_Map.Login.LoginUI;



public class CommonScript {
	
	WebDriver driver;
	WebDriverWait wait;
	
	LoginUI loginUI = new LoginUI();
	
	
	CommonAction  ca= new CommonAction();
    
	public CommonScript(WebDriver driver,WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
	}
    
	  /** Test Case ID - AUI_Login_01
		 * Test case Details - Verification user login successfully or not
		 * Author -  Amol
	 * @param logger 
		 * */ 
	    
		public String VerifyValidLoginUser(String methodName, Hashtable<String, String> data, ExtentTest logger) throws InterruptedException {
			// TODO Auto-generated method stub
			
			ca.ElementToClickWithLogger(loginUI.loginEmailTextbox, driver, wait,logger,"Step1");
	
	    	ca.ElementToSendDataLogger(loginUI.loginEmailTextbox, data.get("login_user"), driver, wait,logger,"Step2");
	    	ca.ElementToClickWithLogger(loginUI.loginPasswordTextbox, driver, wait,logger,"Step3");
	    	ca.ElementToSendDataLogger(loginUI.loginPasswordTextbox, data.get("login_pass"), driver, wait,logger,"Step4");
	    	ca.ElementToClickWithLogger(loginUI.signInButton, driver, wait,logger,"Step5");
	    	String GetUserName = ca.ElementGetTextLogger(loginUI.getUserName, driver, wait,logger,"Step6");
			
	    	return GetUserName;
			
		}
		
		
    /** Test Case ID - AUI_Login_01
	 * Test case Details - Verification user logout successfully or not
	 * Author -  Amol
	 * */ 
	
    public void logOutApplication() throws InterruptedException 
    {
	// TODO Auto-generated method stub
	Thread.sleep(1000); 
	ca.ElementToClick(loginUI.logOutBtn, driver, wait);
	Thread.sleep(1000);
	
    }

  
    
    
    
}
