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
 * @ClassName: OmsOrderOperateHistory
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory实体
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderOperateHistory实体", value = "OmsOrderOperateHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_operate_history")
public class OmsOrderOperateHistory extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID", required = false)
    private Long orderId;
    @ApiModelProperty(value = "操作人: 用户；系统；后台管理员", required = false)
    private String operator;
    @ApiModelProperty(value = "订单状态: 0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单", required = false)
    private Integer orderStatus;
    @ApiModelProperty(value = "备注", required = false)
    private String remark;
}
