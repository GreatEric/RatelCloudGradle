package com.ratel.order.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderOperateHistoryDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory DTO
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderOperateHistory DTO", value = "OmsOrderOperateHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OmsOrderOperateHistoryDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID", required = false)
    private Long id;
    @ApiModelProperty(value = "订单ID", required = false)
    private Long orderId;
    @ApiModelProperty(value = "操作人: 用户；系统；后台管理员", required = false)
    private String operator;
    @ApiModelProperty(value = "订单状态: 0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单", required = false)
    private Integer orderStatus;
    @ApiModelProperty(value = "备注", required = false)
    private String remark;
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

