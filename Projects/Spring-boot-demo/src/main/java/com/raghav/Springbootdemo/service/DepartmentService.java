package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.entity.Department;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartments();


    public Department fetchDepartmentByID(Long departmentID);
}
