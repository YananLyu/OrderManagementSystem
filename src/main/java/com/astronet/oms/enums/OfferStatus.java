package com.astronet.oms.enums;

/**
 * @author: Yanan Lyu
 * @date 3/6/21 11:44 AM
 */
public enum OfferStatus {
    ACTIVE("有效", 1),
    INACTIVE("无效",0);

    private String message;
    private Integer status;


    OfferStatus(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "OfferStatus{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
