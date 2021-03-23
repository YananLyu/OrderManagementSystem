package com.astronet.oms;

import com.astronet.oms.entity.OmsOrder;
import com.astronet.oms.enums.InboundStatusEnum;
import com.astronet.oms.repository.OmsOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class OmsOrderUnitTest {

    @Autowired
    OmsOrderRepository repository;

    @Test
    public void testNewInbound() {
        OmsOrder omsOrder = OmsOrder.builder()
                .orderStatus(InboundStatusEnum.WAIT_FOR_PAYMENT)
                .build();
        OmsOrder savedOmsOrder = repository.save(omsOrder);
        assertThat(savedOmsOrder.getId()).isGreaterThan(0);
    }

}
