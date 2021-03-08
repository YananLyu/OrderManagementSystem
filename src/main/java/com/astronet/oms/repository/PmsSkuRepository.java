package com.astronet.oms.repository;

import com.astronet.oms.entity.PmsSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Yanan Lyu
 * @date 3/3/21 9:36 PM
 */
@Repository
public interface PmsSkuRepository extends JpaRepository<PmsSku, Long> {
}
