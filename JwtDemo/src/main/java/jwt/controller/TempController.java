///*
// * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
// *
// * This software is only to be used for the purpose for which it has been
// * provided. No part of it is to be reproduced, disassembled, transmitted,
// * stored in a retrieval system nor translated in any human or computer
// * language in any way or for any other purposes whatsoever without the prior
// * written consent of HSBC Holdings plc.
// */
//package jwt.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.client.RestTemplate;
//
//import jwt.model.JwtUser;
//
//@Controller
//public class TempController {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @RequestMapping(value = "/issue", method = RequestMethod.GET)
//    public String issue() {
//
//        System.out.println("INSIDE ISSUE METHOD OF TEMP CONTROLLER");
//        JwtUser user = new JwtUser();
//        user.setId(123L);
//        user.setUserName("Pulin");
//        user.setRole("admin");
//
//        String uri = new String("http://localhost:8084/token/");
//        System.out.println("URL -" + uri);
//        JwtUser response = this.restTemplate.postForObject(uri, user, JwtUser.class);
//
//
//        System.out.println("OUTPUT - ");
//        System.out.println(response);
//
//
//        return "token";
//    }
//
//}
