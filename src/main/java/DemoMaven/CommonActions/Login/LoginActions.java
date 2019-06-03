package DemoMaven.CommonActions.Login;


import java.util.Hashtable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.CommonActions.Login.LoginActions;
import DemoMaven.UI_Map.Login.LoginUI;



public class LoginActions {
	
	WebDriver driver;
	WebDriverWait wait;
	
	LoginUI loginUI = new LoginUI();
	
	CommonAction  ca= new CommonAction();
    
	public LoginActions(WebDriver driver,WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
	}
    
	 /** Test Case ID - AUI_Login_01
	 * Test case Details - Verification user login successfully or not
	 * Author -  Amol
	 * */ 
	
    public String ASPSVerifyValidLoginDetails(String UserName, String Password)throws InterruptedException {    	    	    
    	ca.ElementToClick(loginUI.loginEmailTextbox, driver, wait);
    	ca.ElementToSendData(loginUI.loginEmailTextbox, UserName, driver, wait);
    	ca.ElementToClick(loginUI.loginPasswordTextbox, driver, wait);
    	ca.ElementToSendData(loginUI.loginPasswordTextbox, Password, driver, wait);
    	ca.ElementToClick(loginUI.signInButton, driver, wait);
    	
    	String successMessage = ca.ElementGetText(loginUI.getUserName, driver, wait);
    	return successMessage;
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

    /** Test Case ID - AUI_Login_01
	 * Test case Details - Verification user login successfully or not
	 * Author -  Amol
	 * */ 
    
	public String VerifyValidLoginDetails(String methodName, Hashtable<String, String> data) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ca.ElementToClick(loginUI.loginEmailTextbox, driver, wait);
    	ca.ElementToSendData(loginUI.loginEmailTextbox, data.get("login_user"), driver, wait);
    	ca.ElementToClick(loginUI.loginPasswordTextbox, driver, wait);
    	ca.ElementToSendData(loginUI.loginPasswordTextbox, data.get("login_pass"), driver, wait);
    	ca.ElementToClick(loginUI.signInButton, driver, wait);
    	String successMessage = ca.ElementGetText(loginUI.getUserName, driver, wait);
		
    	return successMessage;
		
	}
    
    
    
}
