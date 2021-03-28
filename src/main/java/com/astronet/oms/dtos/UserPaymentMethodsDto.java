package com.astronet.oms.dtos;

import com.astronet.oms.enums.PaymentTypeEnum;
import lombok.*;

/**
 * @author Zhubo Deng
 * @date 03/27/2021 8:10 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentMethodsDto {

    private PaymentTypeEnum paymentType;
    private String cardCompany;
    private String cardNetwork;
    private String accountHolder;
    private Long accountNumber;

}
