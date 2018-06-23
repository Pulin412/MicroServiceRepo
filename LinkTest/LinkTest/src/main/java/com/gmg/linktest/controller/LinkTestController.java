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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmg.linktest.model.DashBoardDTO;
import com.gmg.linktest.model.MessageDTO;
import com.gmg.linktest.service.LinkTestService;
import com.gmg.linktest.util.ConfigProperties;

/**
 * <p>
 * Link Test controller
 * </p>
 */
@Controller
public class LinkTestController {

    @Autowired
    private LinkTestService linkTestService;

    @Autowired
    private ConfigProperties configProperties;

    // @Value("${dashboard.origService}")
    // private String origService;
    //
    // @Value("${dashboard.mqsLinkStatus}")
    // private String mqsLinkStatus;
    //
    // @Value("${dashboard.sendQueueNamePattern}")
    // private String sendQueueNamePattern;
    //
    // @Value("${dashboard.recieveQueueNamePattern}")
    // private String recieveQueueNamePattern;

    private DashBoardDTO dashboardDTO;

    @RequestMapping(method = RequestMethod.GET, value = "/linkTest")
    public String welcome(final ModelMap model) {

        System.out.println("In welcome GET method " + this.configProperties.getOrigService());
        this.dashboardDTO = new DashBoardDTO();

        // this.dashboardDTO.setLinkMessageMap(this.linkTestService.createDashBoardDTO(this.configProperties.getOrigService()));
        // this.dashboardDTO.setMqsLinkDTOList(this.linkTestService.findBymqsLinkStatus(this.configProperties.getMqsLinkStatus()));
        this.dashboardDTO = this.linkTestService.findMessagesInReadyQueue(this.configProperties.getQueueNamePattern().get("send"),
            this.dashboardDTO);

        DashBoardDTO recieveDashoardDTO = new DashBoardDTO();
        recieveDashoardDTO = this.linkTestService
            .findMessagesInReadyQueue(this.configProperties.getQueueNamePattern().get("recieve"), recieveDashoardDTO);

        model.addAttribute("senddashboardDTO", this.dashboardDTO);
        model.addAttribute("recievedashboardDTO", recieveDashoardDTO);
        if (this.dashboardDTO.getDashBoardDTOList() == null || this.dashboardDTO.getDashBoardDTOList().size() != 0) {
            model.addAttribute("senddashBoardEmpty", "No Messages on any link(s) currently");
        }
        if (recieveDashoardDTO.getDashBoardDTOList() == null || recieveDashoardDTO.getDashBoardDTOList().size() != 0) {
            model.addAttribute("recievedashBoardEmpty", "No Messages on any link(s) currently");
        }
        // model.addAttribute("dashBoardDTOForLinkcount",
        // this.dashboardDTO.getMqsLinkDTOList().size());
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/linkTest/findByLinkId")
    public String findEmpByName(final ModelMap model) {

        System.out.println("In findByLinkId GET method");
        return "findByLinkId";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/linkTest/findByLinkId")
    public String findByOrigLink(final ModelMap model, @RequestParam final String origLinkId) {

        System.out.println("In findByOrigLink method");
        List<MessageDTO> messageDTOList = this.linkTestService.findByorigLinkId(origLinkId);
        model.addAttribute("messageDTOList", messageDTOList);
        model.addAttribute("messagesCount", messageDTOList.size());
        return "findByLinkId";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/linkTest/findByorigService")
    public String findByorigService(final ModelMap model) {

        System.out.println("In findByorigService GET method");
        return "findByorigService";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/linkTest/findByorigService")
    public String findByorigService(final ModelMap model, @RequestParam final String origService) {

        System.out.println("In findByorigService method");
        List<MessageDTO> messageDTOList = this.linkTestService.findByorigService(origService);
        model.addAttribute("messageDTOList", messageDTOList);
        model.addAttribute("messagesCount", messageDTOList.size());
        return "findByorigService";
    }

    // @RequestMapping(method = RequestMethod.GET, value =
    // "/linkTest/getReadyQueueStatus")
    // public String getReadyQueueStatus(final ModelMap model) {
    //
    // System.out.println("In getReadyQueueStatus GET method");
    // List<ReadyQueueCountDTO> readyQueueCountList =
    // this.linkTestService.findMessagesInReadyQueue(this.sendQueueNamePattern);
    // model.addAttribute("readyQueueCountList", readyQueueCountList);
    // return "welcome";
    // }
}
