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
 * @ClassName: OmsRefundInfoDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsRefundInfo DTO
 * @Version: 1.0
 */
@ApiModel(description = "OmsRefundInfo DTO", value = "OmsRefundInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OmsRefundInfoDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", required = false)
    private Long id;
    @ApiModelProperty(value = "退款的订单", required = false)
    private Long refundOrderId;
    @ApiModelProperty(value = "退款金额", required = false)
    private String refundAmt;
    @ApiModelProperty(value = "退款交易流水号", required = false)
    private String refundSn;
    @ApiModelProperty(value = "退款状态", required = false)
    private String refundStatus;
    @ApiModelProperty(value = "退款渠道: 1->微信; 2->支付宝; 3->Stripe; 4->Paypal; 5->银联", required = false)
    private Integer refundChannel;
    @ApiModelProperty(value = "退款内容", required = false)
    private String refundItems;
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

