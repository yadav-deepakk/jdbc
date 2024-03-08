package sqlqueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateQuery {

	public static void updateStudentInfo(Scanner scan, String colName) {
		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = jdbc.JDBCUtilClass.getConnection();
			String updateQuery = "Update student Set " + colName + "= ? where rollno = ?";
			prepStmt = conn.prepareStatement(updateQuery);
			System.out.println("Enter ROLL NO: ");
			int rollNo = scan.nextInt();
			prepStmt.setInt(2, rollNo);

			System.out.println("Enter value for " + colName + ": ");
			if (colName == "studentname" || colName == "email") {
				String newVal = scan.next();
				prepStmt.setString(1, newVal);
			} else {
				int newVal = scan.nextInt();
				prepStmt.setInt(1, newVal);
			}

			System.out.println("QUERY: " + prepStmt.toString());
			int rowsAffected = prepStmt.executeUpdate();
			if (rowsAffected == 1) {
				System.out.println("Changes are made for student with rollNo: " + rollNo);
			} else {
				System.out.println("No Student found with entered roll no: " + rollNo);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				jdbc.JDBCUtilClass.closeResources(conn, prepStmt);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
