/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.empmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.DAO.EmployeeDAO;
import com.empmanagement.model.EmployeeDTO;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
@Service
public class EmpManagementService {

    @Autowired
    EmployeeDAO empDao;

    public EmployeeDTO saveEmployeeData(final EmployeeDTO employee) {

        return this.empDao.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {

        return this.empDao.findAll();
    }

    public EmployeeDTO getSingleEmployee(final int id) {

        return this.empDao.findOne(id);
    }

    public EmployeeDTO updateEmployee(final int id, final EmployeeDTO employee) {

        EmployeeDTO empDtoLocal = this.empDao.findOne(id);
        empDtoLocal.setEmpAge(employee.getEmpAge());
        empDtoLocal.setEmpDepartment(employee.getEmpDepartment());
        empDtoLocal.setEmpName(employee.getEmpName());
        empDtoLocal.setEmpRole(employee.getEmpRole());
        empDtoLocal.setEmpSalary(employee.getEmpSalary());

        EmployeeDTO empDtoFinal = this.empDao.save(empDtoLocal);
        return empDtoFinal;
    }

    public boolean deleteEmployee(final int id) {

        EmployeeDTO empDTO = this.empDao.findOne(id);
        this.empDao.delete(empDTO);
        return true;
    }

    public List<EmployeeDTO> findbyName(final String name) {

        return this.empDao.findByempName(name);
    }

}
