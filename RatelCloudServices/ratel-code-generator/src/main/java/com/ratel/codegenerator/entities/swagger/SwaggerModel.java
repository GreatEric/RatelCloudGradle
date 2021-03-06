package com.ratel.codegenerator.entities.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerModel {
    //名字
    private String name;

    //类型
    private String type;

    //字段集合
    private List<SwaggerModelProperties> properties;

    //描述
    private String description;
}
