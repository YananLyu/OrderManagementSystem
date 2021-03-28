package com.astronet.oms.dtos;

import lombok.*;

/**
 * @author Zhubo Deng
 * @date 03/23/2021 3:52 AM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsSpuDto {

    private String platformSeller;
    private String productName;
    private String productLink;

}
