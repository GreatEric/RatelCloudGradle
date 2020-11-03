package com.ratel.common.feign;

import com.ratel.common.feign.configs.RestTemplateProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.DefaultPropertiesFactory;
import org.springframework.context.annotation.Bean;

/**
 * RatelCloud
 * @ClassName: RibbonAutoConfigure
 * @Package: com.ratel.common.feign
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: Ribbon扩展配置类
 * @Version: 1.0
 */
@EnableConfigurationProperties(RestTemplateProperties.class)
public class RibbonAutoConfigure {
    @Bean
    public DefaultPropertiesFactory defaultPropertiesFactory() {
        return new DefaultPropertiesFactory();
    }
}
