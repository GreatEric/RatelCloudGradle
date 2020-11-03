package com.ratel.product.api.pojos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ratel.common.core.entities.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * RatelCloud
 *
 * @ClassName: PmsBrand
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand实体
 * @Version: 1.0
 */
@ApiModel(description = "PmsBrand实体", value = "PmsBrand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pms_brand")
public class PmsBrand extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌中文名", required = false)
    private String nameZh;
    @ApiModelProperty(value = "品牌英文名", required = false)
    private String nameEn;
    @ApiModelProperty(value = "品牌图片地址", required = false)
    private String icon;
    @ApiModelProperty(value = "品牌的首字母", required = false)
    private String initial;
    @ApiModelProperty(value = "排序", required = false)
    private Integer seq;
}
