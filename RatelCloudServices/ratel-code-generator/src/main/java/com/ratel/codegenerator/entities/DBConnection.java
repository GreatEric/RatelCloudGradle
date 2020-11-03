package com.ratel.codegenerator.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tb_dbconnection")
@ApiModel(description = "Database Connection",value = "数据库连接")
public class DBConnection extends BaseEntity {
    @ApiModelProperty(value = "数据库连接配置名",required = true)
    @NotBlank(message = "数据库连接配置名不能为空")
    private String configName;

    @ApiModelProperty(value = "数据库类型名",required = true)
    @NotNull(message = "数据库类型不能为空")
    private Integer dbType;

    @ApiModelProperty(value = "数据库主机名",required = true)
    @NotBlank(message = "数据库主机名不能为空")
    private String hostName;

    @ApiModelProperty(value = "数据库端口号",required = true)
    @NotNull(message = "数据库端口号不能为空")
    private Integer port;

    @ApiModelProperty(value = "数据库用户名",required = false)
    @NotBlank(message = "数据库用户名")
    private String userName;

    @ApiModelProperty(value = "数据库密码",required = false)
    @NotBlank(message = "数据库密码不能为空")
    private String pwd;

    @ApiModelProperty(value = "数据库schema",required = false)
    @NotBlank(message = "数据库schema不能为空")
    private String schemaName;

    @ApiModelProperty(value = "是否保存该设置",required = false)
    private Boolean saveConfig;
}
