package com.deloitte.demo.service;

import com.deloitte.demo.model.Department;
import com.deloitte.demo.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepository = new DepartmentRepository();

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(id);
        if (existingDepartment != null) {
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setLocation(updatedDepartment.getLocation());
            return departmentRepository.update(existingDepartment);
        }
        return null;
    }

    public boolean deleteDepartment(int id) {
        return departmentRepository.deleteById(id);
    }
}
