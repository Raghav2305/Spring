package com.raghav.Springbootdemo.controller;

import com.raghav.Springbootdemo.entity.Department;
import com.raghav.Springbootdemo.error.DepartmentNotFoundException;
import com.raghav.Springbootdemo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside the SaveDepartment method of DepartmentController");
       return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("Inside the fetchDepartments method of DepartmentController");
        return departmentService.fetchDepartments();

    }@GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        LOGGER.info("Inside the fetchDepartmentByID method of DepartmentController");
        return departmentService.fetchDepartmentByID(departmentID);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentID){
        departmentService.deleteDepartment(departmentID);
        LOGGER.info("Inside the deleteDepartment method of DepartmentController");
        return "Department deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentByID(@PathVariable("id") Long departmentID, @RequestBody Department department) throws DepartmentNotFoundException{
        LOGGER.info("Inside the updateDepartmentByID method of DepartmentController");
        return departmentService.updateDepartmentByID(departmentID, department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside the fetchDepartmentByName method of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
    @GetMapping("/departments/address/{address}")
    public Department fetchDepartmentByAddress(@PathVariable("address") String address){
        LOGGER.info("Inside the fetchDepartmentByAddress method of DepartmentController");
        return departmentService.fetchDepartmentByAddress(address);
    }


}
