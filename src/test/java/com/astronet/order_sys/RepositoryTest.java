package com.astronet.order_sys;


import com.astronet.order_sys.entity.OmsSku;
import com.astronet.order_sys.repository.OmsSkuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
