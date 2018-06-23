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

/**
 * <p>
 * <b> Simple bean for count of messages in ready queue </b>
 * </p>
 */
public class ReadyQueueCountDTO {

    private Integer currentQueueId;
    private Long countOfMessages;

    public ReadyQueueCountDTO(final Integer currentQueueId, final Long countOfMessages) {
        super();
        this.currentQueueId = currentQueueId;
        this.countOfMessages = countOfMessages;
    }

    /**
     * @return the currentQueueId
     */
    public Integer getCurrentQueueId() {
        return this.currentQueueId;
    }

    /**
     * @param currentQueueId
     *            the currentQueueId to set
     */
    public void setCurrentQueueId(final Integer currentQueueId) {
        this.currentQueueId = currentQueueId;
    }

    /**
     * @return the countOfMessages
     */
    public Long getCountOfMessages() {
        return this.countOfMessages;
    }

    /**
     * @param countOfMessages
     *            the countOfMessages to set
     */
    public void setCountOfMessages(final Long countOfMessages) {
        this.countOfMessages = countOfMessages;
    }

}
