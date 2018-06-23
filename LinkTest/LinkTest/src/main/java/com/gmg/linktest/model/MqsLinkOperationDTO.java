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
 * <b> DTO for Message Table </b>
 * </p>
 */
@Entity
@Table(name = "mqs_link_operation")
public class MqsLinkOperationDTO {

    @Id
    @Column(name = "MQS_LINK_ID")
    @NotNull
    private Integer mqsLinkId;
    @Column(name = "LINK_DIRECTION")
    @NotNull
    private String linkDirection;
    @Column(name = "LAST_SEQ_NO")
    @NotNull
    private Long lastSeqNum;
    @Column(name = "LAST_ACK_SEQ_NO")
    private Long lastAckSeqNo;
    @Column(name = "NO_MSG_ACK")
    private Long noMsgAck;
    @Column(name = "NO_MSG_NAK")
    private Long noMsgNak;
    @Column(name = "NO_MSG_XMIT")
    private Long noMsgXmit;
    @Column(name = "MQS_LINK_STATUS")
    private String mqsLinkStatus;
    @Column(name = "INST_ID")
    private Integer instId;

    /**
     * @return the mqsLinkId
     */
    public Integer getMqsLinkId() {
        return this.mqsLinkId;
    }

    /**
     * @param mqsLinkId
     *            the mqsLinkId to set
     */
    public void setMqsLinkId(final Integer mqsLinkId) {
        this.mqsLinkId = mqsLinkId;
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
     * @return the lastSeqNum
     */
    public Long getLastSeqNum() {
        return this.lastSeqNum;
    }

    /**
     * @param lastSeqNum
     *            the lastSeqNum to set
     */
    public void setLastSeqNum(final Long lastSeqNum) {
        this.lastSeqNum = lastSeqNum;
    }

    /**
     * @return the lastAckSeqNo
     */
    public Long getLastAckSeqNo() {
        return this.lastAckSeqNo;
    }

    /**
     * @param lastAckSeqNo
     *            the lastAckSeqNo to set
     */
    public void setLastAckSeqNo(final Long lastAckSeqNo) {
        this.lastAckSeqNo = lastAckSeqNo;
    }

    /**
     * @return the noMsgAck
     */
    public Long getNoMsgAck() {
        return this.noMsgAck;
    }

    /**
     * @param noMsgAck
     *            the noMsgAck to set
     */
    public void setNoMsgAck(final Long noMsgAck) {
        this.noMsgAck = noMsgAck;
    }

    /**
     * @return the noMsgNak
     */
    public Long getNoMsgNak() {
        return this.noMsgNak;
    }

    /**
     * @param noMsgNak
     *            the noMsgNak to set
     */
    public void setNoMsgNak(final Long noMsgNak) {
        this.noMsgNak = noMsgNak;
    }

    /**
     * @return the noMsgXmit
     */
    public Long getNoMsgXmit() {
        return this.noMsgXmit;
    }

    /**
     * @param noMsgXmit
     *            the noMsgXmit to set
     */
    public void setNoMsgXmit(final Long noMsgXmit) {
        this.noMsgXmit = noMsgXmit;
    }

    /**
     * @return the mqsLinkStatus
     */
    public String getMqsLinkStatus() {
        return this.mqsLinkStatus;
    }

    /**
     * @param mqsLinkStatus
     *            the mqsLinkStatus to set
     */
    public void setMqsLinkStatus(final String mqsLinkStatus) {
        this.mqsLinkStatus = mqsLinkStatus;
    }

    /**
     * @return the instId
     */
    public Integer getInstId() {
        return this.instId;
    }

    /**
     * @param instId
     *            the instId to set
     */
    public void setInstId(final Integer instId) {
        this.instId = instId;
    }


}
