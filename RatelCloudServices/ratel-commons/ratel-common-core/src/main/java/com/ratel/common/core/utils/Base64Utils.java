package com.ratel.common.core.utils;

import org.apache.commons.io.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * RatelCloud
 * @ClassName: Base64Utils
 * @Package: com.ratel.common.utils
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 15/09/20
 * @Description: Base64工具类
 * @Version: 1.0
 */
public class Base64Utils {
     /**
      * @Author: Eric
      * @Date: 9:25 PM 15/09/20
      * @Description: 图片转Base64编码
      * @Param: String filePath 图片路径
      * @Return:
      */
    public static String imgToBase64(String filePath){
        byte[] fileContent = null;
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }
     /**
      * @Author: Eric
      * @Date: 9:26 PM 15/09/20
      * @Description: 图片转Base64编码
      * @Param: ByteArrayOutputStream bs 输入流
      * @Return:
      */
    public static String imgToBase64(ByteArrayOutputStream bs){
        String encodedString =  Base64.getEncoder().encodeToString(bs.toByteArray());
        return encodedString;
    }

     /**
      * @Author: Eric
      * @Date: 9:26 PM 15/09/20
      * @Description: Base64编码转图片
      * @Param:
      * @Return:
      */
    public static void base64ToImg(String encodedString,String outputFilePath){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        try {
            FileUtils.writeByteArrayToFile(new File(outputFilePath), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
      * @Author: Eric
      * @Date: 9:27 PM 15/09/20
      * @Description: 生成html页面中的base64编码图片
      * @Param:
      * @Return:
      */
    public static String generateHtmlBase64ImageCode(String encodedString){
        String code = "data:image/png;base64,"+encodedString;
        return code;
    }
     /**
      * @Author: Eric
      * @Date: 9:27 PM 15/09/20
      * @Description: 简单字符串编码
      * @Param:
      * @Return:
      */
    public static String basicEncoding(String originalInput){
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        return encodedString;
    }

     /**
      * @Author: Eric
      * @Date: 9:28 PM 15/09/20
      * @Description: 简单字符串解码
      * @Param:
      * @Return:
      */
    public static String basicDecoding(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }

    public static String encodeWithoutPadding(String originalInput){
        String encodedString = Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());
        return encodedString;
    }
}
