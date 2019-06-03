package DemoMaven.UI_Map.DashBoard;

import org.openqa.selenium.By;

public class DashBoardLocators {
	
	
	
	public By measureSetDropDownActiveLaabl = By.xpath("//*[@id='txtMeasureSet']");	
	public By measureSetDropDownActiveDD2018 = By.xpath("//tr/td[@class='width-5']/input[@class='chkmultiselect radioclass']");	
	public By measureSetDropDownCloseButton = By.xpath("//*[@id='MasterWrapperMeasureSet']/div[2]/a");
	public By OutcomeMeasures=By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[@id]/td[5][contains(text(),'YES')]");
	
	public  By ClickOnPractice=By.xpath("//*[@id='row3a24533f-2471-4b34-9370-6b5749304216']/div[1]/h4/div/table/tbody/tr/td/a");
	
	public By measureSetDropDown = By.xpath("//*[@id='txtMeasureSet']");	
	public By measureSet2017MeasuresetRB= By.xpath("//*[@id='chkddl43619a92-b44d-47c9-880d-f168c3ad211d']");	
	
	
	//Xpath for Practice-PatientDrilllDown
	public By measurePracticePerformance = By.xpath("//*[@id='tr3dd81505-8c2d-4130-b85d-e854d6b8bfcf']/td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[2]");
	public By measurePracticePerfromanceTrendMETCount = By.xpath("(//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr/td[@class]/a)[1]");////*[@id='divPerformanceTrande']/div[2]/div[2]/table/tbody/tr[1]/td[3]/a
	public By measurePracticePerfromanceTrendPatientDrillDownCount = By.xpath("(//*[contains(text(),'Records')])[4]");
	
	// TC_DetailedPPDrillDownCountNR 
	public By ProvideSubMenu = By.xpath("//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li[1]/ul/li[3]/a");
	public By ProvideCATARACTTESTMeasue = By.xpath("//*[@id='row9bdca45e-db69-430b-ba6d-004c80fa597b']/div[1]/h4/div/table/tbody/tr/td[1]/a/i");
	public By ProvideIRISeCQM1Measue = By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[3]/table/tbody/tr/td");
	public By ProvidePerformanceQuarter = By.xpath("(//tbody/tr/td[@class]/a)[1]");////*[@id='3dd81505-8c2d-4130-b85d-e854d6b8bfcf']/tbody/tr[1]/td[3]/a
	public By ProvideCATARACTTESTDrillDownValue = By.xpath("//*[@id='divProviderDrilDownPager']/div"); //*[@id='divProviderDrilDownPager']/b
	public By ProvideCATARACTTESTDrillDownValue_Rol = By.xpath("//*[@id='divProviderDrilDownPager']/b"); 
	public By ProvideCATARACTTESTDrillDownCloseBtn = By.xpath(".//*[@id='ModalNumerator']/div/div/div[1]/button");
	
	
	
	public By PracticeSubMenu = By.xpath("//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li[1]/ul/li[1]/a");
	public By PracticeMeasureCount = By.xpath("//*[@id='divPager']/div");
	public By PracticeFavoritesBtn = By.xpath("//label[@class='control-label cursor-pointer' and text()='FAVORITES']");//*[@id='aspnetForm']/div[3]/div[2]/div[1]/div/div[1]/table/tbody/tr/td[11]
	
	
	
	
	
