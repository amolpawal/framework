package DemoMaven.DataBase.DashBoard;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DemoMaven.DataBase.DataProvider;

public class LipidTestsDB {
	
	DataProvider dataprovider = new DataProvider();
	
	public String TC_verifyAllCount_2018(String query) throws SQLException{
		String count = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		
		System.out.println("Query Pass for Database: "+query);
		try{
			con = dataprovider.getDbConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getString("total");
			}
		}
		catch(Exception e){
			System.out.println("Error occured while making connection"+e.getMessage());
		}
		finally{
			con.close();
		}
		System.out.println("DB count:"+count);
		return count;
	}

}
