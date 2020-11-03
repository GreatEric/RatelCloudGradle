package com.ratel.common.core.utils;

import java.util.Arrays;

/**
 * RatelCloud
 * @ClassName: InvitationCodeUtils
 * @Package: com.ratel.common.utils
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 15/09/20
 * @Description: 邀请码生成器
 * @Version: 1.0
 */
public class InvitationCodeUtils {
    /**
     * 随机字符串
     */
    private static final char[] CHARS = new char[] {
            'F', 'L', 'G', 'W', '5', 'X', 'C', '3',
            '9', 'Z', 'M', '6', '7', 'Y', 'R', 'T',
            '2', 'H', 'S', '8', 'D', 'V', 'E', 'J',
            '4', 'K', 'Q', 'P', 'U', 'A', 'N', 'B'};

    private final static int CHARS_LENGTH = 32;
    /**
     * 邀请码长度
     */
    private final static int CODE_LENGTH = 6;

    /**
     * 随机数据
     */
    private final static long SLAT = 1234561L;

    /**
     * PRIME1 与 CHARS 的长度 L互质，可保证 ( id * PRIME1) % L 在 [0,L)上均匀分布
     */
    private final static int PRIME1 = 3;

    /**
     * PRIME2 与 CODE_LENGTH 互质，可保证 ( index * PRIME2) % CODE_LENGTH  在 [0，CODE_LENGTH）上均匀分布
     */
    private final static int PRIME2 = 11;

     /**
      * @Author: Eric
      * @Date: 9:33 PM 15/09/20
      * @Description: 生成邀请码
      * @Param:
      * @Return:
      */
    public String gen(Long id) {
        //补位
        id = id * PRIME1 + SLAT;
        //将 id 转换成32进制的值
        long[] b = new long[CODE_LENGTH];
        //32进制数
        b[0] = id;
        for (int i = 0; i < CODE_LENGTH - 1; i++) {
            b[i + 1] = b[i] / CHARS_LENGTH;
            //按位扩散
            b[i] = (b[i] + i * b[0]) % CHARS_LENGTH;
        }
        b[5] = (b[0] + b[1] + b[2] + b[3] + b[4]) * PRIME1 % CHARS_LENGTH;

        //进行混淆
        long[] codeIndexArray = new long[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            codeIndexArray[i] = b[i * PRIME2 % CODE_LENGTH];
        }

        StringBuilder buffer = new StringBuilder();
        Arrays.stream(codeIndexArray).boxed().map(Long::intValue).map(t -> CHARS[t]).forEach(buffer::append);
        return buffer.toString();
    }

     /**
      * @Author: Eric
      * @Date: 9:33 PM 15/09/20
      * @Description: 将邀请码解密成原来的id
      * @Param:
      * @Return:
      */
    public Long decode(String code) {
        if (code.length() != CODE_LENGTH) {
            return null;
        }
        //将字符还原成对应数字
        long[] a = new long[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            char c = code.charAt(i);
            int index = findIndex(c);
            if (index == -1) {
                //异常字符串
                return null;
            }
            a[i * PRIME2 % CODE_LENGTH] = index;
        }

        long[] b = new long[CODE_LENGTH];
        for (int i = CODE_LENGTH - 2; i >= 0; i--) {
            b[i] = (a[i] - a[0]*i + CHARS_LENGTH * i) % CHARS_LENGTH;
        }

        long res = 0;
        for (int i = CODE_LENGTH - 2; i >= 0; i--) {
            res += b[i];
            res *= (i > 0 ? CHARS_LENGTH : 1);
        }
        return (res - SLAT) / PRIME1;
    }

     /**
      * @Author: Eric
      * @Date: 9:33 PM 15/09/20
      * @Description: 查找对应字符的index
      * @Param:
      * @Return:
      */
    private int findIndex(char c) {
        for (int i = 0; i < CHARS_LENGTH; i++) {
            if (CHARS[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static InvitationCodeUtils instance() {
        return InvitationCodeHolder.instance;
    }

    private static class InvitationCodeHolder {
        private static InvitationCodeUtils instance = new InvitationCodeUtils();
    }
}