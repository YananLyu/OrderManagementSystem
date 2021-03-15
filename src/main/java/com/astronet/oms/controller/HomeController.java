package com.astronet.oms.controller;

import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhubo Deng
 * @date 3/14/21 9:42 PM
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    PmsSpuRepository pmsSpuRepository;

    @Autowired
    PmsSkuRepository pmsSkuRepository;


    @GetMapping("/")
    public Long activeOfferNumber() {
        return Long.valueOf(pmsSkuRepository.countByOfferStatus());
    }

    @GetMapping("/")
    public Long inactiveOfferNumber() {
        return Long.valueOf(pmsSkuRepository.countByOfferStatus());
    }

}
