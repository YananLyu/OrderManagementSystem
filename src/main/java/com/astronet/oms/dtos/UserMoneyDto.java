package com.astronet.oms.dtos;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:49 AM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMoneyDto {

    private BigDecimal onHoldAmount;
    private BigDecimal balanceAmount;
    private BigDecimal pendingAmount;
    private BigDecimal requestAmount;

}
