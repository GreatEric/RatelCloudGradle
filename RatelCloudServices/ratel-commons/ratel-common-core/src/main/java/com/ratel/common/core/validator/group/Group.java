package com.ratel.common.core.validator.group;

import javax.validation.GroupSequence;

/**
 * RatelCloud
 * @ClassName: Group
 * @Package: com.ratel.common.core.validator
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 18/09/20
 * @Description: 定义校验Order，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @Version: 1.0
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
