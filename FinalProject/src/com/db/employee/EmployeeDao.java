package com.db.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

		Connection con = DbConnect.getConnection();
	
		public List<EmpAddress> getDetails(){
			List<EmpAddress> eList = new ArrayList<EmpAddress>();
	        
			String sql = "select * from employees";
			
			try {
				Statement stat = con.createStatement();
				ResultSet re = stat.executeQuery(sql);
				
				while(re.next()) {
					EmpAddress e = new EmpAddress();
					e.setEmpName(re.getString("empName"));
					e.setEmpNo(re.getInt("empNo"));
					e.setStreet(re.getString("street"));
					e.setCity(re.getString("city"));
					e.setState(re.getString("state"));
					eList.add(e);
				}			
				return eList;
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			return null;
		}
		
		public boolean insertRecord(String empName, int empNo, String street, String city, String state, int code) {
			String sql = "insert into employees(empName,empNo,street,city,state,code)values(?,?,?,?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, empName);
				ps.setInt(2, empNo);
				ps.setString(3, street);
				ps.setString(4, city);
				ps.setString(5, state);
				ps.setInt(6, code);

				int i = ps.executeUpdate();
				
				if(i>0)
					return true;
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			return false;
		}
		
		public boolean deleteRecord(String empName) {
			String sql = "delete from employees where empName = ?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, empName);
				
				int i = ps.executeUpdate();
				
				if(i>0)
					return true;
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			return false;
		}
		
		public EmpAddress searchRecord(String empName) {	
			String sql = "select * from employees where empName = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, empName);
				
				ResultSet re = ps.executeQuery();
				EmpAddress e = new EmpAddress();
				if(re.next()) {
					e.setEmpName(re.getString("empName"));
					e.setEmpNo(re.getInt("empNo"));
					e.setStreet(re.getString("street"));
					e.setCity(re.getString("city"));
					e.setState(re.getString("state"));
					e.setCode(re.getInt("code"));

					return e;
				}				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}		
			return null;
		}
		
		public EmpAddress searchRecord(int empNo) {	
			String sql = "select * from employees where empNo = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(2, empNo);
				
				ResultSet re = ps.executeQuery();
				EmpAddress e = new EmpAddress();
				if(re.next()) {
					e.setEmpName(re.getString("empName"));
					e.setEmpNo(re.getInt("empNo"));
					e.setStreet(re.getString("street"));
					e.setCity(re.getString("city"));
					e.setState(re.getString("state"));
					e.setCode(re.getInt("code"));

					return e;
				}				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}		
			return null;
		}
	
		
		public boolean updateRecord(EmpAddress e) {
			String sql = "update employees set empName=?, empNo=?, street=?, city=?, state=?, code=? where empNo=?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, e.getEmpName());
				ps.setInt(2, e.getEmpNo());
				ps.setString(3, e.getStreet());
				ps.setString(4, e.getCity());
				ps.setString(5, e.getState());
				ps.setInt(6, e.getCode());
				ps.setInt(7, e.getEmpNo());
				
				int i = ps.executeUpdate();
				if(i>0)
					return true;
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			return false;
		}
	}
	

