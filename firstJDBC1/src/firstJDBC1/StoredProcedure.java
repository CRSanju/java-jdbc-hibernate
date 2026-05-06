package firstJDBC1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class StoredProcedure {

	public static void main(String[] args) {

		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);

		String dpath = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/firstdb? user=root & password=Sanju024816$";
		String sql = "call getstudent(?)";

		try {

			Class.forName(dpath);
			con = DriverManager.getConnection(url);
			cs = con.prepareCall(sql);

			System.out.println("Enter marks to fetch the students above entered marks");
			int marks = scan.nextInt();
			cs.setInt(1, marks);

			boolean res = cs.execute();

			if (res == true) {
				rs = cs.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
				}
			} else {
				int nora = cs.getUpdateCount();
				System.out.println(nora + "Row(s) affected");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (cs != null)
					cs.close();
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
