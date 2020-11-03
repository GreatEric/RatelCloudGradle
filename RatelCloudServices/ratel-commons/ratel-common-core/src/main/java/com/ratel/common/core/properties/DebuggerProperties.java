package com.ratel.common.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Setter
@Getter
@ConfigurationProperties(prefix = "ratel.debugger")
@RefreshScope
public class DebuggerProperties {
    /**
     * 是否开启打印
     */
    private Boolean showPrint = false;
}
