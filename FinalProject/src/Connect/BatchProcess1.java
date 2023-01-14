package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcess1 {

	public static void main(String[] args) {

		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			String url = "jdbc:mysql://localhost:3306/employee";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement stat = con.createStatement();
			
			con.setAutoCommit(false);
			
			stat.addBatch("insert into employees(empName,street,city,state,code)values('kim','Alandi','Pune','Maharashtra',412109)");
			stat.addBatch("delete from employees where empName='kim'");
			stat.addBatch("update employees set empName='tom' where empNo=2");
			
			stat.executeBatch();
			
			con.commit();
			
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


