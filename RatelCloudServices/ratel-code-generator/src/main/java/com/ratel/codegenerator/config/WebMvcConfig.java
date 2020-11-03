package com.ratel.codegenerator.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * RatelCloud
 * @ClassName: WebMvcConfig
 * @Package: com.ratel.order.configs
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 29/9/20
 * @Description: 跨域配置
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    /**
     * @Author: Eric
     * @Date: 12:07 am
     * @Description: 系统跨域设置
     * @Param: CorsRegistry registry
     * @Return:
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(MAX_AGE_SECS);
    }
}