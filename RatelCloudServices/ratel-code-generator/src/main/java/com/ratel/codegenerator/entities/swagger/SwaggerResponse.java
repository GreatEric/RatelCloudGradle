package com.ratel.codegenerator.entities.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerResponse {
    //响应状态码  200,404.。。
    private int code;

    //描述
    private String description;

    //响应引用
    private String schema;
}
