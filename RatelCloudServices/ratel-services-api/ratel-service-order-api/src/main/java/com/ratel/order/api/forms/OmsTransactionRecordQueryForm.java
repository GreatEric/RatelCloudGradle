package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsTransactionRecord;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsTransactionRecordQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsTransactionRecord查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsTransactionRecordQueryForm", value = "OmsTransactionRecordQueryForm")
@Setter
@Getter
public class OmsTransactionRecordQueryForm extends PageForm<OmsTransactionRecord> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "bussiness_id", condition = RelationEnum.EQUAL)
    private Long bussinessId;
    @QueryField(tableAlias = "oms", column = "customer_id", condition = RelationEnum.EQUAL)
    private Long customerId;
    @QueryField(tableAlias = "oms", column = "currency", condition = RelationEnum.EQUAL)
    private String currency;
    @QueryField(tableAlias = "oms", column = "payment_time", condition = RelationEnum.EQUAL)
    private Timestamp paymentTime;
    @QueryField(tableAlias = "oms", column = "payment_type", condition = RelationEnum.EQUAL)
    private Integer paymentType;
    @QueryField(tableAlias = "oms", column = "payment_result", condition = RelationEnum.EQUAL)
    private Integer paymentResult;
    @QueryField(tableAlias = "oms", column = "payment_amt", condition = RelationEnum.EQUAL)
    private String paymentAmt;
    @QueryField(tableAlias = "oms", column = "order_serial", condition = RelationEnum.EQUAL)
    private String orderSerial;
    @QueryField(tableAlias = "oms", column = "transaction_id", condition = RelationEnum.EQUAL)
    private String transactionId;
    @QueryField(tableAlias = "oms", column = "merchant_id", condition = RelationEnum.EQUAL)
    private String merchantId;
    @QueryField(tableAlias = "oms", column = "decline_reason", condition = RelationEnum.EQUAL)
    private String declineReason;
    @QueryField(tableAlias = "oms", column = "callback_content", condition = RelationEnum.EQUAL)
    private String callbackContent;
    @QueryField(tableAlias = "oms", column = "callback_time", condition = RelationEnum.EQUAL)
    private Timestamp callbackTime;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
