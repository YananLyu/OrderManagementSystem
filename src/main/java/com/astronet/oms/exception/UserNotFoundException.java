package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 6:15 PM
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
