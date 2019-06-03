package DemoMaven.Utilities;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

import DemoMaven.CommonActions.CommonAction.ConfigurationManager;
/**
 *
 * @author abhishek.gaikwad
 *
 */

public class EmailReportManager implements IReporter  {
	int failedtc=0;
	int passedtc=0;
	static int totalexecuted=0;
	public static Logger log =Logger.getLogger("rootLogger");
	

	public void generateReport(List<XmlSuite> arg0, List<ISuite> suites, String arg2) {
		EmailManager em = new EmailManager();
		ConfigurationManager rd=new ConfigurationManager();
		//ExcelReportManager erm = new ExcelReportManager();
		//erm.generateReport(arg0,suites,arg2);
		log.info("Excel Report Done");
		

		/*if(rd.read_Configfile("CreateCustomReport").equalsIgnoreCase("enable"))
		{
			CustomReportManager customReportManager = new CustomReportManager();
			customReportManager.generateReport(arg0,suites,arg2);
			Setup.log.info("Custom Report Done");
		}
		else {
			Setup.log.info("CustomReport is NotEnable for current execution Hence old report is Sent in Mail");
		}*/

		em.sendMail(getReport(suites));
		
		log.info("Email Done");

		try
         {
			 java.util.Date date= new java.util.Date();
			 java.sql.Timestamp t = new java.sql.Timestamp(date.getTime());
			 String dateNow = t.toString().replace(":","_");
			 String OldReportPath=rd.read_Configfile("OldReportPath");
			 String CurrentReportPath=rd.read_Configfile("CurrentReportPath");
			 File SrcFile=new File(System.getProperty("user.dir")+CurrentReportPath);
			 Thread.sleep(2000);
			 String username = System.getProperty("user.name");
			 org.apache.commons.io.FileUtils.copyDirectory(SrcFile,new File(OldReportPath+"\\"+username+"\\"+"_"+dateNow+"Report"));
			 //Setup.log.info("Report copied to path" + SrcFile);
         }
		catch(Exception e)
		{
			log.fatal("Error in File moving"+e);
		}


	}

	/**
	 *
	 * @author Update Rakesh.Kulkarni
	 * Date : 10-5-2016
	 * Add Calculated time for execution column
	 */
	private String startHtmlTable()
	{
		String msg;
		msg = "<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\" >";
		msg = msg + "<tr bgcolor=\"#0066FF\">";
		msg = msg + "<th>Test Cases</th>";
		//msg = msg + "<th>Parameters</th>";
		//msg = msg + "<th>Expected Result</th>";
		msg = msg + "<th>Actual Result</th>";
		msg = msg + "<th>Execution Start Time<br/></th>";
//		msg = msg + "<th>Screen Shot Folder Path<br/></th>";
		msg = msg + "</tr>";
		return msg;
	}
	/**
	 *
	 * @author Update Nilesh.Kokane
	 * Date : 07-08-2018
	 * Send screenshot of failed Tc
	 */
	/*public String getListOfFailedTCScreenshotZipfile(List<ISuite> suites)
	{
		String  strpath=ScreenshotManager.currentExecutionFolderPath();
		ZipFiles zipFiles = new ZipFiles();
		File dir =null;
		String zipDirName =null;
		for(ISuite s: suites)
		{
			
			for ( ISuiteResult r : s.getResults().values())
			{
			    ITestContext i = r.getTestContext();
				
				for( ITestResult res: i.getFailedTests().getAllResults())
				{
					
					String failedtestName=i.getName();
					zipDirName=failedtestName;
					strpath=strpath+"\\"+failedtestName;
					dir=new File(strpath);
							
					zipFiles.zipDirectory(dir,zipDirName);
					
					
					
					List<String> elephantList3 = OtherClass(testName);
					String name=elephantList3.get(0);
					String result=elephantList3.get(1);
				
				}
			}
		}
		
		return "";
	}*/
	
	
	
	
	private String getQuickSummaryExecution()
	{
		String msg;

		msg = "<table border=\"3\">";
		msg = msg + "<th><strong>Quick Summary Of Executed Automation Script</strong></th>";
		msg = msg + "<th><strong>Count</strong></th>";
		msg = msg + "<tr>";
		msg = msg + "<td><strong>Total Testcase Executed</strong></td>";
		msg = msg + "<td>"+totalexecuted+"</td>";
		msg = msg + "</tr>";
		msg = msg + "<tr>";
		msg = msg + "<td><strong>Passed</strong></td>";
		msg = msg + "<td><font color=\"green\">"+passedtc+"</td>";
		msg = msg + "</tr>";
		msg = msg + "<tr>";
		msg = msg + "<td><strong>Failed</strong></td>";
		msg = msg + "<td><font color=\"red\">"+failedtc+"</td>";
		msg = msg + "</tr>";
		msg = msg + "</table>";
		
		return msg;
		
		
	}
	
	
	
