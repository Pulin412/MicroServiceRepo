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

import java.sql.Timestamp;
import java.util.Date;

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
@Table(name = "message")
public class MessageDTO {

    @Id
    @Column(name = "IRN")
    @NotNull
    private long irn;
    @Column(name = "ORIG_ADDR")
    @NotNull
    private String origAddress;
    @Column(name = "DESTN_ADDR")
    @NotNull
    private String destnAddress;
    @Column(name = "CURR_CODE")
    private String currCode;
    @Column(name = "AMT")
    private Double amount;
    @Column(name = "XSACTION_REF_NO")
    private String xsactionRefNo;
    @Column(name = "VALUE_DATE")
    private Date valueDate;
    @Column(name = "SENDER_ISN")
    private Integer senderIsn;
    @Column(name = "ORIG_LINK_ID")
    private String origLinkId;
    @Column(name = "CREATE_DT_TIME")
    @NotNull
    private Timestamp createDateTime;
    @Column(name = "ACKNAK_STATUS")
    private String ackNackStatus;
    @Column(name = "MSG_STATE")
    private String msgState;
    @Column(name = "OWNER_DEPT_CODE")
    @NotNull
    private String ownerDeptCode;
    @Column(name = "ORIG_SERVICE")
    private String origService;
    @Column(name = "PDM")
    private String pdm;
    @Column(name = "MSG_TYPE")
    @NotNull
    private String msgType;
    @Column(name = "SECONDARY_ACK")
    @NotNull
    private String secAck;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CURRENT_OWNER_DEPT")
    private String currentOwnerDept;
    @Column(name = "MSG_PRIORITY")
    @NotNull
    private Integer msgPriority;
    @Column(name = "PRINT_COUNT")
    @NotNull
    private Integer printCount;
    @Column(name = "SRN")
    private String srn;
    @Column(name = "MSG_ID")
    private String msgId;
    @Column(name = "MSG_STATE_DT_TIME")
    private Timestamp msgStateDateTime;
    @Column(name = "PARENT_IRN")
    private Long parentIrn;
    @Column(name = "TRANSMIT_DT_TIME")
    private Timestamp transmitDateTime;
    @Column(name = "DESTN_LINK_ID")
    private String destLinkId;
    @Column(name = "DESTN_SERVICE")
    private String destService;
    @Column(name = "PARENT_REASON")
    private String parentReason;
    @Column(name = "SERVICE_ISN")
    private Integer serviceIsn;
    @Column(name = "SERVICE_OSN")
    private Integer serviceOsn;
    @Column(name = "CURRENT_QUEUE_ID")
    @NotNull
    private Integer currentQueueId;
    @Column(name = "NAK_REASON_CODE")
    private String nakReasonCode;
    @Column(name = "RECEIVE_DT_TIME")
    private Timestamp receiveDateTime;
    @Column(name = "ORIG_SWIFT_ADDR")
    private String origSwiftAddress;
    @Column(name = "DESTN_SWIFT_ADDR")
    private String destnSwiftAddress;
    @Column(name = "MSG_DIRECTION")
    private Character msgDirection;
    @Column(name = "COPY_SERVICE_ID")
    private String copyServiceId;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "SUB_MSG_TYPE")
    private String subMsgType;
    @Column(name = "PAYMENT_UID")
    private String paymentUid;
    @Column(name = "INST_ID")
    private Integer instId;
    @Column(name = "TRACKING_UID")
    private String trackingUid;
    @Column(name = "UETR")
    private String uetr;

    // for link handler join
    // @OneToOne
    // @JoinColumn(name = "CURRENT_QUEUE_ID")
    // private LinkHandlerQueueDTO linkHandlerQueueDto;


    /**
     * @return the irn
     */
    public long getIrn() {
        return this.irn;
    }

    /**
     * @param irn
     *            the irn to set
     */
    public void setIrn(final long irn) {
        this.irn = irn;
    }

    /**
     * @return the origAddress
     */
    public String getOrigAddress() {
        return this.origAddress;
    }

    /**
     * @param origAddress
     *            the origAddress to set
     */
    public void setOrigAddress(final String origAddress) {
        this.origAddress = origAddress;
    }

    /**
     * @return the destnAddress
     */
    public String getDestnAddress() {
        return this.destnAddress;
    }

    /**
     * @param destnAddress
     *            the destnAddress to set
     */
    public void setDestnAddress(final String destnAddress) {
        this.destnAddress = destnAddress;
    }

    /**
     * @return the currCode
     */
    public String getCurrCode() {
        return this.currCode;
    }

    /**
     * @param currCode
     *            the currCode to set
     */
    public void setCurrCode(final String currCode) {
        this.currCode = currCode;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return this.amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(final double amount) {
        this.amount = amount;
    }

    /**
     * @return the xsactionRefNo
     */
    public String getXsactionRefNo() {
        return this.xsactionRefNo;
    }

    /**
     * @param xsactionRefNo
     *            the xsactionRefNo to set
     */
    public void setXsactionRefNo(final String xsactionRefNo) {
        this.xsactionRefNo = xsactionRefNo;
    }

    /**
     * @return the valueDate
     */
    public Date getValueDate() {
        return this.valueDate;
    }

    /**
     * @param valueDate
     *            the valueDate to set
     */
    public void setValueDate(final Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     * @return the senderIsn
     */
    public int getSenderIsn() {
        return this.senderIsn;
    }

    /**
     * @param senderIsn
     *            the senderIsn to set
     */
    public void setSenderIsn(final int senderIsn) {
        this.senderIsn = senderIsn;
    }

    /**
     * @return the origLinkId
     */
    public String getOrigLinkId() {
        return this.origLinkId;
    }

    /**
     * @param origLinkId
     *            the origLinkId to set
     */
    public void setOrigLinkId(final String origLinkId) {
        this.origLinkId = origLinkId;
    }

    /**
     * @return the createDateTime
     */
    public Timestamp getCreateDateTime() {
        return this.createDateTime;
    }

    /**
     * @param createDateTime
     *            the createDateTime to set
     */
    public void setCreateDateTime(final Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }

    /**
     * @return the ackNackStatus
     */
    public String getAckNackStatus() {
        return this.ackNackStatus;
    }

    /**
     * @param ackNackStatus
     *            the ackNackStatus to set
     */
    public void setAckNackStatus(final String ackNackStatus) {
        this.ackNackStatus = ackNackStatus;
    }

    /**
     * @return the msgState
     */
    public String getMsgState() {
        return this.msgState;
    }

    /**
     * @param msgState
     *            the msgState to set
     */
    public void setMsgState(final String msgState) {
        this.msgState = msgState;
    }

    /**
     * @return the ownerDeptCode
     */
    public String getOwnerDeptCode() {
        return this.ownerDeptCode;
    }

    /**
     * @param ownerDeptCode
     *            the ownerDeptCode to set
     */
    public void setOwnerDeptCode(final String ownerDeptCode) {
        this.ownerDeptCode = ownerDeptCode;
    }

    /**
     * @return the origService
     */
    public String getOrigService() {
        return this.origService;
    }

    /**
     * @param origService
     *            the origService to set
     */
    public void setOrigService(final String origService) {
        this.origService = origService;
    }

    /**
     * @return the pdm
     */
    public String getPdm() {
        return this.pdm;
    }

    /**
     * @param pdm
     *            the pdm to set
     */
    public void setPdm(final String pdm) {
        this.pdm = pdm;
    }

    /**
     * @return the msgType
     */
    public String getMsgType() {
        return this.msgType;
    }

    /**
     * @param msgType
     *            the msgType to set
     */
    public void setMsgType(final String msgType) {
        this.msgType = msgType;
    }

    /**
     * @return the secAck
     */
    public String getSecAck() {
        return this.secAck;
    }

    /**
     * @param secAck
     *            the secAck to set
     */
    public void setSecAck(final String secAck) {
        this.secAck = secAck;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the currentOwnerDept
     */
    public String getCurrentOwnerDept() {
        return this.currentOwnerDept;
    }

    /**
     * @param currentOwnerDept
     *            the currentOwnerDept to set
     */
    public void setCurrentOwnerDept(final String currentOwnerDept) {
        this.currentOwnerDept = currentOwnerDept;
    }

    /**
     * @return the msgPriority
     */
    public int getMsgPriority() {
        return this.msgPriority;
    }

    /**
     * @param msgPriority
     *            the msgPriority to set
     */
    public void setMsgPriority(final int msgPriority) {
        this.msgPriority = msgPriority;
    }

    /**
     * @return the printCount
     */
    public int getPrintCount() {
        return this.printCount;
    }

    /**
     * @param printCount
     *            the printCount to set
     */
    public void setPrintCount(final int printCount) {
        this.printCount = printCount;
    }

    /**
     * @return the srn
     */
    public String getSrn() {
        return this.srn;
    }

    /**
     * @param srn
     *            the srn to set
     */
    public void setSrn(final String srn) {
        this.srn = srn;
    }

    /**
     * @return the msgId
     */
    public String getMsgId() {
        return this.msgId;
    }

    /**
     * @param msgId
     *            the msgId to set
     */
    public void setMsgId(final String msgId) {
        this.msgId = msgId;
    }

    /**
     * @return the msgStateDateTime
     */
    public Timestamp getMsgStateDateTime() {
        return this.msgStateDateTime;
    }

    /**
     * @param msgStateDateTime
     *            the msgStateDateTime to set
     */
    public void setMsgStateDateTime(final Timestamp msgStateDateTime) {
        this.msgStateDateTime = msgStateDateTime;
    }

    /**
     * @return the parentIrn
     */
    public Long getParentIrn() {
        return this.parentIrn;
    }

    /**
     * @param parentIrn
     *            the parentIrn to set
     */
    public void setParentIrn(final long parentIrn) {
        this.parentIrn = parentIrn;
    }

    /**
     * @return the transmitDateTime
     */
    public Timestamp getTransmitDateTime() {
        return this.transmitDateTime;
    }

    /**
     * @param transmitDateTime
     *            the transmitDateTime to set
     */
    public void setTransmitDateTime(final Timestamp transmitDateTime) {
        this.transmitDateTime = transmitDateTime;
    }

    /**
     * @return the destLinkId
     */
    public String getDestLinkId() {
        return this.destLinkId;
    }

    /**
     * @param destLinkId
     *            the destLinkId to set
     */
    public void setDestLinkId(final String destLinkId) {
        this.destLinkId = destLinkId;
    }

    /**
     * @return the destService
     */
    public String getDestService() {
        return this.destService;
    }

    /**
     * @param destService
     *            the destService to set
     */
    public void setDestService(final String destService) {
        this.destService = destService;
    }

    /**
     * @return the parentReason
     */
    public String getParentReason() {
        return this.parentReason;
    }

    /**
     * @param parentReason
     *            the parentReason to set
     */
    public void setParentReason(final String parentReason) {
        this.parentReason = parentReason;
    }

    /**
     * @return the serviceIsn
     */
    public int getServiceIsn() {
        return this.serviceIsn;
    }

    /**
     * @param serviceIsn
     *            the serviceIsn to set
     */
    public void setServiceIsn(final int serviceIsn) {
        this.serviceIsn = serviceIsn;
    }

    /**
     * @return the serviceOsn
     */
    public int getServiceOsn() {
        return this.serviceOsn;
    }

    /**
     * @param serviceOsn
     *            the serviceOsn to set
     */
    public void setServiceOsn(final int serviceOsn) {
        this.serviceOsn = serviceOsn;
    }

    /**
     * @return the currentQueueId
     */
    public int getCurrentQueueId() {
        return this.currentQueueId;
    }

    /**
     * @param currentQueueId
     *            the currentQueueId to set
     */
    public void setCurrentQueueId(final int currentQueueId) {
        this.currentQueueId = currentQueueId;
    }

    /**
     * @return the nakReasonCode
     */
    public String getNakReasonCode() {
        return this.nakReasonCode;
    }

    /**
     * @param nakReasonCode
     *            the nakReasonCode to set
     */
    public void setNakReasonCode(final String nakReasonCode) {
        this.nakReasonCode = nakReasonCode;
    }

    /**
     * @return the receiveDateTime
     */
    public Timestamp getReceiveDateTime() {
        return this.receiveDateTime;
    }

    /**
     * @param receiveDateTime
     *            the receiveDateTime to set
     */
    public void setReceiveDateTime(final Timestamp receiveDateTime) {
        this.receiveDateTime = receiveDateTime;
    }

    /**
     * @return the origSwiftAddress
     */
    public String getOrigSwiftAddress() {
        return this.origSwiftAddress;
    }

    /**
     * @param origSwiftAddress
     *            the origSwiftAddress to set
     */
    public void setOrigSwiftAddress(final String origSwiftAddress) {
        this.origSwiftAddress = origSwiftAddress;
    }

    /**
     * @return the destnSwiftAddress
     */
    public String getDestnSwiftAddress() {
        return this.destnSwiftAddress;
    }

    /**
     * @param destnSwiftAddress
     *            the destnSwiftAddress to set
     */
    public void setDestnSwiftAddress(final String destnSwiftAddress) {
        this.destnSwiftAddress = destnSwiftAddress;
    }

    /**
     * @return the msgDirection
     */
    public Character getMsgDirection() {
        return this.msgDirection;
    }

    /**
     * @param msgDirection
     *            the msgDirection to set
     */
    public void setMsgDirection(final char msgDirection) {
        this.msgDirection = msgDirection;
    }

    /**
     * @return the copyServiceId
     */
    public String getCopyServiceId() {
        return this.copyServiceId;
    }

    /**
     * @param copyServiceId
     *            the copyServiceId to set
     */
    public void setCopyServiceId(final String copyServiceId) {
        this.copyServiceId = copyServiceId;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * @param accountNumber
     *            the accountNumber to set
     */
    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the subMsgType
     */
    public String getSubMsgType() {
        return this.subMsgType;
    }

    /**
     * @param subMsgType
     *            the subMsgType to set
     */
    public void setSubMsgType(final String subMsgType) {
        this.subMsgType = subMsgType;
    }

    /**
     * @return the paymentUid
     */
    public String getPaymentUid() {
        return this.paymentUid;
    }

    /**
     * @param paymentUid
     *            the paymentUid to set
     */
    public void setPaymentUid(final String paymentUid) {
        this.paymentUid = paymentUid;
    }

    /**
     * @return the instId
     */
    public int getInstId() {
        return this.instId;
    }

    /**
     * @param instId
     *            the instId to set
     */
    public void setInstId(final int instId) {
        this.instId = instId;
    }

    /**
     * @return the trackingUid
     */
    public String getTrackingUid() {
        return this.trackingUid;
    }

    /**
     * @param trackingUid
     *            the trackingUid to set
     */
    public void setTrackingUid(final String trackingUid) {
        this.trackingUid = trackingUid;
    }

    /**
     * @return the uetr
     */
    public String getUetr() {
        return this.uetr;
    }

    /**
     * @param uetr
     *            the uetr to set
     */
    public void setUetr(final String uetr) {
        this.uetr = uetr;
    }

}
