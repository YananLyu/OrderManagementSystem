package com.astronet.oms.service;

import com.astronet.oms.dtos.PmsInventoryDto;
import com.astronet.oms.entity.PmsInventory;
import com.astronet.oms.exception.PmsInventoryNotFoundException;
import com.astronet.oms.repository.PmsInventoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:07 AM
 */

@Service
public class PmsInventoryService {

    @Autowired
    PmsInventoryRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create
     * @param dto
     * @return
     */
    public PmsInventoryDto createInventory(PmsInventoryDto dto) {
        PmsInventory savedItem = repository.save(mapper.map(dto, PmsInventory.class));
        return mapper.map(savedItem, PmsInventoryDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<PmsInventoryDto> readAllInventory() {
        List<PmsInventory> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, PmsInventoryDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    public PmsInventoryDto readOneInventory(Long id) {
        PmsInventory item = repository.findById(id)
                .orElseThrow(() -> new PmsInventoryNotFoundException(id));
        return mapper.map(item, PmsInventoryDto.class);
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    public PmsInventoryDto updateInventory(PmsInventoryDto dto, Long id) {
        PmsInventory newItem = mapper.map(dto, PmsInventory.class);
        PmsInventory updatedItem = repository.findById(id)
                .map(item -> {
                    item.setAddrType(newItem.getAddrType());
                    item.setAddrLine1(newItem.getAddrLine1());
                    item.setAddrLine2(newItem.getAddrLine2());
                    item.setAddrCity(newItem.getAddrCity());
                    item.setAddrState(newItem.getAddrState());
                    item.setAddrZipcode(newItem.getAddrZipcode());
                    item.setAddrCountry(newItem.getAddrCountry());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
        return mapper.map(updatedItem, PmsInventoryDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteInventory(Long id) {
        repository.deleteById(id);
    }

}
