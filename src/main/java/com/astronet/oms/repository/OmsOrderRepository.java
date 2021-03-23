package com.astronet.oms.repository;

import com.astronet.oms.entity.OmsOrder;
import com.astronet.oms.enums.InboundStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Zhubo Deng
 * @date 3/15/21 11:44 AM
 */

public interface OmsOrderRepository extends JpaRepository<OmsOrder, Long> {

    List<OmsOrder> findAllByOrderByIdDesc();

    List<OmsOrder> findByOrderStatus(InboundStatusEnum statusEnum);

    long countByOrderStatus(InboundStatusEnum statusEnum);

}
