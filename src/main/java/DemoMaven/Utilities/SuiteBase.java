package DemoMaven.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import DemoMaven.CommonActions.CommonAction.ConfigurationManager;
import DemoMaven.CommonActions.extentreport.ExtentTestManager;
import DemoMaven.DataBase.DashBoard.DashBoardTestsDB;
import DemoMaven.DataBase.DashBoard.LipidTestsDB;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.TestData.CommonData.CommanData;
import DemoMaven.UI_Map.DashBoard.LipidLocators;

public class SuiteBase {
	public static WebDriver driver;
	public ExtentReports report;
	public static ExtentTest logger;
	public ConfigurationManager rd=new ConfigurationManager();
	public CommanData commonData = new CommanData();
	protected static CommonAction ca = new CommonAction();
	public static Logger log =Logger.getLogger("SuiteBase");
	protected DashBoardTestsDB dashBoardTestsDB = new DashBoardTestsDB();
	public LipidLocators lipidui  = new LipidLocators();
	public LipidTestsDB lipidTestsDB= new LipidTestsDB();
	
	
@BeforeTest
public void setupTest()
{
	
	
	//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	String browser= commonData.BrowserName;

	try {
	
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("iexplorer"))
        {
            // Update the driver path with your location
            String IeDriverPath=rd.read_Configfile("IeDriversPath");
            String IeDriverName=rd.read_Configfile("IeDriversName");
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+IeDriverPath+"\\"+IeDriverName);
            driver = new InternetExplorerDriver();
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            // Update the driver path with your location
            String ChromeDriversPath=rd.read_Configfile("ChromeDriversPath");
            String ChromeDriversName=rd.read_Configfile("ChromeDriversName");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ChromeDriversPath+"\\"+ChromeDriversName);
            //Code added for download file
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    		chromePrefs.put("profile.default_content_settings.popups", 0);
    		//chromePrefs.put("download.default_directory", "C:");
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--incognito");
    		options.setExperimentalOption("prefs", chromePrefs);
    		DesiredCapabilities cap = DesiredCapabilities.chrome();
    		cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
    		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    		cap.setCapability(ChromeOptions.CAPABILITY, options);
    		driver = new ChromeDriver(cap);
            //driver = new ChromeDriver();
        }
        log.info("Browser Started");
   //   screen.stop();
        driver.manage().window().maximize();
        driver.get(rd.read_Configfile("url"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
}

	@AfterTest
	public void tearownTest()
	{
		//driver.quit();
		
	}
	
	public String generateReport(String reportFileName,String reportDocTitle,String reportName ,String reportDetailsName)
	{
		  //System.out.println("Report for Adgebra.");
		 // String reportURL = CreativeServerImages.ReportPath+"/"+reportFileName+".html";
		 // String reportURL = "/home/amol/git/selfserve_adgebraui_selenium/SelfServ-Selenium/report/"+reportFileName+".html";
		  String reportURL = "./report/"+reportFileName+".html";
		  report = new ExtentReports(reportURL,true);
		  report.config().documentTitle(reportDocTitle);
		  report.config().reportName(reportName);
		  logger = report.startTest( reportDetailsName+" Tests");	
		  return reportURL;
	}

	public void captureFailureScreen(String methodName){
		
		String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
                getScreenshotAs(OutputType.BASE64);
 
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(Calendar.getInstance().getTime());
		String srcfile = "./ScreenShot/"+methodName+"_"+timeStamp+".jpg";
		System.out.println("srcfile :"+srcfile);
		try {
			FileUtils.copyFile(scrFile, new File(srcfile));
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base64Screenshot));
		} catch (IOException e) {
			System.out.println("Scrren not capture..");
		}
	}

}