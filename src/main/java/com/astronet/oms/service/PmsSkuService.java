package com.astronet.oms.service;

import com.astronet.oms.dtos.*;
import com.astronet.oms.entity.PmsSku;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.enums.OfferStatusEnum;
import com.astronet.oms.exception.SkuNotFoundException;
import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 5:34 AM
 */

@Service
public class PmsSkuService {

    @Autowired
    PmsSkuRepository pmsSkuRepository;

    @Autowired
    PmsSpuRepository pmsSpuRepository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create; create spu & sku instance from one DTO, save to both repo
     * @param pmsSkuCreateDto
     * @return
     */
    public PmsSkuDto createOffer(PmsSkuCreateDto pmsSkuCreateDto) {
//        PmsSpu savedPmsSpu = pmsSpuRepository.save(mapper.map(pmsSkuCreateDto, PmsSpu.class));
//        PmsSku pmsSku = mapper.map(pmsSkuCreateDto, PmsSku.class);
//        pmsSku.setPmsSpu(savedPmsSpu);
//        pmsSku.setQuantityLeft(pmsSku.getQuantity());
//        pmsSku.setOfferStatus(OfferStatusEnum.ACTIVE);
//        PmsSku savedPmsSku = pmsSkuRepository.save(pmsSku);

        PmsSpu pmsSpu = mapper.map(pmsSkuCreateDto, PmsSpu.class);
        PmsSku pmsSku = mapper.map(pmsSkuCreateDto, PmsSku.class);
        pmsSku.setPmsSpu(pmsSpu);
        pmsSku.setQuantityLeft(pmsSku.getQuantity());
        pmsSku.setOfferStatus(OfferStatusEnum.ACTIVE);
        PmsSku savedPmsSku = pmsSkuRepository.save(pmsSku);   // save both sku & spu b/c persist

        PmsSkuCreateDto returnedDto = mapper.map(savedPmsSku, PmsSkuCreateDto.class);
        returnedDto.setPlatformSeller(savedPmsSku.getPmsSpu().getPlatformSeller());
        returnedDto.setProductName(savedPmsSku.getPmsSpu().getProductName());
        returnedDto.setProductLink(savedPmsSku.getPmsSpu().getProductLink());

        return returnedDto;
    }

    /**
     * R - Read all
     * @return
     */
    public List<PmsSkuDto> readAllOffers() {
        List<PmsSku> findAll = pmsSkuRepository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, PmsSkuReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    public PmsSkuDto readOneOffer(Long id) {
        PmsSku item = pmsSkuRepository.findById(id)
                .orElseThrow(() -> new SkuNotFoundException(id));
        return mapper.map(item, PmsSkuReadDto.class);
    }

    /**
     * R - Retrieval all the active offers
     * @return
     */
    public List<PmsSkuDto> activeOffers() {
        List<PmsSku> items = pmsSkuRepository.findByOfferStatus(OfferStatusEnum.ACTIVE);
        System.out.println(items);
        return items.stream()
                .map(x -> mapper.map(x, PmsSkuReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the inactive offers
     * @return
     */
    public List<PmsSkuDto> inactiveOffers() {
        List<PmsSku> items = pmsSkuRepository.findByOfferStatus(OfferStatusEnum.INACTIVE);
        return items.stream()
                .map(x -> mapper.map(x, PmsSkuReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * U - Update
     * @param newPmsSkuDto
     * @param id
     * @return
     */
    public PmsSkuDto updateOffer(PmsSkuUpdateDto newPmsSkuDto, Long id) {
        PmsSku newPmsSku = mapper.map(newPmsSkuDto, PmsSku.class);
        PmsSku updatedPmsSku = pmsSkuRepository.findById(id)
                .map(sku -> {
                    sku.setUnitPrice(newPmsSku.getUnitPrice());
                    sku.setAdminPrice(newPmsSku.getAdminPrice());
                    sku.setModPrice(newPmsSku.getModPrice());
                    sku.setQuantity(newPmsSku.getQuantity());
                    sku.setQuantityLeft(newPmsSku.getQuantityLeft());
                    sku.setOfferStatus(newPmsSku.getOfferStatus());
                    sku.setOfferNote(newPmsSku.getOfferNote());
                    return pmsSkuRepository.save(sku);
                })
                .orElseGet(() -> {
                    newPmsSku.setId(id);
                    return pmsSkuRepository.save(newPmsSku);
                });
        return mapper.map(updatedPmsSku, PmsSkuUpdateDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteOffer(Long id) {
        pmsSkuRepository.deleteById(id);
    }

}
