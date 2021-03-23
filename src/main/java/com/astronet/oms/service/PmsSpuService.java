package com.astronet.oms.service;

import com.astronet.oms.dtos.PmsSpuDto;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.exception.SpuNotFoundException;
import com.astronet.oms.repository.PmsSpuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 5:34 AM
 */

@Component
public class PmsSpuService {

    @Autowired
    PmsSpuRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public PmsSpuDto createProduct(PmsSpuDto pmsSpuDto) {
        PmsSpu savedItem = repository.save(modelMapper.map(pmsSpuDto, PmsSpu.class));
        return modelMapper.map(savedItem, PmsSpuDto.class);
    }

//        public List<PmsSpuDto> readAllProduct() {
//        List<PmsSpu> findAll = repository.findAllByOrderByIdDesc();
//        return converter.entityToDto(findAll);
//    }

    public PmsSpuDto readOneProduct(Long id) {
        PmsSpu item = repository.findById(id)
                .orElseThrow(() -> new SpuNotFoundException(id));
        return modelMapper.map(item, PmsSpuDto.class);
    }

    public PmsSpuDto updateProduct(PmsSpuDto newPmsSpuDto, Long id) {
        PmsSpu newPmsSpu = modelMapper.map(newPmsSpuDto, PmsSpu.class);
        PmsSpu updatedPmsSpu = repository.findById(id)
                .map(spu -> {
                    spu.setProductName(newPmsSpu.getProductName());
                    spu.setProductLink(newPmsSpu.getProductLink());
                    spu.setPlatformSeller(newPmsSpu.getPlatformSeller());
                    return repository.save(spu);
                })
                .orElseGet(() -> {
                    newPmsSpu.setId(id);
                    return repository.save(newPmsSpu);
                });
        return modelMapper.map(updatedPmsSpu, PmsSpuDto.class);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

}
