package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String sql = "insert into student values(?,?,?,?,?,?,?)";
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb";
		String user = "root";
		String password = "Sanju024816$";

		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);

			System.out.println("Enter the number of student details you want to insert");
			int n = scan.nextInt();

			for (int i = 0; i < n; i++) {
				
				System.out.println("Enter the sid, sname, gender, section, pno, age and marks");
				int sid = scan.nextInt();
				String sname = scan.next();
				String gender = scan.next();
				String section = scan.next();
				String pno = scan.next();
				int age = scan.nextInt();
				int marks = scan.nextInt();
				ps.setInt(1, sid);
				ps.setString(2, sname);
				ps.setString(3, gender);
				ps.setString(4, section);
				ps.setString(5, pno);
				ps.setInt(6, age);
				ps.setInt(7, marks);

				int res = ps.executeUpdate();
				System.out.println(res + "Row(s) inserted");
			}
			

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
