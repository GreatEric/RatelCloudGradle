package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsOrderSetting;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderSettingQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderSetting查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderSettingQueryForm", value = "OmsOrderSettingQueryForm")
@Setter
@Getter
public class OmsOrderSettingQueryForm extends PageForm<OmsOrderSetting> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "flash_order_overtime", condition = RelationEnum.EQUAL)
    private Integer flashOrderOvertime;
    @QueryField(tableAlias = "oms", column = "normal_order_overtime", condition = RelationEnum.EQUAL)
    private Integer normalOrderOvertime;
    @QueryField(tableAlias = "oms", column = "confirm_overtime", condition = RelationEnum.EQUAL)
    private Integer confirmOvertime;
    @QueryField(tableAlias = "oms", column = "finish_overtime", condition = RelationEnum.EQUAL)
    private Integer finishOvertime;
    @QueryField(tableAlias = "oms", column = "comment_overtime", condition = RelationEnum.EQUAL)
    private Integer commentOvertime;
    @QueryField(tableAlias = "oms", column = "customer_level", condition = RelationEnum.EQUAL)
    private Integer customerLevel;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
