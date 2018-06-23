package com.empmanagement.test.DAO;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.empmanagement.DAO.EmployeeDAO;
import com.empmanagement.model.EmployeeDTO;

// @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot
// test features and JUnit.
// Whenever we are using any Spring Boot testing features in our JUnit tests,
// this annotation will be required.
// @DataJpaTest provides some standard setup needed for testing the persistence
// layer:
// •configuring H2,
// •setting Hibernate, Spring Data, and the DataSource
// •performing an @EntityScan
// •turning on SQL logging
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeDAOTest {

    // The TestEntityManager provided by Spring Boot is an alternative to the
    // standard JPA EntityManager that provides methods commonly used when
    // writing tests.
    @Autowired
    private TestEntityManager testentityManager;

    @Autowired
    private EmployeeDAO empDAO;

    @SuppressWarnings("deprecation")
    @Test
    public void findByName_positive() {

        // add employee first
        EmployeeDTO emp1 = new EmployeeDTO(1, "dummy1", 30, 12212, "dummyDept1", "dummyRole1");
        this.testentityManager.persist(emp1);
        this.testentityManager.flush();

        // call the DAO
        List<EmployeeDTO> checkEmp = this.empDAO.findByempName(emp1.getEmpName());

        // check
        Assert.assertNotNull(checkEmp);
    }

}
