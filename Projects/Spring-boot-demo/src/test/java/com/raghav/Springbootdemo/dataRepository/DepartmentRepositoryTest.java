package com.raghav.Springbootdemo.dataRepository;

import com.raghav.Springbootdemo.entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical")
                .departmentAddress("Chennai")
                .departmentCode("ME-03")
                .build();

        entityManager.persist(department);
    }
    @Test
    public void ReturnDepartmentUponValidId(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals("Mechanical", department.getDepartmentName());

    }
}