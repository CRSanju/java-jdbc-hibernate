package com.kodnest.jdbcbatchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";
		String sql = "insert into department values(?,?,?,?)";

		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(sql);

			raja: while (true) {
				System.out.println("Enter 1 or 2 to insert or to exit");
				int choice = scan.nextInt();
				switch (choice) {

				case 1: {
					System.out.println("Enter id, name, loc, noe");
					int id = scan.nextInt();
					String name = scan.next();
					String loc = scan.next();
					int noe = scan.nextInt();

					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, loc);
					ps.setInt(4, noe);

					ps.addBatch();
					break;
				}

				case 2: {
					break raja;
				}

				} // end of switch
			} // end of loop

			int res[] = ps.executeBatch();
			for (int i : res) {
				System.out.println(i + " ");
			}
			System.out.println();

		} catch (Exception e) {

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
