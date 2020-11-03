package com.ratel.codegenerator.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "basicconfig")
@ApiModel(description = "Basic Config",value = "基础配置")
public class BasicConfig extends BaseEntity {

    @ApiModelProperty(value = "项目路径",required = true)
    @NotBlank(message = "项目路径不能为空")
    private String projectPath;

    @ApiModelProperty(value = "模板路径",required = true)
    @NotBlank(message = "模板路径不能为空")
    private String templatePath;

    @ApiModelProperty(value = "POJO所在包名",required = true)
    @NotBlank(message = "POJO所在包名不能为空")
    private String pojoPackName;

    @ApiModelProperty(value = "Mapper所在包名",required = true)
    @NotBlank(message = "Mapper所在包名不能为空")
    private String mapperPackName;

    @ApiModelProperty(value = "是否生成 mapper XML文件",required = false)
    private Boolean enableMapperXML;

    @ApiModelProperty(value = "Mapper XML所在位置",required = false)
    private String mapperXMLPath;

    @ApiModelProperty(value = "Service接口所在包名",required = false)
    private String serviceInferfacePackName;

    @ApiModelProperty(value = "是否生成 service接口以及service实现",required = false)
    private Boolean enableServiceInterface;

    @ApiModelProperty(value = "Controller所在包名",required = false)
    private String controllerPackName;

    @ApiModelProperty(value = "是否生成 controller",required = false)
    private Boolean enableController;

    @ApiModelProperty(value = "feign所在包名",required = false)
    private String feignPackName;

    @ApiModelProperty(value = "是否生成 Feign",required = false)
    private Boolean enableFeign;

    @ApiModelProperty(value = "远程数据库类型",required = true)
    @NotBlank(message = "远程数据库类型名不能为空")
    private String remoteDBType;

    @ApiModelProperty(value = "远程数据库名称",required = true)
    @NotBlank(message = "远程数据库名称不能为空")
    private String remoteDBName;

    @ApiModelProperty(value = "远程数据库用户名",required = true)
    @NotBlank(message = "远程数据库用户名不能为空")
    private String remoteDBUserName;

    @ApiModelProperty(value = "远程数据库密码",required = true)
    @NotBlank(message = "远程数据库密码不能为空")
    private String remoteDBPWD;

    @ApiModelProperty(value = "是否使用swagger",required = false)
    private Boolean enableSwagger;

    @ApiModelProperty(value = "swagger-ui路径",required = false)
    private String swaggerUIPath;

    @ApiModelProperty(value = "服务名称",required = false)
    private String serviceName;
}
