package sqlqueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteQuery {
	public static void deleteStudentById(Scanner scan) {
		
		Connection conn = null;
		PreparedStatement prepStmt = null; 
		
		try {
			String deleteQuery = "Delete from student where rollno = ?"; 
			conn = jdbc.JDBCUtilClass.getConnection(); 
			prepStmt = conn.prepareStatement(deleteQuery); 
			System.out.println("Enter rollNo of Student to be deleted. (can not be recovered again): ");
			int rollNo = scan.nextInt(); 
			prepStmt.setInt(1, rollNo);
			
			int rowsAffected = prepStmt.executeUpdate(); 
			
			if(rowsAffected == 1) {
				System.out.println("Deleted successfully!!!");
			}else {
				System.out.println("Deletion un-successful!");
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			try {
				jdbc.JDBCUtilClass.closeResources(conn, prepStmt);
			}catch (Exception ex) {
				ex.printStackTrace();
			} 
		}
		
	}
}
