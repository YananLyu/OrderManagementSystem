package com.astronet.oms.service;

import com.astronet.oms.dtos.UserPaymentDto;
import com.astronet.oms.entity.UserPayment;
import com.astronet.oms.enums.PaymentStatusEnum;
import com.astronet.oms.exception.UserPaymentNotFoundException;
import com.astronet.oms.repository.UserPaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:20 AM
 */

@Service
public class UserPaymentService {

    @Autowired
    UserPaymentRepository repository;

    @Autowired
    ModelMapper mapper;

    /**
     * C - Create
     * @param dto
     * @return
     */
    public UserPaymentDto createPayment(UserPaymentDto dto) {
        UserPayment savedItem = repository.save(mapper.map(dto, UserPayment.class));
        return mapper.map(savedItem, UserPaymentDto.class);
    }

    /**
     * R - Read all
     * @return
     */
    public List<UserPaymentDto> readAllPayment() {
        List<UserPayment> findAll = repository.findAllByOrderByIdDesc();
        return findAll.stream()
                .map(x -> mapper.map(x, UserPaymentDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    public UserPaymentDto readOnePayment(Long id) {
        UserPayment item = repository.findById(id)
                .orElseThrow(() -> new UserPaymentNotFoundException(id));
        return mapper.map(item, UserPaymentDto.class);
    }

    /**
     * R - Retrieval all the pending payments
     * @return
     */
    public List<UserPaymentDto> pendingPayments() {
        List<UserPayment> items = repository.findByPaymentStatus(PaymentStatusEnum.PENDING);
        return items.stream()
                .map(x -> mapper.map(x, UserPaymentDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the received payments
     * @return
     */
    public List<UserPaymentDto> receivedPayments() {
        List<UserPayment> items = repository.findByPaymentStatus(PaymentStatusEnum.RECEIVED);
        return items.stream()
                .map(x -> mapper.map(x, UserPaymentDto.class))
                .collect(Collectors.toList());
    }

    /**
     * R - Retrieval all the issued payments
     * @return
     */
    public List<UserPaymentDto> issuedPayments() {
        List<UserPayment> items = repository.findByPaymentStatus(PaymentStatusEnum.ISSUED);
        return items.stream()
                .map(x -> mapper.map(x, UserPaymentDto.class))
                .collect(Collectors.toList());
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    public UserPaymentDto updatePayment(UserPaymentDto dto, Long id) {
        UserPayment newItem = mapper.map(dto, UserPayment.class);
        UserPayment updatedItem = repository.findById(id)
                .map(item -> {
                    item.setMoneyAmount(newItem.getMoneyAmount());
                    item.setPaymentStatus(newItem.getPaymentStatus());
                    item.setPaymentNote(newItem.getPaymentNote());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
        return mapper.map(updatedItem, UserPaymentDto.class);
    }

    /**
     * D - Delete
     * @param id
     */
    public void deletePayment(Long id) {
        repository.deleteById(id);
    }

}
