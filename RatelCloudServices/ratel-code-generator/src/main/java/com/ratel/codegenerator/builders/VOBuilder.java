package com.ratel.codegenerator.builders;

import java.util.Map;

/**
 * RatelCloud
 * @ClassName: PojoBuilder
 * @Package: com.ratel.codegenerator.builders
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: Pojo构建
 * @Version: 1.0
 */
public class VOBuilder {
    /**
     * @Author: Eric
     * @Date: 9:48 pm
     * @Description: 生成VO层文件
     * @Param:
     * @Return:
     */
    public static void build(Map<String, Object> dataModel,int type) {
        BuilderFactory.builder(dataModel, type);
    }
}
