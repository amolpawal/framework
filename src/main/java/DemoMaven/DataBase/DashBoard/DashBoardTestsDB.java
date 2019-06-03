package DemoMaven.DataBase.DashBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import DemoMaven.DataBase.DataProvider;

public class DashBoardTestsDB {
	
	DataProvider dataProvider = new DataProvider();
	
	
	public HashMap<String,String> TC_CrossCuttingMeasuresForMeasureSet2018DB(String Query) throws SQLException{
			HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
			Connection con = null;
			System.out.println("Query Pass for Database: "+Query);
			try {
				con = dataProvider.getDbConnection();
			// Create Statement object
			PreparedStatement ps = con.prepareStatement(Query);
			 //ps.setString(1,accountOrPartnerId);
			 ResultSet rs = ps.executeQuery();
			// Storeing Data From Database
			 	while(rs.next()){
			 		CrossCuttingMeasuresForMeasureSet2018.put("inactive",rs.getString("inactive"));
	         }
			} catch (Exception e) {
				System.out.println("Connection not created."+e);
			}
			finally{
			// closing DB Connection       
	        con.close(); 
			
			}
			return CrossCuttingMeasuresForMeasureSet2018;
		}

	
	
	public HashMap<String,String> TC_DetailedPPDrillDownCountNR(String Query) throws SQLException{
		HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
		Connection con = null;
		System.out.println("Query Pass for Database: "+Query);
		try {
			con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		 //ps.setString(1,accountOrPartnerId);
		 ResultSet rs = ps.executeQuery();
		// Storeing Data From Database
		 	while(rs.next()){
		 		CrossCuttingMeasuresForMeasureSet2018.put("PracticeUid_Count",rs.getString("PracticeUid_Count"));
         }
		} catch (Exception e) {
			System.out.println("Connection not created."+e);
		}
		// closing DB Connection       
        con.close(); 
		return CrossCuttingMeasuresForMeasureSet2018;
	}
	
	
	public HashMap<String,String> TC_DetailedPPDrillDownCountR(String Query) throws SQLException{
		HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
		Connection con = null;
		System.out.println("Query Pass for Database: "+Query);
		try {
			con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		 //ps.setString(1,accountOrPartnerId);
		 ResultSet rs = ps.executeQuery();
		// Storeing Data From Database
		 	while(rs.next()){
		 		CrossCuttingMeasuresForMeasureSet2018.put("PracticeUid_Count",rs.getString("PracticeUid_Count"));
         }
		} catch (Exception e) {
			System.out.println("Connection not created."+e);
		}
		// closing DB Connection       
        con.close(); 
		return CrossCuttingMeasuresForMeasureSet2018;
	}
	
	
	
	public HashMap<String,String> TC_PracticeMeasureCountR(String Query) throws SQLException{
		HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
		Connection con = null;
		System.out.println("Query Pass for Database: "+Query);
		try {
			con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		 //ps.setString(1,accountOrPartnerId);
		 ResultSet rs = ps.executeQuery();
		// Storeing Data From Database
		 	while(rs.next()){
		 		CrossCuttingMeasuresForMeasureSet2018.put("QualityMeasureUid_Count",rs.getString("QualityMeasureUid_Count"));
         }
		} catch (Exception e) {
			System.out.println("Connection not created."+e);
		}
		// closing DB Connection       
        con.close(); 
		return CrossCuttingMeasuresForMeasureSet2018;
	}
	
