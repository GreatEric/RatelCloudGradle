package com.ratel.common.core.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;

/**
 * RatelCloud
 * @ClassName: BaseEnum
 * @Package: com.ratel.common.core.enums
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 18/09/20
 * @Description: Enum
 * @Version: 1.0
 */
public interface SuperEnum<T extends Serializable> extends IEnum<T> {
    @Override
    @JsonValue
    T getValue();

    String getRemark();
}