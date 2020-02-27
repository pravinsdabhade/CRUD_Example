package com.example.crudexample.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudexample.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Autowired
	private EntityManager em;

	@Override
	public List<Employee> getAllEmployees() {
		Session currentSession = em.unwrap(Session.class);
		Query<Employee> createQuery = currentSession.createQuery("from Employee", Employee.class);
		return createQuery.getResultList();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Session currentSession = em.unwrap(Session.class);
		return currentSession.get(Employee.class, empId);
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = em.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(Integer empId) {
		Session currentSession = em.unwrap(Session.class);
		Query createQuery = currentSession.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		createQuery.setParameter("employeeId", empId);
		int deletedRowCount = createQuery.executeUpdate();
		System.out.println("Total " + deletedRowCount + " record deleted...");
	}

}
