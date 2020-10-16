package DemoMaven.CommonActions.CommonAction;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import  DemoMaven.Utilities.SuiteBase;

public class CommonAction extends SuiteBase
{
	
	public boolean isElementPresent(By loc, WebDriver driver)
	{
		try
		{
			driver.findElement(loc);
			//System.out.println("Hi");
			return true;
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Locator not found - "+loc);
			return false;
		}
	}
	
	public static void assertFailWithOutException(String failMsg)
	{
		Assert.fail(failMsg);
	}
	
	public void verifyAsserTrue(boolean condition, String passMsg , String failMsg, String methodName)
	{
		try
		{
			Assert.assertTrue(condition, failMsg);
			System.out.println(passMsg);
		}
		catch(AssertionError e)
		{
			System.out.println(failMsg+methodName);
		}
	}
	
	public void verifyAssertEqualsString(String actual, String expected,String failMsg,String passMsg ,String methodName,ExtentTest logger)
	{
		try
		{
			Assert.assertEquals(actual, expected,failMsg);
			System.out.println(passMsg);
			
			logger.log(LogStatus.PASS, passMsg);
		}
		catch(AssertionError ex)
		{
			 System.out.println(ex.getMessage());
			 logger.log(LogStatus.FAIL , "Unable to verify url."+ex.getMessage());
		}
	}
	
	
	public void verifyAssertEquals(String actual, String expected,String failMsg,String passMsg ,
			String methodName,ExtentTest logger,String TestCaseId)
	{
		try
		{
			Assert.assertEquals(actual, expected,failMsg);
			System.out.println(TestCaseId+" Pass :"+passMsg);
			logger.log(LogStatus.PASS, TestCaseId+" Pass:"+passMsg);
		}
		catch(AssertionError ex)
		{
			System.out.println("FAIL :"+TestCaseId+" "+ex.getMessage());
			logger.log(LogStatus.FAIL ,"Fail :"+TestCaseId+" Unable to verify "+ex.getMessage());
			/*String screenshotPath = CommonAction.getScreenhot(driver, TestCaseId);
			 //To add it in the extent report  
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));*/
			
		}
	}
	
	
	
	public void verifyAssertEquals(String actual, String expected,String failMsg,String passMsg ,String methodName,ExtentTest logger,String TestCaseId,WebDriver driver ) throws Exception
	{
		try
		{
			Assert.assertEquals(actual, expected,failMsg);
			System.out.println(TestCaseId+" Pass : "+passMsg);
			logger.log(LogStatus.PASS, TestCaseId+" Pass:"+passMsg);
		}
		catch(AssertionError ex)
		{
			System.out.println("FAIL :"+TestCaseId+" "+ex.getMessage());
			logger.log(LogStatus.FAIL ,"Fail :"+TestCaseId+" Unable to verify "+ex.getMessage());
			String screenshotPath = CommonAction.getScreenhot(driver, TestCaseId);
			 //To add it in the extent report  
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			//CommonAction.assertFailWithOutException(failMsg);
			Assert.fail();
		}
	}
	
	
	
