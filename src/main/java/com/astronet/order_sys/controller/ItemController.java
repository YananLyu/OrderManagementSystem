package com.astronet.order_sys.controller;


import com.astronet.order_sys.model.Item;
import com.astronet.order_sys.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return itemRepository.findAll();
    }
}
