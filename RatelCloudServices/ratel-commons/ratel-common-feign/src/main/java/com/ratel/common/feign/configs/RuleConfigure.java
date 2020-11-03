package com.ratel.common.feign.configs;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.loadbalancer.IRule;
import com.ratel.common.feign.rules.VersionIsolationRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * RatelCloud
 * @ClassName: RuleConfigure
 * @Package: com.ratel.common.feign.configs
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: TODO
 * @Version: 1.0
 */
public class RuleConfigure {
    @Bean
    @ConditionalOnClass(NacosServer.class)
    @ConditionalOnMissingBean
    public IRule versionIsolationRule() {
        return new VersionIsolationRule();
    }
}
