package com.astronet.oms.convertors.enumconvertor;

import com.astronet.oms.enums.RoleEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * @author Yanan Lyu
 * @date 3/14/21 12:53 AM
 *
 * We've set the @Converter‘s value of autoApply to true so that JPA will automatically apply the conversion logic
 * to all mapped attributes of a Category type. Otherwise, we'd have to put the @Converter annotation directly
 * on the entity's field.
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<RoleEnum, String> {

    @Override
    public String convertToDatabaseColumn(RoleEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public RoleEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(RoleEnum.values())
                .filter(r -> r.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
