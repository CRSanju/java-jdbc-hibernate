package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRecords {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";
		String sql = "update employee set name = ? where id = ?";

		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(sql);

			System.out.println("Enter id to update name of the employee");
			int id = scan.nextInt();
			System.out.println("Enter new name: ");
			String newName = scan.next();

			ps.setInt(2, id);
			ps.setString(1, newName);

			int res = ps.executeUpdate();
			System.out.println(res + "Row(s) affected");

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
