package com.empmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.model.EmployeeDTO;
import com.empmanagement.service.EmpManagementService;

@Controller
public class EmpManageController {

    @Autowired
    EmpManagementService empService;

    RestTemplate restTemplate = new RestTemplate();
    String url = "";

    @RequestMapping(method = RequestMethod.GET, value = "/getAllEmployees")
    public String getAllEmployees(final ModelMap model) {

        System.out.println("In getAllEmployees method of EmpManageController Controller");
        // call rest service to get all employees
        this.url = "http://localhost:2222/empRest/getAllEmployees";
        List<EmployeeDTO> employees = this.restTemplate.getForObject(this.url, List.class);
        model.addAttribute("employeesList", employees);
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addEmp")
    public String getEmpManage(final ModelMap model) {

        System.out.println("In getEmpManage method of EmpManageController Controller");
        return "addEmp";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome1")
    public String welcomePage(final ModelMap model) {

        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEmp")
    public String postEmpManage(final ModelMap model, @Valid final EmployeeDTO empDto) {

        System.out.println("In postEmpManage method of EmpManageController Controller");
        this.url = "http://localhost:2222/empRest/addEmployee";
        HttpEntity<EmployeeDTO> employeeEntity = new HttpEntity<EmployeeDTO>(empDto);

        EmployeeDTO employee = this.empService.saveEmployeeData(empDto);
        if (employee != null) {
            model.put("welcomeerrormessage", "Employee Added Successfully..");
        } else {
            model.put("welcomeerrormessage", "Error in adding Employee..");
        }
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateEmp/{empId}/")
    public String updateEmployeeGet(final ModelMap model, @PathVariable final String empId) {

        System.out.println("In updateEmployeeGet method of EmpManageController Controller");
        this.url = "http://localhost:2222/empRest/get/" + empId + "/";
        EmployeeDTO employees = this.restTemplate.getForObject(this.url, EmployeeDTO.class);
        System.out.println(employees.getEmpName());
        model.addAttribute("empName", employees.getEmpName());
        model.addAttribute("empAge", employees.getEmpAge());
        model.addAttribute("empSalary", employees.getEmpSalary());
        model.addAttribute("empDepartment", employees.getEmpDepartment());
        model.addAttribute("empRole", employees.getEmpRole());
        return "updateEmp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateEmp")
    public String updateEmployee(final ModelMap model, final EmployeeDTO empDto) {

        System.out.println("In updateEmployee post method of EmpManageController Controller");

        if (this.empService.updateEmployee(empDto.getEmpId(), empDto) != null) {
            model.addAttribute("welcomeerrormessage", "Employee updated successfully");
        } else {
            model.addAttribute("welcomeerrormessage", "Some error occured..");
        }

        return "welcome";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/delEmp")
    public String getEmpDelete(final ModelMap model) {

        System.out.println("In getEmpDelete method of EmpManageController Controller");
        // call rest service to get all employees
        this.url = "http://localhost:2222/empRest/getAllEmployees";
        List<EmployeeDTO> employees = this.restTemplate.getForObject(this.url, List.class);
        model.put("employeesList", employees);
        return "deleteEmp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delEmp/{empId}/")
    public String deleteEmployee(final ModelMap model, @PathVariable final int empId, final RedirectAttributes redirAtt) {

        System.out.println("delete Employee in controller - emp id - " + empId);

        // calling rest service to delete empid
        this.url = "http://localhost:2222/empRest/delete/" + empId;
        this.restTemplate.delete(this.url);
        redirAtt.addFlashAttribute("welcomeerrormessage", "Employee Deleted Successfully..");
        return "redirect:/welcome1";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByName")
    public String findEmpByName(final ModelMap model) {

        System.out.println("In findEmpByName method of EmpManageController Controller");
        return "findByName";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/findByName")
    public String findEmpByNamePost(final ModelMap model, @RequestParam final String empName) {

        System.out.println("In findEmpByNamePost method of EmpManageController Controller");
        List<EmployeeDTO> empList = this.empService.findbyName(empName);
        model.addAttribute("employeesList", empList);
        return "findByName";
    }


}
