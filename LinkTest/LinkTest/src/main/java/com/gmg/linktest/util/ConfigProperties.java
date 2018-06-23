/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.gmg.linktest.util;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dashboard")
// @PropertySource("classpath:configprops.properties")
public class ConfigProperties {

    private String origService;
    private String mqsLinkStatus;
    private Map<String, String> queueNamePattern;

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
     * @return the queueNamePattern
     */
    public Map<String, String> getQueueNamePattern() {
        return this.queueNamePattern;
    }

    /**
     * @param queueNamePattern
     *            the queueNamePattern to set
     */
    public void setQueueNamePattern(final Map<String, String> queueNamePattern) {
        this.queueNamePattern = queueNamePattern;
    }
}