	public By Copyrightloc=By.xpath("//a[contains(text(), '© 2019')]");
	public By Copyrighttab1=By.xpath("//a[contains(text(),'Copyright')]");    //div[@class='tabbable']/ul/li[1]/a
	public By Copyrighttab2=By.xpath("//a[contains(text(),'Terms of Use')]"); //div[@class='tabbable']/ul/li[2]/a
	public By Copyrighttab3=By.xpath("//a[contains(text(),'Privacy Policy')]");//div[@class='tabbable']/ul/li[3]/a
	public By Copyrighttab4=By.xpath("//a[contains(text(),'Patents & Trademarks')]");//div[@class='tabbable']/ul/li[4]/a
	public By copyrightpopupclosebutton=By.xpath("//div[@id='modaltermsandcondition']/div/div/div/button[@class='close modal-close-button']/img");
	
	
	public By ProviderpatientcountNR=By.xpath("(//*[contains(text(),'Records ')])[4]");
	public By DashboardProvider=By.xpath("//a[@data-parent='Dashboards' and @data-module='Provider']");
	//public By rollnonroll=By.xpath("//input[@id='RollNonRoll']");
	public By rollnonroll=By.xpath("//span[@class='lbl']");
	public By OurProvider=By.xpath("//a[@data-parent='#accordion' and @href='#collapseca82e83e-0047-4896-9c27-cb3cf1f812c1']");
	public By firstmeasure=By.xpath("//td[contains(text(),'Complete Lipid Profile')]"); //Xpath for 'IRIS eCQM 1' Measureset
	public By clickoncount=By.xpath("(//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[@class]/a)[1]");
	public By patientdrilldownclosebutton=By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button");
	//Xpath added for the pqrs measure
	public By firstmeasure_pqrs=By.xpath("//td[text()='Diabetes: Hemoglobin A1c (HbA1c) Poor Control (> 9%)']");
		
	//-----------------TC-0014
	public By practicemeasurepopupprovidertab=By.xpath("//ul[@id='tabdashboard']/li/a[@data-href='#PROVIDERS']");
	public By catractprovider=By.xpath("//table[@class='table table-striped table-hover cursor-default']/tbody/tr[1]/td[1]");
	public By countmet=By.xpath("(//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr[1]/td[@class]/a)[1]");
	public By metcount=By.xpath("(//*[contains(text(),'Records')])[4]");
	public By practicefirstmeasure=By.xpath("//td[./text()=' IRIS eCQM 1']");
	
	
	//a[@onclick='fnGetPatientDrillDown(\"884\", \"Numerator\",undefined,undefined,2 ,\"1\")']
	
	public By ClickonPracticeTab=By.xpath("//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li[1]/ul/li[1]/a");
	public By HighpriorityMeasures=By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[@id]/td[6][contains(text(),'YES')]");
	//public By ClickOnPractice=By.xpath("//*[@id]/div[1]/h4/div/table/tbody/tr/td[1]/a");
	public By QCDR2018eCQM_QPP=By.xpath("//*[@id='chkddl9d9e7b99-ccfb-4dd9-8b51-0f45dd96893d']");
	//public By measureSetDropDown = By.xpath("//*[@id='txtMeasureSet']");	
	//public By measureSet2017MeasuresetRB= By.xpath("//*[@id='chkddl43619a92-b44d-47c9-880d-f168c3ad211d']");	
	
	public By SelectProvidersubmenu1= By.xpath("//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li[1]/ul/li[2]/a");
	
	public By getonprovider= By.xpath("(//div[1]/h4/div/table/tbody/tr/td[1]/a)[1]");
	public By clickonprovider= By.xpath("(//div[1]/h4/div/table/tbody/tr/td[1]/a)[1]");	//div[1]/h4/div/table/tbody/tr/td[1]/a)[1]

	public By Selectmeasure= By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[1]/td[1]");
	
	public By ClickonmetCount= By.xpath("//table[@id]/tbody/tr[1]/td[3]/a");
	public By getprovidertext= By.xpath("//*[@id='spnModalPatientDrilDownHeader']");
	public By closePopUp= By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button/img");
	public By closeDrillDownPopUp= By.xpath("//*[@id='ModalSummryProviderLocationPractice']/div/div/button/img");
	public By getNationalAverageondrilldown= By.xpath("//*[@id='spanNationalAverage']");
	public By getNationalAverageonlandingpage= By.xpath("//td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[5]");//td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[4]
	
	
	// Surbhi
	
	public By providerMenu = By.xpath("//a[@data-parent='Dashboards' and @data-module='Provider']");
	public By RollingProviderRecord = By.xpath("//*[@id='divProviderPager']/div");
   // public By RollingProviderRecord = By.xpath("//div[@class='widget-box ']/div[@class='widget-body']/div/div/div/div");
	public By NRolling = By.xpath("//*[@type='checkbox' and @id='RollNonRoll']");
	
