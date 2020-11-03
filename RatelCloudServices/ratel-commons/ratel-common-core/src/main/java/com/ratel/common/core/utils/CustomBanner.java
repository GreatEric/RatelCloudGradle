package com.ratel.common.core.utils;

import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.DescriptionBanner;
import com.nepxion.banner.LogoBanner;
import java.util.ArrayList;
import java.util.List;

/**
 * RatelCloud
 * @ClassName: CustomBanner
 * @Package: com.ratel.common.core.utils
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: 自定义Banner
 * @Version: 1.0
 */
public class CustomBanner {
    public static void show(LogoBanner logoBanner, Description... descriptionList) {
        String bannerShown = System.getProperty(BannerConstant.BANNER_SHOWN, "true");
        if (!Boolean.valueOf(bannerShown)) {
            return;
        }

        System.out.println("");
        String bannerShownAnsiMode = System.getProperty(BannerConstant.BANNER_SHOWN_ANSI_MODE, "false");
        /*if (Boolean.valueOf(bannerShownAnsiMode)) {
           System.out.println(logoBanner.getBanner());
        } else {
           System.out.println(logoBanner.getPlainBanner());
        }*/
        System.out.println(logoBanner.getBanner());

        List<Description> descriptions = new ArrayList<>();
        for (Description description : descriptionList) {
            descriptions.add(description);
        }

        DescriptionBanner descriptionBanner = new DescriptionBanner();
        System.out.println(descriptionBanner.getBanner(descriptions));
    }
}
