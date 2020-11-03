package com.ratel.codegenerator.entities.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerModelProperties {
    //属性名字
    private String name;

    //类型
    private String type;

    //格式
    private String format;

    //描述
    private String description;
}
