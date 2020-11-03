package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsOrderRefundReason;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundReasonQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderRefundReasonQueryForm", value = "OmsOrderRefundReasonQueryForm")
@Setter
@Getter
public class OmsOrderRefundReasonQueryForm extends PageForm<OmsOrderRefundReason> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "reason_title", condition = RelationEnum.EQUAL)
    private String reasonTitle;
    @QueryField(tableAlias = "oms", column = "seq", condition = RelationEnum.EQUAL)
    private Integer seq;
    @QueryField(tableAlias = "oms", column = "enable_status", condition = RelationEnum.EQUAL)
    private String enableStatus;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
