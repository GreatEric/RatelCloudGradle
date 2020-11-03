//package com.ratel.common.core.configs;
//
//import com.ratel.common.core.properties.DebuggerProperties;
//import com.ratel.common.core.utils.Debugger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//
//@EnableConfigurationProperties(DebuggerProperties.class)
//public class DebuggerAutoConfigure {
//
//    @Autowired
//    private DebuggerProperties properties;
//
//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "ratel.debugger", name = "showPrint", havingValue = "true", matchIfMissing = true)
//    public Debugger debugger() {
//        return Debugger.getInstance(properties);
//    }
//}
