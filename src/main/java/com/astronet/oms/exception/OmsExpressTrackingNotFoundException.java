package com.astronet.oms.exception;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:34 AM
 */
public class OmsExpressTrackingNotFoundException extends RuntimeException {
    public OmsExpressTrackingNotFoundException(Long id) {
        super("Could not find express tracking " + id);
    }
}
