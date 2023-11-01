package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.dataRepository.DepartmentRepository;
import com.raghav.Springbootdemo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceClass implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentID) {
        return departmentRepository.findById(departmentID).get();
    }
}
