package com.astronet.oms.controller;

import com.astronet.oms.dtos.UserPaymentMethodsDto;
import com.astronet.oms.service.UserPaymentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/27/2021 8:01 PM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserPaymentMethodsController {

    @Autowired
    UserPaymentMethodsService service;

    /**
     * C - Create a new payment method
     * @param dto
     * @return
     */
    @PostMapping("/payment_methods")
    public UserPaymentMethodsDto createPaymentMethod(UserPaymentMethodsDto dto) {
        return service.createPaymentMethod(dto);
    }

    /**
     * R - Read all payment methods
     * @return
     */
    @GetMapping("/payment_methods")
    public List<UserPaymentMethodsDto> readAllPaymentMethods() {
        return service.readAllPaymentMethods();
    }

    /**
     * R - Read one payment method
     * @param id
     * @return
     */
    @GetMapping("/payment_methods/{id}")
    public UserPaymentMethodsDto readOnePaymentMethods(@PathVariable Long id) {
        return service.readOnePaymentMethods(id);
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/payment_methods/{id}")
    public UserPaymentMethodsDto updatePaymentMethod(@RequestBody UserPaymentMethodsDto dto, @PathVariable Long id) {
        return service.updatePaymentMethod(dto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/payment_methods/{id}")
    public void deletePaymentMethod(@PathVariable Long id) {
        service.deletePaymentMethod(id);
    }

}
