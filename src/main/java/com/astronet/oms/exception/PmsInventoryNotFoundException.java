package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:15 AM
 */
public class PmsInventoryNotFoundException extends RuntimeException {
    public PmsInventoryNotFoundException(Long id) {
        super("Could not find inventory " + id);
    }
}
