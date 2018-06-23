/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.empmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.model.EmployeeDTO;
import com.empmanagement.service.EmpManagementService;

@RestController
@RequestMapping("/empRest")
public class EmpManageRestController {


    @Autowired
    private EmpManagementService empService;

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees() {

        return this.empService.getAllEmployees();
    }

    @RequestMapping(value = "/addEmployee", produces = {"application/json"}, method = RequestMethod.POST, consumes = {
        "application/x-www-form-urlencoded"})
    public EmployeeDTO addEmployee(@Valid final EmployeeDTO empDto) {
        System.out.println("inside add employee method of rest controller");
        System.out.println(empDto.getEmpId());
        System.out.println(empDto.getEmpName());
        return this.empService.saveEmployeeData(empDto);
    }

    @GetMapping("/get/{EmpId}")
    public EmployeeDTO getSingleEmployee(@PathVariable(value = "EmpId") final int empId) {
        return this.empService.getSingleEmployee(empId);
    }

    @PutMapping("/update/{EmpId}")
    public EmployeeDTO updateEmployee(@PathVariable(value = "EmpId") final int empId,
        @Valid @RequestBody final EmployeeDTO empDto) {
        return this.empService.updateEmployee(empId, empDto);
    }

    @DeleteMapping("/delete/{EmpId}")
    public Boolean deleteEmployee(@PathVariable(value = "EmpId") final int empId) {

        System.out.println("Inside delete Employee method of Rest controller");
        if (this.empService.deleteEmployee(empId)) {
            return true;
        } else {
            return false;
        }
    }
}
