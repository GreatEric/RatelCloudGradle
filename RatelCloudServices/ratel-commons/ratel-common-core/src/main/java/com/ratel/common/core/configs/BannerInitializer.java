package com.ratel.common.core.configs;

import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.LogoBanner;
import com.ratel.common.core.constants.CommonConstant;
import com.ratel.common.core.utils.CustomBanner;
import com.taobao.text.Color;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * RatelCloud
 * @ClassName: BannerInitializer
 * @Package: com.ratel.common.core.config
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: 应用Banner
 * @Version: 1.0
 */
public class BannerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            LogoBanner logoBanner = new LogoBanner(BannerInitializer.class, "/ratelcloud/logo.txt", "Ratel Cloud Services", 1, 5, new Color[] { Color.yellow }, false);
            Environment env = applicationContext.getEnvironment();
            String externalAddress = "";
            try {
                externalAddress = InetAddress.getLocalHost().getHostAddress().toString();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            CustomBanner.show(
                    logoBanner,
                    new Description(BannerConstant.VERSION + ":", CommonConstant.PROJECT_VERSION, 0, 1),
                    new Description("Application:", env.getProperty("spring.application.name"), 0, 1),
                    new Description("Access URLs", "", 0, 1),
                    new Description("Local:", "http://localhost:"+env.getProperty("server.port"), 0, 1),
                    new Description("External:", "http://"+externalAddress+":"+env.getProperty("server.port"), 0, 1),
                    new Description("Doc:", "http://"+externalAddress+":"+env.getProperty("server.port")+"/doc.html", 0, 1)
            );
        }
    }
}
