package com.astronet.order_sys;


import com.astronet.order_sys.entity.OmsSku;
import com.astronet.order_sys.repository.OmsSkuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private OmsSkuRepository omsSkuRepository;

    @Test
    public void test() {
        List<OmsSku> sku = omsSkuRepository.findAll();
        System.out.println(sku);
    }

    @Test
    public void testFindById() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<OmsSku> sku = omsSkuRepository.findAllById(ids);
        System.out.println(sku);
    }
}
