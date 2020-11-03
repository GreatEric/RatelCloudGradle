package com.ratel.common.core.form;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * RatelCloud
 * @ClassName: PersistForm
 * @Package: com.ratel.common.core.form
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 18/09/20
 * @Description: 持久化表单数据
 * @Version: 1.0
 */
@Slf4j
public abstract class PersistForm<T> extends BaseForm<T> {
    public T toEntity() {
        try {
            T entity = domain.newInstance();
            BeanUtils.copyProperties(this, entity);
            return entity;
        } catch (InstantiationException | IllegalAccessException ex) {
            log.warn(ex.getMessage(), ex);
            return null;
        }
    }
}
