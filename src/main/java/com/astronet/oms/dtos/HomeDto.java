package com.astronet.oms.dtos;

import lombok.*;

/**
 * @author Yanan Lyu
 * @date 3/23/21 11:49 PM
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeDto {

    /**
     * number of offers
     */
    private Long numOfActiveOffers;
    private Long numOfExpiredOffers;
    private Long numOfProposedOffers;

    /**
     * number of Inbound
     */
    private Long numOfInboundItem;
    private Long numOfReportedItem;

    /**
     * number of Outbound
     */
    private Long numOfOutboundShipments;

    /**
     * number of Payment Requests
     */
    private Long numOfPaymentRequests;
}