	//Xpath for provider-PatientDrilllDown
	public By ProviderMeasureClick = By.xpath("//*[@id='row9bdca45e-db69-430b-ba6d-004c80fa597b']/div[1]/h4/div/table/tbody/tr/td[1]/a/i");
	public By MeasureClick = By.xpath("//*[@id='sample-table-1']/tbody[1]/tr[11]/td[3]/table/tbody/tr/td");
	public By MetCount = By.xpath("//*[@id='35a50729-4c16-45ad-aee8-2bf7d49fb265']/tbody/tr[1]/td[3]/a");
	public By DrillDownCount = By.xpath("(//*[contains(text(),'Records')])[4]");
	public By drillDownClose = By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button/img");
	
	
	
	// Poonam
	public By measurePracticePerfromanceTrendPatientDrillDownCountCloseWindow = By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button/img");
	//Xpath for Practice-All Tab for Rolling
	public By practicePerformanceAllTab = By.xpath("//*[@id='tabdashboard']/li[4]/a");
	public By measurePracticePerfromanceTrendCloseWindow = By.xpath("//*[@id='ModalSummryProviderLocationPractice']/div/div/button/img");
	public By practicePerformanceAllTabProviderCount = By.xpath("//*[@id='divMeasureProviderPager']/div");
	public By practicePerformanceAllTabCloseWindow = By.xpath("//*[@id='ModalSummryProviderLocationPractice']/div/div/button/img");
	
	//Xpath for nonrolling
	public By practicePerformanceDashboardNR = By.xpath("//*[@id='tr3dd81505-8c2d-4130-b85d-e854d6b8bfcf']/td[3]/table/tbody/tr/td/table/tbody/tr/td[1]/div[2]");
	public By practicePerformanceDashboardNRAllTab = By.xpath("//*[@id='tabdashboard']/li[4]/a");
	public By practicePerformanceDashboardNRProviderCount = By.xpath("//*[@id='divMeasureProviderPager']/div");
	public By practicePerformanceDashboardRPerfromanceTrendNRMETCount = By.xpath("(//table[@class='table table-striped table-bordered table-hover cursor-default']/tbody/tr/td[@class]/a)[1]");//By.xpath("//*[@id='divPerformanceTrande']/div[2]/div[2]/table/tbody/tr[1]/td[3]/a");
	public By practicePerformanceDashboardRPerfromanceTrendNRPatientcount = By.xpath("(//*[contains(text(),'Records')])[4]");
	
	
	
	//Xpath for Practice-Provider tab
	public By practicePerformanceDashboardProviderTab = By.xpath("//*[@id='tabdashboard']/li[3]/a");
	public By practicePerformanceDashboardProviderTabRProvidersCount = By.xpath("//*[@id='divMeasureProviderPager']/div");
	
	
	
	
	////awadhesh 
	
	
	public By FavouriteButton = By.xpath("//*[text()[contains(.,'FAVORITES')]]");
	public By PracticeSubmodule = By.xpath("//*[./text()='Practice'][@class='navurl']");
	public By TotalPageRecordWithoutPagination = By.xpath("//div[@id='divPager']/div");
	public By PMeasureLocatorWithHigherCount  = By.xpath("//table[@id='sample-table-1']/tbody/tr[@style]//i[2][@data-toggle='tooltip'][@title='Higher score for this measure is Better']/../..");
	public By PMeasureLocatorWithLowerCount= By.xpath("//table[@id='sample-table-1']/tbody/tr[@style]//i[2][@data-toggle='tooltip'][@title='Lower score for this measure is Better']/../..");
	
	
	
	//Xpath for Practice-PatientDrilllDown
	
	public By selectElementFromMeasuregrid = By.xpath("//*[@id='tr3dd81505-8c2d-4130-b85d-e854d6b8bfcf']/td[1]");
	public By performanceTrend = By.xpath("//*[@id='tabdashboard']/li[1]/a");
	public By selectQuarter = By.xpath("//*[@id='divPerformanceTrande']/div[2]/div[2]/table/tbody/tr[1]/td[3]/a");
	public By observePracticeName = By.xpath("//span[@id='spnModalPracticeName']");////*[@id='ModalNumerator']/div/div/div[1]/div[3]/div[1]/div[2]/div
	public By observeMeasureName= By.xpath("(//div[@class='col-xs-12 col-sm-9'])[2]");
	public By observeTooltip = By.xpath("//*[@id='sample-table-1']/tbody/tr[1]/td[5]/i[@class='icon-info-sign bigger-150 light-grey tooltip-hide']");
	public By closePopup2 =By.xpath("//*[@id='ModalNumerator']/div/div/div[1]/button/img");
	public By ClosePopup1= By.xpath("//*[@id='ModalSummryProviderLocationPractice']/div/div/button/img");
	
	
	
