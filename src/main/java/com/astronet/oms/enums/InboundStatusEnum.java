package com.astronet.oms.enums;

import lombok.Getter;

/**
 * @author: Zhubo Deng
 * @date 3/15/21 11:44 AM
 */

@Getter
public enum InboundStatusEnum implements BaseEnum{

    WAIT_FOR_PAYMENT(0),
    WAIT_FOR_DELIVERY(1),
    DELIVERED(2),
    COMPLETED(3),
    CLOSED(4),
    INVALID(5);

    private Integer code;

    InboundStatusEnum(Integer code) {
        this.code = code;
    }

}
