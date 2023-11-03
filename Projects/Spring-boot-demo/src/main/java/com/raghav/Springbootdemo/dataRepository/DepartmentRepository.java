package com.raghav.Springbootdemo.dataRepository;

import com.raghav.Springbootdemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    public Department findByDepartmentAddressIgnoreCase(String departmentAddress);


}
