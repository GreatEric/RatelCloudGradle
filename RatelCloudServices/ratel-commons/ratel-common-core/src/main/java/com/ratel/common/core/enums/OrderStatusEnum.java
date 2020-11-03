package com.ratel.common.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * RatelCloud
 * @ClassName: OrderStatusEnum
 * @Package: com.ratel.order.api.enums
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 18/09/20
 * @Description: 订单状态枚举
 * @Version: 1.0
 */
public enum OrderStatusEnum implements SuperEnum<Integer> {
    NEW_ORDER(0,"new order(新订单)"),
    UNPAID(1, "unpaid(未支付)"),
    PAID(2, "paid(已支付)"),
    SHIPPED(3,"shipped(已发货)"),
    COMPLETED(4,"completed(已完成)"),
    CANCELLED(5,"Cancelled(已取消)"),
    REQUEST_REFUND(6,"Request a refund(已取消)");

    private final int value;
    private final String remark;

    private OrderStatusEnum(int value, String remark) {
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
    public static OrderStatusEnum getByValue(Integer value) {
        if (null != value) {
            for (OrderStatusEnum o : OrderStatusEnum.values()) {
                if (o.value == value) {
                    return o;
                }
            }
        }
        return null;
    }
}
