package com.astronet.order_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.astronet.order_sys.entity.OmsSku;

import java.util.List;

@Repository
public interface OmsSkuRepository extends JpaRepository<OmsSku, Long> {
    List<OmsSku> findAll();
    List<OmsSku> findAllById(Iterable<Long> ids);
    List<OmsSku> findAllByOrderByCreateTimeDesc();
//    List<OmsSku> findById();
}
