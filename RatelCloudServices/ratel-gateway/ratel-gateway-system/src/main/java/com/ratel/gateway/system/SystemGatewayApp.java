package com.ratel.gateway.system;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SystemGatewayApp {
    public static void main(String[] args) {
        SpringApplication appRun = new SpringApplication(SystemGatewayApp.class);
        appRun.setBannerMode(Banner.Mode.OFF);
        appRun.run(args);
    }
}