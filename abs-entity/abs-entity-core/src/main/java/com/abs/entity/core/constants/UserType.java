package com.abs.entity.core.constants;

/**
 * 会员类型
 */
public enum UserType {

    ORDINARY("普通会员"),
    BUSINESS("商家会员"),
    SYSTEM("系统会员");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
