package com.ratel.common.db.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * RatelCloud
 * @ClassName: MybatisPlusAutoFillProperties
 * @Package: com.ratel.common.db.properties
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: mybatis-plus 配置
 * @Version: 1.0
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "ratel.mybatis-plus.auto-fill")
@RefreshScope
public class MybatisPlusAutoFillProperties {
    /**
     * 是否开启自动填充字段
     */
    private Boolean enabled = true;
    /**
     * 是否开启了插入填充
     */
    private Boolean enableInsertFill = true;
    /**
     * 是否开启了更新填充
     */
    private Boolean enableUpdateFill = true;
    /**
     * 创建时间字段名
     */
    private String createTimeField = "createTime";
    /**
     * 更新时间字段名
     */
    private String modifyTimeField = "modifyTime";
}
