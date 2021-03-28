package com.astronet.oms.controller;

import com.astronet.oms.dtos.PmsSkuDto;
import com.astronet.oms.dtos.UserPaymentDto;
import com.astronet.oms.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:36 AM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserPaymentController {

    @Autowired
    UserPaymentService service;

    /**
     * C - Create
     * @param dto
     * @return
     */
    @PostMapping("/payments")
    public UserPaymentDto createPayment(@RequestBody UserPaymentDto dto) {
        return service.createPayment(dto);
    }

    /**
     * R - Read all
     * @return
     */
    @GetMapping("/payments")
    public List<UserPaymentDto> readAllPayment() {
        return service.readAllPayment();
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    @GetMapping("/payments/{id}")
    public ResponseEntity<UserPaymentDto> readOnePayment(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOnePayment(id));
    }

    /**
     * R - Retrieval all the pending payments
     * @return
     */
    @GetMapping("/payments/pending")
    public List<UserPaymentDto> pendingPayments() {
        return service.pendingPayments();
    }

    /**
     * R - Retrieval all the received payments
     * @return
     */
    @GetMapping("/payments/received")
    public List<UserPaymentDto> receivedPayments() {
        return service.receivedPayments();
    }

    /**
     * R - Retrieval all the issued payments
     * @return
     */
    @GetMapping("/payments/issued")
    public List<UserPaymentDto> issuedPayments() {
        return service.issuedPayments();
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/payments/{id}")
    public UserPaymentDto updatePayment(@RequestBody UserPaymentDto dto, @PathVariable Long id) {
        return service.updatePayment(dto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/payments/{id}")
    public void deletePayment(@PathVariable Long id) {
        service.deletePayment(id);
    }

}
