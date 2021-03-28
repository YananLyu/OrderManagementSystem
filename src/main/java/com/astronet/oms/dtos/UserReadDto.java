package com.astronet.oms.dtos;

import lombok.*;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 3:53 AM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReadDto implements UserDto {
    private String username;
    private String email;
}
