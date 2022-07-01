package com.springbootproject.Springboot.tutorial.service;

import com.springbootproject.Springboot.tutorial.entity.Department;
import com.springbootproject.Springboot.tutorial.error.DepartmentNotFoundException;
import com.springbootproject.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        //Método de la librería JpaRepository
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException{
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();

        if (department!=null && !department.getDepartmentName().isEmpty()){
            department1.setDepartmentName(department.getDepartmentName());
        }

        if (department!=null && !department.getDepartmentAddress().isEmpty()){
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (department!=null && !department.getDepartmentCode().isEmpty()){
            department1.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(department1);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
