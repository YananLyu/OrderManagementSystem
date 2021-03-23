package com.astronet.oms.dtos;

import lombok.Data;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 3:53 AM
 */

@Data
public class UserReadDto implements UserDto {
    private String username;
    private String email;
}
