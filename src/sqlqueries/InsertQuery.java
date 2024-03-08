package sqlqueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertQuery {

	public static void insertWithStatement() {
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = jdbc.JDBCUtilClass.getConnection();
			String insertQuery = "insert into student values(11, 'Deepak', 'deepak342@gmail.com', 25)";
			stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(insertQuery);
			if (rowsAffected == 1) {
				System.out.println("Row inserted Successfully !!!");
			} else {
				System.out.println("Row insertion Un-successful !!!");
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbc.JDBCUtilClass.closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void insertWithPreparedStatement(Scanner scan) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		try {
			conn = jdbc.JDBCUtilClass.getConnection();
			String insertQuery = "insert into student values(?, ?, ?, ?)";

			prepStmt = conn.prepareStatement(insertQuery);

			// adding parameters - roll-no, name, email, age;
			int rollno, age;
			String name, email;
			System.out.println("Enter student roll no (should not be existing one):");
			rollno = scan.nextInt();
			System.out.println("Enter student name:");
			name = scan.next();
			System.out.println("Enter student email:");
			email = scan.next();
			System.out.println("Enter student age:");
			age = scan.nextInt();

			prepStmt.setInt(1, rollno);
			prepStmt.setString(2, name);
			prepStmt.setString(3, email);
			prepStmt.setInt(4, age);

			int rowsAffected = prepStmt.executeUpdate();
			if (rowsAffected == 1) {
				System.out.println("Row inserted Successfully !!!");
			} else {
				System.out.println("Row insertion Un-successful !!!");
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbc.JDBCUtilClass.closeResources(conn, prepStmt);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
