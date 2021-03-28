package com.astronet.oms.dtos;

import lombok.*;

/**
 * @author Zhubo Deng
 * @date 03/20/2021 6:49 PM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {

    private String wechatId;
    private String wechatName;
    private String phoneNumber;

}
