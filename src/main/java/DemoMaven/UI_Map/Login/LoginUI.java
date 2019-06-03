package DemoMaven.UI_Map.Login;

import org.openqa.selenium.By;

public class LoginUI {
	
	public By loginEmailTextbox = By.id("ctl00_MainContent_txtUserName");	
	public By loginPasswordTextbox = By.id("ctl00_MainContent_txtPassword");	
	public By signInButton = By.id("imgOk22");
	
	public By getUserName = By.id("ctl00_ctl00_HeaderContent_lblLoggedeUserName");
	public By logOutBtn = By.xpath("//*[@id='divLogout']");
	
	
  }
