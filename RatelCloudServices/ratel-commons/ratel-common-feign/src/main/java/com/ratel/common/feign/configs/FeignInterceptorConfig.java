package com.ratel.common.feign.configs;

import cn.hutool.core.util.StrUtil;
import com.ratel.common.core.constants.CommonConstant;
import com.ratel.common.core.constants.SecurityConstants;
import com.ratel.common.core.context.TenantContextHolder;
import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;

/**
 * RatelCloud
 * @ClassName: FeignInterceptorConfig
 * @Package: com.ratel.common.feign.configs
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: feign拦截器，只包含基础数据
 * @Version: 1.0
 */
public class FeignInterceptorConfig {
    /**
     * 使用feign client访问别的微服务时，将上游传过来的client、traceid等信息放入header传递给下一个服务
     */
    @Bean
    public RequestInterceptor baseFeignInterceptor() {
        return template -> {
            //传递client
            String tenant = TenantContextHolder.getTenant();
            if (StrUtil.isNotEmpty(tenant)) {
                template.header(SecurityConstants.TENANT_HEADER, tenant);
            }

            //传递日志traceId
            String traceId = MDC.get(CommonConstant.LOG_TRACE_ID);
            if (StrUtil.isNotEmpty(traceId)) {
                template.header(CommonConstant.TRACE_ID_HEADER, traceId);
            }
        };
    }
}
