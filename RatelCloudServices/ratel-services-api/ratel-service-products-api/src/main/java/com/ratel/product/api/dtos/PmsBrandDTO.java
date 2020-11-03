package com.ratel.product.api.dtos;

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
 * @ClassName: PmsBrandDTO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand DTO
 * @Version: 1.0
 */
@ApiModel(description = "PmsBrand DTO", value = "PmsBrand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PmsBrandDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌id", required = false)
    private Long id;
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
    @ApiModelProperty(value = "创建时间", required = false)
    private Timestamp createTime;
    @ApiModelProperty(value = "修改时间", required = false)
    private Timestamp modifyTime;
}

