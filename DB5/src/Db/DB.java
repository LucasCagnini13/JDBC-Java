package Db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection loadConnection() {

		if (conn == null) {
			try {

				Properties props = getProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);

			} catch (SQLException e) {

				throw new DbExcepition(e.getMessage());
			}

		}

		return conn;
	}

	public static void closeConnection() {

		if (conn != null) {

			try {

				conn.close();
			} catch (SQLException e) {
				throw new DbExcepition(e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {

				throw new DbExcepition(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				throw new DbExcepition(e.getMessage());
			}
		}
	}

	private static Properties getProperties() {

		try (FileInputStream file = new FileInputStream("db.properties")) {

			Properties props = new Properties();
			props.load(file);
			return props;
		} catch (IOException e) {
			throw new DbExcepition(e.getMessage());
		}

	}
}
