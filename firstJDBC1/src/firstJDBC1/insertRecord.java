package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class insertRecord {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		Scanner scan = new Scanner(System.in);
		String sql = "insert into employee values(?,?,?,?)";
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb";
		String user = "root";
		String password = "Sanju024816$";

		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			
			System.out.println("Enter the id, name, gender and salary");
			int id = scan.nextInt();
			String name = scan.next();
			String gender = scan.next();
			int salary = scan.nextInt();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setInt(4, salary);
			
			int res = ps.executeUpdate();
			System.out.println(res + "Row(s) inserted");	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(scan != null) scan.close();
				
			} catch (Exception e2) {
			    e2.printStackTrace();
			}
		}
	}

}
