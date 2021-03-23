package com.astronet.oms.convertors.dtoconverter;

import com.astronet.oms.dtos.OmsOrderDto;
import com.astronet.oms.entity.OmsOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Todo: Finish all the setters
 * @author: Zhubo Deng
 * @date 3/15/21 11:44 AM
 */

@Component
public class OmsOrderConverter {

    public OmsOrderDto entityToDto(OmsOrder omsOrder) {
        OmsOrderDto omsOrderDto = new OmsOrderDto();
        omsOrderDto.setId(omsOrderDto.getId());


        return omsOrderDto;
    }

    public List<OmsOrderDto> entityToDto(List<OmsOrder> omsOrders) {
        return omsOrders.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public OmsOrder dtoToEntity(OmsOrderDto omsOrderDto) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(omsOrderDto.getId());


        return omsOrder;
    }

    public List<OmsOrder> dtoToEntity(List<OmsOrderDto> omsOrderDtos) {
        return omsOrderDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
