package com.ratel.common.db.configs;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ratel.common.db.properties.MybatisPlusAutoFillProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * RatelCloud
 * @ClassName: MybatisPlusAutoConfigure
 * @Package: com.ratel.common.db.configs
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: mybatis-plus自动配置
 * @Version: 1.0
 */
@EnableConfigurationProperties(MybatisPlusAutoFillProperties.class)
public class MybatisPlusAutoConfigure {
    @Autowired
    private MybatisPlusAutoFillProperties autoFillProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "ratel.mybatis-plus.auto-fill", name = "enabled", havingValue = "true", matchIfMissing = true)
    public MetaObjectHandler metaObjectHandler() {
        return new DataMetaObjectHandler(autoFillProperties);
    }
}
