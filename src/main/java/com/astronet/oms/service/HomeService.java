package com.astronet.oms.service;

import com.astronet.oms.dtos.HomeDto;
import com.astronet.oms.enums.OfferStatusEnum;
import com.astronet.oms.repository.PmsSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yanan Lyu
 * @date 3/24/21 12:57 AM
 */
@Service
public class HomeService {

    @Autowired
    PmsSkuRepository pmsSkuRepository;

    /**
     * TODO: inbound, outbound, payment暂时用的hard code的数据。
     * @return HomeDto
     */
    public HomeDto getOffersInfo() {
        Long numOfActiveOffers = pmsSkuRepository.countByOfferStatus(OfferStatusEnum.ACTIVE);
        Long numOfExpiredOffers = pmsSkuRepository.countByOfferStatus(OfferStatusEnum.INACTIVE);

        HomeDto homeDto = HomeDto.builder()
                .numOfActiveOffers(numOfActiveOffers)
                .numOfExpiredOffers(numOfExpiredOffers)
                .numOfProposedOffers(0L)
                .numOfInboundItem(2L)
                .numOfReportedItem(1L)
                .numOfOutboundShipments(3L)
                .numOfPaymentRequests(1L)
                .build();
        return homeDto;
    }
}
