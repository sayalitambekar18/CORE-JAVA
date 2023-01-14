package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadRecord1 {

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement stat = con.createStatement();
			
			String sql = "select * from employees";
			
			ResultSet re = stat.executeQuery(sql);
			
			while(re.next()) { 
                System.out.println("Name: " + re.getString("EmpName"));
				System.out.println("Number: " + re.getInt("empNo"));
				System.out.println("Street: " + re.getInt("street"));
				System.out.println("City : " + re.getInt("city"));
				System.out.println("State: " + re.getDouble("state"));
				System.out.println("Code: " + re.getInt("code"));

			}
			
			con.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}

}
