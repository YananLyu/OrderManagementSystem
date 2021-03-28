package com.astronet.oms.repository;

import com.astronet.oms.entity.UserMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:48 AM
 */

@Repository
public interface UserMoneyRepository extends JpaRepository<UserMoney, Long> {

    /**
     * R - Read all
     * @return
     */
    List<UserMoney> findAllByOrderByIdDesc();

}
