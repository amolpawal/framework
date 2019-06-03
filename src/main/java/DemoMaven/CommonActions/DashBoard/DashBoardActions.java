package DemoMaven.CommonActions.DashBoard;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import DemoMaven.CommonActions.CommonAction.CommonAction;
import DemoMaven.UI_Map.DashBoard.DashBoardLocators;
import DemoMaven.UI_Map.Login.LoginUI;



public class DashBoardActions {
	
	private static final int webCount = 0;
	WebDriver driver;
	WebDriverWait wait;

	String callerClassName = Thread.currentThread().getStackTrace()[2].getMethodName();
	
	LoginUI loginUI = new LoginUI();
	DashBoardLocators dashBoardUI = new DashBoardLocators();
	CommonAction  ca= new CommonAction();
    
	public DashBoardActions(WebDriver driver,WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
	}
    
	/**
	 * Testcase ID- TC_0034 : TC_CrossCuttingMeasuresForMeasureSet2018"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
	
    public int TC_CrossCuttingMeasuresForMeasureSet2018()throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	ca.ElementToClick(dashBoardUI.PracticeSubMenu, driver, wait);
    	Thread.sleep(5000);
    	ca.ElementToClick(dashBoardUI.measureSetDropDownActiveLaabl, driver, wait);
    	int webCount =ca.ListOfElementSize(dashBoardUI.measureSetDropDownActiveDD2018, driver, wait);
    	ca.ElementToClick(dashBoardUI.measureSetDropDownCloseButton, driver, wait);
    	
    	
    	
    	return webCount;
    }
    
    /**
	 * Testcase ID- TC_0002 : TC_DetailedPPDrillDownCountNR﻿"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
    
    public String TC_DetailedPPDrillDownCountNR(String methodName, Hashtable<String, String> tC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
    
    	ca.ElementToClickWithLogger(dashBoardUI.providerMenu, driver, wait, logger, "Step1");
    
    	ca.SelectMeasureSet(driver, wait, logger, tC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
    	
    	Thread.sleep(5000);
 
    	ca.SelectNonRolling(driver, wait, logger, "Step3");
   
    	
    	ca.selectQuarter(dashBoardUI.quarterdrp, driver, wait, logger,tC_DetailedPPDrillDownCountNR.get("Quarter"), "Step4");
    	
    	ca.searchProvider(dashBoardUI.providersearchbox,driver,wait,logger,"AINSWORTH,MICHAEL","Info");
    	
    	ca.ElementToClickWithLogger(dashBoardUI.OurProvider, driver, wait, logger, "Step4");//dashBoardUI.ProvideCATARACTTESTMeasue

    	ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step5");//dashBoardUI.ProvideIRISeCQM1Measue
    
    	ca.ElementToClickWithLogger(dashBoardUI.ProvidePerformanceQuarter, driver, wait, logger, "Step6");
  
    	String[] DetailedPPDrillDownCount = ca.splitElementWithExpression(dashBoardUI.ProvideCATARACTTESTDrillDownValue, driver, wait,logger, " ","Step7");
    	ca.ElementToClickWithLogger(dashBoardUI.ProvideCATARACTTESTDrillDownCloseBtn, driver, wait, logger, "Step8");
    	return DetailedPPDrillDownCount[3];
    }
    
    
    
    /**
	 * Testcase ID- TC_003 : TC_DetailedPPDrillDownCountR﻿"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
    
    public String TC_DetailedPPDrillDownCountR(String methodName, Hashtable<String, String> tC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	ca.ElementToClickWithLogger(dashBoardUI.providerMenu, driver, wait, logger, "Step1");
    	ca.SelectMeasureSet(driver, wait, logger, tC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
    	Thread.sleep(1000);
    	ca.SelectRolling(driver, wait, logger, "Step3");
    	Thread.sleep(3000);
    	
    	ca.selectQuarter(dashBoardUI.quarterdrp, driver, wait, logger,tC_DetailedPPDrillDownCountNR.get("Quarter"), "Step4");
    	
    	Thread.sleep(2000);
    	
    	ca.ElementToClickWithLogger(dashBoardUI.OurProvider, driver, wait, logger, "Step4");
    	Thread.sleep(5000);
    	ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step5");
    	Thread.sleep(5000);
    	ca.ElementToClickWithLogger(dashBoardUI.ProvidePerformanceQuarter, driver, wait, logger, "Ste6");
    	String[] DetailedPPDrillDownCount = ca.splitElementWithExpression(dashBoardUI.ProvideCATARACTTESTDrillDownValue_Rol, driver, wait,logger, " ","Step7");
    	ca.ElementToClickWithLogger(dashBoardUI.ProvideCATARACTTESTDrillDownCloseBtn, driver, wait, logger, "Step8");
    	return DetailedPPDrillDownCount[5];
    }
    
    
	
    
    
    /**
	 * Testcase ID- TC_004 : TC_PracticeMeasureCountR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
    
    public String TC_PracticeMeasureCountR(String methodName, Hashtable<String, String> TC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
    	ca.SelectMeasureSet(driver, wait, logger, TC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
    	Thread.sleep(1000);
    	ca.SelectRolling(driver, wait, logger, "Step3");
    	Thread.sleep(3000);
    	String[] DetailedPPDrillDownCount = ca.splitElementWithExpression(dashBoardUI.PracticeMeasureCount, driver, wait,logger, " ","Step4");
    	return DetailedPPDrillDownCount[3];
    }
    
    
    
    /**
  	 * Testcase ID- TC_005 : TC_PracticeMeasureCountNR"
  	 * Copyright 2018 FIGmd.in © 2018.
  	 * All rights reserved.
  	 * The Displayer class displays text 
  	 * on the computer screen.
  	 * @author  Amol Bande
  	 * @version 1.0 01/06/18
  	 * @see     java.lang.System
  	 */
      
