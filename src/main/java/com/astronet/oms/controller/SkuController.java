package com.astronet.oms.controller;

import com.astronet.oms.dtos.PmsSkuCreateDto;
import com.astronet.oms.dtos.PmsSkuDto;
import com.astronet.oms.dtos.PmsSkuUpdateDto;
import com.astronet.oms.service.PmsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 3/13/21 9:42 PM
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SkuController {

    @Autowired
    private PmsSkuService service;

    /**
     * C - Create
     * @param pmsSkuCreateDto
     * @return
     */
    @PostMapping("/admin/offers")
    public PmsSkuDto createOffer(@RequestBody PmsSkuCreateDto pmsSkuCreateDto) {
        return service.createOffer(pmsSkuCreateDto);
    }

    /**
     * R - Read
     * @return
     */
    @GetMapping("/offers")
    public List<PmsSkuDto> readAllOffers() {
        return service.readAllOffers();
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/offers/{id}")
    public ResponseEntity<PmsSkuDto> readOneOffer(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneOffer(id));
    }

    /**
     * R - Retrieval all the active offers
     * @return
     */
    @GetMapping("/offers/active")
    public List<PmsSkuDto> activeOffers() {
        return service.activeOffers();
    }

    /**
     * R - Retrieval all the inactive offers
     * @return
     */
    @GetMapping("/offers/inactive")
    public List<PmsSkuDto> inactiveOffers() {
        return service.inactiveOffers();
    }

    /**
     * U - Update
     * @param newPmsSkuDto
     * @param id
     * @return
     */
    @PutMapping("/offers/{id}")
    public PmsSkuDto updateOffer(@RequestBody PmsSkuUpdateDto newPmsSkuDto, @PathVariable Long id) {
        return service.updateOffer(newPmsSkuDto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/admin/offers/{id}")
    public void deleteOffer(@PathVariable Long id) {
        service.deleteOffer(id);
    }

}
