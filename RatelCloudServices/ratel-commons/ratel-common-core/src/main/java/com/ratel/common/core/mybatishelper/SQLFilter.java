package com.ratel.common.core.mybatishelper;

import com.ratel.common.core.entities.I18n;
import com.ratel.common.core.enums.StatusCodeEnum;
import com.ratel.common.core.exception.BizException;
import org.apache.commons.lang3.StringUtils;

/**
 * RatelCloud
 * @ClassName: SQLFilter
 * @Package: com.ratel.common.core.mybatishelper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: SQL过滤
 * @Version: 1.0
 */
public class SQLFilter {
    
     /**
      * @Author: Eric
      * @Date: 10:46 AM 17/09/20
      * @Description: SQL注入过滤
      * @Param:
      * @Return:
      */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.contains(keyword)){
                throw new BizException(StatusCodeEnum.ContainsIllegalCharacters.getValue());
            }
        }
        return str;
    }
}
