package com.ratel.order.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.order.api.pojos.OmsOrderItem;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderItemQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderItem查询表单
 * @Version: 1.0
 */
@ApiModel(description = "OmsOrderItemQueryForm", value = "OmsOrderItemQueryForm")
@Setter
@Getter
public class OmsOrderItemQueryForm extends PageForm<OmsOrderItem> {
    @QueryField(tableAlias = "oms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "oms", column = "order_id", condition = RelationEnum.EQUAL)
    private Long orderId;
    @QueryField(tableAlias = "oms", column = "order_sn", condition = RelationEnum.EQUAL)
    private String orderSn;
    @QueryField(tableAlias = "oms", column = "spu_id", condition = RelationEnum.EQUAL)
    private Long spuId;
    @QueryField(tableAlias = "oms", column = "spu_name", condition = RelationEnum.EQUAL)
    private String spuName;
    @QueryField(tableAlias = "oms", column = "spu_pic", condition = RelationEnum.EQUAL)
    private String spuPic;
    @QueryField(tableAlias = "oms", column = "spu_brand", condition = RelationEnum.EQUAL)
    private String spuBrand;
    @QueryField(tableAlias = "oms", column = "category_id", condition = RelationEnum.EQUAL)
    private Long categoryId;
    @QueryField(tableAlias = "oms", column = "sku_id", condition = RelationEnum.EQUAL)
    private Long skuId;
    @QueryField(tableAlias = "oms", column = "sku_name", condition = RelationEnum.EQUAL)
    private String skuName;
    @QueryField(tableAlias = "oms", column = "sku_pic", condition = RelationEnum.EQUAL)
    private String skuPic;
    @QueryField(tableAlias = "oms", column = "sku_price", condition = RelationEnum.EQUAL)
    private String skuPrice;
    @QueryField(tableAlias = "oms", column = "sku_qty", condition = RelationEnum.EQUAL)
    private Integer skuQty;
    @QueryField(tableAlias = "oms", column = "sku_attrs_vals", condition = RelationEnum.EQUAL)
    private String skuAttrsVals;
    @QueryField(tableAlias = "oms", column = "promotion_amt", condition = RelationEnum.EQUAL)
    private String promotionAmt;
    @QueryField(tableAlias = "oms", column = "coupon_amt", condition = RelationEnum.EQUAL)
    private String couponAmt;
    @QueryField(tableAlias = "oms", column = "real_amt", condition = RelationEnum.EQUAL)
    private String realAmt;
    @QueryField(tableAlias = "oms", column = "integration_amt", condition = RelationEnum.EQUAL)
    private String integrationAmt;
    @QueryField(tableAlias = "oms", column = "gift_integration", condition = RelationEnum.EQUAL)
    private Integer giftIntegration;
    @QueryField(tableAlias = "oms", column = "gift_growth", condition = RelationEnum.EQUAL)
    private Integer giftGrowth;
    @QueryField(tableAlias = "oms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "oms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
