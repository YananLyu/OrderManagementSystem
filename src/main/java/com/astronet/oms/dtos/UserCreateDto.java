package com.astronet.oms.dtos;

import lombok.Data;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 3:57 AM
 */

@Data
public class UserCreateDto implements UserDto {
    private String username;
    private String email;
    private String password;
}
