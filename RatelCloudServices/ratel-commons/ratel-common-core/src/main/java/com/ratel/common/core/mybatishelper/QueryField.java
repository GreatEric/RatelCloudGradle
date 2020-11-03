package com.ratel.common.core.mybatishelper;

import com.ratel.common.core.enums.RelationEnum;
import java.lang.annotation.*;

/**
 * RatelCloud
 * @ClassName: QueryField
 * @Package: com.ratel.common.core.mybatishelper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 查询字段
 * @Version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface QueryField {

    /**
     * 对应的表别名,单表查询为空,联表查询必带
     */
    String tableAlias() default "";

    /**
     * 表字段名（驼峰命名方式，该值可none）
     */
    String column() default "";

    /**
     * 字段 where 实体查询比较条件
     * 默认 `=` 等值
     */
    RelationEnum condition() default RelationEnum.EQUAL;
}