	// X-Path for Location Menu
	
	public By dashboardLocation = By.xpath("//a[@data-parent='Dashboards' and @data-module='Location']");
	public By dashboardLocationCount = By.xpath("//div[@id='divLocationPager']/div");
	public By dashboardLocationBubble = By.xpath("//span[contains(@class,'Dashboards') and @id='spnLocation-Count']");
	
	// X-Path for Last Update
	
	public By dashboardLastUpdate = By.xpath("//*[@id='lblLastUpdatedValue']");
	
	
	public By dashboardIRISeCQM1Measure = By.xpath("//*[@id='tr3dd81505-8c2d-4130-b85d-e854d6b8bfcf']/td[2]");
	public By dashboardIRISeCQM1MeasureLocationBtn = By.xpath("//*[@id='tabdashboard']/li[2]/a");
	public By dashboardIRISeCQM1MeasureLocationTotalCount = By.xpath("//*[@id='divMeasureLocationPager']/div");
	
	
	//xpath for Practice drop-down
	public By practicedropdown = By.xpath("//input[@id='txtddlparentPractice']");
	public By practicedropdown_pid = By.xpath("//input[@id='txtPracticeIdfilter']");
	public By practicedropdown_pid_btnRadio = By.xpath("//table[@id='tblPracticeDropDownList']//tbody/tr[2]/td[1]");
	public By alltab=By.xpath("//label[@class='control-label cursor-pointer' and contains(text(),'ALL')]");
	public By practicepopup=By.xpath("(//button[@class='close modal-close-button-largepopup' and @type='button'])[1]");
	public By selectedpracticeid = By.xpath("//table[@id='tblPracticeDropDownList']//tr[@class='rowselected']/td[2]");
	
	//xpath for quarter dropdown
	
	public By quarterdrp=By.xpath("//select[@id='ddlQuarter']");
	
	//xpath for the MIPS Group
	
	public By mips2018 = By.xpath("//span[text()=' MIPS-2018 ']");
	public By mips2018lnk = By.xpath("//a[@data-parent='MIPS-2018' and @data-module='MIPS-2018' ]");
	public By grouptile = By.xpath("(//div[@class='grid_column tile animated'])[2]");
	public By practicearrow = By.xpath("//div[@class='title']/i[@class='dropdown icon']");
	//public By seemorebtn = By.xpath("//button[text()='See More']");
	
	public By qualitylnk = By.xpath("(//span[@class='redirectLink redirectLinkOnText' and text()='QUALITY'])[1]");
	public By  savebtn = By.xpath("//button[text()='Save']");
	public By alertYes = By.xpath("//button[@id='yesSavedata']");
	public By practicedrpmenu = By.xpath("//div[@class='ui search selection dropdown homeScreenproviderDropDown']");
	public By practicetxtbox = By.xpath("//input[@class='search']");
	public By savemesg = By.xpath("//div[contains(text(), 'Quality Details saved successfully')]");
	public By homeicon = By.xpath("//div[@class='home_icon']");
	
	//Xpath for Clinician
	
	public By cliniciantile = By.xpath("(//div[@class='grid_column tile animated'])[1]");
	
	public By practicedrpmenuClinician = By.xpath("(//div[@class='text'])[1]");
	
	public By practicetxtboxclinician = By.xpath("(//input[@class='search'])[1]");
	public By searchbox = By.xpath("//button[@class='ui button providerinfo_search']");
	public By cliniciansearch = By.xpath("//input[@class='prompt']");
	
	public By clinicianlistpage = By.xpath("//p[@class='home__l']");
	
	public By allpage = By.xpath("//div[@class='ui selection bottom pointing dropdown drpPageChange']");
	
	public By allno= By.xpath("//span[text()='ALL']");
	
	public By providersearchbox =  By.xpath("//input[@id='txtProviderFilter']");
	

	
	
	
	
	
	
  }
