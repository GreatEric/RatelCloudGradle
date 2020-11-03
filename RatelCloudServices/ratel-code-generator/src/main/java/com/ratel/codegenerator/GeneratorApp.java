package com.ratel.codegenerator;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = {GeneratorApp.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class GeneratorApp {
    public static void main(String[] args) {
        SpringApplication appRun = new SpringApplication(GeneratorApp.class);
        appRun.setBannerMode(Banner.Mode.OFF);
        appRun.run(args);
    }
}
