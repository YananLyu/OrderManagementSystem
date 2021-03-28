package com.astronet.oms.service;

import com.astronet.oms.dtos.PmsSpuDto;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.exception.SpuNotFoundException;
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
public class PmsSpuService {

    @Autowired
    PmsSpuRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create
     * @param pmsSpuDto
     * @return
     */
    public PmsSpuDto createProduct(PmsSpuDto pmsSpuDto) {
        PmsSpu savedItem = repository.save(mapper.map(pmsSpuDto, PmsSpu.class));
        return mapper.map(savedItem, PmsSpuDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<PmsSpuDto> readAllProduct() {
        List<PmsSpu> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, PmsSpuDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    public PmsSpuDto readOneProduct(Long id) {
        PmsSpu item = repository.findById(id)
                .orElseThrow(() -> new SpuNotFoundException(id));
        return mapper.map(item, PmsSpuDto.class);
    }

    /**
     * U - Update
     * @param newPmsSpuDto
     * @param id
     * @return
     */
    public PmsSpuDto updateProduct(PmsSpuDto newPmsSpuDto, Long id) {
        PmsSpu newPmsSpu = mapper.map(newPmsSpuDto, PmsSpu.class);
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
        return mapper.map(updatedPmsSpu, PmsSpuDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

}
