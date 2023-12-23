package Program;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

import com.mysql.cj.xdevapi.PreparableStatement;

import Db.DB;
import Db.DbExcepition;
import Db.DbIntegrityException;

public class program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;

		conn = DB.loadConnection();

		try {
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int linhasAfetadas = st.executeUpdate("UPDATE seller "
												+"SET BaseSalary = 4000 "
					        					+ "WHERE DepartmentId = 1");
			
			int x = 0;
			if(x < 2) {
				
				throw new DbExcepition("SQL error");
			}
			
			int linhasAfetadas2 = st.executeUpdate("UPDATE seller "
													+"SET BaseSalary = 2000 "
													+ "WHERE DepartmentId = 2");

			System.out.println("linhas fatadas do primeiro comando : " + linhasAfetadas);
			System.out.println("linhas fatadas do segundo comando : " + linhasAfetadas2);
			
			conn.commit();


		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbExcepition("SQL ERROR, cause by "+e.getMessage());
			} catch (SQLException e1) {
				
				throw new DbExcepition("Error trying to rollback! cause by "+e1.getMessage());
			}
			
		} finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
