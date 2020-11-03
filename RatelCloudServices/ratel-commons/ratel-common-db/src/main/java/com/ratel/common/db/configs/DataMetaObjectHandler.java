package com.ratel.common.db.configs;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ratel.common.db.properties.MybatisPlusAutoFillProperties;
import org.apache.ibatis.reflection.MetaObject;

import java.sql.Timestamp;
import java.util.Date;

/**
 * RatelCloud
 * @ClassName: DataMetaObjectHandler
 * @Package: com.ratel.common.db.configs
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 自定义填充公共字段
 * @Version: 1.0
 */
public class DataMetaObjectHandler implements MetaObjectHandler {
    private MybatisPlusAutoFillProperties autoFillProperties;

    public DataMetaObjectHandler(MybatisPlusAutoFillProperties autoFillProperties) {
        this.autoFillProperties = autoFillProperties;
    }

    /**
     * 是否开启了插入填充
     */
    @Override
    public boolean openInsertFill() {
        return autoFillProperties.getEnableInsertFill();
    }

    /**
     * 是否开启了更新填充
     */
    @Override
    public boolean openUpdateFill() {
        return autoFillProperties.getEnableUpdateFill();
    }

    /**
     * 插入填充，字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName(autoFillProperties.getCreateTimeField(), metaObject);
        Object updateTime = getFieldValByName(autoFillProperties.getModifyTimeField(), metaObject);
        if (createTime == null || updateTime == null) {
            Timestamp date = new Timestamp(System.currentTimeMillis());
            if (createTime == null) {
                setFieldValByName(autoFillProperties.getCreateTimeField(), date, metaObject);
            }
            if (updateTime == null) {
                setFieldValByName(autoFillProperties.getModifyTimeField(), date, metaObject);
            }
        }
    }

    /**
     * 更新填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(autoFillProperties.getModifyTimeField(), new Date(), metaObject);
    }
}