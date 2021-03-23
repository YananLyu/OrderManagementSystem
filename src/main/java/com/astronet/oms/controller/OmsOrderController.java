package com.astronet.oms.controller;

import com.astronet.oms.convertors.dtoconverter.OmsOrderConverter;
import com.astronet.oms.dtos.OmsOrderDto;
import com.astronet.oms.entity.OmsOrder;
import com.astronet.oms.enums.InboundStatusEnum;
import com.astronet.oms.exception.SkuNotFoundException;
import com.astronet.oms.repository.OmsOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Zhubo Deng
 * @date 3/15/21 11:44 AM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OmsOrderController {

    @Autowired
    OmsOrderRepository repository;

    @Autowired
    OmsOrderConverter converter;

    /**
     * C - Create
     * @param omsOrderDto
     * @return
     */
    @PostMapping("/user/inbounds")
    public OmsOrderDto newInbound(@RequestBody OmsOrderDto omsOrderDto) {
        OmsOrder savedItem = repository.save(converter.dtoToEntity(omsOrderDto));
        return converter.entityToDto(savedItem);
    }

    /**
     * R - Read
     * @return
     */
    @GetMapping("/inbounds")
    public List<OmsOrderDto> all() {
        List<OmsOrder> findAll = repository.findAllByOrderByIdDesc();
        return converter.entityToDto(findAll);
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/inbounds/{id}")
    public ResponseEntity<OmsOrderDto> one(@PathVariable Long id) {
        OmsOrder item = repository.findById(id)
                .orElseThrow(() -> new SkuNotFoundException(id));
        return ResponseEntity.ok(converter.entityToDto(item));
    }

    /**
     * R - Retrieval all the wait-for-payment inbounds
     * @return
     */
    @GetMapping("/inbounds/waitForPayment")
    public List<OmsOrderDto> waitForPaymentInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.WAIT_FOR_PAYMENT);
        return converter.entityToDto(items);
    }

    /**
     * R - Retrieval all the wait-for-delivery inbounds
     * @return
     */
    @GetMapping("/inbounds/waitForDelivery")
    public List<OmsOrderDto> waitForDeliveryInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.WAIT_FOR_DELIVERY);
        return converter.entityToDto(items);
    }

    /**
     * R - Retrieval all the delivered inbounds
     * @return
     */
    @GetMapping("/inbounds/delivered")
    public List<OmsOrderDto> deliveredInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.DELIVERED);
        return converter.entityToDto(items);
    }

    /**
     * R - Retrieval all the completed inbounds
     * @return
     */
    @GetMapping("/inbounds/completed")
    public List<OmsOrderDto> completedInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.COMPLETED);
        return converter.entityToDto(items);
    }

    /**
     * R - Retrieval all the closed inbounds
     * @return
     */
    @GetMapping("/inbounds/closed")
    public List<OmsOrderDto> closedInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.CLOSED);
        return converter.entityToDto(items);
    }

    /**
     * R - Retrieval all the invalid inbounds
     * @return
     */
    @GetMapping("/inbounds/invalid")
    public List<OmsOrderDto> invalidInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.INVALID);
        return converter.entityToDto(items);
    }

    /**
     * TODO: Finish all the setters
     * U - Update
     * @param newOmsOrderDto
     * @param id
     * @return
     */
    @PutMapping("/Inbounds/{id}")
    public OmsOrderDto updateInbounds(@RequestBody OmsOrderDto newOmsOrderDto, @PathVariable Long id) {
        OmsOrder newOmsOrder = converter.dtoToEntity(newOmsOrderDto);
        OmsOrder updatedOmsOrder = repository.findById(id)
                .map(order -> {
                    order.setOrderStatus(newOmsOrder.getOrderStatus());



                    return repository.save(order);
                })
                .orElseGet(() -> {
                    newOmsOrder.setId(id);
                    return repository.save(newOmsOrder);
                });
        return converter.entityToDto(updatedOmsOrder);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/user/inbounds/{id}")
    public void deleteInbound(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
