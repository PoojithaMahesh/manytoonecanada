package manytoonecanada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoonecanada.dto.Company;
import manytoonecanada.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void saveEmployee(Employee employee,int companyId) {
		EntityManager  entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that company is present then i can add this employee
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			employee.setCompany(dbCompany);
			entityManager.persist(employee);
			entityTransaction.commit();
		}else {
//			that company is not present
			System.out.println("Sorry that company is not present");
		}
	}
	
	public void updateEMployee(int employeeId,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, employeeId);
		
		if(dbEmployee!=null) {
//			that emp is present so i can update the data
			
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			employee.setId(employeeId);
			
			employee.setCompany(dbEmployee.getCompany());
			
			entityManager.merge(employee);
			
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present");
		}
		
	}
	public void findEMployee(int employeeId) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, employeeId);
		
		if(dbEmployee!=null) {
//			that emp is present so i can update the data
			
			System.out.println(dbEmployee);
		}else {
			System.out.println("Sorry id is not present");
		}
		
	}
	public void deleteEMployee(int employeeId) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, employeeId);
		
		if(dbEmployee!=null) {
//			that emp is present so i can update the data
			
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
		
			entityManager.remove(dbEmployee);
			
			entityTransaction.commit();
			
		}else {
			System.out.println("Sorry id is not present");
		}
		
	}
	
}
