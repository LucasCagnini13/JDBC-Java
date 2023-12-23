package Program;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DB;
import Db.DbExcepition;

public class program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.loadConnection();
			st = conn.createStatement();
			rs = st.executeQuery("Select * from department");
		} catch (SQLException e) {
			
			throw new DbExcepition(e.getMessage());
		}
		
		
		try {
			while(rs.next()) {
				
				System.out.println(rs.getInt("Id") + ", "+rs.getString("Name"));
			}
		} catch (SQLException e) {
		
			throw new DbExcepition(e.getMessage());
		}
		
		
		DB.closeResultSet(rs);
		DB.closeStatement(st);
		DB.closeConnection();

	}

}
