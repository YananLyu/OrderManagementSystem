package com.astronet.oms.exception;

/**
 * @author Yanan Lyu
 * @date 3/11/21 12:39 AM
 */
public class SpuNotFoundException extends RuntimeException {

    public SpuNotFoundException(Long id) {
        super("Could not find product " + id);
    }
}
