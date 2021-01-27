package com.astronet.order_sys.repository;

import com.astronet.order_sys.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOrderByCreateTimeAsc();
}
