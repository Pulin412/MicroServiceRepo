package com.empmanagement.test.empRestController;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.empmanagement.controller.EmpManageRestController;
import com.empmanagement.model.EmployeeDTO;
import com.empmanagement.service.EmpManagementService;

// To test the Controllers, we can use @WebMvcTest. It will auto-configure the
// Spring MVC infrastructure for our unit tests.
@RunWith(SpringRunner.class)
@WebMvcTest(EmpManageRestController.class)
public class EmployeeRestControllerTest {

    @Autowired
    private MockMvc mvc;

    // In most of the cases, @WebMvcTest will be limited to bootstrap a single
    // controller. It is used along with @MockBean to provide mock
    // implementations for required dependencies.
    @MockBean
    private EmpManagementService empManagementService;

    @SuppressWarnings("deprecation")
    @Test
    public void givenEmployees_getAll_ReturnList() throws Exception {

        // add employee first
        EmployeeDTO emp1 = new EmployeeDTO(1, "dummy1", 30, 12212, "dummyDept1", "dummyRole1");
        List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
        empList.add(emp1);

        Mockito.when(this.empManagementService.getAllEmployees()).thenReturn(empList);
        String expected = "[{empId:1,empName:dummy1,empAge:30,empSalary:12212.0,empDepartment:dummyDept1,empRole:dummyRole1}]";

        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/empRest/getAllEmployees").accept(MediaType.ALL);
        MvcResult result = this.mvc.perform(reqBuilder).andReturn();

        System.out.println("result = " + result.getResponse());
        // Assert.assertEquals(expected,
        // result.getResponse().getContentAsString(), false);
    }

}
