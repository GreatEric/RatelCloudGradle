package com.ratel.codegenerator.entities.table;

import com.ratel.codegenerator.utils.StringUtils;

/**
 * RatelCloud
 *
 * @ClassName: JavaTypes
 * @Package: com.ratel.codegenerator.entities.table
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 6/10/20
 * @Description: Java数据类型
 * @Version: 1.0
 */
public class JavaTypes {
    /**
     * @Author: Eric
     * @Date: 9:53 pm
     * @Description: 根据java.sql.Types的值返回java的类型
     * @Param:
     * @Return:
     */
    public static String getType(int value) {
        switch (value) {
            case -6:
                return "java.lang.Integer";
            case 5:
                return "java.lang.Integer";
            case 4:
                return "java.lang.Integer";
            case -5:
                return "java.lang.Long";
            case 6:
                return "java.lang.Float";
            case 8:
                return "java.lang.Double";
            case 1:
                return "java.lang.String";
            case 12:
                return "java.lang.String";
            case -1:
                return "java.lang.String";
            case 91:
                return "java.util.Date";
            case 92:
                return "java.util.Date";
            case 93:
                return "java.util.Date";
            case 16:
                return "java.lang.Boolean";
            default:
                return "java.lang.String";
        }
    }

    /**
     * @Author: Eric
     * @Date: 9:54 pm
     * @Description: 去掉数据类型的包
     * @Param:
     * @Return:
     */
    public static String simpleName(String type) {
        return type.replace("java.lang.", "").replaceFirst("java.util.", "");
    }

    /**
     * @Author: Eric
     * @Date: 9:54 pm
     * @Description: 去掉数据类型的包，并且首字母小写
     * @Param:
     * @Return:
     */
    public static String simpleNameLowerFirst(String type) {
        //去掉前缀
        type = simpleName(type);
        //将第一个字母转成小写
        return StringUtils.firstLower(type);
    }
}
