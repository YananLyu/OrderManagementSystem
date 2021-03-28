package com.astronet.oms.repository;

import com.astronet.oms.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/26/2021 12:39 AM
 */

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    /**
     * R - Read all
     * @return
     */
    List<UserProfile> findAllByOrderByIdDesc();

}
