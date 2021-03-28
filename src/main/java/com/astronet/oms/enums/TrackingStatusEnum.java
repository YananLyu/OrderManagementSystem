package com.astronet.oms.enums;

import lombok.Getter;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:24 AM
 */

@Getter
public enum TrackingStatusEnum implements BaseEnum {

    PENDING(0),
    RECEIVED(1),
    ISSUED(2);

    private Integer code;

    TrackingStatusEnum(Integer code) {
        this.code = code;
    }

}
