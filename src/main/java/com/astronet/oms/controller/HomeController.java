package com.astronet.oms.controller;

import com.astronet.oms.convertors.dtoconverter.PmsSkuConverter;
import com.astronet.oms.convertors.dtoconverter.PmsSpuConverter;
import com.astronet.oms.enums.InboundStatusEnum;
import com.astronet.oms.enums.OfferStatusEnum;
import com.astronet.oms.repository.OmsOrderRepository;
import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: Outbounds and Payments
 * @author Zhubo Deng
 * @date 3/14/21 9:42 PM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    PmsSpuRepository pmsSpuRepository;

//    @Autowired
//    PmsSpuConverter pmsSpuConverter;

    @Autowired
    PmsSkuRepository pmsSkuRepository;

//    @Autowired
//    PmsSkuConverter pmsSkuConverter;

    @Autowired
    OmsOrderRepository omsOrderRepository;


    @GetMapping("/activeOffer")
    public Long activeOfferNumber() {
        return Long.valueOf(pmsSkuRepository.countByOfferStatus(OfferStatusEnum.ACTIVE));
    }

    @GetMapping("/inactiveOffer")
    public Long inactiveOfferNumber() {
        return Long.valueOf(pmsSkuRepository.countByOfferStatus(OfferStatusEnum.INACTIVE));
    }

    @GetMapping("/waitForPayment")
    public Long waitForPaymentInboundNumber() {
        return Long.valueOf(omsOrderRepository.countByOrderStatus(InboundStatusEnum.WAIT_FOR_PAYMENT));
    }

    @GetMapping("/waitForDelivery")
    public Long waitForDeliveryInboundNumber() {
        return Long.valueOf(omsOrderRepository.countByOrderStatus(InboundStatusEnum.WAIT_FOR_DELIVERY));
    }

    @GetMapping("/deliveredInbound")
    public Long deliveredInboundNumber() {
        return Long.valueOf(omsOrderRepository.countByOrderStatus(InboundStatusEnum.DELIVERED));
    }

    @GetMapping("/completedInbound")
    public Long completedInboundNumber() {
        return Long.valueOf(omsOrderRepository.countByOrderStatus(InboundStatusEnum.COMPLETED));
    }

    @GetMapping("/closedInbound")
    public Long closedInboundNumber() {
        return Long.valueOf(omsOrderRepository.countByOrderStatus(InboundStatusEnum.CLOSED));
    }

    @GetMapping("/invalidInbound")
    public Long invalidInboundNumber() {
        return Long.valueOf(omsOrderRepository.countByOrderStatus(InboundStatusEnum.INVALID));
    }

}
