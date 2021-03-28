package com.astronet.oms.dtos;

import com.astronet.oms.enums.PaymentStatusEnum;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:17 AM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentDto {

    private BigDecimal moneyAmount;
    private PaymentStatusEnum paymentStatus;
    private String paymentNote;

}
