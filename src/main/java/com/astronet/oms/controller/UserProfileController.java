package com.astronet.oms.controller;

import com.astronet.oms.dtos.UserProfileDto;
import com.astronet.oms.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/20/2021 7:24 PM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    UserProfileService service;

    /**
     * C - Create
     * @param userProfileDto
     * @return
     */
    @PostMapping("/userProfile")
    public UserProfileDto createUserProfile(@RequestBody UserProfileDto userProfileDto) {
        return service.createUserProfile(userProfileDto);
    }

    /**
     * R - Read all
     * @return
     */
    @GetMapping("/userProfile")
    public List<UserProfileDto> readAllUserProfile() {
        return service.readAllUserProfile();
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    @GetMapping("/userProfile/{id}")
    public ResponseEntity<UserProfileDto> readOneUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneUserProfile(id));
    }

    /**
     * U - Update Username or Email
     * @param newUserProfileDto
     * @param id
     * @return
     */
    @PutMapping("/userProfile/{id}")
    public UserProfileDto updateUserProfile(@RequestBody UserProfileDto newUserProfileDto, @PathVariable Long id) {
        return service.updateUserProfile(newUserProfileDto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/userProfile/{id}")
    public void deleteUserProfile(@PathVariable Long id) {
        service.deleteUserProfile(id);
    }

}
