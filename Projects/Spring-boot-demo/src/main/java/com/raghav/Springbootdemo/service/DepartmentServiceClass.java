package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.dataRepository.DepartmentRepository;
import com.raghav.Springbootdemo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void deleteDepartment(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartmentByID(Long departmentID, Department department) {
        Department existingDepartment = departmentRepository.findById(departmentID).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            existingDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            existingDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            existingDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(existingDepartment);
    }
}
