package com.ratel.common.core.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: SuperEntity
 * @Package: com.ratel.common.core
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: 实体父类
 * @Version: 1.0
 */
@Setter
@Getter
public class SuperEntity<T extends Model<?>> extends Model<T> {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键id", required = true)
    @TableId
    private Long id;

    @ApiModelProperty(value = "创建时间", required = true)
    /*@JsonFormat(pattern = "dd/MM/yyyy", timezone = "UTC")
    @Temporal(TemporalType.TIMESTAMP)*/
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间", required = true)
    /*@JsonFormat(pattern = "dd/MM/yyyy", timezone = "UTC")
    @Temporal(TemporalType.TIMESTAMP)*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp modifyTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
