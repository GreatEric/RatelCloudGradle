package com.ratel.product.api.forms;

import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.product.api.pojos.PmsBrand;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: PmsBrandQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand查询表单
 * @Version: 1.0
 */
@ApiModel(description = "PmsBrandQueryForm", value = "PmsBrandQueryForm")
@Setter
@Getter
public class PmsBrandQueryForm extends PageForm<PmsBrand> {
    @QueryField(tableAlias = "pms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "pms", column = "name_zh", condition = RelationEnum.EQUAL)
    private String nameZh;
    @QueryField(tableAlias = "pms", column = "name_en", condition = RelationEnum.EQUAL)
    private String nameEn;
    @QueryField(tableAlias = "pms", column = "icon", condition = RelationEnum.EQUAL)
    private String icon;
    @QueryField(tableAlias = "pms", column = "initial", condition = RelationEnum.EQUAL)
    private String initial;
    @QueryField(tableAlias = "pms", column = "seq", condition = RelationEnum.EQUAL)
    private Integer seq;
    @QueryField(tableAlias = "pms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "pms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
