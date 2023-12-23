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
		PreparedStatement st = null;

		conn = DB.loadConnection();

		try {
			st = conn.prepareStatement("DELETE from department " + "WHERE " + "Id = ?");

			st.setInt(1, 1);

			int linhasAfetadas = st.executeUpdate();

			System.out.println("linhas fatadas " + linhasAfetadas);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
