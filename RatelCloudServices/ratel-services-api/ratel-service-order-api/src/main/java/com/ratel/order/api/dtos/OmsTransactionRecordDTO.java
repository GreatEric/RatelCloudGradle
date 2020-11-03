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
 * @ClassName: OmsTransactionRecordDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsTransactionRecord DTO
 * @Version: 1.0
 */
@ApiModel(description = "OmsTransactionRecord DTO", value = "OmsTransactionRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OmsTransactionRecordDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "", required = false)
    private Long id;
    @ApiModelProperty(value = "商户ID", required = false)
    private Long bussinessId;
    @ApiModelProperty(value = "客户ID", required = false)
    private Long customerId;
    @ApiModelProperty(value = "交易币种,默认为AUD", required = false)
    private String currency;
    @ApiModelProperty(value = "支付时间", required = false)
    private Timestamp paymentTime;
    @ApiModelProperty(value = "支付方式", required = false)
    private Integer paymentType;
    @ApiModelProperty(value = "支付结果: 0->支付失败;1->支付成功;2->支付中", required = false)
    private Integer paymentResult;
    @ApiModelProperty(value = "交易金额", required = false)
    private String paymentAmt;
    @ApiModelProperty(value = "订单编号", required = false)
    private String orderSerial;
    @ApiModelProperty(value = "交易凭证id", required = false)
    private String transactionId;
    @ApiModelProperty(value = "merchant_id,Stripe没有则为空", required = false)
    private String merchantId;
    @ApiModelProperty(value = "失败原因", required = false)
    private String declineReason;
    @ApiModelProperty(value = "回调内容", required = false)
    private String callbackContent;
    @ApiModelProperty(value = "回调时间", required = false)
    private Timestamp callbackTime;
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

