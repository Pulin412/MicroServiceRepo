/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.gmg.linktest.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gmg.linktest.model.MessageDTO;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
@Repository
public interface LinkTestDAO extends JpaRepository<MessageDTO, String> {

    public List<MessageDTO> findByorigLinkId(String origLinkId);

    public List<MessageDTO> findByorigService(String origService);

    @Query(value = "select MessageDTO m from message where ORIG_SERVICE=:origService group by ORIG_LINK_ID", nativeQuery = true)
    public List<MessageDTO> findByorigServiceQuery(@Param("origService") String origService);

    // message linkhandler join query
    @Query(value = "select m.irn from MessageDTO m, LinkHandlerQueueDTO l where m.currentQueueId=l.queueId and l.queueName like :queueName group by l.queueName", nativeQuery = true)
    public List<MessageDTO> getReadyQueueStatus(@Param("queueName") String queueName);

}
