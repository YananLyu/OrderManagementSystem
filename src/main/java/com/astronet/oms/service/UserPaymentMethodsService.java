package com.astronet.oms.service;

import com.astronet.oms.dtos.UserPaymentMethodsDto;
import com.astronet.oms.entity.UserPaymentMethods;
import com.astronet.oms.exception.UserPaymentMethodsNotFoundException;
import com.astronet.oms.repository.UserPaymentMethodsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/27/2021 8:01 PM
 */

@Service
public class UserPaymentMethodsService {

    @Autowired
    UserPaymentMethodsRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create a new payment method
     *
     * @param dto
     * @return
     */
    public UserPaymentMethodsDto createPaymentMethod(UserPaymentMethodsDto dto) {
        UserPaymentMethods savedItem = repository.save(mapper.map(dto, UserPaymentMethods.class));
        return mapper.map(savedItem, UserPaymentMethodsDto.class);
    }

    /**
     * R - Read all payment methods
     *
     * @return
     */
    public List<UserPaymentMethodsDto> readAllPaymentMethods() {
        List<UserPaymentMethods> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, UserPaymentMethodsDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read one payment method
     *
     * @param id
     * @return
     */
    public UserPaymentMethodsDto readOnePaymentMethods(Long id) {
        UserPaymentMethods item = repository.findById(id)
                .orElseThrow(() -> new UserPaymentMethodsNotFoundException(id));
        return mapper.map(item, UserPaymentMethodsDto.class);
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    public UserPaymentMethodsDto updatePaymentMethod(UserPaymentMethodsDto dto, Long id) {
        UserPaymentMethods newItem = mapper.map(dto, UserPaymentMethods.class);
        UserPaymentMethods updatedItem = repository.findById(id)
                .map(item -> {
                    item.setPaymentType(newItem.getPaymentType());
                    item.setCardCompany(newItem.getCardCompany());
                    item.setCardNetwork(newItem.getCardNetwork());
                    item.setAccountHolder(newItem.getAccountHolder());
                    item.setAccountNumber(newItem.getAccountNumber());
                    return repository.save(newItem);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
        return mapper.map(updatedItem, UserPaymentMethodsDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deletePaymentMethod(Long id) {
        repository.deleteById(id);
    }

}
