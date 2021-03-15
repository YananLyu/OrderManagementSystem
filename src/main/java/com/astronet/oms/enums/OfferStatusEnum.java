package com.astronet.oms.enums;

import lombok.Getter;
import org.omg.CORBA.UNKNOWN;

/**
 * @author: Yanan Lyu
 * @date 3/6/21 11:44 AM
 */
@Getter
public enum OfferStatusEnum implements BaseEnum{
    /**
     * 有效
     */
    ACTIVE(1),

    /**
     * 无效
     */
    INACTIVE(0);

    /**
     * Offer 状态编码
     */
    private Integer code;

    OfferStatusEnum(Integer code) {
        this.code = code;
    }
}
