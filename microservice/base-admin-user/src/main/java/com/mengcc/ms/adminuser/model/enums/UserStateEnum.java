package com.mengcc.ms.adminuser.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.google.common.collect.ImmutableMap;

/**
 * @author zhouzq
 * @date 2019/9/19
 * @desc 用户状态枚举
 */
public enum UserStateEnum {

    NORMAL(1, "正常"),

    DISABLE(2, "禁用"),

    DELETE(0, "删除");


    @EnumValue
    private Integer key;

    private String value;

    private static ImmutableMap<Integer, UserStateEnum> stateMap;

    static {
        stateMap = ImmutableMap.of(1, NORMAL, 2, DISABLE, 0, DELETE);
    }

    UserStateEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static UserStateEnum fromKey(Integer key) {
        return stateMap.getOrDefault(key, null);
    }
}
