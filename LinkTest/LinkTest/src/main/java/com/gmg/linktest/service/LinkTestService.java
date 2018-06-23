/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.gmg.linktest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmg.linktest.DAO.LinkHandlerDAO;
import com.gmg.linktest.DAO.LinkTestDAO;
import com.gmg.linktest.DAO.ScheduleTestDAO;
import com.gmg.linktest.model.DashBoardDTO;
import com.gmg.linktest.model.LinkHandlerQueueDTO;
import com.gmg.linktest.model.MessageDTO;
import com.gmg.linktest.model.MqsLinkOperationDTO;
import com.gmg.linktest.model.ReadyQueueCountDTO;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
@Service
public class LinkTestService {

    @Autowired
    private LinkTestDAO linkTestDAO;

    @Autowired
    private ScheduleTestDAO scheduleTestDAO;

    @Autowired
    private LinkHandlerDAO linkHandlerDAO;

    public List<MessageDTO> getLinksData() {

        return this.linkTestDAO.findAll();
    }

    public List<MessageDTO> findByorigLinkId(final String origLinkId) {

        return this.linkTestDAO.findByorigLinkId(origLinkId);
    }

    public List<MessageDTO> findByorigService(final String origService) {

        return this.linkTestDAO.findByorigService(origService);
    }


    public List<MessageDTO> findByorigServiceQuery(final String origService) {

        return this.linkTestDAO.findByorigServiceQuery(origService);
    }

    public Map<String, Integer> createDashBoardDTO(final String origService) {

        List<MessageDTO> messageDTOList = this.linkTestDAO.findByorigService(origService);
        // List<MqsLinkOperationDTO> mqsLinkOpsList =
        // this.scheduleTestDAO.findBymqsLinkStatus(mqsLinkStatus);
        Map<String, Integer> linkMessageMap = new HashMap<String, Integer>();
        Map<String, HashMap<String, String>> finalMap = new HashMap<String, HashMap<String, String>>();
        int count = 0;

        for (MessageDTO messageDTO : messageDTOList) {
            String currentOrigLinkId = messageDTO.getOrigLinkId();
            if (!linkMessageMap.containsKey(currentOrigLinkId)) {
                linkMessageMap.put(currentOrigLinkId, count++);
            } else {
                linkMessageMap.put(currentOrigLinkId, linkMessageMap.get(currentOrigLinkId) + 1);
            }
        }

        return linkMessageMap;
    }

    // schedule methods -
    public List<MqsLinkOperationDTO> findBymqsLinkStatus(final String mqsLinkStatus) {

        return this.scheduleTestDAO.findBymqsLinkStatus(mqsLinkStatus);
    }

    public List<MessageDTO> getReadyQueueStatus(final String queueName) {
        return this.linkTestDAO.getReadyQueueStatus(queueName);
    }

    public DashBoardDTO findMessagesInReadyQueue(final String queueName, final DashBoardDTO dashBoardDTO) {

        List<LinkHandlerQueueDTO> queuesInReadyStateList = this.linkHandlerDAO.findByqueueNameIgnoreCaseContaining(queueName);
        List<Integer> queuesList = new ArrayList<Integer>();
        HashMap<Integer, LinkHandlerQueueDTO> queueIdObjMap = new HashMap<Integer, LinkHandlerQueueDTO>();
        String linkName;
        List<DashBoardDTO> dashBoardDTOList = new ArrayList<DashBoardDTO>();
        DashBoardDTO tempDashDTO;

        for (LinkHandlerQueueDTO linkHandlerQueueDTO : queuesInReadyStateList) {
            queuesList.add(linkHandlerQueueDTO.getQueueId());
            queueIdObjMap.put(linkHandlerQueueDTO.getQueueId(), linkHandlerQueueDTO);
        }

        if (queuesInReadyStateList.size() > 0) {
            List<ReadyQueueCountDTO> readyQueueCountList = this.linkHandlerDAO.getCountOfMessagesInReadyQueue(queuesList);
            for (ReadyQueueCountDTO readyQueueCountDTO : readyQueueCountList) {
                tempDashDTO = new DashBoardDTO();
                String temp = queueIdObjMap.get(readyQueueCountDTO.getCurrentQueueId()).getQueueName();
                linkName = temp.substring(3, temp.indexOf("RDYQ"));
                tempDashDTO.setLinkName(linkName);
                tempDashDTO.setReadyQueueMessagesCount(readyQueueCountDTO.getCountOfMessages());
                tempDashDTO.setLinkDirection(queueIdObjMap.get(readyQueueCountDTO.getCurrentQueueId()).getQueueCategory());
                dashBoardDTOList.add(tempDashDTO);
            }
            dashBoardDTO.setDashBoardDTOList(dashBoardDTOList);
        }

        return dashBoardDTO;
    }

}
