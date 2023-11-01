package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartments();


     Department fetchDepartmentByID(Long departmentID);

    void deleteDepartment(Long departmentID);

    Department updateDepartmentByID(Long departmentID, Department department);
}
