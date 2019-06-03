package DemoMaven.CommonActions.CommonAction;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import DemoMaven.Utilities.SuiteBase;


public class NewCommonAction extends SuiteBase{
	
	private boolean isElementPresent(By xpath) {
		try
		{
			driver.findElement(xpath);
			return true;
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Locator not found - "+xpath);
			return false;
		}
		
	}
	
	

	public String IsmenuSelected(String data,String step) {
		
		
			int flag_menu=0;
			try
				{
				
				   if(data.isEmpty())
			       {
			    	// System.out.println("Menu is not given");
			    	 return "Not Allowed to Proceed further";
			       }
				    int no_menu=driver.findElements(By.xpath(".//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li")).size();
					//System.out.println("Total menu is"+no_menu);
					for(int i=1;i<=no_menu;i++)
					{
						     String menu_list_xpath=".//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li["+i+"]/a";
						     String actual_menu= driver.findElement(By.xpath(menu_list_xpath)).getText();
						    // System.out.println("Actul menu is "+actual_menu);
						 //Match UI menu with given menu
						 if(actual_menu.equalsIgnoreCase(data))
						 {
						    	String style_path=".//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li["+i+"]";
						    	if(isElementPresent(By.xpath(style_path)))
						    	{	
						    	  String menu_style=driver.findElement(By.xpath(style_path)).getAttribute("class");
						    	 // System.out.println("class is "+menu_style);
						    	  //check menu is already selected or not
						    	  if(menu_style.isEmpty())
						    	   { 
		                                  
						    		    driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_MainContent_divLeftMenu']/ul/li["+i+"]")).click();
						    		    logger.log(LogStatus.INFO,step+ " Element is clickable..");
						    			System.out.println(step + " :Menu-\" "+actual_menu+" \" selected ");
						    			return "Pass";
						    			
						    		}	
						    	  
						    	  else if(menu_style.equals("open"))
						    	   {
						    	     System.out.println(step+" :Menu-  \" "+ actual_menu+" \" is already selected ");
						    	     flag_menu=1;
						    	     return "Pass";
						    	   }
						   }
						   
						 }
						    
		    		 }
				  //Menu is not present	
				  if(flag_menu==0) 
					   {
						    	 System.out.println("Menu "+data+ " is not present ");
						    	 return "Pass Not Allowed to Proceed";
					   }
					return "Pass";
				}		
			catch(Exception e)
				{
					System.out.println("Exception occurs while selecting menu"+e);
					
					return "Fail during selecting Menu"+data;
				}
				
		}
		
	

	
	


	public String IsSubmenuSelected(String data, String step) {
		
		int flag_menu=0;
		try
			{
			
			   if(data.isEmpty())
		       {
		    	// System.out.println("Menu is not given");
		    	 return "Not Allowed to Proceed further";
		       }
			    int no_menu=driver.findElements(By.xpath("//a[@id='Dashboards']//following-sibling::ul//a")).size();
				//System.out.println("Total menu is"+no_menu);
				for(int i=1;i<=no_menu;i++)
				{
					     String menu_list_xpath="(//a[@id='Dashboards']//following-sibling::ul//a)["+i+"]";
					     String actual_menu= driver.findElement(By.xpath(menu_list_xpath)).getText();
					    // System.out.println("Actul menu is "+actual_menu);
					 //Match UI menu with given menu
					 if(actual_menu.equalsIgnoreCase(data))
					 {
						 String menu_style=driver.findElement(By.xpath(menu_list_xpath)).getAttribute("class");
						 
						 if(menu_style.equals("active")){
							 System.out.println(step+ ":SubMenu  \" "+actual_menu+" \"  is already selected");
							 flag_menu++;
						 }
						 else{
							 driver.findElement(By.xpath(menu_list_xpath)).click();
							 System.out.println(step+" :SubMenu selected" +actual_menu); 
					    	flag_menu++;
					    	  
					   }
					   
					 }
					    
	    		 }
			  //Menu is not present	
			  if(flag_menu==0) 
				   {
					    	 System.out.println("Menu "+data+ " is not present ");
					    	 return "Pass Not Allowed to Proceed";
				   }
				return "Pass";
			}		
		catch(Exception e)
			{
				System.out.println("Exception occurs while selecting Submenu"+e);
				
				return "Fail during selecting SubMenu"+data;
			}
			
	}
		
		
	

}
