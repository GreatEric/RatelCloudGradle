package com.ratel.common.feign.annotations;

import com.ratel.common.feign.configs.FeignHttpInterceptorConfig;
import com.ratel.common.feign.configs.FeignInterceptorConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RatelCloud
 *
 * @ClassName: EnableFeignInterceptor
 * @Package: com.ratel.common.feign.annotations
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: 开启feign拦截器传递数据给下游服务，包含基础数据和http的相关数据
 * @Version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({FeignInterceptorConfig.class, FeignHttpInterceptorConfig.class})
public @interface EnableFeignInterceptor {

}
