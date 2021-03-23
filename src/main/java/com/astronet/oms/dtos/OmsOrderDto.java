package com.astronet.oms.dtos;

import com.astronet.oms.entity.User;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Zhubo Deng
 * @date 3/15/21 11:44 AM
 */

@Data
public class OmsOrderDto {

    private Long id;
    private Long super_order_id;
    private Integer orderStatus;
    private User user;
    private String username;
    private BigDecimal totalAmount;
    private BigDecimal refundAmount;
    private Long quantity;
    private Long skuCreatedByUserId;
    private String skuCreatedByUserName;




}
