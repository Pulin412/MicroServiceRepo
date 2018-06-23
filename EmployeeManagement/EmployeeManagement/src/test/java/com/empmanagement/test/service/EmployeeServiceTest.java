package com.empmanagement.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.empmanagement.DAO.EmployeeDAO;
import com.empmanagement.model.EmployeeDTO;
import com.empmanagement.service.EmpManagementService;


@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    // To check the Service class, we need to have an instance of Service class
    // created and available as a @Bean so that we can @Autowire it in our test
    // class. This configuration is achieved by using the @TestConfiguration
    // annotation.

    // During component scanning, we might find components or configurations
    // created only for specific tests accidentally get picked up everywhere.
    // To help prevent that, Spring Boot provides @TestConfiguration annotation
    // that can be used on classes in src/test/java to indicate that they
    // should not be picked up by scanning.

    @TestConfiguration
    static class EmployeeServiceTestContextConfig {

        @Bean
        public EmpManagementService empManagementService() {
            return new EmpManagementService();
        }
    }

    @Autowired
    private EmpManagementService empManagementService;

    // @MockBean - It creates a Mock for the EmployeeRepository which can be
    // used to bypass the call to the actual EmployeeRepository
    @MockBean
    private EmployeeDAO empDAO;


    // create an Employee before the actual test
    @Before
    public void setUp() {
        EmployeeDTO emp1 = new EmployeeDTO(1, "dummy1", 30, 12212, "dummyDept1", "dummyRole1");
        List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
        empList.add(emp1);

        // Mockito.when(this.empDAO.findByempName(emp1.getEmpName())).thenReturn(empList);
    }

    @Test
    public void whenValidName_EmpShouldBeFound() {

        String name = "dummy1";
        List<EmployeeDTO> empList = this.empManagementService.findbyName(name);

        Assert.assertNotNull(empList);
    }

}
