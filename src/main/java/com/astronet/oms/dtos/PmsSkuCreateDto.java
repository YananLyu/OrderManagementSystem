package com.astronet.oms.dtos;

import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.enums.OfferStatusEnum;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 2:48 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsSkuCreateDto implements PmsSkuDto {

    /**
     * for SKU
     */
    private String platformSeller;
    private String productName;
    private String productLink;

    /**
     * for SPU
     */
    private BigDecimal unitPrice;
    private BigDecimal adminPrice;
    private BigDecimal modPrice;
    private Long quantity;
    private String offerNote;

}
