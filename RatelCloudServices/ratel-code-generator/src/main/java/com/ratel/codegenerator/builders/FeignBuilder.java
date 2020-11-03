package com.ratel.codegenerator.builders;

import java.util.Map;

/**
 * RatelCloud
 * @ClassName: FeignBuilder
 * @Package: com.ratel.codegenerator.builders
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: Feign构建
 * @Version: 1.0
 */
public class FeignBuilder {
    /**
     * @Author: Eric
     * @Date: 9:46 pm
     * @Description: 生成Feign层文件
     * @Param:
     * @Return:
     */
    public static void builder(Map<String, Object> modelMap,int type) {
        BuilderFactory.builder(modelMap, type);
    }
}
