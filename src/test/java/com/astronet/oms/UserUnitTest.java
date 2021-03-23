package com.astronet.oms;

import com.astronet.oms.dtos.UserDto;
import com.astronet.oms.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 5:22 AM
 */
public class UserUnitTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

//    @Test
//    public UserDto createUser_usingUserService() {
//
//    }
}
