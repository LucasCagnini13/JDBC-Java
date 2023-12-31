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

		Connection conn = null;
		PreparedStatement st = null;

		conn = DB.loadConnection();

		try {
			st = conn.prepareStatement(
					"UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " + "DepartmentId = ? ",
					Statement.RETURN_GENERATED_KEYS);

			st.setDouble(1, 200);
			st.setInt(2, 4);

			int linhasAfetadas = st.executeUpdate();


			System.out.println("linhas fatadas " + linhasAfetadas);

		} catch (SQLException e) {
			e.getStackTrace();
		} finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
