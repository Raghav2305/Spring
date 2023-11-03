package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.entity.Department;
import com.raghav.Springbootdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartments();


     Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException;

    void deleteDepartment(Long departmentID);

    Department updateDepartmentByID(Long departmentID, Department department) throws DepartmentNotFoundException;

    Department fetchDepartmentByName(String departmentName);

    Department fetchDepartmentByAddress(String address);
}
