package com.astronet.oms.controller;

import com.astronet.oms.dtos.UserCreateDto;
import com.astronet.oms.dtos.UserDto;
import com.astronet.oms.dtos.UserReadDto;
import com.astronet.oms.dtos.UserUpdateDto;
import com.astronet.oms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/20/2021 6:50 PM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * C - Create
     * @param userCreateDto
     * @return
     */
    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return service.createUser(userCreateDto);
    }

    /**
     * R - Read
     * @return
     */
    @GetMapping("/users")
    public List<UserDto> readAllUser() {
        return service.readAllUser();
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<UserReadDto> readOneUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneUser(id));
    }

    /**
     * U - Update Username or Email
     * @param newUserUpdateDto
     * @param id
     * @return
     */
    @PutMapping("/users/{id}")
    public UserDto updateUser(@RequestBody UserUpdateDto newUserUpdateDto, @PathVariable Long id) {
        return service.updateUser(newUserUpdateDto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

}
