package com.deloitte.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deloitte.demo.model.Department;
import com.deloitte.demo.model.Employee;
import com.deloitte.demo.repository.DepartmentRepository;
import com.deloitte.demo.repository.EmployeeRepository;
public class EmployeeService {
	
	private EmployeeRepository employeeRepository = new EmployeeRepository();
	
	public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
    	
    	DepartmentRepository departmentRepository = new DepartmentRepository();
        if (employee.getDepartment() != null && employee.getDepartment().getId() != 0) {
            Department department = departmentRepository.findById(employee.getDepartment().getId());
            employee.setDepartment(department);  
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            
            DepartmentRepository departmentRepository = new DepartmentRepository();
            if (updatedEmployee.getDepartment() != null && updatedEmployee.getDepartment().getId() != 0) {
                Department department = departmentRepository.findById(updatedEmployee.getDepartment().getId());
                existingEmployee.setDepartment(department);
            }
            return employeeRepository.update(existingEmployee);
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteById(id);
    }


//	 private static List<Employee> empList = new ArrayList<>(Arrays.asList(
//		        new Employee(1, "Sonu", 90.25), 
//		        new Employee(2, "Monu", 95.75),
//		        new Employee(3, "Tonu", 92.25)
//		    ));

//	public List<Employee> getAllEmployees() {
//		empList.forEach(System.out::println);
//		return empList;
//	}
//	
//	public Employee getEmployeeById(int id) {
//	    for (Employee emp : empList) {
//	        if (emp.getId() == id) {
//	            return emp; 
//	        }
//	    }
//	    return null;
//	}
//	
//	public Employee addEmployee(Employee employee) {
//		
//		empList.add(employee);
//		return employee;
//	}
//	
//	
//	public boolean deleteEmployee(int id) {
//        return empList.removeIf(emp -> emp.getId() == id); 
//    }
//	
//	public Employee updateEmployee(int id, Employee updatedEmployee) {
//	    for (int i = 0; i < empList.size(); i++) {
//	        Employee emp = empList.get(i);
//	        if (emp.getId() == id) {
//	            
//	            emp.setFirstName(updatedEmployee.getFirstName());
//	           
//	            emp.setSalary(updatedEmployee.getSalary());
//	            
//	   
//	            if (emp.getId() != updatedEmployee.getId()) {
//	                emp.setId(updatedEmployee.getId());
//	            }
//	            
//	           
//	            empList.set(i, emp);
//	            return emp;
//	        }
//	    }
//	    return null; 
//	}
	
	

}