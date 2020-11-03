package com.ratel.common.feign;

import com.ratel.common.core.constants.ConfigConstants;
import com.ratel.common.feign.configs.RuleConfigure;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * RatelCloud
 *
 * @ClassName: LbIsolationAutoConfigure
 * @Package: com.ratel.common.feign
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: 自定义负载均衡配置
 * @Version: 1.0
 */
@ConditionalOnProperty(value = ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED, havingValue = "true")
@RibbonClients(defaultConfiguration = {RuleConfigure.class})
public class LbIsolationAutoConfigure {

}
