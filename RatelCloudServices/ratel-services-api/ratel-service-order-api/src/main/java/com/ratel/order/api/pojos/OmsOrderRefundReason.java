package com.ratel.order.api.pojos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ratel.common.core.entities.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundReason
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason实体
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderRefundReason实体", value = "OmsOrderRefundReason")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_refund_reason")
public class OmsOrderRefundReason extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "退货原因名", required = false)
    private String reasonTitle;
    @ApiModelProperty(value = "排序", required = false)
    private Integer seq;
    @ApiModelProperty(value = "启用状态", required = false)
    private String enableStatus;
}
