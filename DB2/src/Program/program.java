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

public class program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {

			conn = DB.loadConnection();
			/*
			 * st = conn.prepareStatement("INSERT into seller " +
			 * "(NAME, Email, BirthDate, BaseSalary, DepartmentId) " + "VALUES " +
			 * "(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			 * 
			 * st.setString(1, "João"); st.setString(2, "João@gmail.com"); st.setDate(3, new
			 * Date(sdf.parse("20/12/2020").getTime()));
			 * 
			 * st.setDouble(4, 2000); st.setInt(5, 4);
			 */

			st = conn.prepareStatement("INSERT into department (Name) values ('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();

				while (rs.next()) {

					int id = rs.getInt(1);
					System.out.println("DONE, id = " + id);
				}
				DB.closeResultSet(rs);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
