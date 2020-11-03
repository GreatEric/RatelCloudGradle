package com.ratel.common.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * RatelCloud
 * @ClassName: SuperMapper
 * @Package: com.ratel.common.db.mapper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: mapper 父类，注意这个类不要让 mp 扫描到
 * @Version: 1.0
 */
public interface SuperMapper<T> extends BaseMapper<T> {
}
