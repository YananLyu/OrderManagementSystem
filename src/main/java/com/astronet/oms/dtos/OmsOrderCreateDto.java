package com.astronet.oms.dtos;

import com.astronet.oms.entity.User;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 11:42 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderCreateDto implements OmsOrderDto {

    /**
     * Order information
     */
    private Long super_order_id;
    private Integer orderStatus;
    private User user;
    private String username;
    private BigDecimal totalAmount;
    private BigDecimal refundAmount;
    private Long quantity;
    private String offerNote;

    /**
     * Inventory information
     */
    private Long inventoryId;
    private Integer addrType;
    private String addrLine1;
    private String addrLine2;
    private String addrCity;
    private String addrState;
    private String addrZipcode;
    private String addrCountry;

}
