package com.ratel.order.api.pojos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ratel.common.core.entities.SuperEntity;
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
 * @ClassName: OmsTransactionRecord
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsTransactionRecord实体
 * @Version: 1.0
 */
@ApiModel(description = "OmsTransactionRecord实体", value = "OmsTransactionRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("oms_transaction_record")
public class OmsTransactionRecord extends SuperEntity {
    private static final long serialVersionUID = 1L;

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
}
