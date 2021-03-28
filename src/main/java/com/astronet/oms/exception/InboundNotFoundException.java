package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 6:54 PM
 */
public class InboundNotFoundException extends RuntimeException{
    public InboundNotFoundException(Long id) {
        super("Could not find inbound " + id);
    }
}
