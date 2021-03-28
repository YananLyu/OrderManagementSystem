package com.astronet.oms.service;

import com.astronet.oms.dtos.UserMoneyDto;
import com.astronet.oms.entity.UserMoney;
import com.astronet.oms.exception.UserMoneyNotFoundException;
import com.astronet.oms.repository.UserMoneyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:51 AM
 */

@Service
public class UserMoneyService {

    @Autowired
    UserMoneyRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create
     * @param dto
     * @return
     */
    public UserMoneyDto createMoney(UserMoneyDto dto) {
        UserMoney savedItem = repository.save(mapper.map(dto, UserMoney.class));
        return mapper.map(savedItem, UserMoneyDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<UserMoneyDto> readAllMoney() {
        List<UserMoney> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, UserMoneyDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    public UserMoneyDto readOneMoney(Long id) {
        UserMoney item = repository.findById(id)
                .orElseThrow(() -> new UserMoneyNotFoundException(id));
        return mapper.map(item, UserMoneyDto.class);
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    public UserMoneyDto updateMoney(UserMoneyDto dto, Long id) {
        UserMoney newItem = mapper.map(dto, UserMoney.class);
        UserMoney updatedItem = repository.findById(id)
                .map(item -> {
                    item.setOnHoldAmount(newItem.getOnHoldAmount());
                    item.setBalanceAmount(newItem.getBalanceAmount());
                    item.setPendingAmount(newItem.getPendingAmount());
                    item.setRequestAmount(newItem.getRequestAmount());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
        return mapper.map(updatedItem, UserMoneyDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deleteMoney(Long id) {
        repository.deleteById(id);
    }

}
