package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/25/2021 6:18 PM
 */
public class SkuNotFoundException extends RuntimeException{
    public SkuNotFoundException(Long id) {
        super("Could not find offer " + id);
    }
}
