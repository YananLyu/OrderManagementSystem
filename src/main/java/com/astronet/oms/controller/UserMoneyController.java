package com.astronet.oms.controller;

import com.astronet.oms.dtos.UserMoneyDto;
import com.astronet.oms.service.UserMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:57 AM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserMoneyController {

    @Autowired
    UserMoneyService service;

    /**
     * C - Create
     * @param dto
     * @return
     */
    @PostMapping("/money")
    public UserMoneyDto createMoney(@RequestBody UserMoneyDto dto) {
        return service.createMoney(dto);
    }

    /**
     * R - Read all
     * @return
     */
    @GetMapping("/money")
    public List<UserMoneyDto> readAllMoney() {
        return service.readAllMoney();
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    @GetMapping("/money/{id}")
    public ResponseEntity<UserMoneyDto> readOneMoney(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneMoney(id));
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/money/{id}")
    public UserMoneyDto updateMoney(@RequestBody UserMoneyDto dto, @PathVariable Long id) {
        return service.updateMoney(dto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/money/{id}")
    public void deleteMoney(@PathVariable Long id) {
        service.deleteMoney(id);
    }

}
