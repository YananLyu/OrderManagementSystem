package com.astronet.order_sys.controller;

import com.astronet.order_sys.entity.OmsSku;
import com.astronet.order_sys.exception.ResourceNotFoundException;
import com.astronet.order_sys.repository.OmsSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OfferController {

    @Autowired
    private OmsSkuRepository omsSkuRepository;

    @GetMapping("/offers")
    public List<OmsSku> getAllOffers() {
        return omsSkuRepository.findAllByOrderByCreateTimeDesc();
    }

    @GetMapping("/offers/active")
    public List<OmsSku> getOfferByIds() {
        return omsSkuRepository.findAll();
    }

    @GetMapping("/offers/items/{id}")
    public ResponseEntity<OmsSku> getOfferById(@PathVariable Long id) {
        OmsSku item = omsSkuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: " + id));

        return ResponseEntity.ok(item);
    }

}
