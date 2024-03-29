import java.util.Scanner;

public class MainClass {

	public static void displayMenu() {
		System.out.println("**** MENU ****");
		System.out.println("1. SELECT All students from student table");
		System.out.println("2. SELECT a student from student table");
		System.out.println("3. INSERT into student table");
		System.out.println("4. UPDATE Name of a student into student table");
		System.out.println("5. UPDATE Email of a student into student table");
		System.out.println("6. UPDATE Age of a student into student table");
		System.out.println("7. Delete from student table");
		System.out.println("8. Exit/Quit");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int choice;
			do {
				displayMenu();
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					sqlqueries.SelectQuery.selectAllStudent();
					break;
				case 2:
					sqlqueries.SelectQuery.selectStudentByRollNo(scan);
					break;
				case 3:
					sqlqueries.InsertQuery.insertWithPreparedStatement(scan);
					break;
				case 4:
					sqlqueries.UpdateQuery.updateStudentInfo(scan, "studentname");
					break;
				case 5:
					sqlqueries.UpdateQuery.updateStudentInfo(scan, "email");
					break;
				case 6:
					sqlqueries.UpdateQuery.updateStudentInfo(scan, "age");
					break;
				case 7:
					sqlqueries.DeleteQuery.deleteStudentById(scan);
					break;
				case 8:
					System.out.println("*** Thanks for using the JDBC application ****");
					break;
				default:
					System.out.println("Invalid choice! Retry !!!");
				}
			} while (choice != 5);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();; 
		}
	}

}
