package com.ratel.codegenerator.builders;

import java.util.Map;
/**
 * RatelCloud
 * @ClassName: SwaggerBuilder
 * @Package: com.ratel.codegenerator.builders
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: 生成Swagger
 * @Version: 1.0
 */
public class SwaggerBuilder {
    /**
     * @Author: Eric
     * @Date: 9:50 pm
     * @Description: 生成swagger的文件
     * @Param:
     * @Return:
     */
    public static void builder(Map<String,Object> modelMap,int type){
        //swagger的文件名字
        modelMap.put("Table","swagger");
        BuilderFactory.builder(modelMap,type);
    }
}
