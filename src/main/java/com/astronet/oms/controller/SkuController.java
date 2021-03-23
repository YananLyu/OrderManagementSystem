package com.astronet.oms.controller;

import com.astronet.oms.convertors.dtoconverter.PmsSkuConverter;
import com.astronet.oms.dtos.PmsSkuDto;
import com.astronet.oms.entity.PmsSku;
import com.astronet.oms.enums.OfferStatusEnum;
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

    @Autowired
    private PmsSkuConverter converter;

    /**
     * C - Create
     * @param pmsSkuDto
     * @return
     */
    @PostMapping("/admin/offers")
    public PmsSkuDto newOffer(@RequestBody PmsSkuDto pmsSkuDto) {
        PmsSku savedItem = repository.save(converter.dtoToEntity(pmsSkuDto));
        return converter.entityToDto(savedItem);
    }

    /**
     * R - Read
     * @return
     */
    @GetMapping("/offers")
    public List<PmsSkuDto> all() {
        List<PmsSku> findAll = repository.findAllByOrderByIdDesc();
        return converter.entityToDto(findAll);
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/offers/{id}")
    public ResponseEntity<PmsSkuDto> one(@PathVariable Long id) {
        PmsSku item = repository.findById(id)
                .orElseThrow(() -> new SkuNotFoundException(id));
        return ResponseEntity.ok(converter.entityToDto(item));
    }



    /**
     * R - Retrieval all the active offers
     * @return
     */
    @GetMapping("/offers/active")
    public List<PmsSkuDto> activeOffers() {
        List<PmsSku> items = repository.findByOfferStatus(OfferStatusEnum.ACTIVE);
        return converter.entityToDto(items);
    }

    /**
     * R - Retrieval all the inactive offers
     * @return
     */
    @GetMapping("/offers/inactive")
    public List<PmsSkuDto> inactiveOffers() {
        List<PmsSku> items = repository.findByOfferStatus(OfferStatusEnum.INACTIVE);
        return converter.entityToDto(items);
    }

    /**
     * U - Update
     * @param newPmsSkuDto
     * @param id
     * @return
     */
    @PutMapping("/offers/{id}")
    public PmsSkuDto updateOffer(@RequestBody PmsSkuDto newPmsSkuDto, @PathVariable Long id) {
        PmsSku newPmsSku = converter.dtoToEntity(newPmsSkuDto);
        PmsSku updatedPmsSku = repository.findById(id)
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
        return converter.entityToDto(updatedPmsSku);
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
