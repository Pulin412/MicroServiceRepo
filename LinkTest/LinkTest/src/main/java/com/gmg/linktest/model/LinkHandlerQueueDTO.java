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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * <b> DTO for Link Handler Queue Table </b>
 * </p>
 */
@Entity
@Table(name = "link_handler_queue")
public class LinkHandlerQueueDTO {

    @Id
    @Column(name = "QUEUE_ID")
    @NotNull
    private Integer queueId;
    @Column(name = "QUEUE_NAME")
    @NotNull
    private String queueName;
    @Column(name = "QUEUE_CATEGORY")
    @NotNull
    private String queueCategory;

    // @OneToOne(fetch = FetchType.LAZY, mappedBy = "linkHandlerQueueDto")
    // private MessageDTO messageDto;

    /**
     * @return the queueId
     */
    public Integer getQueueId() {
        return this.queueId;
    }

    /**
     * @param queueId
     *            the queueId to set
     */
    public void setQueueId(final Integer queueId) {
        this.queueId = queueId;
    }

    /**
     * @return the queueName
     */
    public String getQueueName() {
        return this.queueName;
    }

    /**
     * @param queueName
     *            the queueName to set
     */
    public void setQueueName(final String queueName) {
        this.queueName = queueName;
    }

    /**
     * @return the queueCategory
     */
    public String getQueueCategory() {
        return this.queueCategory;
    }

    /**
     * @param queueCategory
     *            the queueCategory to set
     */
    public void setQueueCategory(final String queueCategory) {
        this.queueCategory = queueCategory;
    }


}
