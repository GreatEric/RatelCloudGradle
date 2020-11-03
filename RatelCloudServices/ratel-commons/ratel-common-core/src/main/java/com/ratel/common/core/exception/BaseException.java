package com.ratel.common.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * RatelCloud
 * @ClassName: BaseException
 * @Package: com.ratel.common.core.exception
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: 自定义异常父类
 * @Version: 1.0
 */
@Getter
@Setter
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;
    private Integer code;

    public BaseException(int code) {
        super();
        this.code = code;
    }

    public BaseException(int code,String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(Throwable e, int code, String msg) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
