package DemoMaven.UI_Map.DashBoard;

import org.openqa.selenium.By;

public class LipidLocators {
	
	public By lipidmenu = By.xpath("//a[@data-parent='Dashboards' and @data-module='Lipid Pathway']");
	public By breadcrum = By.xpath("//span[@id='spnBreadcrum']");
	public By yeardropdown = By.xpath("//select[@id='ddlYear']");
	public By ascvdordiabetesdropdown = By.xpath("//select[@id='ddlASCVDDiab']");
	public By pathway = By.xpath("//select[@id='ddlPathway']");
	public By btnSearch = By.xpath("//button[@id='btnSearch']");
	public By tablerecords = By.xpath("(//div[@id='divPatientDetailsGridPager']/*)[1]");
	public By docslinks = By.xpath("//i[@class='fa fa-square']/following-sibling::a");
	
	

}
