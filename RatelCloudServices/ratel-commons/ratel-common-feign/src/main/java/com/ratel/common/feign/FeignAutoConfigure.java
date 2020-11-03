package com.ratel.common.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * RatelCloud
 *
 * @ClassName: FeignAutoConfigure
 * @Package: com.ratel.common.feign
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: Feign统一配置
 * @Version: 1.0
 */
public class FeignAutoConfigure {

    /**
     * Feign 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
