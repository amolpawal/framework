package DemoMaven.Utilities;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import DemoMaven.CommonActions.CommonAction.ConfigurationManager;

public class EmailManager {

	private final String host;
	private String from;
	private String to;
	private String subject;
	private String cc;
	ConfigurationManager cm  = new ConfigurationManager();
	//File dir = new File("C:/Users/nilesh.kokane/Documents/TopsScreenShots");
    //String zipDirName = "C:/Users/nilesh.kokane/Documents/TopsScreenShots.zip";
	//File dir = new File("C:/Users/nilesh.kokane/Documents/ASPSScreenShots");
   // String zipDirName = "C:/Users/nilesh.kokane/Documents/ASPSScreenShots.zip";
   
   /* public void onStart(ISuite suite) {
    	subject=suite.getName();
    }*/
	public EmailManager()
	{
		
		from =  cm.read_Configfile("from");
		//subject= cm.read_Configfile("subject");
		to = cm.read_Configfile("to");
		cc = cm.read_Configfile("cc");
		host = "mail.figmd.com";
		//ZipFiles zipFiles = new ZipFiles();
		//zipFiles.zipDirectory(dir, zipDirName);
		//sendMail(to, cc, subject, "Hi");
	}
	
	private Properties initializeProperties()
	{
		 Properties props = System.getProperties();  
		 
		 
		 
		 props.setProperty("mail.smtp.host", host);
	
		return props;
	}

	private Session createSession()
	{
		//Session session = Session.getDefaultInstance(props); 
		return Session.getDefaultInstance(initializeProperties());
	}

	private Message createMessage()
	{
		return new MimeMessage(createSession());
	}

	public boolean sendMail(String emailContent)
	{
		Message message = createMessage();
		
		try
		{
		

			try
			{
				message.setFrom(new InternetAddress(from,"ACC_Automation_Test_Report"));
			}
			catch (Exception e)
			{
				System.out.println("Please verify the from address in Application config");
			}

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

			//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));

			// Set Subject: header field
			/*if(emailContent.contains("TC_VerifyPracticeStatus")) 
			{
				subject= cm.read_Configfile("PracticeStatuscheckAutoRPT");
				message.setSubject(subject);
			}else if(emailContent.contains("TC_AutoAllProcedureLogin")) 
			{
				subject= cm.read_Configfile("graftAutoRPT1");
				message.setSubject(subject);
			}else if(emailContent.contains("TC_AutoGraftBreastLoginTest")) 
			{
				subject= cm.read_Configfile("graftAutoRPT2");
				message.setSubject(subject);
			}else if(emailContent.contains("TC_AutoNBIRLogin")) 
			{
				subject= cm.read_Configfile("nbirAutoRPT");
				message.setSubject(subject);
			}else if(emailContent.contains("TC_TOPSAutoLogin")) 
			{
				subject= cm.read_Configfile("TOPSAutoRPT");
				message.setSubject(subject);
			}else if(emailContent.contains("TC_AutoQCDRRegistryLogin")) 
			{
				subject= cm.read_Configfile("QCDRAutoRPT");
				message.setSubject(subj
				subject="Autoamtion Test Result Report";
				message.setSubject(subject);
			}
			*/
			
			
			

			// Send the actual HTML message, as big as you like
		//	message.setContent(	emailContent,"text/html");
			//********************************

			//System.out.println(emailContent);



			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			// Now set the actual message
			//messageBodyPart.setText(emailContent);
			messageBodyPart.setContent(emailContent,"text/html");
			// Create a multipar message
			Multipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			/*// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			Thread.sleep(2000);
			//String filename = "Z:\\Daily Work\\AUTOMATION\\Intellij\\AAO\\ReportExcel.xlsx";   //Old code to get file from static locatin
			String filename = System.getProperty("user.dir")+"\\test-output\\AutomationReportASPS.xlsx";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("AutomationReportASPS.xlsx");
			multipart.addBodyPart(messageBodyPart);
			*/
			
			
			
			

			// Part three is attachment
			messageBodyPart = new MimeBodyPart();
			//String filenametext = "Z:\\Daily Work\\AUTOMATION\\Intellij\\AAO\\test-output\\AaoDemoCustom Report.html"; //Z:\Daily Work\AUTOMATION\Intellij\Dashboard\test-output\Custom Report.html
			String filenametext = System.getProperty("user.dir")+"\\report\\DashBoardfilename.html";
			DataSource source1 = new FileDataSource(filenametext);
			messageBodyPart.setDataHandler(new DataHandler(source1));
			messageBodyPart.setFileName("AutomationReportACC.html");
			multipart.addBodyPart(messageBodyPart);
			
			/*// Part Four is attachment
			messageBodyPart = new MimeBodyPart();
			//String filenametext = "Z:\\Daily Work\\AUTOMATION\\Intellij\\AAO\\test-output\\AaoDemoCustom Report.html"; //Z:\Daily Work\AUTOMATION\Intellij\Dashboard\test-output\Custom Report.html
			String filenameConsoletext = System.getProperty("user.dir")+"\\test-output\\CurrentExecutionConsoleOutput.txt";
			DataSource sourceConsoletext = new FileDataSource(filenameConsoletext);
			messageBodyPart.setDataHandler(new DataHandler(sourceConsoletext));
			messageBodyPart.setFileName("CurrentExecutionConsoleOutput.txt");
			multipart.addBodyPart(messageBodyPart);
			*/
			// Part three is attachment
		/*	messageBodyPart = new MimeBodyPart();
			//String filenametext = "Z:\\Daily Work\\AUTOMATION\\Intellij\\AAO\\test-output\\AaoDemoCustom Report.html"; //Z:\Daily Work\AUTOMATION\Intellij\Dashboard\test-output\Custom Report.html
			String zipfilenametext ="TopsScreenShots.zip" ;//System.getProperty("user.dir")+"C:\\Users\\nilesh.kokane\\Documents\\TopsScreenShots.zip";
			DataSource zipsource1 = new FileDataSource(new File("C:/Users/nilesh.kokane/Documents/TopsScreenShots.zip"));
			messageBodyPart.setDataHandler(new DataHandler(zipsource1));
			messageBodyPart.setFileName(zipfilenametext);
			multipart.addBodyPart(messageBodyPart);*/

			// Send the complete message parts
			message.setContent(multipart);
			Transport.send(message);


			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}



			//********************************
	/*		Transport.send(message);
			Setup.log.info("Message send successfully");
			return true;
		}
		catch(MessagingException e)
		{
			Setup.log.error("There was some error in creating Message");
		}*/
		return false;
	}

	public boolean sendMail(String to,String cc,String subject,String emailContent)
	{
		this.to = to;
		this.cc = cc;
		this.subject=subject;
		return sendMail(emailContent);
	}
	

}


