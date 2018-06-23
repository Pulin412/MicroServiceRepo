/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.accounts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class AccountsController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;


    @Value("${employeeManagementApp}")
    private String employeeSearchServiceId;

    /*
     * @GetMapping("/welcome") public String showWelcomePage() {
     *
     * return "welcome"; }
     */

    @RequestMapping(method = RequestMethod.GET, value = "/employeesData")
    public String getEmployeesFromEmpService(final ModelMap model) {

        System.out.println("inside getEmployeesFromEmpService in accounts service");
        Application application = this.eurekaClient.getApplication(this.employeeSearchServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);

        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "empRest" + "/" + "getAllEmployees";
        System.out.println("URL - " + url);

        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // List<EmployeeDTO> employees = this.restTemplate.getForObject(url,
        // List.class);

        ResponseEntity<String> employees = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("response = " + employees);
        model.addAttribute("employeesList", employees);
        return "wel";
    }
}
