/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.accounts.model;

public class EmployeeDTO {

    public int empId;
    public String empName;
    public int empAge;
    public double empSalary;
    public String empDepartment;
    public String empRole;

    public EmployeeDTO() {

    }

    public EmployeeDTO(final int empId, final String empName, final int empAge, final double empSalary, final String empDepartment,
        final String empRole) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empSalary = empSalary;
        this.empDepartment = empDepartment;
        this.empRole = empRole;
    }

    /**
     * @return the empId
     */
    public int getEmpId() {
        return this.empId;
    }

    /**
     * @param empId
     *            the empId to set
     */
    public void setEmpId(final int empId) {
        this.empId = empId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return this.empName;
    }

    /**
     * @param empName
     *            the empName to set
     */
    public void setEmpName(final String empName) {
        this.empName = empName;
    }

    /**
     * @return the empAge
     */
    public int getEmpAge() {
        return this.empAge;
    }

    /**
     * @param empAge
     *            the empAge to set
     */
    public void setEmpAge(final int empAge) {
        this.empAge = empAge;
    }

    /**
     * @return the empSalary
     */
    public double getEmpSalary() {
        return this.empSalary;
    }

    /**
     * @param empSalary
     *            the empSalary to set
     */
    public void setEmpSalary(final double empSalary) {
        this.empSalary = empSalary;
    }

    /**
     * @return the empDepartment
     */
    public String getEmpDepartment() {
        return this.empDepartment;
    }

    /**
     * @param empDepartment
     *            the empDepartment to set
     */
    public void setEmpDepartment(final String empDepartment) {
        this.empDepartment = empDepartment;
    }

    /**
     * @return the empRole
     */
    public String getEmpRole() {
        return this.empRole;
    }

    /**
     * @param empRole
     *            the empRole to set
     */
    public void setEmpRole(final String empRole) {
        this.empRole = empRole;
    }


}
