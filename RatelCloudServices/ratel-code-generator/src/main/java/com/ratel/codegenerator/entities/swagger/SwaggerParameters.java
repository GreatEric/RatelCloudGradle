package com.ratel.codegenerator.entities.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerParameters {

    //输入类型 body
    private String in;

    //输入名字介绍  Album对象
    private String name;

    //输入描述
    private String description;

    //是否是必须输入
    private Boolean required;

    //引用对象
    private String schema;

    //类型
    private String type;

    //format
    private String format;
}
