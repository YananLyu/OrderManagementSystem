package com.astronet.oms.controller;


import com.astronet.oms.exception.ResourceNotFoundException;
import com.astronet.oms.model.Item;
import com.astronet.oms.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // get all items
    @GetMapping("/items")
    public List<Item> getAllItems() {
//        return itemRepository.findAll();
        return itemRepository.findAllByOrderByCreateTimeAsc();
    }

    @GetMapping("items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: " + id));

        return ResponseEntity.ok(item);
    }
}
