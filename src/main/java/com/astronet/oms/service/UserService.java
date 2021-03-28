package com.astronet.oms.service;

import com.astronet.oms.dtos.*;
import com.astronet.oms.exception.UserNotFoundException;
import com.astronet.oms.repository.UserRepository;
import com.astronet.oms.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 3:58 AM
 */

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * C - Create
     * @param userCreateDto
     * @return
     */
    public UserDto createUser(UserCreateDto userCreateDto) {
        User savedUser = repository.save(modelMapper.map(userCreateDto, User.class));
        return modelMapper.map(savedUser, UserCreateDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<UserDto> readAllUser() {
        List<User> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> modelMapper.map(x, UserReadDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read one
     * @param id
     * @return
     */
    public UserReadDto readOneUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserReadDto.class);
    }

    /**
     * U - Update
     * @param newUserUpdateDto
     * @param id
     * @return
     */
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

    /**
     * D - Delete
     * @param id
     */
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

}