      public String TC_PracticeMeasureCountNR(String methodName, Hashtable<String, String> TC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
      	Thread.sleep(2000);
      	ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
      	ca.SelectMeasureSet(driver, wait, logger, TC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
      	Thread.sleep(1000);
      	ca.SelectNonRolling(driver, wait, logger, "Step3");
      	Thread.sleep(5000);
      	String[] DetailedPPDrillDownCount = ca.splitElementWithExpression(dashBoardUI.PracticeMeasureCount, driver, wait,logger, " ","Step4");
      	return DetailedPPDrillDownCount[3];
      }
      
    
      /**
    	 * Testcase ID- TC_006 : TC_PracticeFavoritesMeasureCountR"
    	 * Copyright 2018 FIGmd.in © 2018.
    	 * All rights reserved.
    	 * The Displayer class displays text 
    	 * on the computer screen.
    	 * @author  Amol Bande
    	 * @version 1.0 01/06/18
    	 * @see     java.lang.System
    	 */
        
        public String TC_PracticeFavoritesMeasureCountR(String methodName, Hashtable<String, String> TC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
        	Thread.sleep(2000);
        	ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
        	ca.SelectMeasureSet(driver, wait, logger, TC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
        	Thread.sleep(1000);
        	ca.SelectRolling(driver, wait, logger, "Step3");
        	Thread.sleep(5000);
        	ca.ElementToClickWithLogger(dashBoardUI.PracticeFavoritesBtn, driver, wait, logger, "Step1");
        	Thread.sleep(10000);
        	try {
        		String[] DetailedPPDrillDownCount = ca.splitElementWithExpression(dashBoardUI.PracticeMeasureCount, driver, wait,logger, " ","Step4");
        		System.out.println(DetailedPPDrillDownCount[3]);
            	return DetailedPPDrillDownCount[3];
			} catch (Exception e) {
				return "0";
			}
        	
        	
        	
        }
    
    
        public int TC_OutcomeMeasuresForMeasureSet2018(String methodName,
    			Hashtable<String, String> TC_OutcomeMeasuresForMeasureSet2018, ExtentTest logger) throws InterruptedException {
    		
    		ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "Step1");
    		ca.SelectMeasureSet(driver, wait, logger, TC_OutcomeMeasuresForMeasureSet2018.get("MeasureSet"), "Step2");
    		//ca.ElementToClickWithLogger(dashBoardUI.ClickOnPractice, driver, wait, logger, "Step3");
    		
    		Thread.sleep(2000);
    	
    		int webCount =ca.ListOfElementSize(dashBoardUI.OutcomeMeasures, driver, wait);
    		
    		System.out.println(webCount);
    		// TODO Auto-generated method stub
    		return webCount;
    	}
	
	/**
	 * Testcase ID- TC_0032 : TC_verifyCpyrightTabsnames"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Akshay Pandav
	 * @version 1.0 1/09/18
	 * @see     java.lang.System
	 */
	public String TC_verifyCpyrightTabsnames(ExtentTest logger)throws InterruptedException 
    {     	
   	
    	ca.ElementToClickWithLogger(dashBoardUI.Copyrightloc, driver, wait,logger,"Step1");
    	String copyrighttabstr= ca.ElementGetTextLogger(dashBoardUI.Copyrighttab1,driver,wait,logger,"Step2");
       	String copyrighttabstr1=ca.ElementGetTextLogger(dashBoardUI.Copyrighttab2,driver,wait,logger,"Step3");
    	String copyrighttabstr2=ca.ElementGetTextLogger(dashBoardUI.Copyrighttab3,driver,wait,logger,"Step4");
    	String copyrighttabstr3=ca.ElementGetTextLogger(dashBoardUI.Copyrighttab4,driver,wait,logger,"Step5");
    	ca.ElementToClickWithLogger(dashBoardUI.copyrightpopupclosebutton, driver, wait, logger, "Step6");
    	String alltabsname=(copyrighttabstr+", "+copyrighttabstr1+", "+copyrighttabstr2+", "+copyrighttabstr3);
   	System.out.println("tabnames from UI:"+alltabsname);
    	return alltabsname;
    }



	/**
	 * Testcase ID- TC_0031 : TC_CopyrightyearCntent"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Akshay Pandav
	 * @version 1.0 1/09/18
	 * @see     java.lang.System
	 */
	
	public String TC_CopyrightyearCntent(ExtentTest logger)throws InterruptedException 
    {     	
   	
    
    	String copyrightyear= ca.ElementGetTextLogger(dashBoardUI.Copyrightloc, driver, wait, logger,"step1");
         
    	return copyrightyear;
    }



//	**
//	 * Testcase ID- TC_0031 : TC_ProviderPatientDrillDownCountNR"
//	 * Copyright 2018 FIGmd.in © 2018.
//	 * All rights reserved.
//	 * The Displayer class displays text 
//	 * on the computer screen.
//	 * @author  Akshay Pandav
//	 * @version 1.0 1/09/18
//	 * @see     java.lang.System
//	 */
	 
	public String TC_ProviderPatientDrillDownCountNR(ExtentTest logger,Hashtable <String, String> data)throws InterruptedException 
    {     	
   	
		ca.SelectMeasureSet(driver, wait, logger, data.get("MeasureSet"), "Step1");  
		ca.SelectNonRolling(driver, wait, logger, "step2");
		ca.ElementToClickWithLogger(dashBoardUI.DashboardProvider, driver, wait, logger, "step3");
		ca.ElementToClickWithLogger(dashBoardUI.OurProvider, driver, wait, logger, "step4");
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "step5");
		ca.ElementToClickWithLogger(dashBoardUI.clickoncount, driver, wait, logger, "step6");
		String count=ca.trimuicount(dashBoardUI.ProviderpatientcountNR, driver, wait, logger, "step7");
		ca.ElementToClickWithLogger(dashBoardUI.patientdrilldownclosebutton, driver, wait, logger, "Step8");
		System.out.println("count after trim:"+count);
		
    	return count;
    }


	/**
	 * Testcase ID- TC_0031 : TC_ProviderPatientDrillDownCountpqrs"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Akshay Pandav
	 * @version 1.0 1/09/18
	 * @see     java.lang.System
	 */
	public String TC_ProviderPatientDrillDownCountpqrs(ExtentTest logger,Hashtable <String, String> data)throws InterruptedException 
    {     	
   	
		ca.SelectMeasureSet(driver, wait, logger, data.get("MeasureSet"), "Step1");  
		//ca.SelectNonRolling(driver, wait, logger, "step2");
		ca.ElementToClickWithLogger(dashBoardUI.DashboardProvider, driver, wait, logger, "Step2");
		ca.ElementToClickWithLogger(dashBoardUI.OurProvider, driver, wait, logger, "Step3");
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure_pqrs, driver, wait, logger, "Step4");
		ca.ElementToClickWithLogger(dashBoardUI.clickoncount, driver, wait, logger, "Step5");
		String count=ca.trimuicount(dashBoardUI.ProviderpatientcountNR, driver, wait, logger, "Step6");
		ca.ElementToClickWithLogger(dashBoardUI.patientdrilldownclosebutton, driver, wait, logger, "Step7");
		System.out.println("count after trim:"+count);
		
    	return count;
    }

