package com.astronet.oms.controller;

import com.astronet.oms.dtos.PmsInventoryDto;
import com.astronet.oms.service.PmsInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:16 AM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PmsInventoryController {

    @Autowired
    PmsInventoryService service;

    /**
     * C - Create
     * @param dto
     * @return
     */
    @PostMapping("/inventory")
    public PmsInventoryDto createInventory(@RequestBody PmsInventoryDto dto) {
        return service.createInventory(dto);
    }

    /**
     * R - Read all
     * @return
     */
    @GetMapping("/inventory")
    public List<PmsInventoryDto> readAllInventory() {
        return service.readAllInventory();
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    @GetMapping("/inventory/{id}")
    public ResponseEntity<PmsInventoryDto> readOneInventory(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneInventory(id));
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/inventory/{id}")
    public PmsInventoryDto updateInventory(@RequestBody PmsInventoryDto dto, @PathVariable Long id) {
        return service.updateInventory(dto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable Long id) {
        service.deleteInventory(id);
    }

}
