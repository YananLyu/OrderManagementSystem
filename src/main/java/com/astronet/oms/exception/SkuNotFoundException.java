package com.astronet.oms.exception;

public class SkuNotFoundException extends RuntimeException{
    public SkuNotFoundException(Long id) {
        super("Could not find offer " + id);
    }
}
