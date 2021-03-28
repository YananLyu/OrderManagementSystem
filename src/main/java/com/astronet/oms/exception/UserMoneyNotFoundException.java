package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:56 AM
 */
public class UserMoneyNotFoundException extends RuntimeException {
    public UserMoneyNotFoundException(Long id) {
        super("Could not find user money " + id);
    }
}
