package com.ratel.codegenerator.builders;

import java.util.Map;

/**
 * RatelCloud
 * @ClassName: MapperXMLBuilder
 * @Package: com.ratel.codegenerator.builders
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: MapperXML构建
 * @Version: 1.0
 */
public class MapperXMLBuilder {
    /**
     * @Author: Eric
     * @Date: 9:48 pm
     * @Description: 生成Mapper层XML文件
     * @Param:
     * @Return:
     */
    public static void build(Map<String, Object> modelMap,int type) {
        BuilderFactory.builder(modelMap,type);
    }
}
