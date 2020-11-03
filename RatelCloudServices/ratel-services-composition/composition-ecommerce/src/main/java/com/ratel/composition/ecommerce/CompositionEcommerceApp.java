package com.ratel.composition.ecommerce;

import com.ratel.common.feign.annotations.EnableFeignInterceptor;
import com.ratel.order.api.feign.OmsOrderItemApiService;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients(clients = {OmsOrderItemApiService.class})
@EnableFeignInterceptor
public class CompositionEcommerceApp {
    public static void main(String[] args) {
        SpringApplication appRun = new SpringApplication(CompositionEcommerceApp.class);
        appRun.setBannerMode(Banner.Mode.OFF);
        appRun.run(args);
    }
}