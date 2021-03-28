package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 2:32 AM
 */
public class UserPaymentMethodsNotFoundException extends RuntimeException {
    public UserPaymentMethodsNotFoundException(Long id) {
        super("Could not find user payment method" + id);
    }
}
