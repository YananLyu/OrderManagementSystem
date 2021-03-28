package com.astronet.oms.service;

import com.astronet.oms.dtos.OmsExpressTrackingDto;
import com.astronet.oms.entity.OmsExpressTracking;
import com.astronet.oms.enums.TrackingStatusEnum;
import com.astronet.oms.exception.OmsExpressTrackingNotFoundException;
import com.astronet.oms.repository.OmsExpressTrackingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:28 AM
 */

@Service
public class OmsExpressTrackingService {

    @Autowired
    OmsExpressTrackingRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create
     * @param dto
     * @return
     */
    public OmsExpressTrackingDto createTracking(OmsExpressTrackingDto dto) {
        OmsExpressTracking savedItem = repository.save(mapper.map(dto, OmsExpressTracking.class));
        return mapper.map(savedItem, OmsExpressTrackingDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<OmsExpressTrackingDto> readAllTracking() {
        List<OmsExpressTracking> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, OmsExpressTrackingDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    public OmsExpressTrackingDto readOneTracking(Long id) {
        OmsExpressTracking item = repository.findById(id)
                .orElseThrow(() -> new OmsExpressTrackingNotFoundException(id));
        return mapper.map(item, OmsExpressTrackingDto.class);
    }

    /**
     * R - Retrieval all the pending express tracking
     * @return
     */
    public List<OmsExpressTrackingDto> pendingTracking() {
        List<OmsExpressTracking> items = repository.findByTrackingStatus(TrackingStatusEnum.PENDING);
        return items.stream()
                .map(x -> mapper.map(x, OmsExpressTrackingDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the received express tracking
     * @return
     */
    public List<OmsExpressTrackingDto> receivedTracking() {
        List<OmsExpressTracking> items = repository.findByTrackingStatus(TrackingStatusEnum.RECEIVED);
        return items.stream()
                .map(x -> mapper.map(x, OmsExpressTrackingDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the issued express tracking
     * @return
     */
    public List<OmsExpressTrackingDto> issuedTracking() {
        List<OmsExpressTracking> items = repository.findByTrackingStatus(TrackingStatusEnum.ISSUED);
        return items.stream()
                .map(x -> mapper.map(x, OmsExpressTrackingDto.class))
                .collect(Collectors.toList());
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    public OmsExpressTrackingDto updateTracking(OmsExpressTrackingDto dto, Long id) {
        OmsExpressTracking newItem = mapper.map(dto, OmsExpressTracking.class);
        OmsExpressTracking updatedItem = repository.findById(id)
                .map(item -> {
                    item.setQuantity(newItem.getQuantity());
                    item.setTrackingStatus(newItem.getTrackingStatus());
                    item.setTrackingNote(newItem.getTrackingNote());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
        return mapper.map(updatedItem, OmsExpressTrackingDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteTracking(Long id) {
        repository.deleteById(id);
    }

}
