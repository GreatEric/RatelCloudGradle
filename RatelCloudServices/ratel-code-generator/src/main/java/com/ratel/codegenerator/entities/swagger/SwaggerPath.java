package com.ratel.codegenerator.entities.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerPath {

    //请求路径
    private String path;

    //方法配置
    private List<SwaggerMethod> methods;

    //对象
    private String model;

    //对象-首字母小写
    private String table;
}
