package com.ratel.codegenerator.utils;

/**
 * RatelCloud
 * @ClassName: StringUtils
 * @Package: com.ratel.codegenerator
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 2/10/20
 * @Description: 字符串处理
 * @Version: 1.0
 */
public class StringUtils {

    /**
     * @Author: Eric
     * @Date: 9:56 pm
     * @Description: 首字母大写
     * @Param:
     * @Return:
     */
    public static String firstUpper(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

    /**
     * @Author: Eric
     * @Date: 9:56 pm
     * @Description: 首字母小写
     * @Param:
     * @Return:
     */
    public static String firstLower(String str){
        return str.substring(0,1).toLowerCase()+str.substring(1);
    }

    /**
     * @Author: Eric
     * @Date: 9:56 pm
     * @Description: 移除tab_,tb_
     * @Param:
     * @Return:
     */
    public static String replaceTab(String str){
        return str.replaceFirst("tab_","").replaceFirst("tb_","");
    }

    /**
     * @Author: Eric
     * @Date: 9:56 pm
     * @Description: 将下划线替换掉
     * @Param:
     * @Return:
     */
    public static String replace_(String str){
        //根据下划线分割
        String[] split = str.split("_");
        //循环组装
        String result = split[0];
        if(split.length>1){
            for (int i = 1; i < split.length; i++) {
                result+=firstUpper(split[i]);
            }
        }
        return result;
    }
}
