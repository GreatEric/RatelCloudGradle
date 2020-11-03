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
 * @ClassName: OmsOrderItemDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderItem DTO
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderItem DTO", value = "OmsOrderItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OmsOrderItemDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID", required = false)
    private Long id;
    @ApiModelProperty(value = "订单ID", required = false)
    private Long orderId;
    @ApiModelProperty(value = "订单编号", required = false)
    private String orderSn;
    @ApiModelProperty(value = "SPU_ID", required = false)
    private Long spuId;
    @ApiModelProperty(value = "SPU_NAME", required = false)
    private String spuName;
    @ApiModelProperty(value = "SPU_PIC", required = false)
    private String spuPic;
    @ApiModelProperty(value = "品牌", required = false)
    private String spuBrand;
    @ApiModelProperty(value = "商品分类ID", required = false)
    private Long categoryId;
    @ApiModelProperty(value = "商品SKU编号", required = false)
    private Long skuId;
    @ApiModelProperty(value = "商品SKU名字", required = false)
    private String skuName;
    @ApiModelProperty(value = "商品SKU图片", required = false)
    private String skuPic;
    @ApiModelProperty(value = "商品SKU价格", required = false)
    private String skuPrice;
    @ApiModelProperty(value = "商品购买的数量", required = false)
    private Integer skuQty;
    @ApiModelProperty(value = "商品销售属性组合(JSON)", required = false)
    private String skuAttrsVals;
    @ApiModelProperty(value = "商品促销分解金额", required = false)
    private String promotionAmt;
    @ApiModelProperty(value = "优惠券优惠分解金额", required = false)
    private String couponAmt;
    @ApiModelProperty(value = "该商品经过优惠后的分解金额", required = false)
    private String realAmt;
    @ApiModelProperty(value = "积分优惠分解金额", required = false)
    private String integrationAmt;
    @ApiModelProperty(value = "赠送积分", required = false)
    private Integer giftIntegration;
    @ApiModelProperty(value = "赠送成长值", required = false)
    private Integer giftGrowth;
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

