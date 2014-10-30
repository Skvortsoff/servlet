package com.academysmart.repository;

import java.util.ArrayList;
import java.util.List;

import com.academysmart.exception.IncorrectEmailException;
import com.academysmart.exception.ServletException;
import com.academysmart.model.Employee;
import sun.invoke.empty.Empty;

public class EmployeeRepositorySingleton {
    private static EmployeeRepositorySingleton instance;
  List<Employee> employees = new ArrayList<Employee>();
private EmployeeRepositorySingleton(){}

	public static EmployeeRepositorySingleton getRepository() {
		//TODO implement method that returns repository instance
        if(instance == null) {
          instance=new  EmployeeRepositorySingleton();
        }
        return instance;
	}

	public void addEmployee(String fname, String lname, String email)
        //TODO implement method that adds an employee to repository
        //This method should check that email is not used by other employees
			throws ServletException {
        if (fname.trim().equals("") || lname.trim().equals("") || email.trim().equals("")){
            throw new ServletException("one or more fields empty");
        }
        if (!employees.isEmpty()){
            for(Employee mail: employees){
                if(mail.getEmail().equals(email)){
                    throw  new IncorrectEmailException("this E-MAIL used");
                }
            }
        }
Employee empl= new Employee();
                empl.setFname(fname);
                empl.setLname(lname);
                empl.setEmail(email);
                employees.add(empl);

	}

	public List<Employee> getAllEmployees() {

		//TODO implement method that returns list of all employees
		return employees;
	}
}
