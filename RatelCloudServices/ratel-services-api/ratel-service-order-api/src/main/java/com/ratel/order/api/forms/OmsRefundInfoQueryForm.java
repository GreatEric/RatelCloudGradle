package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsRefundInfo;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsRefundInfoQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsRefundInfo查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsRefundInfoQueryForm", value = "OmsRefundInfoQueryForm")
@Setter
@Getter
public class OmsRefundInfoQueryForm extends PageForm<OmsRefundInfo> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "refund_order_id", condition = RelationEnum.EQUAL)
    private Long refundOrderId;
    @QueryField(tableAlias = "oms", column = "refund_amt", condition = RelationEnum.EQUAL)
    private String refundAmt;
    @QueryField(tableAlias = "oms", column = "refund_sn", condition = RelationEnum.EQUAL)
    private String refundSn;
    @QueryField(tableAlias = "oms", column = "refund_status", condition = RelationEnum.EQUAL)
    private String refundStatus;
    @QueryField(tableAlias = "oms", column = "refund_channel", condition = RelationEnum.EQUAL)
    private Integer refundChannel;
    @QueryField(tableAlias = "oms", column = "refund_items", condition = RelationEnum.EQUAL)
    private String refundItems;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
