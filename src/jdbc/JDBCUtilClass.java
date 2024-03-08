package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class JDBCUtilClass {
	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		FileInputStream fis = new FileInputStream("application.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String url, user, pass;
		url = prop.getProperty("url");
		user = prop.getProperty("username");
		pass = prop.getProperty("password");
		Connection conn = DriverManager.getConnection(url, user, pass);

		return conn;
	}

	public static void closeResources(Connection conn, Statement statement) throws SQLException {
		if (conn != null)
			conn.close();
		if (statement != null)
			statement.close();
	}

	public static void closeResources(Connection conn, Statement statement, ResultSet resSet) throws SQLException {
		closeResources(conn, statement);
		if (resSet != null)
			resSet.close();
	}

	public static void closeResources(Connection conn, PreparedStatement prepStatement) throws SQLException {
		if (conn != null)
			conn.close();
		if (prepStatement != null)
			prepStatement.close();
	}

	public static void closeResources(Connection conn, PreparedStatement prepStatement, ResultSet resSet)
			throws SQLException {
		closeResources(conn, prepStatement);
		if (resSet != null)
			resSet.close();
	}

}
