package com.astronet.oms.dtos;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 7:09 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderReadDto implements OmsOrderDto {

    private Long id;
    private Long super_order_id;
    private BigDecimal totalAmount;
    private Long quantity;
    private String productName;
    private BigDecimal adminPrice;
    private String offerNote;

}
