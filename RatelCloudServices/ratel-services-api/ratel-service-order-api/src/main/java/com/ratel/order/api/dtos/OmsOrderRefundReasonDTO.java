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
 * @ClassName: OmsOrderRefundReasonDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason DTO
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderRefundReason DTO", value = "OmsOrderRefundReason")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OmsOrderRefundReasonDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID", required = false)
    private Long id;
    @ApiModelProperty(value = "退货原因名", required = false)
    private String reasonTitle;
    @ApiModelProperty(value = "排序", required = false)
    private Integer seq;
    @ApiModelProperty(value = "启用状态", required = false)
    private String enableStatus;
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

