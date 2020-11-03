package com.ratel.common.feign.filters;

import cn.hutool.core.util.StrUtil;
import com.ratel.common.core.constants.CommonConstant;
import com.ratel.common.core.constants.ConfigConstants;
import com.ratel.common.core.context.LbIsolationContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RatelCloud
 *
 * @ClassName: LbIsolationFilter
 * @Package: com.ratel.common.feign.filters
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: 负载均衡隔离规则过滤器
 * @Version: 1.0
 */
@ConditionalOnClass(Filter.class)
public class LbIsolationFilter extends OncePerRequestFilter {
    @Value("${" + ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED + ":false}")
    private boolean enableIsolation;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !enableIsolation;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        try {
            String version = request.getHeader(CommonConstant.RATEL_VERSION);
            if (StrUtil.isNotEmpty(version)) {
                LbIsolationContextHolder.setVersion(version);
            }

            filterChain.doFilter(request, response);
        } finally {
            LbIsolationContextHolder.clear();
        }
    }
}
