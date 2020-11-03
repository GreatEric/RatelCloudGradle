package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 * @ClassName: OmsOrderOperateHistoryQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderOperateHistoryQueryForm", value = "OmsOrderOperateHistoryQueryForm")
@Setter
@Getter
public class OmsOrderOperateHistoryQueryForm extends PageForm<OmsOrderOperateHistory> {
    @QueryField(tableAlias ="oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias ="oms", column = "order_id", condition = RelationEnum.EQUAL)
    private Long orderId;
    @QueryField(tableAlias ="oms", column = "operator", condition = RelationEnum.EQUAL)
    private String operator;
    @QueryField(tableAlias ="oms", column = "order_status", condition = RelationEnum.EQUAL)
    private Integer orderStatus;
    @QueryField(tableAlias ="oms", column = "remark", condition = RelationEnum.EQUAL)
    private String remark;
    @QueryField(tableAlias ="oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias ="oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
