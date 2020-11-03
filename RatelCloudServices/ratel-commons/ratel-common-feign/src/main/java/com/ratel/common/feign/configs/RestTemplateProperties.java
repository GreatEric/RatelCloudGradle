package com.ratel.common.feign.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RatelCloud
 * @ClassName: RestTemplateProperties
 * @Package: com.ratel.common.feign.configs
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: RestTemplate 配置
 * @Version: 1.0
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "ratel.rest-template")
public class RestTemplateProperties {
    /**
     * 最大链接数
     */
    private int maxTotal = 200;
    /**
     * 同路由最大并发数
     */
    private int maxPerRoute = 50;
    /**
     * 读取超时时间 ms
     */
    private int readTimeout = 35000;
    /**
     * 链接超时时间 ms
     */
    private int connectTimeout = 10000;
}