/**
	 * Testcase ID- TC_0031 : TC_PracticeProvidersPatientDrillDownCountR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Akshay Pandav
	 * @version 1.0 5/09/18
	 * @see     java.lang.System
	 */
	public String TC_PracticeProvidersPatientDrillDownCountR(ExtentTest logger,Hashtable <String, String> data)throws InterruptedException 
    {     	
   	
		ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "Step1");
		Thread.sleep(5000);
		ca.SelectMeasureSet(driver, wait, logger, data.get("MeasureSet"), "Step2");  
		Thread.sleep(5000);
		//ca.SelectNonRolling(driver, wait, logger, "step2");
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure_pqrs, driver, wait, logger, "Step3");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.practicemeasurepopupprovidertab, driver, wait, logger, "Step4");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.catractprovider, driver, wait, logger, "Step5");
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.countmet, driver, wait, logger, "Step6");
		Thread.sleep(2000);
		String count=ca.trimuicount(dashBoardUI.metcount, driver, wait, logger, "Step7");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.patientdrilldownclosebutton, driver, wait, logger, "Step8");
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.closeDrillDownPopUp, driver, wait, logger, "Step8");
		System.out.println("count after trim:"+count);
		
				
    	return count;
    }



	
    	
	public int TC_HighpriorityMeasuresForMeasureSet2018(String methodName,
			Hashtable<String, String> TC_HighpriorityMeasuresForMeasureSet2018, ExtentTest logger) throws InterruptedException {
		Thread.sleep(2000);
	
		ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "Step1");
		ca.SelectMeasureSet(driver, wait, logger, TC_HighpriorityMeasuresForMeasureSet2018.get("MeasureSet"), "Step2");
		//ca.ElementToClickWithLogger(dashBoardUI.ClickOnPractice, driver, wait, logger, "Step3");
		int webCount =ca.ListOfElementSize(dashBoardUI.HighpriorityMeasures, driver, wait);
		System.out.println(webCount);
		// TODO Auto-generated method stub
		return webCount;
	}
	
	public ArrayList<String> TC_HeaderDetailsforPatientDDWhenOpenedForProvider(String methodName,
			Hashtable<String, String> TC_HeaderDetailsforPatientDDWhenOpenedForProvider, ExtentTest logger) throws InterruptedException {
		ArrayList<String> providername = new ArrayList<String>();
	    ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "Step1");
		ca.ElementToClickWithLogger(dashBoardUI.DashboardProvider, driver, wait, logger, "Step2");//dashBoardUI.SelectProvidersubmenu1
		ca.SelectMeasureSet(driver, wait, logger, TC_HeaderDetailsforPatientDDWhenOpenedForProvider.get("MeasureSet"), "Step3");
		Thread.sleep(5000);
		String str1=ca.ElementGetTextLogger(dashBoardUI.OurProvider, driver, wait, logger, "Step4");//dashBoardUI.getonprovider
		ca.ElementToClickWithLogger(dashBoardUI.OurProvider, driver, wait, logger, "Step5");//dashBoardUI.clickonprovider
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step6");//dashBoardUI.Selectmeasure
		ca.ElementToClickWithLogger(dashBoardUI.ClickonmetCount, driver, wait, logger, "Step7");
		String str2=ca.ElementGetTextLogger(dashBoardUI.getprovidertext, driver, wait, logger, "Step8");
		ca.ElementToClickWithLogger(dashBoardUI.closePopUp, driver, wait, logger, "Step9");
		//ca.ElementToClickWithLogger(dashBoardUI.closeDrillDownPopUp, driver, wait, logger, "Step8");
		System.out.println(str1);
		System.out.println(str2);
		providername.add(str1);
		providername.add(str2);
		return providername;
	}

	public ArrayList<String> TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice(String methodName,
			Hashtable<String, String> TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice, ExtentTest logger) throws InterruptedException {
		
        ArrayList<String> RegistryAverage = new ArrayList<String>();
        ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "Step1");
		ca.SelectMeasureSet(driver, wait, logger, TC_VerifyRegistryAvgOnPerformanceTrendModalForPractice.get("MeasureSet"), "Step2");
		Thread.sleep(5000);
		//ca.ElementToClickWithLogger(dashBoardUI.ClickOnPractice, driver, wait, logger, "Step3");
		String str1=ca.ElementGetTextLogger(dashBoardUI.getNationalAverageonlandingpage, driver, wait, logger, "Step4");
		ca.ElementToClickWithLogger(dashBoardUI.getNationalAverageonlandingpage, driver, wait, logger, "Step5");
		String str2=ca.ElementGetTextLogger(dashBoardUI.getNationalAverageondrilldown, driver, wait, logger, "Step6");
		ca.ElementToClickWithLogger(dashBoardUI.closeDrillDownPopUp, driver, wait, logger, "Step7");
		System.out.println(str1);
		System.out.println(str2);
		//String str3=str1.replace(":", "");
		RegistryAverage.add(str1.replaceAll("[()\\s]",""));
		RegistryAverage.add(str2.replaceAll("[()\\s]",""));
		return RegistryAverage;
	}
    
    	
    
    	
    	
    	
  
	
	/**
	 * Testcase ID- TC_0025 : TC_ProviderCountR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 *
	 * @author  Surabhi Shah
	 * @version 1.0 01/06/18
	 * @throws SQLException 
	 * @see java.lang.System
	 **/
    public String TC_ProviderCountR(String methodName, Hashtable<String, String> TC_ProviderCountR, ExtentTest logger)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	ca.ElementToClickWithLogger(dashBoardUI.providerMenu, driver, wait, logger, "Step1");
    	 ca.ElementToClickWithLogger(dashBoardUI.RollingProviderRecord, driver, wait, logger, "Step2");
        String webCount=ca.trimuicount(dashBoardUI.RollingProviderRecord, driver, wait, logger,"steps3");

         return webCount;
    }
    
    
    /**
	 * Testcase ID- TC_0028 : TC_ProviderCountNR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 *
	 * @author  Surabhi Shah
	 * @version 1.0 01/06/18
	 * @throws SQLException 
	 * @see java.lang.System
	* */
    
    public String TC_ProviderCountNR(String methodName, Hashtable<String, String> TC_ProviderCountNR, ExtentTest logger)throws InterruptedException {    	    	    
     ca.SelectNonRolling(driver, wait, logger, "Step1");
     /*Added step for the selection of provider */
     ca.ElementToClickWithLogger(dashBoardUI.providerMenu, driver, wait, logger, "Step2");
     ca.ElementToClickWithLogger(dashBoardUI.RollingProviderRecord, driver, wait, logger, "Step3");
     String webcount=ca.trimuicount(dashBoardUI.RollingProviderRecord, driver, wait, logger,"steps4");
     return webcount;
    }
    

    /**
	 * Testcase ID- TC_0028 : TC_ProviderCountNR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 *
	 * @author  Surabhi Shah
	 * @version 1.0 01/06/18
	 * @throws SQLException 
	 * @see java.lang.System
	* */
    
    public String TC_ProviderPatientCount(String methodName, Hashtable<String, String> TC_ProviderPatientCount, ExtentTest logger)throws InterruptedException { 
    	ca.SelectMeasureSet(driver, wait, logger, TC_ProviderPatientCount.get("MeasureSet"), "Step1");
    	Thread.sleep(2000);
    	ca.SelectRolling(driver, wait, logger, "Rolling Selected");
    	ca.ElementToClickWithLogger(dashBoardUI.providerMenu, driver, wait, logger, "Step1");
    	ca.ElementToClickWithLogger(dashBoardUI.OurProvider, driver, wait, logger, "Step2");//Changed dashBoardUI.ProviderMeasureClick
    	ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step3");//changed dashBoardUI.MeasureClick
    	ca.ElementToClickWithLogger(dashBoardUI.clickoncount,driver, wait, logger, "Step4");//dashBoardUI.MetCount
    	//ca.ElementToClickWithLogger(dashBoardUI.DrillDownCount, driver, wait, logger, "Step5");
    	String webcount=ca.trimuicount(dashBoardUI.DrillDownCount, driver, wait, logger,"steps5");
    	//ca.ElementToClickWithLogger(dashBoardUI.DrillDownCount, driver, wait, logger, "Step5");//Not Required this step
    	ca.ElementToClickWithLogger(dashBoardUI.drillDownClose, driver, wait, logger, "Step7");
    	
    	return webcount;
    }
    

	// Poonam
    
    /**
	 * Testcase ID- TC_0021 : TC_PracticePerformanceTrendPatientDrillDownCountR"
	 * Copyright 2018 FIGmd.in © 2018. All rights reserved. The Displayer class
	 * displays text on the computer screen.
	 * 
	 * @author Poonam Zambare
	 * @version 1.0 01/06/18
	 * @see java.lang.System
	 */

	public String TC_PracticePerformanceTrendPatientDrillDownCountR(String methodName,
			Hashtable<String, String> TC_PracticePerformanceTrendPatientDrillDownCountR, ExtentTest logger)
			throws InterruptedException {
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
		ca.SelectMeasureSet(driver, wait, logger, TC_PracticePerformanceTrendPatientDrillDownCountR.get("MeasureSet"),
				"Step2");
		ca.SelectRolling(driver, wait, logger, "Step3");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step4");//dashBoardUI.measurePracticePerformance
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.measurePracticePerfromanceTrendMETCount, driver, wait, logger, "Step5");
		Thread.sleep(5000);
		String webcountinstring = ca.trimuicount(dashBoardUI.measurePracticePerfromanceTrendPatientDrillDownCount,
				driver, wait, logger,"steps4");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.measurePracticePerfromanceTrendPatientDrillDownCountCloseWindow, driver,
			wait, logger, "Step6");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.measurePracticePerfromanceTrendCloseWindow, driver, wait, logger,
				"Step7");

		return webcountinstring;

	}

	/**
	 * Testcase ID- TC_0022 :
	 * TC_PracticePerformanceTrendPatientDrillDownCountNR" Copyright 2018
	 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
	 * on the computer screen.
	 * 
	 * @author Poonam Zambare
	 * @version 1.0 01/06/18
	 */

	public String TC_PracticePerformanceTrendPatientDrillDownCountNR(String methodName,
			Hashtable<String, String> TC_PracticePerformanceTrendPatientDrillDownCountNR, ExtentTest logger)
			throws InterruptedException {
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
		ca.SelectMeasureSet(driver, wait, logger, TC_PracticePerformanceTrendPatientDrillDownCountNR.get("MeasureSet"),
				"Step2");
		Thread.sleep(5000);
		ca.SelectNonRolling(driver, wait, logger, "Step2");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step3");//dashBoardUI.practicePerformanceDashboardNR
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceDashboardRPerfromanceTrendNRMETCount, driver, wait,
				logger, "Step4");
		Thread.sleep(5000);
		String webcountinstring = ca.trimuicount(
				dashBoardUI.practicePerformanceDashboardRPerfromanceTrendNRPatientcount, driver, wait, logger,"steps5");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.measurePracticePerfromanceTrendPatientDrillDownCountCloseWindow, driver,
				wait, logger, "Step6");
		
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.measurePracticePerfromanceTrendCloseWindow, driver,
				wait, logger, "Step7");
		
		
		
		return webcountinstring;

	}

	/**
	 * Testcase ID- TC_0023 : TC_PracticeAllProvidersPopUpCountR" Copyright 2018
	 * FIGmd.in © 2018. All rights reserved. The Displayer class displays text
	 * on the computer screen.
	 * 
	 * @author Poonam Zambare
	 * @version 1.0 01/06/18
	 * @see java.lang.System
	 */
	public String TC_PracticeAllProvidersPopUpCountR(String methodName,
			Hashtable<String, String> TC_PracticeAllProvidersPopUpCountR, ExtentTest logger)
			throws InterruptedException {
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
		ca.SelectMeasureSet(driver, wait, logger, TC_PracticeAllProvidersPopUpCountR.get("MeasureSet"),
				"Step1");
		ca.SelectRolling(driver, wait, logger, "Step2");
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step3");
		ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceAllTab, driver, wait, logger, "Step2");
		String webcountinstring = ca.trimuicount(dashBoardUI.practicePerformanceAllTabProviderCount, driver, wait,
				logger,"steps3");
		ca.ElementToClickWithLogger(dashBoardUI.measurePracticePerfromanceTrendCloseWindow, driver, wait, logger, "Step4");
		
		
		return webcountinstring;

	}
	
	/**
	 * Testcase ID- TC_0024 : TC_PracticeAllProvidersPopUpCountNR" Copyright
	 * 2018 FIGmd.in © 2018. All rights reserved. The Displayer class displays
	 * text on the computer screen.
	 * 
	 * @author Poonam Zambare
	 * @version 1.0 01/06/18
	 * @see java.lang.System
	 */

	public String TC_PracticeAllProvidersPopUpCountNR(String methodName,
            Hashtable<String, String> TC_PracticeAllProvidersPopUpCountNR, ExtentTest logger)
            throws InterruptedException {
    Thread.sleep(2000);
    ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
    ca.SelectMeasureSet(driver, wait, logger, TC_PracticeAllProvidersPopUpCountNR.get("MeasureSet"),
                    "Step2");
    Thread.sleep(5000);
    ca.SelectNonRolling(driver, wait, logger, "Step3");
    Thread.sleep(5000);
    ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step4");//dashBoardUI.practicePerformanceDashboardNR
    Thread.sleep(2000);
    ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceDashboardNRAllTab, driver, wait, logger, "Step5");
    Thread.sleep(2000);
    ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceDashboardNRProviderCount, driver, wait, logger,
                    "Step6");

    String webcountinstring = ca.trimuicount(dashBoardUI.practicePerformanceDashboardNRProviderCount, driver, wait,
                    logger,"steps7");

    ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceAllTabCloseWindow, driver, wait, logger, "Step8");
    return webcountinstring;

}
	
	
	
	/**
	 * Testcase ID- TC_0013 : TC_PracticeProvidersPopUpCountR Copyright
	 * 2018 FIGmd.in © 2018. All rights reserved. The Displayer class displays
	 * text on the computer screen.
	 * 
	 * @author Poonam Zambare
	 * @version 1.0 01/06/18
	 * @see java.lang.System
	 */
	public String TC_PracticeProvidersPopUpCountR(String methodName,
			Hashtable<String, String> TC_PracticeProvidersPopUpCountR, ExtentTest logger)
			throws InterruptedException {
		Thread.sleep(2000);
		//ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
		ca.SelectMeasureSet(driver, wait, logger, TC_PracticeProvidersPopUpCountR.get("MeasureSet"),"Step1");
		
		
		Thread.sleep(5000);
		//ca.ElementToClickWithLogger(dashBoardUI.PracticeSubMenu, driver, wait, logger, "Step1");
		// ca.SelectMeasureSet(driver, wait, logger, TC_PracticeProvidersPopUpCountR.get("MeasureSet"), "Step2");
		//ca.SelectRolling(driver, wait, logger, "Step3");
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step4");//Replaced dashBoardUI.measurePracticePerformance
		Thread.sleep(4000);
		ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceDashboardProviderTab, driver, wait, logger, "Step5");
		Thread.sleep(4000);
		String webcountinstring = ca.trimuicount(dashBoardUI.practicePerformanceDashboardProviderTabRProvidersCount, driver, wait,
				logger,"steps6");
		Thread.sleep(4000);
		System.out.println(webcountinstring);
		
		ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceAllTabCloseWindow, driver, wait, logger, "Step7");
		return webcountinstring;

	}
    
    
    //////awadhesh
	
	/**
	 * Testcase ID- TC_007 : TC_PracticeFavoritesMeasureCountNR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Awadhesh Sengar
	 * @version 1.0 08-27-2018
	 * @see     java.lang.System
	 */
	
    public String TC_PracticeFavoritesMeasureCountNR(String methodName, Hashtable<String, String> TC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	///Step 1:
    	ca.SelectMeasureSet(driver, wait, logger, TC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
    	ca.SelectNonRolling(driver, wait, logger, "Step3");
    	Thread.sleep(5000);
    	//Step 2 : 
    	ca.ElementToClick(dashBoardUI.FavouriteButton, driver, wait);
    	Thread.sleep(5000);
       // String webCount = ca.ElementGetText(dashBoardUI.TotalPageRecordWithoutPagination, driver, wait);
        // String[] webCountd = webCount.split(" : ");
        // webCount = webCountd[1];
         //Step 3 :
    	try {
    		String[] DetailedPPDrillDownCount = ca.splitElementWithExpression(dashBoardUI.PracticeMeasureCount, driver, wait,logger, " ","Step4");
    		System.out.println(DetailedPPDrillDownCount[3]);
    		ca.ElementToClick(dashBoardUI.PracticeSubmodule, driver, wait);
        	return DetailedPPDrillDownCount[3];
		} catch (Exception e) {
			ca.ElementToClick(dashBoardUI.PracticeSubmodule, driver, wait);
			return "0";
		}
    	
    }
    

    public String TC_PMCountOfHigherScore(String methodName, Hashtable<String, String> TC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	///Step 1:
    	ca.SelectMeasureSet(driver, wait, logger, TC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
    	Thread.sleep(5000);
    	ca.ElementToClickWithLogger(dashBoardUI.alltab, driver, wait, logger, "Step2");
    	///ca.SelectNonRolling(driver, wait, null, data);
    	if(callerClassName.contains("NR"))
    	{
    		try {
    			ca.SelectNonRolling(driver, wait, logger, "Step3");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exception occurred while selecting non rolling");
			}
    	}
    	Thread.sleep(10000);
    	//Step 2 : 
    	 List<WebElement> CountOfHigherScoreLIST = ca.ListOfElement(dashBoardUI.PMeasureLocatorWithHigherCount, driver, wait);
    	 String UIcountHigherscoreMeasures = Integer.toString(CountOfHigherScoreLIST.size());
    	return UIcountHigherscoreMeasures;
    }
    
    public String TC_PMCountOfLowerScore(String methodName, Hashtable<String, String> TC_DetailedPPDrillDownCountNR, ExtentTest logger)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	///Step 1:
    	ca.SelectMeasureSet(driver, wait, logger, TC_DetailedPPDrillDownCountNR.get("MeasureSet"),"Step2");
    	if(callerClassName.contains("NR"))
    	{
    		try {
    			ca.SelectNonRolling(driver, wait, logger, "Step3");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exception occurred while selecting non rolling");
			}
    	}
    	 List<WebElement> CountOfHigherScoreLIST = ca.ListOfElement(dashBoardUI.PMeasureLocatorWithLowerCount, driver, wait);
    	 String UIcountLowerscoreMeasures = Integer.toString(CountOfHigherScoreLIST.size());
    	return UIcountLowerscoreMeasures;
    }
    
    
  
	
//----------------------------------------------------
    
    public String TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPractice(String methodName,
			Hashtable<String, String> TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticep, ExtentTest logger) throws InterruptedException
    {
   /* ca.ElementToClickWithLogger(dashBoardUI.measureSetDropDown, driver, wait, logger, "Step1");
    //ca.ElementToClickWithLogger(dashBoardUI.measureSet2017MeasuresetRB, driver, wait, logger, "Step2");
    //Thread.sleep(5000);
    
   
    //ca.ElementToClickWithLogger(dashBoardUI.selectElementFromMeasuregrid, driver, wait, logger, "Step3");
    //ca.ElementToClickWithLogger(dashBoardUI.selectQuarter, driver, wait, logger, "Step4");
    
    if(ca.isElementPresent(dashBoardUI.observePracticeName, driver))
    {
    String practice= ca.ElementGetText(dashBoardUI.observePracticeName, driver, wait);
    System.out.println("practice name:"+practice);
    ca.ElementToClickWithLogger(dashBoardUI.closePopup2, driver, wait, logger, "Step6");
    ca.ElementToClickWithLogger(dashBoardUI.ClosePopup1, driver, wait, logger, "Step7");
    return practice;
    }
    else
    {
    return null;
   }*/
    	
    	
    	 ca.SelectMeasureSet(driver, wait, logger, TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticep.get("MeasureSet"),"Step1");
         ca.ElementToClick(dashBoardUI.firstmeasure, driver, wait);
         
         String PracticeName =driver.findElement(By.xpath("//span[@id='spnModalPracticeName']")).getText();
         
         System.out.println(PracticeName);
         
         if(ca.isElementPresent(dashBoardUI.observePracticeName, driver))
         {
         String practice= ca.ElementGetText(dashBoardUI.observePracticeName, driver, wait);
         System.out.println("practice name:"+practice);
         //ca.ElementToClickWithLogger(dashBoardUI.closePopup2, driver, wait, logger, "Step6");
         //ca.ElementToClickWithLogger(dashBoardUI.ClosePopup1, driver, wait, logger, "Step7");
         ca.ElementToClickWithLogger(dashBoardUI.practicepopup, driver, wait, logger, "Step2");
         return practice;
         }
         else
         {
         return null;
        }
         
    	
    	
 }



  public String TC_VerifyMeasureNameHeaderPerformaceTrendForPractice(String methodName,
			Hashtable<String, String> TC_VerifyMeasureNameHeaderPerformaceTrendForPracticep, ExtentTest logger) throws InterruptedException
    {
	    //ca.ElementToClickWithLogger(dashBoardUI.measureSetDropDown, driver, wait, logger, "Step1");
	   // ca.SelectMeasureSet(driver, wait, logger, TC_VerifyMeasureNameHeaderPerformaceTrendForPracticep.get("MeasureSet"), "Step1");
	    //ca.ElementToClickWithLogger(dashBoardUI.measureSet2017MeasuresetRB, driver, wait, logger, "Step2");
	    ca.SelectMeasureSet(driver, wait, logger, TC_VerifyMeasureNameHeaderPerformaceTrendForPracticep.get("MeasureSet"), "Step1");
	    Thread.sleep(10000);
	    ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "Step2");
	    Thread.sleep(10000);
	    ca.ElementToClickWithLogger(dashBoardUI.practicePerformanceDashboardRPerfromanceTrendNRMETCount, driver, wait, logger, "Step3");
    
	    Thread.sleep(10000);
	    if(ca.isElementPresent(dashBoardUI.observeMeasureName, driver))
    		{
	    	String measure= ca.ElementGetText(dashBoardUI.observeMeasureName, driver, wait);
	    	System.out.println("measure name:"+measure);
	    	
	    	
	    	
	    	Thread.sleep(10000);
	    	String[] dashboardIRISeCQM1MeasureLocationTotalCount = ca.splitElementWithExpression(dashBoardUI.observeMeasureName, driver, wait,logger, ":","Step4");
	    	ca.ElementToClickWithLogger(dashBoardUI.closePopup2, driver, wait, logger, "Step5");
	    	ca.ElementToClickWithLogger(dashBoardUI.ClosePopup1, driver, wait, logger, "Step6");
	      	return dashboardIRISeCQM1MeasureLocationTotalCount[1];
	    	
    		}
	    else
    	{
    	return null;
    
    	}
   
    }


  
  public String TC_VerifytooltipAgainstMeasures(String methodName,
			Hashtable<String, String> TC_VerifytooltipAgainstMeasuresp, ExtentTest logger) throws InterruptedException
    {
    ca.ElementToClickWithLogger(dashBoardUI.measureSetDropDown, driver, wait, logger, "Step1");
    ca.ElementToClickWithLogger(dashBoardUI.measureSet2017MeasuresetRB, driver, wait, logger, "Step2");
    //ca.ElementToClickWithLogger(dashBoardUI.ClickOnPractice, driver, wait, logger, "Step3");

  //  String tooltip=ca.ElementGetAttribute(dashBoardUI.observeTooltip, driver,"title");
    String tooltip= ca.ElementGetAttrributeTextValue(dashBoardUI.observeTooltip, driver, "title");
    //String tooltip= ca.ElementGetTextLogger(dashBoardUI.observeTooltip, driver, wait,logger,"Steps");
    System.out.println("tooltip name:"+tooltip);
    return tooltip;
    /*if(ca.isElementPresent(dashBoardUI.observeTooltip, driver))
    		{
    		//(dashBoardUI.observePracticeName, driver, wait, logger, "step5"))
    		
    String tooltip= ca.ElementGetTextLogger(dashBoardUI.observeTooltip, driver, wait,logger,"Steps");
    System.out.println("tooltip name:"+tooltip);
    return tooltip;

    }
    else
    {
    	System.out.println("Higher score for this measure is Better");
    return null;
    
   }*/
   
    }
	
  
  //----------------------------------------
  
  // Ankita
  

	public String TC_LocationCountR(String methodName, Hashtable<String, String> tC_ProviderCountR, ExtentTest logger) throws InterruptedException{
		Thread.sleep(2000);
  	//ca.SelectNonRolling(driver, wait, logger, "Step1");
     ca.ElementToClickWithLogger(dashBoardUI.dashboardLocation, driver, wait, logger, "Step1");
  	Thread.sleep(5000);
  	//ca.ElementToClickWithLogger(dashBoardUI.dashboardLocationCount, driver, wait, logger, "Step2");
   String webcount=ca.trimuicount(dashBoardUI.dashboardLocationCount, driver, wait, logger,"Step4");
   System.out.println(webcount);
   return webcount;
  	
	}

	public String TC_LocationCountNR(String methodName, Hashtable<String, String> tC_LocationCountNR,ExtentTest logger) throws InterruptedException{
		Thread.sleep(2000);
  	ca.SelectNonRolling(driver, wait, logger, "Step1");
     ca.ElementToClickWithLogger(dashBoardUI.dashboardLocation, driver, wait, logger, "Step2");
     //Thread.sleep(2000);
    // ca.SelectNonRolling(driver, wait, logger, "Step2");
  	//ca.ElementToClickWithLogger(dashBoardUI.dashboardLocationCount, driver, wait, logger, "Step3");
   String webcount=ca.trimuicount(dashBoardUI.dashboardLocationCount, driver, wait, logger,"Step4");
   return webcount;
	}

	public String TC_LocationBubbleCountR(String methodName, Hashtable<String, String> tC_LocationBubbleCountR,ExtentTest logger) throws InterruptedException{
	 	//ca.SelectNonRolling(driver, wait, logger, "Step1");
	       ca.ElementToClickWithLogger(dashBoardUI.dashboardLocation, driver, wait, logger, "Step1");
	    //	Thread.sleep(2000);
	       String webcount=	ca.ElementGetTextLogger(dashBoardUI.dashboardLocationBubble, driver, wait, logger, "Step2");
	    //ca.trimuicount(dashBoardUI.dashboardLocationCount, driver, wait, logger);
	     return webcount;
	}

	public String TC_VerifyLastUpdatedDate(String methodName, Hashtable<String, String> tC_VerifyLastUpdatedDate,
			ExtentTest logger) throws InterruptedException{
	    ca.ElementToClickWithLogger(dashBoardUI.PracticeSubmodule, driver, wait, logger, "Steps1");
		ca.SelectMeasureSet(driver, wait, logger, tC_VerifyLastUpdatedDate.get("MeasureSet"), "Step2");
		Thread.sleep(5000);
		//ca.SelectRolling(driver, wait, logger, "Step2");
		 String webCount=ca.ElementGetTextLogger(dashBoardUI.dashboardLastUpdate, driver, wait, logger, "Step3");
		    //ca.trimuicount(dashBoardUI.dashboardLocationCount, driver, wait, logger);
		     return webCount;
	}
    
    
	
	
	
	/**
	 * Testcase ID- TC_0034 : TC_PracticeLocationPopUpCountR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
	
    public String TC_PracticeLocationPopUpCountR(ExtentTest logger,Hashtable <String, String> data)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	ca.SelectMeasureSet(driver, wait, logger, data.get("MeasureSet"), "Step1");  
    	Thread.sleep(5000);
		ca.SelectRolling(driver, wait, logger, "step2");
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "step3");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "step4");//dashBoardUI.dashboardIRISeCQM1Measure
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.dashboardIRISeCQM1MeasureLocationBtn, driver, wait, logger, "step5");
		Thread.sleep(10000);
      	String dashboardIRISeCQM1MeasureLocationTotalCount = ca.trimuicount(dashBoardUI.dashboardIRISeCQM1MeasureLocationTotalCount, driver, wait,logger, " ");
      	Thread.sleep(1000);
      	ca.ElementToClickWithLogger(dashBoardUI.ClosePopup1, driver, wait, logger, "step7");
      	return dashboardIRISeCQM1MeasureLocationTotalCount;
		
    	
    }
    
	
	
	
    /**
	 * Testcase ID- TC_0034 : TC_PracticeLocationPopUpCountNR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
	
    public String TC_PracticeLocationPopUpCountNR(ExtentTest logger,Hashtable <String, String> data)throws InterruptedException {    	    	    
    	Thread.sleep(2000);
    	ca.SelectMeasureSet(driver, wait, logger, data.get("MeasureSet"), "Step1");  
    	Thread.sleep(5000);
		ca.SelectNonRolling(driver, wait, logger, "step2");
		Thread.sleep(2000);
		ca.ElementToClickWithLogger(dashBoardUI.ClickonPracticeTab, driver, wait, logger, "step3");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.firstmeasure, driver, wait, logger, "step4");
		Thread.sleep(5000);
		ca.ElementToClickWithLogger(dashBoardUI.dashboardIRISeCQM1MeasureLocationBtn, driver, wait, logger, "step5");
		Thread.sleep(10000);
      	String dashboardIRISeCQM1MeasureLocationTotalCount = ca.trimuicount(dashBoardUI.dashboardIRISeCQM1MeasureLocationTotalCount, driver, wait,logger, " Step 6");
      	Thread.sleep(1000);
      	ca.ElementToClickWithLogger(dashBoardUI.ClosePopup1, driver, wait, logger, "step7");
      	return dashboardIRISeCQM1MeasureLocationTotalCount;
    }
	
	
	
    /**
   	 * Testcase ID- TC : TC_VerifySelectPractice﻿"
   	 * Copyright 2018 FIGmd.in © 2018.
   	 * All rights reserved.
   	 * This select the practice from the practice dropdown on the computer screen.
   	 * @author  Amol Pawal
   	 * @version 1.0 11/13/2018
     * @param data 
     * @throws InterruptedException 
   	 */
       
   public String verifySelectPractice﻿(ExtentTest logger, Hashtable<String, String> data) throws InterruptedException{
	   ca.ElementToClickWithLogger(dashBoardUI.practicedropdown, driver, wait, logger, "Step1");
	   
	  
	  
	   ca.ElementToSendDataLogger(dashBoardUI.practicedropdown_pid, (data.get("PracticeID")), driver, wait, logger,"Step2");
	   
	   ca.EnterPress(dashBoardUI.practicedropdown_pid, driver, wait);
	   
	   
	   ca.ElementToClickWithLogger(dashBoardUI.practicedropdown_pid_btnRadio, driver, wait, logger, "Step4");
	   
	   
	   ca.ElementToClickWithLogger(dashBoardUI.practicedropdown, driver, wait, logger, "Step5");
	   
	   
	   String practiceId= ca.ElementGetTextLogger(dashBoardUI.selectedpracticeid, driver, wait, logger, "step6");
	 //  ca.selectQuarter(dashBoardUI.quarterdrp, driver, wait, logger, (data.get("Quarter")), "Steps5");
	   
	   return practiceId;
   }
   
   

   
   
   
   /**
  	 * Testcase ID- TC : TC_VerifySelectPractice﻿"
  	 * Copyright 2018 FIGmd.in © 2018.
  	 * All rights reserved.
  	 * 
  	 * @author  Amol Pawal
  	 * @version 1.0 11/13/2018
    * @param data 
    * @throws InterruptedException 
  	 */
   
   public String navigateToMips(ExtentTest logger) throws InterruptedException{
	   ca.ElementToClickWithLogger(dashBoardUI.mips2018, driver, wait, logger, "Step1");
	   
	   // Store the current window handle
	   String winHandleBefore = driver.getWindowHandle();

	   // Perform the click operation that opens new window
	  ca.ElementToClickWithLogger(dashBoardUI.mips2018lnk, driver, wait, logger, "Step2");
	  
	  Thread.sleep(50000);
	  
	   // Switch to new window opened
	  String oldTab = driver.getWindowHandle();
	  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    return "Pass";
	  
	  
	  
	 /* String parentWindow = driver.getWindowHandle();
	  Set<String> handles =  driver.getWindowHandles();
	  
	  
	     for(String windowHandle  : handles)
	         {
	         if(!windowHandle.equals(parentWindow))
	            {
	            driver.switchTo().window(windowHandle);
	            System.out.println(driver.getTitle());
	            }
	         }*/
		  
		/*  System.out.println("Control here");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);*/
		  
		  /*WebDriverWait wait = new WebDriverWait(driver, 180);
		  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardUI.grouptile));*/
		 // element.click();
		  
		
   }
   
   
   public String navigateToMipsClinician(ExtentTest logger) throws InterruptedException {
	   
        ca.ElementToClickWithLogger(dashBoardUI.mips2018, driver, wait, logger, "Step1");
	   
	   // Store the current window handle
	   String winHandleBefore = driver.getWindowHandle();

	   // Perform the click operation that opens new window
	  ca.ElementToClickWithLogger(dashBoardUI.mips2018lnk, driver, wait, logger, "Step2");
	  
	  Thread.sleep(50000);
	  
	   // Switch to new window opened
	  String oldTab = driver.getWindowHandle();
	  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    
	    ca.ElementToClickWithLogger(dashBoardUI.cliniciantile, driver, wait, logger, "Steps3"); 
	    
	    return "Pass";
	  
	  
	  
	 /* String parentWindow = driver.getWindowHandle();
	  Set<String> handles =  driver.getWindowHandles();
	  
	  
	     for(String windowHandle  : handles)
	         {
	         if(!windowHandle.equals(parentWindow))
	            {
	            driver.switchTo().window(windowHandle);
	            System.out.println(driver.getTitle());
	            }
	         }*/
		  
		/*  System.out.println("Control here");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);*/
		  
		  /*WebDriverWait wait = new WebDriverWait(driver, 180);
		  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardUI.grouptile));*/
		 // element.click();
	}
   
   

