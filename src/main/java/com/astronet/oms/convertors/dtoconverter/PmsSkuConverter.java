package com.astronet.oms.convertors.dtoconverter;

import com.astronet.oms.dtos.PmsSkuDto;
import com.astronet.oms.entity.PmsSku;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 3/14/21 9:42 PM
 */

@Component
public class PmsSkuConverter {

//    public PmsSkuDto entityToDto(PmsSku pmsSku) {
//        PmsSkuDto pmsSkuDto = new PmsSkuDto();
//        pmsSkuDto.setId(pmsSku.getId());
//        pmsSkuDto.setPmsSpu(pmsSku.getPmsSpu());
//        pmsSkuDto.setUnitPrice(pmsSku.getUnitPrice());
//        pmsSkuDto.setAdminPrice(pmsSku.getAdminPrice());
//        pmsSkuDto.setModPrice(pmsSku.getModPrice());
//        pmsSkuDto.setQuantity(pmsSku.getQuantity());
//        pmsSkuDto.setQuantityLeft(pmsSku.getQuantityLeft());
//        pmsSkuDto.setOfferStatus(pmsSku.getOfferStatus());
//        pmsSkuDto.setOfferNote(pmsSku.getOfferNote());
//        return pmsSkuDto;
//    }
//
//    public List<PmsSkuDto> entityToDto(List<PmsSku> pmsSkus) {
//        return pmsSkus.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
//    }
//
//    public PmsSku dtoToEntity(PmsSkuDto pmsSkuDto) {
//        PmsSku pmsSku = new PmsSku();
//        pmsSku.setId(pmsSkuDto.getId());
//        pmsSku.setPmsSpu(pmsSkuDto.getPmsSpu());
//        pmsSku.setUnitPrice(pmsSkuDto.getUnitPrice());
//        pmsSku.setAdminPrice(pmsSkuDto.getAdminPrice());
//        pmsSku.setModPrice(pmsSkuDto.getModPrice());
//        pmsSku.setQuantity(pmsSkuDto.getQuantity());
//        pmsSku.setQuantityLeft(pmsSkuDto.getQuantityLeft());
//        pmsSku.setOfferStatus(pmsSkuDto.getOfferStatus());
//        pmsSku.setOfferNote(pmsSkuDto.getOfferNote());
//        return pmsSku;
//    }
//
//    public List<PmsSku> dtoToEntity(List<PmsSkuDto> pmsSkuDtos) {
//        return pmsSkuDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//    }

}
