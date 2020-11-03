package com.ratel.common.core.form;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * RatelCloud
 * @ClassName: BaseForm
 * @Package: com.ratel.common.core.form
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 表单基类
 * @Version: 1.0
 */
public abstract class BaseForm<T> implements Serializable {
    @ApiModelProperty(hidden = true)
    protected transient final Class<T> domain;
    public BaseForm() {
        domain = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
