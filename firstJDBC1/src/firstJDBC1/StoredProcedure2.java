package firstJDBC1;

import java.sql.*;
import java.util.*;

public class StoredProcedure2 {

	public static void main(String[] args) {

		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);

		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";

		try {

			Class.forName(dpath);
			con = DriverManager.getConnection(url);

			System.out.println("1. Insert Student");
			System.out.println("2. Fetch Students above marks");
			System.out.print("Enter your choice: ");

			int choice = scan.nextInt();

			if (choice == 1) {

				// -------- INSERT PART --------
				String insertSql = "call insertStudent(?,?,?)";
				cs = con.prepareCall(insertSql);

				System.out.print("Enter id: ");
				int id = scan.nextInt();

				System.out.print("Enter name: ");
				String name = scan.next();

				System.out.print("Enter marks: ");
				int marks = scan.nextInt();

				cs.setInt(1, id);
				cs.setString(2, name);
				cs.setInt(3, marks);

				int count = cs.executeUpdate();
				System.out.println(count + " row inserted");

			} else if (choice == 2) {

				// -------- FETCH PART --------
				String fetchSql = "call getstudent(?)";
				cs = con.prepareCall(fetchSql);

				System.out.print("Enter marks to fetch students above entered marks: ");
				int marks = scan.nextInt();

				cs.setInt(1, marks);

				rs = cs.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
				}

			} else {
				System.out.println("Invalid choice");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (cs != null)
					cs.close();
				if (con != null)
					con.close();
				scan.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}

/*
 * DELIMITER $$
 * 
 * CREATE PROCEDURE insertStudent( IN p_id INT, IN p_name VARCHAR(50), IN
 * p_marks INT ) BEGIN INSERT INTO student(id, name, marks) VALUES (p_id,
 * p_name, p_marks); END$$
 * 
 * DELIMITER ;
 * 
 */