public String selectPractice(Hashtable<String, String> data, ExtentTest logger) throws InterruptedException {
	 Thread.sleep(5000);
	 ca.ElementToClickWithLogger(dashBoardUI.practicedrpmenu, driver, wait, logger, "Steps1"); 
	 ca.ElementToSendDataLogger(dashBoardUI.practicetxtbox,data.get("Practice"), 
			 driver, wait, logger, "Step2");
	 ca.EnterPress(dashBoardUI.practicetxtbox, driver, wait);
	 ca.ElementToClickWithLogger(dashBoardUI.grouptile, driver, wait, logger, "Step4");
	 ca.ElementToClickWithLogger(dashBoardUI.practicearrow, driver, wait, logger, "Step5");
	 ca.ElementToClickWithLogger(dashBoardUI.qualitylnk, driver, wait, logger, "Step6");
	 
	 try{
		 driver.findElement(By.xpath("//button[text()='Save']")).isEnabled();
	 }
	 catch(Exception e){
		 driver.navigate().refresh();
	 }
	 
	/* boolean value = driver.findElement(By.xpath("//button[text()='Save']")).isEnabled();
	 System.out.println(value);
	 if(value==true){
			driver.navigate().refresh();
		}
	 */
	 ca.ElementToClickWithLogger(dashBoardUI.savebtn, driver, wait, logger, "Step7");
	 //driver.switchTo().alert();
	 ca.ElementToClickWithLogger(dashBoardUI.alertYes, driver, wait, logger, "Step8");
	 
	  String actual = ca.ElementGetTextLogger(dashBoardUI.savemesg, driver, wait, logger, "Step8");
	  
	  ca.ElementToClickWithLogger(dashBoardUI.homeicon, driver, wait, logger, "Stpe");
	  
	  
	 
	 
	/*  ca.ElementToClickWithLogger(dashBoardUI.practicedrpmenu, driver, wait, logger, "Steps1");
	  ca.ElementToSendDataLogger(dashBoardUI.practicetxtbox,"151780 - "
	  		+ "HOMETOWN HEALTHCARE PC (CVD/DC)", driver, wait, logger, "Step2");
  */

  // Perform the actions on new window

   return actual;
	
}

