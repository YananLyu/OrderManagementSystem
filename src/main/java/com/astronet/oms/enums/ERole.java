package com.astronet.oms.enums;

/**
 * @author Yanan Lyu
 */

public enum ERole {
    /**
     * M
     */
    ROLE_MODERATOR("M"),

    /**
     * U
     */
    ROLE_USER("U"),

    /**
     * A
     */
    ROLE_ADMIN("A");

    private String code;

    ERole(String code) {
        this.code = code;
    };

    public String getCode() {
        return code;
    }
}
