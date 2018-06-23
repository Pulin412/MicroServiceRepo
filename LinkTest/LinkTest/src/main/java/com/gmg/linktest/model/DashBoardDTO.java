/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.gmg.linktest.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <b> DTO to show the dashboard </b>
 * </p>
 */
public class DashBoardDTO {

    private String linkId;
    private int count;
    private MessageDTO messageDTO;
    private List<MessageDTO> messageDTOList;
    private Map<String, Integer> linkMessageMap;
    private List<MqsLinkOperationDTO> mqsLinkDTOList;
    // ready queue related fields
    private String linkName;
    private Integer messageCount;
    private String linkDirection;
    private List<DashBoardDTO> dashBoardDTOList;
    private HashMap<String, Long> queueIdNameSelectedMap;
    private Long readyQueueMessagesCount;

    /**
     * @return the linkId
     */
    public String getLinkId() {
        return this.linkId;
    }

    /**
     * @param linkId
     *            the linkId to set
     */
    public void setLinkId(final String linkId) {
        this.linkId = linkId;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * @return the messageDTO
     */
    public MessageDTO getMessageDTO() {
        return this.messageDTO;
    }

    /**
     * @param messageDTO
     *            the messageDTO to set
     */
    public void setMessageDTO(final MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
    }

    /**
     * @return the messageDTOList
     */
    public List<MessageDTO> getMessageDTOList() {
        return this.messageDTOList;
    }

    /**
     * @param messageDTOList
     *            the messageDTOList to set
     */
    public void setMessageDTOList(final List<MessageDTO> messageDTOList) {
        this.messageDTOList = messageDTOList;
    }

    /**
     * @return the linkMessageMap
     */
    public Map<String, Integer> getLinkMessageMap() {
        return this.linkMessageMap;
    }

    /**
     * @param linkMessageMap
     *            the linkMessageMap to set
     */
    public void setLinkMessageMap(final Map<String, Integer> linkMessageMap) {
        this.linkMessageMap = linkMessageMap;
    }

    /**
     * @return the mqsLinkDTOList
     */
    public List<MqsLinkOperationDTO> getMqsLinkDTOList() {
        return this.mqsLinkDTOList;
    }

    /**
     * @param mqsLinkDTOList
     *            the mqsLinkDTOList to set
     */
    public void setMqsLinkDTOList(final List<MqsLinkOperationDTO> mqsLinkDTOList) {
        this.mqsLinkDTOList = mqsLinkDTOList;
    }


    /**
     * @return the messageCount
     */
    public Integer getMessageCount() {
        return this.messageCount;
    }

    /**
     * @param messageCount
     *            the messageCount to set
     */
    public void setMessageCount(final Integer messageCount) {
        this.messageCount = messageCount;
    }


    /**
     * @return the linkName
     */
    public String getLinkName() {
        return this.linkName;
    }


    /**
     * @param linkName
     *            the linkName to set
     */
    public void setLinkName(final String linkName) {
        this.linkName = linkName;
    }


    /**
     * @return the linkDirection
     */
    public String getLinkDirection() {
        return this.linkDirection;
    }


    /**
     * @param linkDirection
     *            the linkDirection to set
     */
    public void setLinkDirection(final String linkDirection) {
        this.linkDirection = linkDirection;
    }


    /**
     * @return the dashBoardDTOList
     */
    public List<DashBoardDTO> getDashBoardDTOList() {
        return this.dashBoardDTOList;
    }


    /**
     * @param dashBoardDTOList
     *            the dashBoardDTOList to set
     */
    public void setDashBoardDTOList(final List<DashBoardDTO> dashBoardDTOList) {
        this.dashBoardDTOList = dashBoardDTOList;
    }


    /**
     * @return the queueIdNameSelectedMap
     */
    public HashMap<String, Long> getQueueIdNameSelectedMap() {
        return this.queueIdNameSelectedMap;
    }


    /**
     * @param queueIdNameSelectedMap
     *            the queueIdNameSelectedMap to set
     */
    public void setQueueIdNameSelectedMap(final HashMap<String, Long> queueIdNameSelectedMap) {
        this.queueIdNameSelectedMap = queueIdNameSelectedMap;
    }


    /**
     * @return the readyQueueMessagesCount
     */
    public Long getReadyQueueMessagesCount() {
        return this.readyQueueMessagesCount;
    }


    /**
     * @param readyQueueMessagesCount
     *            the readyQueueMessagesCount to set
     */
    public void setReadyQueueMessagesCount(final Long readyQueueMessagesCount) {
        this.readyQueueMessagesCount = readyQueueMessagesCount;
    }

}