	public HashMap<String,String> TC_PracticeFavoritesMeasureCountR(String Query) throws SQLException{
		HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
		Connection con = null;
		System.out.println("Query Pass for Database: "+Query);
		try {
			con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		 //ps.setString(1,accountOrPartnerId);
		 ResultSet rs = ps.executeQuery();
		// Storeing Data From Database
		 	while(rs.next()){
		 		CrossCuttingMeasuresForMeasureSet2018.put("inactive",rs.getString("inactive"));
         }
		} catch (Exception e) {
			System.out.println("Connection not created."+e);
		}
		// closing DB Connection       
        con.close(); 
		return CrossCuttingMeasuresForMeasureSet2018;
	}
	
	


	
	
	
	





public HashMap<String,String> TC_patientprovidercountNRDB(String Query) throws SQLException{
	HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		CrossCuttingMeasuresForMeasureSet2018.put("TotlaPatient",rs.getString("TotlaPatient"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return CrossCuttingMeasuresForMeasureSet2018;
}

public HashMap<String,String> TC_patientprovidercountpqrsDB(String Query) throws SQLException{
	HashMap<String,String> CrossCuttingMeasuresForMeasureSet2018 = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		CrossCuttingMeasuresForMeasureSet2018.put("TotlaPatient",rs.getString("TotlaPatient"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return CrossCuttingMeasuresForMeasureSet2018;
}

/*
 *          Rupesh Devlekar
 */

public HashMap<String, String> TC_HighpriorityMeasuresForMeasureSet2018(String Query) {
	HashMap<String,String> TC_HighpriorityMeasuresForMeasureSet2018 = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_HighpriorityMeasuresForMeasureSet2018.put("HighPriority",rs.getString("HighPriority"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
	return TC_HighpriorityMeasuresForMeasureSet2018;
}


public HashMap<String, String> TC_OutcomeMeasuresForMeasureSet2018(String Query ) {
	HashMap<String,String> TC_OutcomeMeasuresForMeasureSet2018 = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_OutcomeMeasuresForMeasureSet2018.put("Outcome",rs.getString("Outcome"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
	return TC_OutcomeMeasuresForMeasureSet2018;
}

	
	// Surbhi

public HashMap<String,String> TC_ProviderCountR(String Query) throws SQLException{
	HashMap<String,String> TC_ProviderCountR = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_ProviderCountR.put("inactive",rs.getString("inactive"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return TC_ProviderCountR;
}




//non rolling provider count
public HashMap<String,String> TC_ProviderCountNR(String Query) throws SQLException{
HashMap<String,String> TC_ProviderCountNR = new HashMap<String,String>();
Connection con = null;
System.out.println("Query Pass for Database: "+Query);
try {
	con = dataProvider.getDbConnection();
// Create Statement object
PreparedStatement ps = con.prepareStatement(Query);
 //ps.setString(1,accountOrPartnerId);
 ResultSet rs = ps.executeQuery();
// Storeing Data From Database
 	while(rs.next()){
 		TC_ProviderCountNR.put("inactive",rs.getString("inactive"));
 }
} catch (Exception e) {
	System.out.println("Connection not created."+e);
}
// closing DB Connection       
con.close(); 
return TC_ProviderCountNR;
}

//rolling provider drill down count
public HashMap<String,String> TC_ProviderPatientCount(String Query) throws SQLException{
HashMap<String,String> TC_ProviderPatientdrilldownCount = new HashMap<String,String>();
Connection con = null;
System.out.println("Query Pass for Database: "+Query);
try {
	con = dataProvider.getDbConnection();
// Create Statement object
PreparedStatement ps = con.prepareStatement(Query);
 //ps.setString(1,accountOrPartnerId);
 ResultSet rs = ps.executeQuery();
// Storeing Data From Database
 	while(rs.next()){
 		TC_ProviderPatientdrilldownCount.put("TotalPatient",rs.getString("TotalPatient"));
}
} catch (Exception e) {
	System.out.println("Connection not created."+e);
}
// closing DB Connection       
con.close(); 
return TC_ProviderPatientdrilldownCount;
}
	
	// Poonam
	
	

public HashMap<String, String> TC_PracticePerformanceTrendPatientDrillDownCountR(String Query) throws SQLException {
	HashMap<String, String> PracticePerformanceTrendPatientDrillDownCountR = new HashMap<String, String>();
	Connection con = null;
	System.out.println("Query Pass for Database: " + Query);
	try {
		con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		// ps.setString(1,accountOrPartnerId);
		ResultSet rs = ps.executeQuery();
		// Storing Data From Database
		while (rs.next()) {
			PracticePerformanceTrendPatientDrillDownCountR.put("TotalPatient", rs.getString("TotalPatient"));
		}
	} catch (Exception e) {
		System.out.println("Connection not created." + e);
	}
	// closing DB Connection
	con.close();
	return PracticePerformanceTrendPatientDrillDownCountR;
}

public HashMap<String, String> TC_PracticePerformanceTrendPatientDrillDownCountNR(String Query)
		throws SQLException {
	HashMap<String, String> PracticePerformanceTrendPatientDrillDownCountNR = new HashMap<String, String>();
	Connection con = null;
	System.out.println("Query Pass for Database: " + Query);
	try {
		con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		// ps.setString(1,accountOrPartnerId);
		ResultSet rs = ps.executeQuery();
		// Storeing Data From Database
		while (rs.next()) {
			PracticePerformanceTrendPatientDrillDownCountNR.put("TotalPatient", rs.getString("TotalPatient"));
		}
	} catch (Exception e) {
		System.out.println("Connection not created." + e);
	}
	// closing DB Connection
	con.close();
	return PracticePerformanceTrendPatientDrillDownCountNR;
}

public HashMap<String, String> TC_PracticeAllProvidersPopUpCountR(String Query) throws SQLException {
	HashMap<String, String> TC_PracticeAllProvidersPopUpCountR = new HashMap<String, String>();
	Connection con = null;
	System.out.println("Query Pass for Database: " + Query);
	try {
		con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		// ps.setString(1,accountOrPartnerId);
		ResultSet rs = ps.executeQuery();
		// Storing Data From Database
		while (rs.next()) {
			TC_PracticeAllProvidersPopUpCountR.put("TotalProviders", rs.getString("TotalProviders"));
		}
	} catch (Exception e) {
		System.out.println("Connection not created." + e);
	}
	// closing DB Connection
	con.close();
	return TC_PracticeAllProvidersPopUpCountR;
}

public HashMap<String, String> TC_PracticeAllProvidersPopUpCountNR(String Query) throws SQLException {
	HashMap<String, String> TC_PracticeAllProvidersPopUpCountNR = new HashMap<String, String>();
	Connection con = null;
	System.out.println("Query Pass for Database: " + Query);
	try {
		con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		// ps.setString(1,accountOrPartnerId);
		ResultSet rs = ps.executeQuery();
		// Storing Data From Database
		while (rs.next()) {
			TC_PracticeAllProvidersPopUpCountNR.put("TotalProviders", rs.getString("TotalProviders"));
		}
	} catch (Exception e) {
		System.out.println("Connection not created." + e);
	}
	// closing DB Connection
	con.close();
	return TC_PracticeAllProvidersPopUpCountNR;
}


public HashMap<String, String> TC_PracticeProvidersPopUpCountR(String Query) throws SQLException {
	HashMap<String, String> TC_PracticeProvidersPopUpCountR = new HashMap<String, String>();
	Connection con = null;
	System.out.println("Query Pass for Database: " + Query);
	try {
		con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		// ps.setString(1,accountOrPartnerId);
		ResultSet rs = ps.executeQuery();
		// Storing Data From Database
		while (rs.next()) {
			TC_PracticeProvidersPopUpCountR.put("TotalProviders", rs.getString("TotalProviders"));
		}
	} catch (Exception e) {
		System.out.println("Connection not created." + e);
	}
	// closing DB Connection
	con.close();
	return TC_PracticeProvidersPopUpCountR;
}
//////Awadhesh 
	
public HashMap<String,String> TC_Favourites2017MeasureSet(String Query) throws SQLException{
	HashMap<String,String> FavouriteCountMeasureset2017 = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		FavouriteCountMeasureset2017.put("inactive",rs.getString("inactive"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return FavouriteCountMeasureset2017;
}


public HashMap<String,String> TC_PMCountOfHigherScore(String Query) throws SQLException{
	HashMap<String,String> PMCountOfHigherScore = new HashMap<String,String>();
	Connection con = null;

	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		PMCountOfHigherScore.put("inactive",rs.getString("inactive"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return PMCountOfHigherScore;
}


public HashMap<String,String> PMCountOfLowerScore(String Query) throws SQLException{
	HashMap<String,String> PMCountOfLowerScore = new HashMap<String,String>();
	Connection con = null;

	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		PMCountOfLowerScore.put("inactive",rs.getString("inactive"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return PMCountOfLowerScore;
}


public HashMap<String,String> TC_VerifyHeaderDetailsforPatientDDWhenOpenedForPracticeDB(String Query) throws SQLException{
	HashMap<String,String> HeaderDetailsforPatientPractice = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		HeaderDetailsforPatientPractice.put("Listname",rs.getString("Listname"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return HeaderDetailsforPatientPractice;
}


public HashMap<String,String> TC_VerifyMeasureNameHeaderPerformaceTrendForPracticeDB(String Query) throws SQLException{
	HashMap<String,String> MeasureNameHeaderPerformaceTrendForPractice = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		MeasureNameHeaderPerformaceTrendForPractice.put("Description",rs.getString("Description"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return MeasureNameHeaderPerformaceTrendForPractice;
}


// Ankita


public HashMap<String, String> TC_LocationCountR(String Query) throws SQLException{
	HashMap<String,String> TC_LocationCountR = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_LocationCountR.put("TotalCount",rs.getString("TotalCount"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return TC_LocationCountR;
	
}



public HashMap<String, String> TC_LocationCountNR(String Query) throws SQLException{
	HashMap<String,String> TC_LocationCountNR = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_LocationCountNR.put("TotalCount",rs.getString("TotalCount"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return TC_LocationCountNR;
}



public HashMap<String, String> TC_LocationBubbleCountR(String Query) throws SQLException{
	HashMap<String,String> TC_LocationBubbleCountR = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_LocationBubbleCountR.put("TotalCount",rs.getString("TotalCount"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return TC_LocationBubbleCountR;	
	}



public HashMap<String, String> TC_VerifyLastUpdatedDate(String Query)throws SQLException {
	HashMap<String,String> TC_VerifyLastUpdatedDate = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_VerifyLastUpdatedDate.put("EndTime",rs.getString("EndTime"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return TC_VerifyLastUpdatedDate;
}


	

/**
 * Testcase ID- TC_0015 : TC_PracticeLocationPopUpCountR"
 * Copyright 2018 FIGmd.in © 2018.
 * All rights reserved.
 * The Displayer class displays text 
 * on the computer screen.
 * @author  Amol Bande
 * @version 1.0 01/06/18
 * @see     java.lang.System
 */
	public HashMap<String, String> TC_PracticeLocationPopUpCountR(String Query)throws SQLException {
	HashMap<String,String> TC_VerifyLastUpdatedDate = new HashMap<String,String>();
	Connection con = null;
	System.out.println("Query Pass for Database: "+Query);
	
	try {
		con = dataProvider.getDbConnection();
	// Create Statement object
	PreparedStatement ps = con.prepareStatement(Query);
	 //ps.setString(1,accountOrPartnerId);
	 ResultSet rs = ps.executeQuery();
	// Storeing Data From Database
	 	while(rs.next()){
	 		TC_VerifyLastUpdatedDate.put("Location_Name",rs.getString("Location_Name"));
     }
	} catch (Exception e) {
		System.out.println("Connection not created."+e);
	}
	// closing DB Connection       
    con.close(); 
	return TC_VerifyLastUpdatedDate;
}
	
	
	/**
	 * Testcase ID- TC_0016 : TC_PracticeLocationPopUpCountNR"
	 * Copyright 2018 FIGmd.in © 2018.
	 * All rights reserved.
	 * The Displayer class displays text 
	 * on the computer screen.
	 * @author  Amol Bande
	 * @version 1.0 01/06/18
	 * @see     java.lang.System
	 */
		public HashMap<String, String> TC_PracticeLocationPopUpCountNR(String Query)throws SQLException {
		HashMap<String,String> TC_VerifyLastUpdatedDate = new HashMap<String,String>();
		Connection con = null;
		System.out.println("Query Pass for Database: "+Query);
		
		try {
			con = dataProvider.getDbConnection();
		// Create Statement object
		PreparedStatement ps = con.prepareStatement(Query);
		 //ps.setString(1,accountOrPartnerId);
		 ResultSet rs = ps.executeQuery();
		// Storeing Data From Database
		 	while(rs.next()){
		 		TC_VerifyLastUpdatedDate.put("Location_Name",rs.getString("Location_Name"));
	     }
		} catch (Exception e) {
			System.out.println("Connection not created."+e);
		}
		// closing DB Connection       
	    con.close(); 
		return TC_VerifyLastUpdatedDate;
	}



	public String getServerDetail(String servernamequery) throws SQLException {
	           String servername = null;
	           Connection con = null;
	           System.out.println("Query passed for the databse:"+servernamequery);
	           try{
	        	   con = dataProvider.getDbConnection();
	        	   
	        	   PreparedStatement ps = con.prepareStatement(servernamequery);
	        	   
	        	   ResultSet rs = ps.executeQuery();
	        	   
	        	   while(rs.next()){
	        		   servername = rs.getString("ServerName");
	        	   }
	           }
	           catch(Exception e){
	        	   System.out.println("Connection not created "+e);
	           }
	           finally{
	        	   con.close();
	           }
	           return servername;
		
	}



	public String getLipidPartitionDetails(String dbnamequery) throws SQLException {
		String dbname = null;
		Connection con = null;
		System.out.println("Query passed for the database:"+dbnamequery);
		try{
			con = dataProvider.getDbConnection();
			PreparedStatement ps= con.prepareStatement(dbnamequery);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dbname = rs.getString("DBName");
			}
		}
		catch(Exception e){
			System.out.println("Connection not created " +e);
		}
		finally{
			con.close();
		}
		return dbname;
		
	}

	
}
