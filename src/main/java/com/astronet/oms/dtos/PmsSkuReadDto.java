package com.astronet.oms.dtos;

import com.astronet.oms.entity.PmsSpu;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 2:36 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsSkuReadDto implements PmsSkuDto {

    private Long id;
    private PmsSpu pmsSpu;
    private BigDecimal adminPrice;
    private Long quantityLeft;
    private String offerNote;

}
