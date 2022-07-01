package com.springbootproject.Springboot.tutorial.service;

import com.springbootproject.Springboot.tutorial.entity.Department;
import com.springbootproject.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartment(Long departmentId, Department department);
    public Department fetchDepartmentByName(String departmentName);
}
