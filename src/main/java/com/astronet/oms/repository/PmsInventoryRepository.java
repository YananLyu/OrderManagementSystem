package com.astronet.oms.repository;

import com.astronet.oms.entity.PmsInventory;
import com.astronet.oms.entity.UserMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Yanan Lyu
 * @date 3/3/21 9:36 PM
 */

@Repository
public interface PmsInventoryRepository extends JpaRepository<PmsInventory, Long> {

    /**
     * R - Read all
     * @return
     */
    List<PmsInventory> findAllByOrderByIdDesc();

}
