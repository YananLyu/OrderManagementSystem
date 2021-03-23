package com.astronet.oms.convertors.dtoconverter;

import com.astronet.oms.entity.PmsSpu;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 3/14/21 9:42 PM
 */

@Component
public class PmsSpuConverter {

//    public PmsSpuDto entityToDto(PmsSpu pmsSpu) {
//        PmsSpuDto pmsSpuDto = new PmsSpuDto();
//        pmsSpuDto.setId(pmsSpu.getId());
//        pmsSpuDto.setPlatformSeller(pmsSpu.getPlatformSeller());
//        pmsSpuDto.setProductName(pmsSpu.getProductName());
//        pmsSpuDto.setProductLink(pmsSpu.getProductLink());
//        return pmsSpuDto;
//    }
//
//    public List<PmsSpuDto> entityToDto(List<PmsSpu> pmsSpus) {
//        return pmsSpus.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
//    }
//
//    public PmsSpu dtoToEntity(PmsSpuDto pmsSpuDto) {
//        PmsSpu pmsSpu = new PmsSpu();
//        pmsSpu.setId(pmsSpuDto.getId());
//        pmsSpu.setPlatformSeller(pmsSpuDto.getPlatformSeller());
//        pmsSpu.setProductName(pmsSpuDto.getProductName());
//        pmsSpu.setProductLink(pmsSpuDto.getProductLink());
//        return pmsSpu;
//    }
//
//    public List<PmsSpu> dtoToEntity(List<PmsSpuDto> pmsSpuDtos) {
//        return pmsSpuDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//    }

}
