package com.ratel.common.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FileTypeEnum implements SuperEnum<Integer> {
    /**
     * 图片
     */
    IMAGE(1, "图片"),
    /**
     * 文件
     */
    FILE(2, "文件"),
    /**
     * 视频
     */
    VIDEO(3, "视频");

    private final int value;
    private final String remark;

    private FileTypeEnum(int value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @JsonCreator
    public static FileTypeEnum getByValue(Integer value) {
        if (null != value) {
            for (FileTypeEnum o : FileTypeEnum.values()) {
                if (o.value == value) {
                    return o;
                }
            }
        }
        return null;
    }
}