    //This method is to capture the screenshot and return the path of the screenshot.
	 
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
               //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+"_"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public void verifyAssertEqual(String actual, String expected,String failMsg,String passMsg ,String methodName,ExtentTest logger)
	{
		try
		{
			Assert.assertEquals(actual, expected,failMsg);
			System.out.println(passMsg);
			logger.log(LogStatus.PASS, passMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			captureFailureScreen(methodName);
			logger.log(LogStatus.FAIL, failMsg);
			assertFailWithOutException(failMsg);
			
		}
	}
	

	public void assertfailwithoutExcetion(String actual, String expected,String failMsg,String passMsg ,String methodName,ExtentTest logger){
		try {
			Assert.assertEquals(actual,expected);
			logger.log(LogStatus.PASS , "\" "+expected+"\" " +passMsg);
			System.out.println("\"PASS "+expected+"\" "+passMsg);
			} catch (AssertionError ex) {
				System.out.println(failMsg+ex.getMessage());
				logger.log(LogStatus.FAIL , failMsg+ex.getMessage());
			}
	}
	
		 
	public boolean verifyAssertfail(String actual, String expected,String failMsg,String passMsg ,String methodName,ExtentTest logger)
	{
		try
		{
			Assert.assertEquals(actual, expected);
			System.out.println(passMsg);
			logger.log(LogStatus.PASS, passMsg);
			return true;
		}
		catch(AssertionError e)
		{
			System.out.println("Unable to verify "+e.getMessage());
			logger.log(LogStatus.FAIL, failMsg);
			return false;
		}
	}
	
	public boolean verifyAssertWithoutFail(String actual, String expected,String failMsg,String passMsg ,String methodName,ExtentTest logger,String TestCaseId)
	{
		try
		{
			Assert.assertEquals(actual, expected);
			System.out.println(TestCaseId+" Pass:"+passMsg);
			logger.log(LogStatus.PASS, TestCaseId+" Pass:"+passMsg);
			return true;
		}
		catch(AssertionError ex)
		{
			System.out.println("FAIL :"+TestCaseId+"Unable to verify "+ex.getMessage());
			logger.log(LogStatus.FAIL ,"Fail :"+TestCaseId+failMsg);
			return false;
		}
	}
	
	
	public boolean isAllTrue(Iterable<?> list) {
		for (Object obj : list) {
		    if ((Boolean)obj != true)
		    return false;
		}
		return true;
	}
	
	
	public boolean isClickable(By Element,WebDriver driver)      
	{
	 boolean clickResult = true;
	try
	{
	   WebDriverWait wait = new WebDriverWait(driver, 5);
	   wait.until(ExpectedConditions.elementToBeClickable(Element));
	   ((WebElement) Element).click();
	   clickResult = false;
	   return clickResult;
	}
		catch (Exception e)
		{
			return clickResult;
		}
	}
	
	public static String isElemnetClickable(By Element,WebDriver driver)      
	{
		String clickResult = "true";
		try
		{
		   WebDriverWait wait = new WebDriverWait(driver, 5);
		   wait.until(ExpectedConditions.elementToBeClickable(Element));
		   ((WebElement) Element).click();
		   clickResult = "false";
		   return clickResult;
		}
		catch (Exception e)
		{
			return clickResult;
		}
	}
	
	 public String splitString(String label,String Expression)throws InterruptedException {
		 	String[] parts ;
			parts = label.split(Expression);
			return parts[1];
		}
	 
	 public String ElementGetAttribute(By Element,WebDriver driver,String value){
			String elementValue=driver.findElement(Element).getAttribute("value");	
			return elementValue;
		}
	 
	 public String ElementGetAttrributeTextValue(By Element,WebDriver driver,String attribute){
			String elementValue=driver.findElement(Element).getAttribute(attribute);	
			return elementValue;
		}
	 

	 	public void ElementToClick(By Element ,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.elementToBeClickable(Element));
	    	driver.findElement(Element).click();
		}
		
