package DemoMaven.DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataProvider {
	
	
	private static Connection con;
	private static File file;
	private static FileInputStream fileInput;
	private static Properties properties;

	
	
	public Connection getDbConnection() throws IOException, SQLException {
		try {
			//FileInputStream or_file=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\DatabaseConfigration.properties");
			
			//logger.info(System.getProperty ("user.dir")+"/database.properties");
			//file = new File("or_file");
			fileInput = new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\DatabaseConfigration.properties");
			properties = new Properties();
            properties.load(fileInput);
			String DBIpAddress = properties.getProperty("DBIpAddress");
			String DBNAME = properties.getProperty("DBNAME");
			String USERNAME = properties.getProperty("USERNAME");
			String PASSWORD = properties.getProperty("PASSWORD");

            con = DriverManager.getConnection("jdbc:sqlserver://"+DBIpAddress+";databaseName="+DBNAME+";", USERNAME, PASSWORD);
            
            return con;
            
        } catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		finally{
			fileInput.close();
		}

	}

}
