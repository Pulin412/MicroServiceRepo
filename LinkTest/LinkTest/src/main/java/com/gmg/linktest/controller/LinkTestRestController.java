/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.gmg.linktest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmg.linktest.model.MessageDTO;
import com.gmg.linktest.service.LinkTestService;

/**
 * <p>
 * Link Test controller
 * </p>
 */
@RestController
public class LinkTestRestController {

    @Autowired
    private LinkTestService linkTestService;

    @GetMapping("/getLinksData")
    public List<MessageDTO> getLinksData() {

        System.out.println("inside getLinksData method");
        return this.linkTestService.getLinksData();
    }


}
