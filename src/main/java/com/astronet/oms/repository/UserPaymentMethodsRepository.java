package com.astronet.oms.repository;

import com.astronet.oms.entity.UserPaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/27/2021 8:26 PM
 */

@Repository
public interface UserPaymentMethodsRepository extends JpaRepository<UserPaymentMethods, Long> {

    /**
     * R - Read all
     * @return
     */
    List<UserPaymentMethods> findAllByOrderByIdDesc();

}
