package com.astronet.oms.controller;

import com.astronet.oms.entity.PmsSku;
import com.astronet.oms.exception.SkuNotFoundException;
import com.astronet.oms.repository.PmsSkuRepository;
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
    private PmsSkuRepository repository;

    /**
     * C - Create
     * @param pmsSku
     * @return
     */
    @PostMapping("/admin/offers")
    public PmsSku newOffer(@RequestBody PmsSku pmsSku) {
        return repository.save(pmsSku);
    }

    /**
     * R - Read
     * @return
     */
    @GetMapping("/offers")
    public List<PmsSku> all() {
        return repository.findAllByOrderByIdDesc();
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/offers/{id}")
    public ResponseEntity<PmsSku> one(@PathVariable Long id) {
        PmsSku item = repository.findById(id)
                .orElseThrow(() -> new SkuNotFoundException(id));
        return ResponseEntity.ok(item);
    }



    /**
     * R - Retrieval all the active offers
     * @return
     */
    @GetMapping("/offers/active")
    public List<PmsSku> activeOffers() {
        return repository.findByOfferStatus(Integer.valueOf(1));
    }

    /**
     * R - Retrieval all the inactive offers
     * @return
     */
    @GetMapping("/offers/inactive")
    public List<PmsSku> inactiveOffers() {
        return repository.findByOfferStatus(Integer.valueOf(0));
    }

    /**
     * U - Update
     * @param newPmsSku
     * @param id
     * @return
     */
    @PutMapping("/offers/{id}")
    public PmsSku updateOffer(@RequestBody PmsSku newPmsSku, @PathVariable Long id) {
        return repository.findById(id)
                .map(sku -> {
                    sku.setUnitPrice(newPmsSku.getUnitPrice());
                    sku.setAdminPrice(newPmsSku.getAdminPrice());
                    sku.setModPrice(newPmsSku.getModPrice());
                    sku.setQuantity(newPmsSku.getQuantity());
                    sku.setQuantityLeft(newPmsSku.getQuantityLeft());
                    sku.setOfferStatus(newPmsSku.getOfferStatus());
                    sku.setOfferNote(newPmsSku.getOfferNote());
                    return repository.save(sku);
                })
                .orElseGet(() -> {
                    newPmsSku.setId(id);
                    return repository.save(newPmsSku);
                });
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/admin/offers/{id}")
    public void deleteOffer(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