	/**
	 *
	 * @author Update Rakesh.Kulkarni
	 * Date : 10-5-2016
	 * Remove Start date and End date time column
	 */
	public String getReport(List<ISuite> suites)
	{
		
		String msg;
		String suitname=null;
		//msg = startHtmlTable();
		msg = writeHeader();
		msg = msg +writeMetaData();
		msg = msg +startHtmlTable();
		//buisness.managers.ScreenshotManager sm = new ScreenshotManager();
/*		String Fixp="LoginGroup";
		int z=1;*/
		for(ISuite s: suites)
		{
			//totalexecuted=s.getResults().size();
			System.out.println(s.getResults().toString());
			for ( ISuiteResult r : s.getResults().values())
			{
				
			    ITestContext i = r.getTestContext();
			    totalexecuted = i.getPassedTests().size()+i.getFailedTests().size()+i.getSkippedTests().size();
				for( ITestResult res: i.getPassedTests().getAllResults())
				{
					
				
					passedtc=passedtc+1;
					
/*				// This code is write for group the test case module wise
                    ITestNGMethod method = res.getMethod();
					StringBuilder addon = new StringBuilder();
					String[] groups = method.getGroups();
					int length = groups.length;
					if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
						addon.append("(");
						for ( int m = 0; m < length; m++) {
							if (m > 0) {
								addon.append(", ");
							}
							addon.append(groups[m]);
						}
						addon.append(")");}
					for( z=z;z==1;z++)					{
				        System.out.println("I am in For Loop");
						msg = msg + "<tr>"+Fixp+"</tr>";
					}
					String temp=groups[j];
					if(!temp.equalsIgnoreCase(Fixp) )
					{
						msg = msg + "<tr>"+temp+"</tr>";
						Fixp = groups[j];
					}*/
					
					msg = msg + "<tr>";
					String testName=res.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name=elephantList3.get(0);
					String result=elephantList3.get(1);
					msg = msg + "<td>"+name+"</td>";
					//msg = msg + "<td>"+Utils.escapeHtml(Utils.toString(res.getParameters()))+"</td>";
					//msg = msg + "<td>"+result+"</td>";
                    msg = msg + "<td><center><font color=\"green\">"+ (res.getStatus()==1?"Pass":"Pass") +"</font></center></td>";
/*					//This code  returns required execution time
                    Date startDate = i.getStartDate();
					Date endDate = i.getEndDate();
					long diff = Math.abs(startDate.getTime() - endDate.getTime());
					double seconds = diff / 1000.0;
					int y = (int)Math.round(seconds);*/
					msg = msg + "<td>"+i.getStartDate().toLocaleString()+"</td>";
		//			msg = msg + "<td>"+Screenpath+"\\"+name+"</td>";
					msg = msg + "</tr>";
				/*	j++;*/
				}
				for( ITestResult res: i.getFailedTests().getAllResults())
				{
					failedtc=failedtc+1;
					msg = msg + "<tr>";
					String testName=res.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name=elephantList3.get(0);
					String result=elephantList3.get(1);
					msg = msg + "<td>"+name+"</td>";
					//msg = msg + "<td>"+Utils.escapeHtml(Utils.toString(res.getParameters()))+"</td>";
					//msg = msg + "<td>"+result+"</td>";
					msg = msg + "<td><center><font color=\"red\">"+ (res.getStatus()==1?"Fail":"Fail") +"</font></center></td>";
/*                  // This code  returns required execution time
					Date startDate = i.getStartDate();
					Date endDate = i.getEndDate();
					long diff = Math.abs(startDate.getTime() - endDate.getTime());
					double seconds = diff / 1000.0;
					int y = (int)Math.round(seconds);*/
					msg = msg + "<td>"+i.getStartDate().toLocaleString()+"</td>";
			//		msg = msg + "<td>"+Screenpath+"\\"+name+"</td>";
					msg = msg + "</tr>";
				}
			}
		}
		msg=msg+getQuickSummaryExecution();
		return msg;
	}
	protected PrintWriter createWriter(String outdir) throws IOException {
		//	SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD HH-MM a");
		//  java.util.Date now = new Date(0);
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(
				outdir, "Custom Report"// +sd.format(now)
				+ ".html"))));
	}
	private String writeHeader()
	{
		String msg="";
		msg = msg + ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		msg = msg + ("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		msg = msg + ("<head>");
		msg = msg + ("<title>DashBoard Report</title>");
		msg = msg + ("</head>");
		msg = msg + ("<body>");
		msg = msg + ("<img src=\"http://figmd.com/wp-content/uploads/2018/03/logo.svg\">");
		return msg;
	}
	/**
	 * writes additional details like Executor name
	 * @throws IOException
	 */
	private String writeMetaData()
	{
		String msg="";
		String Module="Dashboard";
		String Verision="1.0";
		msg = msg + ("<h5>Test Executor :- " + System.getProperty("user.name")+"</h3>");
		msg = msg + ("<h5>Date and Time :- " + new Date() +"</h3>");
		msg = msg + ("<h5>Module:-" +Module+ "</h3>");
		msg = msg + ("<h5>Version:-" +Verision+ "</h3>");
    	if(new ConfigurationManager().read_Configfile("url").contains("https://lb01.pinnaclehqi.net/Dashboard/Login.aspx")){
    		msg = msg + ("<h5>Environment:" +"Live"+ "</h3>");
    		
    	}else if (new ConfigurationManager().read_Configfile("url").contains("https://lb01.pinnaclehqi.net/DemoDashboard/Login.aspx")){
    		msg = msg + ("<h5>Environment:" +"Demo"+ "</h3>");
    	}
		try{
			msg = msg + ("<h5><a href=\""+ new ConfigurationManager().read_Configfile("url")+"\">Link for navigates to the Application</a></h5>");
		}catch(Exception e)
		{
			msg = msg + ("Unable to retrive URL link");
		}

		return msg;
	}
	public static int[] splitToComponentTimes(int biggy)
	{
		long longVal = biggy;//.longValue();
		int hours = (int) longVal / 3600;
		int remainder = (int) longVal - hours * 3600;
		int mins = remainder / 60;
		remainder = remainder - mins * 60;
		int secs = remainder;

		int[] ints = {hours , mins , secs};
		return ints;
	}

	private String getDurationString(int seconds) {

		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = seconds % 60;
		String h=twoDigitString(hours);
		String m=twoDigitString(minutes);
		String s=twoDigitString(seconds);
		return h+ " : " + m + " : " + s;
	}
	private String twoDigitString(int number) {

		if (number == 0) {
			return "00";
		}

		if (number / 10 == 0) {
			return "0" + number;
		}

		return String.valueOf(number);
	}
	/**
	 *
	 * @author Rakesh.Kulkarni
	 *
	 */
	public List<String> OtherClass(String input)
	{

		List<String> elephantList = Arrays.asList(input.split(":"));
		try
		{
			String name=elephantList.get(0);
			String result=elephantList.get(1);
		}
		catch (Exception e)
		{
			String result="Result Not Defined";
			List<String> elephantList1 = new ArrayList<String>(1);
			elephantList1.add(0,input);
			elephantList1.add(1,result);
			return elephantList1;
		}
		return elephantList;
	}
}

