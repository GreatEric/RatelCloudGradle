package com.ratel.common.core.exception;

/**
 * RatelCloud
 * @ClassName: IdempotencyException
 * @Package: com.ratel.common.core.exception
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 幂等性异常
 * @Version: 1.0
 */
public class IdempotencyException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public IdempotencyException(String message) {
        super(message);
    }
}
