package com.deloitte.demo.repository;

import com.deloitte.demo.model.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeRepository {

    private EntityManagerFactory entityManagerFactory;

    public EmployeeRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePU");
    }

   
    public List<Employee> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        entityManager.close();
        return employees;
    }

   
    public Employee findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }

    
    public Employee save(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    
    public Employee update(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        employee = entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    
    public boolean deleteById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.close();
        return false;
    }
}
