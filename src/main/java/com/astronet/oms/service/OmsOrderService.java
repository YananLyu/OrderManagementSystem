package com.astronet.oms.service;

import com.astronet.oms.dtos.*;
import com.astronet.oms.entity.OmsOrder;
import com.astronet.oms.enums.InboundStatusEnum;
import com.astronet.oms.exception.InboundNotFoundException;
import com.astronet.oms.repository.OmsOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 6:47 PM
 */

@Service
public class OmsOrderService {

    @Autowired
    OmsOrderRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create
     * @param omsOrderCreateDto
     * @return
     */
    public OmsOrderDto createInbound(OmsOrderCreateDto omsOrderCreateDto) {
        OmsOrder savedItem = repository.save(mapper.map(omsOrderCreateDto, OmsOrder.class));
        return mapper.map(savedItem, OmsOrderCreateDto.class);
    }

    /**
     * R - Read
     * @return
     */
    public List<OmsOrderDto> readAllInbounds() {
        List<OmsOrder> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    public OmsOrderDto readOneInbound(Long id) {
        OmsOrder item = repository.findById(id)
                .orElseThrow(() -> new InboundNotFoundException(id));
        return mapper.map(item, OmsOrderReadDto.class);
    }

    /**
     * R - Retrieval all the wait-for-payment inbounds
     * @return
     */
    public List<OmsOrderDto> waitForPaymentInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.WAIT_FOR_PAYMENT);
        return items.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the wait-for-delivery inbounds
     * @return
     */
    public List<OmsOrderDto> waitForDeliveryInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.WAIT_FOR_DELIVERY);
        return items.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the delivered inbounds
     * @return
     */
    public List<OmsOrderDto> deliveredInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.DELIVERED);
        return items.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the completed inbounds
     * @return
     */
    public List<OmsOrderDto> completedInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.COMPLETED);
        return items.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the closed inbounds
     * @return
     */
    public List<OmsOrderDto> closedInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.CLOSED);
        return items.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the invalid inbounds
     * @return
     */
    public List<OmsOrderDto> invalidInbounds() {
        List<OmsOrder> items = repository.findByOrderStatus(InboundStatusEnum.INVALID);
        return items.stream()
                .map(x -> mapper.map(x, OmsOrderReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * U - Update
     * @param newOmsOrderDto
     * @param id
     * @return
     */
    public OmsOrderDto updateInbounds(OmsOrderUpdateDto newOmsOrderDto, Long id) {
        OmsOrder newOmsOrder = mapper.map(newOmsOrderDto, OmsOrder.class);
        OmsOrder updatedOmsOrder = repository.findById(id)
                .map(order -> {
                    order.setSuper_order_id(newOmsOrder.getSuper_order_id());
                    order.setOrderStatus(newOmsOrder.getOrderStatus());
                    order.setRefundAmount(newOmsOrder.getRefundAmount());
                    order.setOfferNote(newOmsOrder.getOfferNote());
                    return repository.save(order);
                })
                .orElseGet(() -> {
                    newOmsOrder.setId(id);
                    return repository.save(newOmsOrder);
                });
        return mapper.map(updatedOmsOrder, OmsOrderUpdateDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteInbound(Long id) {
        repository.deleteById(id);
    }

}
