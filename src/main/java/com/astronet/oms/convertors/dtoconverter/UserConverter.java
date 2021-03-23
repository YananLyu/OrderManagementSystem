package com.astronet.oms.convertors.dtoconverter;

import com.astronet.oms.dtos.UserDto;
import com.astronet.oms.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/22/2021 4:20 PM
 */

@Component
public class UserConverter {

//    public UserDto entityToDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setUsername(user.getUsername());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        return userDto;
//    }
//
//    public List<UserDto> entityToDto(List<User> users) {
//        return users.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
//    }
//
//    public User dtoToEntity(UserDto userDto) {
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setUsername(userDto.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        return user;
//    }
//
//    public List<User> dtoToEntity(List<UserDto> userDtos) {
//        return userDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//    }

}
