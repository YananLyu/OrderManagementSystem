package com.astronet.oms.dtos;

import lombok.*;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:26 AM
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OmsExpressTrackingDto {

    private Long quantity;
    private Integer trackingStatus;
    private String trackingNote;

}
