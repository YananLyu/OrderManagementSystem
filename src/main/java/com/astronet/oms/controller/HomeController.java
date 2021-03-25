package com.astronet.oms.controller;

import com.astronet.oms.convertors.dtoconverter.PmsSkuConverter;
import com.astronet.oms.convertors.dtoconverter.PmsSpuConverter;
import com.astronet.oms.dtos.HomeDto;
import com.astronet.oms.enums.InboundStatusEnum;
import com.astronet.oms.enums.OfferStatusEnum;
import com.astronet.oms.repository.OmsOrderRepository;
import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import com.astronet.oms.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: Outbounds and Payments
 * @author Yanan Lyu
 * @date 3/14/21 9:42 PM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    HomeService homeService;

    /**
     * 查  R
     * 返回offer， inbound，outbound，payment对应的case数量
     * @return HomeDto
     */
    @GetMapping("/home")
    public HomeDto getOffersInfo() {
        return homeService.getOffersInfo();
    }
}
