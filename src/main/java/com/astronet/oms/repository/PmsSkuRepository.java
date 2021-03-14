package com.astronet.oms.repository;

import com.astronet.oms.entity.PmsSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yanan Lyu
 * @date 3/13/21 12:05 AM
 */

@Repository
public interface PmsSkuRepository extends JpaRepository<PmsSku, Long> {

    /**
     * R - Read
     * @return
     */
    List<PmsSku> findAllByOrderByIdDesc();

}
