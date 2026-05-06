package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteRecords {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String sql = "delete from student where sid = ?";
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";

		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(sql);

			System.out.println("Enter the id you want to delete from the table");
			int sid = scan.nextInt();
			ps.setInt(1, sid);

			int res = ps.executeUpdate();
			System.out.println(res + "Row(s) deleted");

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
