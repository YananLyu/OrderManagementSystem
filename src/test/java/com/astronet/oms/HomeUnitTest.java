package com.astronet.oms;

import com.astronet.oms.enums.OfferStatusEnum;
import com.astronet.oms.repository.OmsOrderRepository;
import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

/**
 * TODO: Test OmsOrder
 * @author: Zhubo Deng
 * @date 3/15/21 11:44 AM
 */

@SpringBootTest
public class HomeUnitTest {

    @Autowired
    PmsSpuRepository pmsSpuRepository;

    @Autowired
    PmsSkuRepository pmsSkuRepository;

    @Autowired
    OmsOrderRepository omsOrderRepository;

    @Test
    public void testActiveOfferNumber() {
        Long num =  Long.valueOf(pmsSkuRepository.countByOfferStatus(OfferStatusEnum.ACTIVE));
        System.out.println(num);
        assertThat(num).isGreaterThanOrEqualTo(0);
    }

}
