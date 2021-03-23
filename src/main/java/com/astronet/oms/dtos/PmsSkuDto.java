package com.astronet.oms.dtos;

import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.enums.OfferStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 3/14/21 9:42 PM
 */

@Data
public class PmsSkuDto {

    private Long id;
    private PmsSpu pmsSpu;
    private BigDecimal unitPrice;
    private BigDecimal adminPrice;
    private BigDecimal modPrice;
    private Long quantity;
    private Long quantityLeft;
    private OfferStatusEnum offerStatus;
    private String offerNote;

}
