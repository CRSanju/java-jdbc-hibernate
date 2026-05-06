package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		Scanner scan = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";

		String sql1 = "update bank set balance = balance - ? where acnum = ? and password = ?";
		String sql2 = "update bank set balance = balance + ? where acnum = ?";

		try {

			Class.forName(dpath);
			con = DriverManager.getConnection(url);

			ps1 = con.prepareStatement(sql1);
			ps2 = con.prepareStatement(sql2);

			System.out.println("Enter from acnum and password");
			int facnum = scan.nextInt();
			String pwd = scan.next();

			System.out.println("Enter to Acnum");
			int toacnum = scan.nextInt();
			System.out.println("Enter amount to transfer");
			int amount = scan.nextInt();

			ps1.setInt(1, amount);
			ps1.setInt(2, facnum);
			ps1.setString(3, pwd);

			ps2.setInt(1, amount);
			ps2.setInt(2, toacnum);

			int res1 = ps1.executeUpdate();
			System.out.println(res1);

			int res2 = ps2.executeUpdate();
			System.out.println(res2 + "Row(s) affected");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps1 != null)
					ps1.close();
				if (ps2 != null)
					ps2.close();
				if (scan != null)
					scan.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
