package sqlqueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectQuery {
	public static void selectStudentByRollNo(Scanner scan) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resSet = null;

		try {
			conn = jdbc.JDBCUtilClass.getConnection();
			String selectQuery = "select * from student where rollno = ?";
			prepStmt = conn.prepareStatement(selectQuery);
			System.out.println("Enter ROLL NO: ");
			int rollNo = scan.nextInt();
			prepStmt.setInt(1, rollNo);

			resSet = prepStmt.executeQuery();
			boolean noRes = true;
			while (resSet.next()) {
				if (noRes != false)
					noRes = false;
				System.out.println("| RollNo | \t Name | \t Email | \t Age |");
				System.out.println("| " + resSet.getInt(1) + "| \t |" + resSet.getString(2) + "| \t |" + resSet.getString(3)
						+ "| \t |" + resSet.getInt(4) + " | ");
			}
			
			if (noRes)
				System.out.println("No Student found with entered roll no: " + rollNo);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				jdbc.JDBCUtilClass.closeResources(conn, prepStmt, resSet);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void selectAllStudent() {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resSet = null;

		try {

			conn = jdbc.JDBCUtilClass.getConnection();

			String selectQuery = "select * from student";
			prepStmt = conn.prepareStatement(selectQuery);
			resSet = prepStmt.executeQuery();
			resSet.next();
			int studentCount = 0;
			while (resSet.next()) {
				System.out.println("-------------------------");
				System.out.println("Student " + ++studentCount);
				System.out.print("RollNo: " + resSet.getInt(1));
				System.out.print("\nName: " + resSet.getString(2));
				System.out.print("\nEmail: " + resSet.getString(3));
				System.out.println("\nAge: " + resSet.getInt(4));
				System.out.println("-------------------------");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				jdbc.JDBCUtilClass.closeResources(conn, prepStmt, resSet);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
