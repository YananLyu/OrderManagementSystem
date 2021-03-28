package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:29 AM
 */
public class UserPaymentNotFoundException extends RuntimeException {
    public UserPaymentNotFoundException(Long id) {
        super("Could not find user payment " + id);
    }
}
