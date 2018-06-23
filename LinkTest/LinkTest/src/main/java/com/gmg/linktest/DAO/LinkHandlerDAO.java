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

import com.gmg.linktest.model.LinkHandlerQueueDTO;
import com.gmg.linktest.model.ReadyQueueCountDTO;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
@Repository
public interface LinkHandlerDAO extends JpaRepository<LinkHandlerQueueDTO, Integer> {

    public List<LinkHandlerQueueDTO> findByqueueNameIgnoreCaseContaining(String queueName);

    @Query("SELECT " + "new com.gmg.linktest.model.ReadyQueueCountDTO(m.currentQueueId, count(m) )" + "FROM " + " MessageDTO m "
        + "WHERE m.currentQueueId IN (:queuesList) " + "GROUP BY " + "m.currentQueueId")
    public List<ReadyQueueCountDTO> getCountOfMessagesInReadyQueue(@Param("queuesList") List<Integer> queuesList);

    public LinkHandlerQueueDTO findByqueueId(Integer queueId);

}
