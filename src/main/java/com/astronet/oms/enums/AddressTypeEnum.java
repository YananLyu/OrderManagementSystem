package com.astronet.oms.enums;

import lombok.Getter;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:02 AM
 */

@Getter
public enum AddressTypeEnum implements BaseEnum {

    SELF_STORAGE(0),
    MOD_STORAGE(1),
    ADMIN_STORAGE(2);

    private Integer code;

    AddressTypeEnum(Integer code) {
        this.code = code;
    }

}
