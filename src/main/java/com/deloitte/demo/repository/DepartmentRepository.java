package com.deloitte.demo.repository;

import com.deloitte.demo.model.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DepartmentRepository {

    private EntityManagerFactory entityManagerFactory;

    public DepartmentRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePU");
    }

    public List<Department> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Department> departments = entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        entityManager.close();
        return departments;
    }

    public Department findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Department department = entityManager.find(Department.class, id);
        entityManager.close();
        return department;
    }

    public Department save(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
        entityManager.close();
        return department;
    }

    public Department update(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        department = entityManager.merge(department);
        entityManager.getTransaction().commit();
        entityManager.close();
        return department;
    }

    public boolean deleteById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Department department = entityManager.find(Department.class, id);
        if (department != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(department);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.close();
        return false;
    }
}
