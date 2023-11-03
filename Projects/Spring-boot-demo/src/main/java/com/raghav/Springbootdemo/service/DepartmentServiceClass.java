package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.dataRepository.DepartmentRepository;
import com.raghav.Springbootdemo.entity.Department;
import com.raghav.Springbootdemo.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Department fetchDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(departmentID);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartmentByID(Long departmentID, Department department) throws DepartmentNotFoundException {

        Optional<Department> existingDepartment = departmentRepository.findById(departmentID);

        if(!existingDepartment.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            existingDepartment.get().setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            existingDepartment.get().setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            existingDepartment.get().setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(existingDepartment.get());
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department fetchDepartmentByAddress(String address) {
        return departmentRepository.findByDepartmentAddressIgnoreCase(address);
    }
}
