package com.ratel.order.api.dtos;

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
 * @ClassName: OmsOrderSettingDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderSetting DTO
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderSetting DTO", value = "OmsOrderSetting")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OmsOrderSettingDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", required = false)
    private Long id;
    @ApiModelProperty(value = "秒杀订单超时关闭时间(分)", required = false)
    private Integer flashOrderOvertime;
    @ApiModelProperty(value = "正常订单超时时间(分)", required = false)
    private Integer normalOrderOvertime;
    @ApiModelProperty(value = "发货后自动确认收货时间（天）", required = false)
    private Integer confirmOvertime;
    @ApiModelProperty(value = "自动完成交易时间，不能申请退货（天）", required = false)
    private Integer finishOvertime;
    @ApiModelProperty(value = "订单完成后自动好评时间（天）", required = false)
    private Integer commentOvertime;
    @ApiModelProperty(value = "会员等级: 0-不限会员等级，全部通用；其他-对应的其他会员等级", required = false)
    private Integer customerLevel;
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

