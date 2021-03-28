package com.astronet.oms.dtos;

import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.enums.OfferStatusEnum;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 2:49 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsSkuUpdateDto implements PmsSkuDto {

    private BigDecimal unitPrice;
    private BigDecimal adminPrice;
    private BigDecimal modPrice;
    private Long quantity;
    private Long quantityLeft;
    private OfferStatusEnum offerStatus;
    private String offerNote;

}
