/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwt.model.JwtUser;
import jwt.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

    public TokenController(final JwtGenerator jwtGenerator) {
        super();
        this.jwtGenerator = jwtGenerator;
    }

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping(produces = "application/json")
    public String generate(@RequestBody final JwtUser jwtUser) {

        System.out.println("INSIDE GENERATE METHOD OF TOKEN CONTROLLER");
        System.out.println(jwtUser.getUserName());
        return this.jwtGenerator.generate(jwtUser);
    }

}
