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
 * @ClassName: OmsOrder
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrder实体
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrder实体", value = "OmsOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order")
public class OmsOrder extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户ID", required = false)
    private Long customerId;
    @ApiModelProperty(value = "客户姓名", required = false)
    private String customerName;
    @ApiModelProperty(value = "商户ID", required = false)
    private Long bussinessId;
    @ApiModelProperty(value = "订单编号", required = false)
    private String orderSn;
    @ApiModelProperty(value = "订单总额", required = false)
    private String totalAmt;
    @ApiModelProperty(value = "应付总额", required = false)
    private String payAmt;
    @ApiModelProperty(value = "运费金额", required = false)
    private String freightAmt;
    @ApiModelProperty(value = "促销优惠金额(促销价、满减、阶梯价)", required = false)
    private String promotionAmt;
    @ApiModelProperty(value = "积分抵扣金额", required = false)
    private String integrationAmt;
    @ApiModelProperty(value = "后台调整订单使用的折扣金额", required = false)
    private String discountAmt;
    @ApiModelProperty(value = "优惠券抵扣金额", required = false)
    private String couponAmt;
    @ApiModelProperty(value = "下单时使用的积分", required = false)
    private Integer useIntegration;
    @ApiModelProperty(value = "使用的优惠券", required = false)
    private Long couponId;
    @ApiModelProperty(value = "可以获得的积分", required = false)
    private Integer integration;
    @ApiModelProperty(value = "可以获得的成长值", required = false)
    private Integer membershipGrowth;
    @ApiModelProperty(value = "物流公司(配送方式)", required = false)
    private String deliveryCompany;
    @ApiModelProperty(value = "物流单号", required = false)
    private String deliverySn;
    @ApiModelProperty(value = "自动确认时间（天）", required = false)
    private Integer autoConfirmDay;
    @ApiModelProperty(value = "发票类型: 0->不开发票；1->电子发票；2->纸质发票", required = false)
    private Integer invoiceType;
    @ApiModelProperty(value = "发票抬头", required = false)
    private String invoiceHeader;
    @ApiModelProperty(value = "发票内容", required = false)
    private String invoiceContent;
    @ApiModelProperty(value = "收票人电话", required = false)
    private String invoiceReceiverPhone;
    @ApiModelProperty(value = "收票人邮箱", required = false)
    private String invoiceReceiverEmail;
    @ApiModelProperty(value = "收货人姓名", required = false)
    private String receiverName;
    @ApiModelProperty(value = "收货人电话", required = false)
    private String receiverPhone;
    @ApiModelProperty(value = "收货人邮编", required = false)
    private String receiverPostCode;
    @ApiModelProperty(value = "省份/直辖市", required = false)
    private String receiverProvince;
    @ApiModelProperty(value = "城市", required = false)
    private String receiverCity;
    @ApiModelProperty(value = "区", required = false)
    private String receiverRegion;
    @ApiModelProperty(value = "详细地址", required = false)
    private String receiverDetailAddress;
    @ApiModelProperty(value = "订单备注", required = false)
    private String remark;
    @ApiModelProperty(value = "支付时间", required = false)
    private Timestamp paymentTime;
    @ApiModelProperty(value = "发货时间", required = false)
    private Timestamp deliveryTime;
    @ApiModelProperty(value = "确认收货时间", required = false)
    private Timestamp receiveTime;
    @ApiModelProperty(value = "评价时间", required = false)
    private Timestamp commentTime;
    @ApiModelProperty(value = "支付方式: 1->微信; 2->支付宝; 3->Stripe; 4->Paypal; 5->银联", required = false)
    private Integer paymentMethod;
    @ApiModelProperty(value = "订单来源: 0->PC订单；1->app订单", required = false)
    private Integer orderSource;
    @ApiModelProperty(value = "确认收货状态: 0->未确认；1->已确认", required = false)
    private Integer confirmStatus;
    @ApiModelProperty(value = "删除状态: 0->未删除；1->已删除", required = false)
    private Integer deleteStatus;
    @ApiModelProperty(value = "订单状态: 0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单", required = false)
    private Integer orderStatus;
}
