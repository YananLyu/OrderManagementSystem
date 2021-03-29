package com.astronet.oms.enums;

import lombok.Getter;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 11:02 AM
 */

@Getter
public enum OrderTypeEnum implements BaseEnum {

    REGULAR(0),
    PROPOSED(1);

    private Integer code;

    OrderTypeEnum(Integer code) {
        this.code = code;
    }

}
