package firstJDBC1;

import java.sql.*;
import java.util.*;

public class Demo2 {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		ResultSet res = null;
		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb";
		String user = "root";
		String password = "Sanju024816$";
		String sql = "select * from student where id = ?";
		
		try {
			Class.forName(dpath);
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			System.out.println("Enter id to fetch the data");
			int sid = sc.nextInt();
			ps.setInt(1, sid);
			res = ps.executeQuery();
			
			if(res.next()) {
				System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3) + " " + res.getInt(4));
			} else {
				System.out.println("Invalid id, student not found with id: " + sid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(res != null) res.close();
				if(sc != null) sc.close();
				
			} catch (Exception e2) {
			    e2.printStackTrace();
			}
		}
		

	}

}
