package com.abs.entity.core.constants;

/**
 * 会员性别类型。
 */
public enum UserSexType {

    UNKNOWN("未知"),
    MALE("男"),
    FEMALE("女");

    private final String value;

    UserSexType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
