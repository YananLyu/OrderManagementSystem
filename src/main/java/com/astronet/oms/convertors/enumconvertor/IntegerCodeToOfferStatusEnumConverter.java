package com.astronet.oms.convertors.enumconvertor;

import com.astronet.oms.enums.OfferStatusEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Yanan Lyu
 * @date 3/14/21 2:38 PM
 */
public class IntegerCodeToOfferStatusEnumConverter implements Converter<Integer, OfferStatusEnum> {

    private Map<Integer, OfferStatusEnum> enumMap = new HashMap<>();

    public IntegerCodeToOfferStatusEnumConverter() {
        for (OfferStatusEnum offerStatusEnum :
             OfferStatusEnum.values()) {
            enumMap.put(offerStatusEnum.getCode(), offerStatusEnum);
        }
    }

    @Override
    public OfferStatusEnum convert(Integer source) {
        OfferStatusEnum offerStatusEnum = enumMap.get(source);
        if (offerStatusEnum == null) {
            throw new IllegalArgumentException("无法匹配对应的枚举类型");
        }
        return offerStatusEnum;
    }

    @Override
    public <U> Converter<Integer, U> andThen(Converter<? super OfferStatusEnum, ? extends U> after) {
        return null;
    }
}
