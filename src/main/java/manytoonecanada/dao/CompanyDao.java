package manytoonecanada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoonecanada.dto.Company;

public class CompanyDao {
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void saveCompany(Company company) {
		EntityManager  entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int companyId,Company company) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that company is present so i vcan update the data
			EntityTransaction  entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			company.setId(companyId);
			
			entityManager.merge(company);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void findCompany(int companyId) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that company is present so i vcan find the data
			System.out.println(dbCompany);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	public void deleteCompany(int companyId) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			that company is present so i vcan find the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
}
