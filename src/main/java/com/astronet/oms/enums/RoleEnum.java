package com.astronet.oms.enums;

/**
 * @author Yanan Lyu
 */

public enum RoleEnum {
    /**
     * M
     */
    ROLE_MODERATOR("ROLE_MODERATOR"),

    /**
     * U
     */
    ROLE_USER("ROLE_USER"),

    /**
     * A
     */
    ROLE_ADMIN("ROLE_ADMIN");

    private String code;

    RoleEnum(String code) {
        this.code = code;
    };

    public String getCode() {
        return code;
    }
}
