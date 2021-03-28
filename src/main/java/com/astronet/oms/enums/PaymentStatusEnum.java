package com.astronet.oms.enums;

import lombok.Getter;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:12 AM
 */

@Getter
public enum PaymentStatusEnum implements BaseEnum {

    PENDING(0),
    RECEIVED(1),
    ISSUED(2);

    private Integer code;

    PaymentStatusEnum(Integer code) {
        this.code = code;
    }

}
