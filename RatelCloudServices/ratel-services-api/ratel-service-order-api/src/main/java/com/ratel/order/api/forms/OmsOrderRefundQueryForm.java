package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsOrderRefund;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefund查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderRefundQueryForm", value = "OmsOrderRefundQueryForm")
@Setter
@Getter
public class OmsOrderRefundQueryForm extends PageForm<OmsOrderRefund> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "order_id", condition = RelationEnum.EQUAL)
    private Long orderId;
    @QueryField(tableAlias = "oms", column = "sku_id", condition = RelationEnum.EQUAL)
    private Long skuId;
    @QueryField(tableAlias = "oms", column = "order_sn", condition = RelationEnum.EQUAL)
    private String orderSn;
    @QueryField(tableAlias = "oms", column = "customer_name", condition = RelationEnum.EQUAL)
    private String customerName;
    @QueryField(tableAlias = "oms", column = "customer_phone", condition = RelationEnum.EQUAL)
    private String customerPhone;
    @QueryField(tableAlias = "oms", column = "refund_amt", condition = RelationEnum.EQUAL)
    private String refundAmt;
    @QueryField(tableAlias = "oms", column = "processing_time", condition = RelationEnum.EQUAL)
    private Timestamp processingTime;
    @QueryField(tableAlias = "oms", column = "sku_img", condition = RelationEnum.EQUAL)
    private String skuImg;
    @QueryField(tableAlias = "oms", column = "sku_name", condition = RelationEnum.EQUAL)
    private String skuName;
    @QueryField(tableAlias = "oms", column = "sku_brand", condition = RelationEnum.EQUAL)
    private String skuBrand;
    @QueryField(tableAlias = "oms", column = "sku_attrs", condition = RelationEnum.EQUAL)
    private String skuAttrs;
    @QueryField(tableAlias = "oms", column = "sku_qty", condition = RelationEnum.EQUAL)
    private Integer skuQty;
    @QueryField(tableAlias = "oms", column = "sku_price", condition = RelationEnum.EQUAL)
    private String skuPrice;
    @QueryField(tableAlias = "oms", column = "sku_paid_amt", condition = RelationEnum.EQUAL)
    private String skuPaidAmt;
    @QueryField(tableAlias = "oms", column = "reason_title", condition = RelationEnum.EQUAL)
    private String reasonTitle;
    @QueryField(tableAlias = "oms", column = "reason_desc", condition = RelationEnum.EQUAL)
    private String reasonDesc;
    @QueryField(tableAlias = "oms", column = "reason_desc_pics", condition = RelationEnum.EQUAL)
    private String reasonDescPics;
    @QueryField(tableAlias = "oms", column = "processing_remark", condition = RelationEnum.EQUAL)
    private String processingRemark;
    @QueryField(tableAlias = "oms", column = "processor", condition = RelationEnum.EQUAL)
    private String processor;
    @QueryField(tableAlias = "oms", column = "receiver", condition = RelationEnum.EQUAL)
    private String receiver;
    @QueryField(tableAlias = "oms", column = "receiver_phone", condition = RelationEnum.EQUAL)
    private String receiverPhone;
    @QueryField(tableAlias = "oms", column = "receiver_email", condition = RelationEnum.EQUAL)
    private String receiverEmail;
    @QueryField(tableAlias = "oms", column = "receive_time", condition = RelationEnum.EQUAL)
    private Timestamp receiveTime;
    @QueryField(tableAlias = "oms", column = "receive_remark", condition = RelationEnum.EQUAL)
    private String receiveRemark;
    @QueryField(tableAlias = "oms", column = "company_address", condition = RelationEnum.EQUAL)
    private String companyAddress;
    @QueryField(tableAlias = "oms", column = "application_status", condition = RelationEnum.EQUAL)
    private String applicationStatus;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