public String selectPracticeClinician(Hashtable<String, String> data, ExtentTest logger) throws InterruptedException {
	
	Thread.sleep(10000);
	ca.ElementToClickWithLogger(dashBoardUI.practicedrpmenuClinician, driver, wait, logger,"Step2");
	ca.ElementToSendDataLogger(dashBoardUI.practicetxtboxclinician, data.get("Practice"), driver, wait, logger, "Step3");
	ca.EnterPress(dashBoardUI.practicetxtboxclinician, driver, wait);
	Thread.sleep(5000);
	ca.ElementToClickWithLogger(dashBoardUI.allpage, driver, wait, logger, "Step121");
	ca.ElementToClickWithLogger(dashBoardUI.allno, driver, wait, logger, "Step345");
	Thread.sleep(5000);
	ca.ElementToClickWithLogger(dashBoardUI.searchbox, driver, wait, logger, "Step4");

	ca.ElementToSendDataLogger(dashBoardUI.cliniciansearch , data.get("Clinician"), driver, wait, logger, "Step4");
	ca.ElementToClickWithLogger(dashBoardUI.practicearrow, driver, wait, logger, "Step5");
	ca.ElementToClickWithLogger(dashBoardUI.qualitylnk, driver, wait, logger, "Step6");
	Thread.sleep(2000);
	
	 try{
		 driver.findElement(By.xpath("//button[text()='Save']")).isEnabled();
	 }
	 catch(Exception e){
		 driver.navigate().refresh();
	 }
	
	ca.ElementToClickWithLogger(dashBoardUI.savebtn, driver, wait, logger, "Step7");
	 ca.ElementToClickWithLogger(dashBoardUI.alertYes, driver, wait, logger, "Step8");
	 
	  String actual = ca.ElementGetTextLogger(dashBoardUI.savemesg, driver, wait, logger, "Step8");
	  
	  ca.ElementToClickWithLogger(dashBoardUI.clinicianlistpage, driver, wait, logger, "Stpe");
	
	return actual;
	
	
	 
}

public void afterFailureClinician(ExtentTest logger) throws InterruptedException {
	ca.ElementToClickWithLogger(dashBoardUI.homeicon, driver, wait, logger, "Step1");
	ca.ElementToClickWithLogger(dashBoardUI.cliniciantile, driver, wait, logger, "Step2");
	
}

public void afterFailureGroup(ExtentTest logger) throws InterruptedException {
	ca.ElementToClickWithLogger(dashBoardUI.homeicon, driver, wait, logger, "Step1");
	
}





	
	
}
