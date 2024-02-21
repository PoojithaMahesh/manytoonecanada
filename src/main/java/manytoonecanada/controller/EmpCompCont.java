package manytoonecanada.controller;

import manytoonecanada.dao.CompanyDao;
import manytoonecanada.dao.EmployeeDao;
import manytoonecanada.dto.Company;
import manytoonecanada.dto.Employee;

public class EmpCompCont {
public static void main(String[] args) {
//	Company company=new Company();
//	company.setId(1000);
//	company.setName("TYS");
//	company.setGst("ty@123");
//	
//	CompanyDao companyDao=new CompanyDao();
//	companyDao.saveCompany(company);
//	Employee employee=new Employee();
//	employee.setId(1);
//	employee.setName("David");
//	employee.setAddress("canada");
//	 
//	EmployeeDao employeeDao=new EmployeeDao();
//	employeeDao.saveEmployee(employee, 1000);
	
	
	Company company=new Company();
	
	company.setName("TY");
	company.setGst("ty@abc");
	
	CompanyDao companyDao=new CompanyDao();
//	companyDao.updateCompany(1000, company);
//	
//	Employee employee=new Employee();
//	employee.setName("DavidC");
//	employee.setAddress("Can");
	EmployeeDao employeeDao=new EmployeeDao();
//	employeeDao.updateEMployee(1, employee);
//	
	companyDao.deleteCompany(1000);
	
//	employeeDao.deleteEMployee(1);
	
	
}
}
