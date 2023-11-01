package com.raghav.Springbootdemo.controller;

import com.raghav.Springbootdemo.entity.Department;
import com.raghav.Springbootdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
       return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        return departmentService.fetchDepartments();
    }@GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentID){
        return departmentService.fetchDepartmentByID(departmentID);
    }


}
