package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRecords2 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";

		String sql1 = "update employee set name = ? where id = ?";
		String sql2 = "update employee set salary = ? where id = ?";

		try {

			Class.forName(dpath);
			con = DriverManager.getConnection(url);

			System.out.println("press 1 to update name");
			System.out.println("press 2 to update name");
			int choice = scan.nextInt();

			switch (choice) {

			case 1 -> {
				ps = con.prepareStatement(sql1);
				System.out.println("Enter id to update the name of the employee");
				int id = scan.nextInt();
				System.out.println("Enter the new name: ");
				String newName = scan.next();
				ps.setInt(2, id);
				ps.setString(1, newName);
			}

			case 2 -> {
				ps = con.prepareStatement(sql2);
				System.out.println("Enter id to update the name of the  employee");
				int id = scan.nextInt();
				System.out.println("Enter new salary");
				int newSalary = scan.nextInt();
				ps.setInt(2, id);
				ps.setInt(1, newSalary);
			}
			} // end switch

			int res = ps.executeUpdate();
			System.out.println(res + " Row(s) updated");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (scan != null)
					scan.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
