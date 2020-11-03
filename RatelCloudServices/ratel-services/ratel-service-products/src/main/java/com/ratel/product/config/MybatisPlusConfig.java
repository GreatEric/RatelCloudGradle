package com.ratel.product.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.IDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RatelCloud
 * @ClassName: MybatisPlusConfig
 * @Package: com.ratel.product.config
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/20
 * @Description: mybatis-plus配置
 * @Version: 1.0
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 乐观锁 插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLoker() {
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
