package com.problems.EmployeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter the id, Houseno, landmark, location, state, city and country");
    	Address add = new Address(scan.nextInt(), scan.nextInt(), scan.next(), scan.next(),scan.next(), scan.next(), scan.next());
    	
    	System.out.println("Enter the id, name, age, salary, depname, gender, address");
    	Employee emp = new Employee(scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(), add);
    	
    	Connection con = null;
    	PreparedStatement ps1 = null;
    	PreparedStatement ps2 = null;
    	
    	String dpath = "com.mysql.cj.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";
    	
    	String sql1 = "insert into employee2 values(?,?,?,?,?,?,?)";
    	String sql2 = "insert into ademployee values(?,?,?,?,?,?,?)";
    	
    	try {
    		
    		Class.forName(dpath);
    		con = DriverManager.getConnection(url);
    		ps1 = con.prepareStatement(sql1);
    		ps2 = con.prepareStatement(sql2);
    		
    		ps1.setInt(1, emp.getId());
    		ps1.setString(2, emp.getName());
    		ps1.setInt(3, emp.getAge());
    		ps1.setInt(4, emp.getSalary());
    		ps1.setString(5, emp.getDepname());
    		ps1.setString(6, emp.getGender());
    		ps1.setInt(7, add.getAid());
    		
    		ps2.setInt(1, add.getAid());
    		ps2.setInt(2, add.getHouseno());
    		ps2.setString(3, add.getLandmark());
    		ps2.setString(4, add.getLocation());
    		ps2.setString(5, add.getState());
    		ps2.setString(6, add.getCity());
    		ps2.setString(7, add.getCountry());
    		
    		int res1 = ps2.executeUpdate();
    		int res2 = ps1.executeUpdate();
    		
    		System.out.println(res1 + res2 + "Row(s) Affected");
			
		} catch (Exception e) {
		     e.printStackTrace();
		}  finally {
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
