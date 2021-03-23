package com.astronet.oms.service;

import com.astronet.oms.dtos.*;
import com.astronet.oms.exception.SkuNotFoundException;
import com.astronet.oms.repository.UserRepository;
import com.astronet.oms.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 3:58 AM
 */

@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserCreateDto userCreateDto) {
        User savedUser = repository.save(modelMapper.map(userCreateDto, User.class));
        return modelMapper.map(savedUser, UserCreateDto.class);
    }

//    public List<UserDto> readAllUser() {
//
//    }

    public UserReadDto readOneUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new SkuNotFoundException(id));
        return modelMapper.map(user, UserReadDto.class);
    }

    public UserDto updateUser(UserUpdateDto newUserUpdateDto, Long id) {
        User newUser = modelMapper.map(newUserUpdateDto, User.class);
        User updatedUser = repository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
        return modelMapper.map(updatedUser, UserUpdateDto.class);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

}
