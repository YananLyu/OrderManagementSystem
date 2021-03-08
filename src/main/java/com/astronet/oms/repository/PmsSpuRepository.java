package com.astronet.oms.repository;

import com.astronet.oms.entity.PmsSpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: Yanan Lyu
 * @date 3/3/21 9:36 PM
 */
@Repository
public interface PmsSpuRepository extends JpaRepository<PmsSpu, Long> {

}
