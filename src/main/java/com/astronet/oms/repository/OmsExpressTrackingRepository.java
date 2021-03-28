package com.astronet.oms.repository;

import com.astronet.oms.entity.OmsExpressTracking;
import com.astronet.oms.enums.TrackingStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:29 AM
 */

@Repository
public interface OmsExpressTrackingRepository extends JpaRepository<OmsExpressTracking, Long> {

    /**
     * R - Read all
     * @return
     */
    List<OmsExpressTracking> findAllByOrderByIdDesc();

    /**
     * R - Read by tracking status
     * @return
     */
    List<OmsExpressTracking> findByTrackingStatus(TrackingStatusEnum status);

}
