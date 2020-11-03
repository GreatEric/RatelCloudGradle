package com.ratel.product;

import com.ratel.common.feign.annotations.EnableFeignInterceptor;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan("com.ratel")
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients
@EnableFeignInterceptor
public class ProductServiceApp {
    public static void main(String[] args) {
        SpringApplication appRun = new SpringApplication(ProductServiceApp.class);
        appRun.setBannerMode(Banner.Mode.OFF);
        appRun.run(args);
    }
}
