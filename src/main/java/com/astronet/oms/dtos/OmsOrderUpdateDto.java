package com.astronet.oms.dtos;

import com.astronet.oms.entity.User;
import com.astronet.oms.enums.InboundStatusEnum;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 11:43 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderUpdateDto implements OmsOrderDto {

    private Long super_order_id;
    private InboundStatusEnum orderStatus;
    private BigDecimal refundAmount;
    private String offerNote;

}
