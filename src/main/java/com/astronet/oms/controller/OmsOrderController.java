package com.astronet.oms.controller;

import com.astronet.oms.convertors.dtoconverter.OmsOrderConverter;
import com.astronet.oms.dtos.OmsOrderCreateDto;
import com.astronet.oms.dtos.OmsOrderDto;
import com.astronet.oms.dtos.OmsOrderUpdateDto;
import com.astronet.oms.entity.OmsOrder;
import com.astronet.oms.enums.InboundStatusEnum;
import com.astronet.oms.exception.SkuNotFoundException;
import com.astronet.oms.repository.OmsOrderRepository;
import com.astronet.oms.service.OmsOrderService;
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
    OmsOrderService service;

    /**
     * C - Create
     * @param omsOrderCreateDto
     * @return
     */
    @PostMapping("/user/inbounds")
    public OmsOrderDto createInbound(@RequestBody OmsOrderCreateDto omsOrderCreateDto) {
        return service.createInbound(omsOrderCreateDto);
    }

    /**
     * R - Read
     * @return
     */
    @GetMapping("/inbounds")
    public List<OmsOrderDto> readAllInbounds() {
        return service.readAllInbounds();
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/inbounds/{id}")
    public ResponseEntity<OmsOrderDto> readOneInbound(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneInbound(id));
    }

    /**
     * R - Retrieval all the wait-for-payment inbounds
     * @return
     */
    @GetMapping("/inbounds/wait_for_payment")
    public List<OmsOrderDto> waitForPaymentInbounds() {
        return service.waitForPaymentInbounds();
    }

    /**
     * R - Retrieval all the wait-for-delivery inbounds
     * @return
     */
    @GetMapping("/inbounds/wait_for_delivery")
    public List<OmsOrderDto> waitForDeliveryInbounds() {
        return service.waitForDeliveryInbounds();
    }

    /**
     * R - Retrieval all the delivered inbounds
     * @return
     */
    @GetMapping("/inbounds/delivered")
    public List<OmsOrderDto> deliveredInbounds() {
        return service.deliveredInbounds();
    }

    /**
     * R - Retrieval all the completed inbounds
     * @return
     */
    @GetMapping("/inbounds/completed")
    public List<OmsOrderDto> completedInbounds() {
        return service.completedInbounds();
    }

    /**
     * R - Retrieval all the closed inbounds
     * @return
     */
    @GetMapping("/inbounds/closed")
    public List<OmsOrderDto> closedInbounds() {
        return service.closedInbounds();
    }

    /**
     * R - Retrieval all the invalid inbounds
     * @return
     */
    @GetMapping("/inbounds/invalid")
    public List<OmsOrderDto> invalidInbounds() {
        return service.invalidInbounds();
    }

    /**
     * TODO: Finish all the setters
     * U - Update
     * @param newOmsOrderDto
     * @param id
     * @return
     */
    @PutMapping("/Inbounds/{id}")
    public OmsOrderDto updateInbounds(@RequestBody OmsOrderUpdateDto newOmsOrderDto, @PathVariable Long id) {
        return service.updateInbounds(newOmsOrderDto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/user/inbounds/{id}")
    public void deleteInbound(@PathVariable Long id) {
        service.deleteInbound(id);
    }

}
