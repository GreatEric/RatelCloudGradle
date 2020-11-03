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
 * @ClassName: OmsOrderRefund
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefund实体
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderRefund实体", value = "OmsOrderRefund")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_refund")
public class OmsOrderRefund extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID", required = false)
    private Long orderId;
    @ApiModelProperty(value = "退货商品ID", required = false)
    private Long skuId;
    @ApiModelProperty(value = "订单编号", required = false)
    private String orderSn;
    @ApiModelProperty(value = "退货人姓名", required = false)
    private String customerName;
    @ApiModelProperty(value = "退货人电话", required = false)
    private String customerPhone;
    @ApiModelProperty(value = "退款金额", required = false)
    private String refundAmt;
    @ApiModelProperty(value = "处理时间", required = false)
    private Timestamp processingTime;
    @ApiModelProperty(value = "商品图片", required = false)
    private String skuImg;
    @ApiModelProperty(value = "商品名称", required = false)
    private String skuName;
    @ApiModelProperty(value = "商品品牌", required = false)
    private String skuBrand;
    @ApiModelProperty(value = "商品销售属性(JSON)", required = false)
    private String skuAttrs;
    @ApiModelProperty(value = "退货数量", required = false)
    private Integer skuQty;
    @ApiModelProperty(value = "商品单价", required = false)
    private String skuPrice;
    @ApiModelProperty(value = "商品实际支付单价", required = false)
    private String skuPaidAmt;
    @ApiModelProperty(value = "原因标题", required = false)
    private String reasonTitle;
    @ApiModelProperty(value = "原因描述", required = false)
    private String reasonDesc;
    @ApiModelProperty(value = "原因描述图片(图片地址数组)", required = false)
    private String reasonDescPics;
    @ApiModelProperty(value = "处理备注", required = false)
    private String processingRemark;
    @ApiModelProperty(value = "处理人员", required = false)
    private String processor;
    @ApiModelProperty(value = "收货人", required = false)
    private String receiver;
    @ApiModelProperty(value = "收货人电话", required = false)
    private String receiverPhone;
    @ApiModelProperty(value = "收货人邮箱", required = false)
    private String receiverEmail;
    @ApiModelProperty(value = "收货时间", required = false)
    private Timestamp receiveTime;
    @ApiModelProperty(value = "收货备注", required = false)
    private String receiveRemark;
    @ApiModelProperty(value = "公司收货地址", required = false)
    private String companyAddress;
    @ApiModelProperty(value = "申请状态: 0->待处理；1->退货中；2->已完成；3->已拒绝", required = false)
    private String applicationStatus;
}
