package com.astronet.oms.enums;

import lombok.Getter;

/**
 * @author Zhubo Deng
 * @date 03/27/2021 7:36 PM
 */

@Getter
public enum PaymentTypeEnum implements BaseEnum {

    BILL_PAY(0),
    CHECK(1),
    WIRE(2);

    private Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }

}
