package Connect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableProcedure1 {

	public static void main(String[] args) {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url,username,password);
			
			CallableStatement cs = 
			con.prepareCall("{call insertproc(?,?,?,?,?,?)}");
			cs.setString(1, "king");
			cs.setInt(2, 17);
			cs.setDouble(3, 90.35);
			
			cs.execute();
			
			con.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
	