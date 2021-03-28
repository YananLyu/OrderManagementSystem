package com.astronet.oms.repository;

import com.astronet.oms.entity.UserPayment;
import com.astronet.oms.enums.PaymentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:15 AM
 */

@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

    /**
     * R - Read all
     * @return
     */
    List<UserPayment> findAllByOrderByIdDesc();

    /**
     * R - Read by payment status
     * @param status
     * @return
     */
    List<UserPayment> findByPaymentStatus(PaymentStatusEnum status);

}
