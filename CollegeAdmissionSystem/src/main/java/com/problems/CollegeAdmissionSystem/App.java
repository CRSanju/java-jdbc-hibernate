package com.problems.CollegeAdmissionSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);

		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprojects? user=root & password=Sanju024816$";

		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url);

			while (true) {
				System.out.println("Enter 1 to add a new applicant");
				System.out.println("Enter 2 to view all the  applicants");
				System.out.println("Enter 3 to approve applicants marks above 75");
				System.out.println("Enter 4 to Delete rejected applicant");
				System.out.println("Enter 5 to exit");

				int choice = scan.nextInt();

				switch (choice) {

				case 1 -> {
					System.out.println("Enter the id, name, course and marks");
					Applicant a = new Applicant(scan.nextInt(), scan.next(), scan.next(), scan.nextInt());
					String sql1 = "insert into admission values(?,?,?,?)";
					ps = con.prepareStatement(sql1);
					ps.setInt(1, a.getId());
					ps.setString(2, a.getName());
					ps.setString(3, a.getCourse());
					ps.setInt(4, a.getMarks());

					int res = ps.executeUpdate();
					System.out.println(res + "Row(s) affected");
				}

				case 2 -> {
					String sql2 = "select * from admission";
					st = con.createStatement();
					rs = st.executeQuery(sql2);

					while (rs.next()) {
						System.out.println(
								rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
					}
				}

				case 3 -> {
					String sql3 = "Select * from admission where marks > 75";
					st = con.createStatement();
					rs = st.executeQuery(sql3);

					System.out.println("Application approved");
					while (rs.next()) {
						System.out.println(
								rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
					}
				}

				case 4 -> {
					System.out.println("Enter id to delete");
					int deleteId = scan.nextInt();

					String sql4 = "delete from admission where id = ?";
					ps = con.prepareStatement(sql4);
					ps.setInt(1, deleteId);
					ps.executeUpdate();
					System.out.println("DELETED");
				}

				case 5 -> {
					System.out.println("Exit");
					return;
				}
				
				default -> System.out.println("Invalid Operation");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
				if (scan != null)
					scan.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
