package com.db.employee;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Mailinglist {

	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("Welcome to Employee details Application");
			System.out.println("1. Display All Records");
			System.out.println("2. Insert New Record");
			System.out.println("3. Update Record");
			System.out.println("4. Delete Record");
			System.out.println("5. Search Record");
			System.out.println("0. Exit");
			
			System.out.print("Enter Your Choice: ");
			int choice = s.nextInt();
			
			if(choice == 0)
				break;
			
			EmployeeDao ed = new EmployeeDao();
			String empName = null;
			int empNo = 0;
			String street = null;
			String city = null;
			String state = null;
			int code = 0;
			
			switch(choice) {			
			case 1: List<EmpAddress> emps = ed.getDetails();
					Iterator<EmpAddress> itr = emps.iterator();
					
					while (itr.hasNext()){
				    	System.out.println(itr.next());
				   }
							
					break;
					
			case 2: System.out.print("Enter the Name: ");
					empName = s.next();
					System.out.print("Enter the Number: ");
					empNo = s.nextInt();
					System.out.print("Enter the Street: ");
					street = s.next();
					System.out.print("Enter the City: ");
					city = s.next();
					System.out.print("Enter the State: ");
					state = s.next();
					System.out.print("Enter the Code: ");
					code = s.nextInt();
					
				 boolean b = ed.insertRecord(empName,empNo,street,city,state,code);
					if(b) {
						System.out.println("Record Inserted Succesfully");
					}
					break;
					
			case 3: System.out.print("Enter the name of the employees whose records is to be updated: ");
					empName = s.next();
					EmpAddress emp = ed.searchRecord(empName);
					System.out.println("What do you want to update?");
					System.out.println("a. Name");
					System.out.println("b. Number");
					System.out.println("c. Street");
					System.out.println("d. city");
					System.out.println("e. State");
					System.out.println("f. Code");
					
					char ch = s.next().charAt(0);
					
					switch(ch) {
					case 'a': System.out.print("Enter New Name: ");
							  empName = s.next();
							  emp.setEmpName(empName);
							  break;
					case 'b': System.out.print("Enter New Number: ");
							  empNo = s.nextInt();
							  emp.setEmpNo(empNo);
							  break;
					case 'c': System.out.print("Enter New Street: ");
					  		  street = s.next();
					  		  emp.setStreet(street);
					  		  break;
					case 'd': System.out.print("Enter New City: ");
			  		          city = s.next();
			  		          emp.setCity(city);
			  		          break;
					case 'e': System.out.print("Enter New State: ");
			  		          state = s.next();
			  		          emp.setState(state);
			  		          break;
					case 'f': System.out.print("Enter New Code: ");
			  		          code = s.nextInt();
			  		          emp.setCode(code);
			  		          break;
					}
					
					b = ed.updateRecord(emp);
					if(b) {
						System.out.println("Record has been Updated");
					}
					break;
					
			case 4: System.out.print("Enter the name of employees whose records is to be deleted: ");
					empName = s.next();
					b = ed.deleteRecord(empName);
					if(b) {
						System.out.println("Record has been Deleted");
					}
					break;
			case 5: System.out.print("Enter the name of the employees whose records is to be searched: ");
					empName = s.next();
					emp = ed.searchRecord(empName);	
					System.out.println(emp);
					break;
					
			default: System.out.println("Enter Correct Choice");
			}
		}	
	}
}
