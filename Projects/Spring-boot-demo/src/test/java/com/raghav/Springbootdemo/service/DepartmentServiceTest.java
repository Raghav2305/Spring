package com.raghav.Springbootdemo.service;

import com.raghav.Springbootdemo.dataRepository.DepartmentRepository;
import com.raghav.Springbootdemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentID(1L)
                .departmentName("CSE")
                .departmentAddress("Bangalore")
                .departmentCode("CSE-06")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase(("CSE"))).thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on valid department names")
    public void UponValidDepartmentNameFindDepartment(){
        String departmentName = "CSE";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        System.out.println(found.getDepartmentName());
        assertEquals(found.getDepartmentName(), departmentName);

    }
}