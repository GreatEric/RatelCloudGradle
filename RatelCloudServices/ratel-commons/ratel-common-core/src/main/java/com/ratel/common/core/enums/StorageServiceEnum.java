package com.ratel.common.core.enums;

/**
 * RatelCloud
 * @ClassName: StorageServiceEnum
 * @Package: com.ratel.common.core.enums
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/20
 * @Description: 云服务商
 * @Version: 1.0
 */
public enum StorageServiceEnum {

    /*阿里云*/
    ALIYUN(1);

    private final int value;

    StorageServiceEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
