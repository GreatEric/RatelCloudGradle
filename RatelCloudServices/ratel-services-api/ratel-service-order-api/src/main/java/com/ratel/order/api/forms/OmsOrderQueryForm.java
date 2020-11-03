package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsOrder;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrder查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderQueryForm", value = "OmsOrderQueryForm")
@Setter
@Getter
public class OmsOrderQueryForm extends PageForm<OmsOrder> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "customer_id", condition = RelationEnum.EQUAL)
    private Long customerId;
    @QueryField(tableAlias = "oms", column = "customer_name", condition = RelationEnum.EQUAL)
    private String customerName;
    @QueryField(tableAlias = "oms", column = "bussiness_id", condition = RelationEnum.EQUAL)
    private Long bussinessId;
    @QueryField(tableAlias = "oms", column = "order_sn", condition = RelationEnum.EQUAL)
    private String orderSn;
    @QueryField(tableAlias = "oms", column = "total_amt", condition = RelationEnum.EQUAL)
    private String totalAmt;
    @QueryField(tableAlias = "oms", column = "pay_amt", condition = RelationEnum.EQUAL)
    private String payAmt;
    @QueryField(tableAlias = "oms", column = "freight_amt", condition = RelationEnum.EQUAL)
    private String freightAmt;
    @QueryField(tableAlias = "oms", column = "promotion_amt", condition = RelationEnum.EQUAL)
    private String promotionAmt;
    @QueryField(tableAlias = "oms", column = "integration_amt", condition = RelationEnum.EQUAL)
    private String integrationAmt;
    @QueryField(tableAlias = "oms", column = "discount_amt", condition = RelationEnum.EQUAL)
    private String discountAmt;
    @QueryField(tableAlias = "oms", column = "coupon_amt", condition = RelationEnum.EQUAL)
    private String couponAmt;
    @QueryField(tableAlias = "oms", column = "use_integration", condition = RelationEnum.EQUAL)
    private Integer useIntegration;
    @QueryField(tableAlias = "oms", column = "coupon_id", condition = RelationEnum.EQUAL)
    private Long couponId;
    @QueryField(tableAlias = "oms", column = "integration", condition = RelationEnum.EQUAL)
    private Integer integration;
    @QueryField(tableAlias = "oms", column = "membership_growth", condition = RelationEnum.EQUAL)
    private Integer membershipGrowth;
    @QueryField(tableAlias = "oms", column = "delivery_company", condition = RelationEnum.EQUAL)
    private String deliveryCompany;
    @QueryField(tableAlias = "oms", column = "delivery_sn", condition = RelationEnum.EQUAL)
    private String deliverySn;
    @QueryField(tableAlias = "oms", column = "auto_confirm_day", condition = RelationEnum.EQUAL)
    private Integer autoConfirmDay;
    @QueryField(tableAlias = "oms", column = "invoice_type", condition = RelationEnum.EQUAL)
    private Integer invoiceType;
    @QueryField(tableAlias = "oms", column = "invoice_header", condition = RelationEnum.EQUAL)
    private String invoiceHeader;
    @QueryField(tableAlias = "oms", column = "invoice_content", condition = RelationEnum.EQUAL)
    private String invoiceContent;
    @QueryField(tableAlias = "oms", column = "invoice_receiver_phone", condition = RelationEnum.EQUAL)
    private String invoiceReceiverPhone;
    @QueryField(tableAlias = "oms", column = "invoice_receiver_email", condition = RelationEnum.EQUAL)
    private String invoiceReceiverEmail;
    @QueryField(tableAlias = "oms", column = "receiver_name", condition = RelationEnum.EQUAL)
    private String receiverName;
    @QueryField(tableAlias = "oms", column = "receiver_phone", condition = RelationEnum.EQUAL)
    private String receiverPhone;
    @QueryField(tableAlias = "oms", column = "receiver_post_code", condition = RelationEnum.EQUAL)
    private String receiverPostCode;
    @QueryField(tableAlias = "oms", column = "receiver_province", condition = RelationEnum.EQUAL)
    private String receiverProvince;
    @QueryField(tableAlias = "oms", column = "receiver_city", condition = RelationEnum.EQUAL)
    private String receiverCity;
    @QueryField(tableAlias = "oms", column = "receiver_region", condition = RelationEnum.EQUAL)
    private String receiverRegion;
    @QueryField(tableAlias = "oms", column = "receiver_detail_address", condition = RelationEnum.EQUAL)
    private String receiverDetailAddress;
    @QueryField(tableAlias = "oms", column = "remark", condition = RelationEnum.EQUAL)
    private String remark;
    @QueryField(tableAlias = "oms", column = "payment_time", condition = RelationEnum.EQUAL)
    private Timestamp paymentTime;
    @QueryField(tableAlias = "oms", column = "delivery_time", condition = RelationEnum.EQUAL)
    private Timestamp deliveryTime;
    @QueryField(tableAlias = "oms", column = "receive_time", condition = RelationEnum.EQUAL)
    private Timestamp receiveTime;
    @QueryField(tableAlias = "oms", column = "comment_time", condition = RelationEnum.EQUAL)
    private Timestamp commentTime;
    @QueryField(tableAlias = "oms", column = "payment_method", condition = RelationEnum.EQUAL)
    private Integer paymentMethod;
    @QueryField(tableAlias = "oms", column = "order_source", condition = RelationEnum.EQUAL)
    private Integer orderSource;
    @QueryField(tableAlias = "oms", column = "confirm_status", condition = RelationEnum.EQUAL)
    private Integer confirmStatus;
    @QueryField(tableAlias = "oms", column = "delete_status", condition = RelationEnum.EQUAL)
    private Integer deleteStatus;
    @QueryField(tableAlias = "oms", column = "order_status", condition = RelationEnum.EQUAL)
    private Integer orderStatus;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
