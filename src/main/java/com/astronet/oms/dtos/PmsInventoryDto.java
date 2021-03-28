package com.astronet.oms.dtos;

import com.astronet.oms.enums.AddressTypeEnum;
import lombok.*;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:06 AM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsInventoryDto {

    private AddressTypeEnum addrType;
    private String addrLine1;
    private String addrLine2;
    private String addrCity;
    private String addrState;
    private String addrZipcode;
    private String addrCountry;

}
