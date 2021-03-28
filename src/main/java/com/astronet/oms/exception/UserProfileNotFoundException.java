package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/26/2021 12:51 AM
 */
public class UserProfileNotFoundException extends RuntimeException {
    public UserProfileNotFoundException(Long id) {
        super("Could not find user profile " + id);
    }
}