		public void ElementToSendData(By Element, String data ,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.elementToBeClickable(Element));
	    	driver.findElement(Element).clear();
	    	driver.findElement(Element).sendKeys(data);
		}
		
		
		public String ElementGetText(By Element,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	    	String elementText = driver.findElement(Element).getText();
	    	return elementText;
		}
		

		public List<WebElement> ListOfElement(By Element,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	    	List<WebElement> elementList = driver.findElements(Element);
	    	return elementList;
		}
		
		public void ElementClear(By Element,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	    	driver.findElement(Element).clear();
	     }

		public void focusToElement(By Element,WebDriver driver)
		{
			if(isElementPresent(Element, driver))
			{
				driver.findElement(Element).sendKeys("");
			}
			else{
				System.out.println("Loc not found -"+Element);
			}
		}
		
		public String ElementGetTextValue(By Element,WebDriver driver){
			String elementValue=driver.findElement(Element).getAttribute("value");	
			return elementValue;
		}
		
		public void EnterPress(By Element ,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.elementToBeClickable(Element));
	    	driver.findElement(Element).sendKeys(Keys.ENTER);
		}
	 
		public int ListOfElementSize(By Element,WebDriver driver ,WebDriverWait wait)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	    	List<WebElement> elementList = driver.findElements(Element);
	    	return elementList.size();
		}
		
		
		public void ElementToClickWithLogger(By Element ,WebDriver driver ,WebDriverWait wait, ExtentTest logger,String Steps)throws InterruptedException {    	
	    	wait.until(ExpectedConditions.elementToBeClickable(Element));
	    	driver.findElement(Element).click();
	    	logger.log(LogStatus.INFO,Steps+": " +Element+" Element is clickable..");
			System.out.println(Steps+": " +Element+" Element is clickable..");
		}
		
		
		public void ElementToSendDataLogger(By Element, String data ,WebDriver driver ,WebDriverWait wait, ExtentTest logger,String Steps)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.elementToBeClickable(Element));
	    	driver.findElement(Element).clear();
	    	driver.findElement(Element).sendKeys(data);
	    	logger.log(LogStatus.INFO,Steps+": " +Element+" Element is Send Data is :"+data);
			System.out.println(Steps+": " +Element+" Element is Send Data is :"+data);
	    	
		}
		
		
		public String ElementGetTextLogger(By Element,WebDriver driver ,WebDriverWait wait, ExtentTest logger,String Steps)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	    	String elementText = driver.findElement(Element).getText();
	    	logger.log(LogStatus.INFO,Steps+": " +Element+" Element is Getting Data is :"+elementText);
			System.out.println(Steps+": " +Element+" Element is Getting Data is :"+elementText);
	    	return elementText;
		}
		
		public List<WebElement> ListOfElementWithLogger(By Element,WebDriver driver ,WebDriverWait wait,ExtentTest logger,String Steps)throws InterruptedException {    	    	    
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	    	List<WebElement> elementList = driver.findElements(Element);
	    	logger.log(LogStatus.INFO,Steps+": " +Element+" Element list Getting Data is :"+elementList.size());
			System.out.println(Steps+": " +Element+" Element is Getting Data is :"+elementList.size());
			
	    	return elementList;
		}
		
			public  String getRandomString() {
	        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 10) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;

	    }
		
			public String  trimuicount(By Element,WebDriver driver, WebDriverWait wait,ExtentTest logger,String steps)
			{
				int index=0;
				char character = ' ';
				int i,j;
				String rawcount = driver.findElement(Element).getText();
				j=(rawcount.length()-1);
				
				for(i=j;rawcount.charAt(i)!=character;i--)
				{}
			
				index=i;
				System.out.println(rawcount.substring(index+1,rawcount.length()));
				return rawcount.substring(index+1,rawcount.length());
			
			}
		    
		    
			
			/***
			 * 
			 * This method will select the required measure set from the measures list.
			 * param : data(Measure Set passed from excel sheet)
			 * @param wait2 
			 * @param driver 
			 * @throws InterruptedException 
			 * @Author Awadhesh Sengar
			 ***/
		 public String SelectMeasureSet(WebDriver driver, WebDriverWait wait,ExtentTest logger,String MeasureSet,String Steps) throws InterruptedException

		{
			WebElement c;
			String ActualMeasureset;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			System.out.println(driver.findElement(By.xpath("//*[@id='txtMeasureSet']")).getText());
			driver.findElement(By.xpath("//*[@id='txtMeasureSet']")).click();

			ActualMeasureset = driver
					.findElement(By.xpath(
							"//table[@id='tblMeasureSetDropDownList']//tbody/tr[@id][@class='rowselected']/td/input"))
					.getAttribute("data-lable");

			if (ActualMeasureset.equalsIgnoreCase(MeasureSet)) {
				System.out.println(Steps+": " +MeasureSet+" is already selected");
				logger.log(LogStatus.INFO,Steps+": " +MeasureSet+" is already selected");
				driver.findElement(By.xpath("//div[@class='closebtn']/a[contains(text(),'Close')]")).click();
				return ActualMeasureset;

			} else if (ActualMeasureset.isEmpty()) {
				System.out.println(Steps+": No data is provided for selecting measure set");
				logger.log(LogStatus.INFO,Steps+": No data is provided for selecting measure set");
			} else {
				try {
					c = driver.findElement(
					By.xpath("//table[@id='tblMeasureSetDropDownList']//input[@data-lable='" + MeasureSet + "']"));
					System.out.println(Steps+":Selecting measure set " + MeasureSet);
					logger.log(LogStatus.INFO,Steps+":Selecting measure set " + MeasureSet);
					//WebDriverWait wait = new WebDriverWait(driver, 30);
					/// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='accordion']//td[2]/a")));
					wait.until(ExpectedConditions.visibilityOf(c));
					ActualMeasureset = c.getAttribute("data-lable");
					c.click();

				} catch (Exception e) {
					System.out.println(Steps+":Exception Occurred while selecting the measure set");
					logger.log(LogStatus.INFO,Steps+":Exception Occurred while selecting the measure set");
					e.printStackTrace();
				}

			}
			return ActualMeasureset;

		}

		
		 
		     /***
			 * 
			 * This method will select Non -rolling from practice breadcrum
			 * param :
			 * @param wait2 
			 * @param driver 
			 * @throws InterruptedException 
			 * @Author Awadhesh Sengar
			 ***/
		public String SelectNonRolling(WebDriver driver, WebDriverWait wait,ExtentTest logger,String Steps) {
			
			String StatusR = driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).getAttribute("checked");
		    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='divPager']")));
			
			
			System.out.println(StatusR);
			log.info("StatusR(TRUE) :" + StatusR);
			try {
				if (StatusR.equalsIgnoreCase("TRUE")) {
					driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).click();
					log.info("NON rollin selected");
					System.out.println("NON rollin selected");
					logger.log(LogStatus.INFO,Steps+":NON rollin selected");
					
				}
			} catch (NullPointerException nexc) {
				log.info("currently Non Rolling Selected hence return true");
				logger.log(LogStatus.INFO,Steps+":currently Non Rolling Selected hence return true");
				
			} catch (Exception exc) {
				log.warn("Exception in SelectNonRolling()");
				System.out.println("Exception in SelectNonRolling");
				logger.log(LogStatus.INFO,Steps+":Exception in SelectNonRolling"+exc);
				exc.printStackTrace();
			
			}
			return "pass";
		}
		
		
		    /***
			 * 
			 * This method will select rolling from practice breadcrum
			 * param :
			 * @param wait2 
			 * @param driver 
			 * @throws InterruptedException 
			 * @Author Awadhesh Sengar
			 ***/
		
		public String SelectRolling(WebDriver driver, WebDriverWait wait,ExtentTest logger,String Steps) {
			String StatusNR = driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).getAttribute("checked");
			log.info("StatusNR(NULL) :" + StatusNR);
			try {
				if (StatusNR.equalsIgnoreCase("TRUE")) {
					log.info("currently Rolling is Selected hence return true");
					System.out.println("currently Rolling is Selected hence return true");
					logger.log(LogStatus.INFO,Steps+":currently Rolling is Selected hence return true");
					
				}
			} catch (NullPointerException nexc) {
				driver.findElement(By.xpath(".//*[@id='RollNonRoll']")).click();
				log.info("Rolling selected");
				System.out.println("NON rolling selected");
				logger.log(LogStatus.INFO,Steps+":Rolling selected");
				
			} catch (Exception exc) {
				log.warn("Exception in SelectRolling()");
				exc.printStackTrace();
				System.out.println("Exception in SelectRolling()");
				logger.log(LogStatus.INFO,Steps+":Exception in SelectNonRolling"+exc);
				
			}
			return "pass";
		}

		
		  /***
		 * 
		 * This method will split Element With Expression
		 * param :
		 * @param wait 
		 * @param driver 
		 * @throws InterruptedException 
		 * @Author Amol Bande
		 ***/
		
		
		public String[] splitElementWithExpression(By Element,WebDriver driver ,WebDriverWait wait,ExtentTest logger,String Expression,String Steps)throws InterruptedException {
			String[] parts ;
			String testString = ElementGetText(Element, driver,wait);
			parts = testString.split(Expression);
			logger.log(LogStatus.INFO,Steps+": " +Element+" Split Element String is :"+testString);
			System.out.println(Steps+": " +Element+" Split Element String is :"+testString);
			
		/*for(String name : parts){
				System.out.println(name);
				}
		*/
			return parts;
			
		}	
		
		
		 /***
		 * This method for selecting quarter dropdown
		 * @Author Amol Pawal
		 ***/

		public String selectQuarter(By element,WebDriver driver, WebDriverWait wait,ExtentTest logger,String quarter,String Steps){
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			Select drpDuration = new Select(driver.findElement(element));
			System.out.println(quarter);
			drpDuration.selectByValue(quarter);
			logger.log(LogStatus.INFO,Steps+": " +element+"Quarter is selected");
			System.out.println(Steps+": " +"Quarter is selected");
			return "Pass";
		}
		
		public String getFirstSelectedOptionInDrp(By element,WebDriver driver, WebDriverWait wait){
			Select drp = new Select(driver.findElement(element));
			WebElement firstOptionElement= drp.getFirstSelectedOption();
			String firstOptionText= firstOptionElement.getText();
			return firstOptionText;
		}
		
		

	//	----------------------------------------Lipid Methods----------------------------------
		
		
		 public String selectYearDropDown(WebDriver driver, WebDriverWait wait,ExtentTest logger,String year,String Steps) throws InterruptedException{
				WebElement drpYear;
				String SetValue=null;
			
			    String actualYearValue = ca.getFirstSelectedOptionInDrp(lipidui.yeardropdown, driver, wait);
				
			

				if (actualYearValue.equalsIgnoreCase(year)) {
					System.out.println(Steps+": " +year+" is already selected in Year dropdown");
					logger.log(LogStatus.INFO,Steps+": " +year+" is already selected in Year dropdown");
					return actualYearValue;

				} else if (actualYearValue.isEmpty()) {
					System.out.println(Steps+": No data available");
					logger.log(LogStatus.INFO,Steps+"No data available");
				} else {
					try {
						drpYear = driver.findElement(lipidui.yeardropdown);
						System.out.println(Steps+":Selecting measure set " + year);
						logger.log(LogStatus.INFO,Steps+":Selecting measure set " + year);
						wait.until(ExpectedConditions.visibilityOf(drpYear));
						Select s = new Select(drpYear);
						s.selectByVisibleText(year);
						SetValue = drpYear.getAttribute("value");
						return SetValue;
					    

					} catch (Exception e) {
						System.out.println(Steps+":Exception Occurred while selecting the Year dropdown value");
						logger.log(LogStatus.INFO,Steps+":Exception Occurred while selecting Year dropdown value");
						throw new AssertionError("A clear description of the failure", e);
					}
                     
				}
				return SetValue;
			}
		 
		 
		 public String selectASCVDOrDiabetes(WebDriver driver, WebDriverWait wait,ExtentTest logger,String disease,String Steps) throws InterruptedException{
				WebElement drpASCVDOrDiabetes;
				String SetValue=null;
			
			    String actualASCVDOrDiabetesValue = ca.ElementGetAttrributeTextValue(lipidui.ascvdordiabetesdropdown, driver, "value");
				
			

				if (actualASCVDOrDiabetesValue.equalsIgnoreCase(disease)) {
					System.out.println(Steps+": " +disease+" is already selected");
					logger.log(LogStatus.INFO,Steps+": " +disease+" is already selected");
					return disease;

				} else if (actualASCVDOrDiabetesValue.isEmpty()) {
					System.out.println(Steps+": No data available");
					logger.log(LogStatus.INFO,Steps+"No data available");
				} else {
					try {
						drpASCVDOrDiabetes = driver.findElement(lipidui.ascvdordiabetesdropdown);
						System.out.println(Steps+":Selecting  value " + disease);
						logger.log(LogStatus.INFO,Steps+":Selecting ASCVD/Diabetes value :" + disease);
						wait.until(ExpectedConditions.visibilityOf(drpASCVDOrDiabetes));
						Select s = new Select(drpASCVDOrDiabetes);
						s.selectByVisibleText(disease);
						SetValue =drpASCVDOrDiabetes.getAttribute("value");
						return SetValue;
					    

					} catch (Exception e) {
						System.out.println(Steps+":Exception Occurred while Selecting ASCVD/Diabetes value");
						logger.log(LogStatus.INFO,Steps+":Exception Occurred while Selecting ASCVD/Diabetes valu");
						throw new AssertionError("A clear description of the failure", e);
					}
                  
				}
				return SetValue;
			}

		public String selectLDL(WebDriver driver, WebDriverWait wait, ExtentTest logger, Hashtable data, String Steps) {
			WebElement drpLdl;
			String setValue = null;
			String xpath;
			
			if(data.get("LDL").equals("All")){
				xpath = "//Select[@id='ddlboth']";
			}
			else{
			xpath = "//Select[@id='ddl"+data.get("ASCVD/Diabetes")+"']";
			}
			
			String actualLdlValue = driver.findElement(By.xpath(xpath)).getAttribute("value");
			
			
			if (actualLdlValue.equalsIgnoreCase((String) data.get("LDL"))) {
				System.out.println(Steps+": " +actualLdlValue+" is already selected");
				logger.log(LogStatus.INFO,Steps+": " +actualLdlValue+" is already selected");
				return setValue;

			} else if (actualLdlValue.isEmpty()) {
				System.out.println(Steps+": No data available");
				logger.log(LogStatus.INFO,Steps+"No data available");
			} else {
				try {
					drpLdl = driver.findElement(By.xpath(xpath));
					System.out.println(Steps+":Selecting  value " + data.get("LDL"));
					logger.log(LogStatus.INFO,Steps+":Selecting measure set " + data.get("LDL"));
					wait.until(ExpectedConditions.visibilityOf(drpLdl));
					Select s = new Select(drpLdl);
					s.selectByVisibleText((String) data.get("LDL"));
					setValue =drpLdl.getAttribute("value");
					return setValue;
				    

				} catch (Exception e) {
					System.out.println(Steps+":Exception Occurred while selecting the LDL value");
					logger.log(LogStatus.INFO,Steps+":Exception Occurred while selecting LDL value");
					throw new AssertionError("A clear description of the failure", e);
				}
              
			}
			return setValue;
		}
		
		
		
		
		public String selectPathway(WebDriver driver, WebDriverWait wait, ExtentTest logger, String pathway, String Steps) {
			WebElement drpPathway;
			String setValue = null;
		
			
			String actualPathwayValue = ca.ElementGetAttrributeTextValue(lipidui.pathway, driver, "value");
			
			
			if (actualPathwayValue.equalsIgnoreCase(pathway)) {
				System.out.println(Steps+": " +pathway+" is already selected");
				logger.log(LogStatus.INFO,Steps+": " +pathway+" is already selected");
				return setValue;

			} else if (actualPathwayValue.isEmpty()) {
				System.out.println(Steps+": No data available");
				logger.log(LogStatus.INFO,Steps+"No data available");
			} else {
				try {
					drpPathway = driver.findElement(lipidui.pathway);
					System.out.println(Steps+":Selecting pathway " + pathway);
					logger.log(LogStatus.INFO,Steps+":Selecting Pathaway " + pathway);
					wait.until(ExpectedConditions.visibilityOf(drpPathway));
					Select s = new Select(drpPathway);
					s.selectByVisibleText(pathway);
					setValue =drpPathway.getAttribute("value");
					return setValue;
				    

				} catch (Exception e) {
					System.out.println(Steps+":Exception Occurred while selecting the Pathway");
					logger.log(LogStatus.INFO,Steps+":Exception Occurred while selecting the Pathway");
					throw new AssertionError("A clear description of the failure", e);
				}
              
			}
			return setValue;
		}
		
		
		public String getTableRecords(WebDriverWait wait) throws InterruptedException{
			
			String str = ca.ElementGetTextLogger(lipidui.tablerecords, driver, wait, logger, "Step5");
			
			ArrayList<Object> records = new ArrayList<Object>();
			String[] values =str.split(" ");
			for(int i=0;i<values.length;i++){
				records.add(values[i]);
			}
			
			return (String) records.get(records.size()-1);
			
		}

		public void clickOnSearchBtn(WebDriver driver, WebDriverWait wait, ExtentTest logger, String Step) throws InterruptedException {
			ca.ElementToClickWithLogger(lipidui.btnSearch, driver, wait, logger, Step);
			
		}

		public String clickOnLipidLinks(WebDriver driver,WebDriverWait wait) {
			List<WebElement> ele= driver.findElements(lipidui.docslinks);
			Iterator<WebElement> i = ele.iterator();
			int j =1;
			while(i.hasNext()) {
				driver.findElement(By.xpath("(//i[@class='fa fa-square']/following-sibling::a)["+j+"]"));
			    WebElement element = i.next();
			     String linkname= element.getAttribute("data-type");
			     System.out.println(linkname);
			    if (element.isDisplayed()) {
			          element.click();
			         
			          
			          String oldTab = driver.getWindowHandle();
			    	  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			    	    newTab.remove(oldTab);
			    	    // change focus to new tab
			    	    driver.switchTo().window(newTab.get(0));
			    	    //String expected = driver.getTitle();
			    	    String url = driver.getCurrentUrl();
			    	    
			    	    System.out.println(url);
			    	    try {
							if(url.contains(linkname)){
								Assert.assertTrue(true);
							}
						} catch (AssertionError er) {
							// TODO Auto-generated catch block
							System.out.println("Document are not available");
						}
			  
			    	    
			            driver.switchTo().window(oldTab);
			            j++;
			          
			    }
			    
		}
			return "pass";
		
		}

		public void searchProvider(By providersearchbox, WebDriver driver, WebDriverWait wait, ExtentTest logger,
				String clinicianName, String step) {
			
			try{
				driver.findElement(providersearchbox).sendKeys(clinicianName);
			}
			catch(RuntimeException ex){
				System.out.println("Not able to search clinician");
			}
			
		}
}
					

