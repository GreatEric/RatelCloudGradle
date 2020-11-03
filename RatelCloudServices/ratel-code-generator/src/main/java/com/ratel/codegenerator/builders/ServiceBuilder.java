package com.ratel.codegenerator.builders;

import java.util.Map;

/**
 * RatelCloud
 * @ClassName: ServiceBuilder
 * @Package: com.ratel.codegenerator.builders
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: Service构建
 * @Version: 1.0
 */
public class ServiceBuilder {
    /**
     * @Author: Eric
     * @Date: 9:49 pm
     * @Description: 生成Service层文件
     * @Param:
     * @Return:
     */
    public static void build(Map<String, Object> modelMap,int type) {
        BuilderFactory.builder(modelMap,type);
    }
}
