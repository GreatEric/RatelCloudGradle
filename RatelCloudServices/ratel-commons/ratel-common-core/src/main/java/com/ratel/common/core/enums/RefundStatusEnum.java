package com.ratel.common.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RefundStatusEnum implements SuperEnum<Integer> {
    NEW_REFUND(0,"new refund(新退款申请)"),
    NOT_APPROVED(1,"not approved(未审批)"),
    APPROVED(2, "approved(审批通过)"),
    REJECTED(3, "rejected(驳回)"),
    SUCCEED(4,"succeed(已退款)");

    private final int value;
    private final String remark;

    private RefundStatusEnum(int value, String remark) {
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
    public static RefundStatusEnum getByValue(Integer value) {
        if (null != value) {
            for (RefundStatusEnum o : RefundStatusEnum.values()) {
                if (o.value == value) {
                    return o;
                }
            }
        }
        return null;
    }
}