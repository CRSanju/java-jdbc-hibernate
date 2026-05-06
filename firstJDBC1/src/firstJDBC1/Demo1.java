package firstJDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		
		 try {
			 
			 //1. Load the Driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded successfully");
			 
			 //2. Establish the connection
			 Connection con;
			 con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "Sanju024816$");
			 System.out.println("Connection estalished");
			 
			 
			 //3. create the medium
			 Statement stmt = con.createStatement();
			 System.out.println("Statement medium created");
			 
			 //4. Execute the query
			 String sql = "select * from student";
			 ResultSet rs = stmt.executeQuery(sql);
			 System.out.println("query executed and received resultset");
			 
			 //5. display the result
			 while(rs.next()) {
				 System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4));
			 }
			 
			 //.6 Close the resources
			 con.close();
			 stmt.close();
			 rs.close();
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }

		
	}

}
