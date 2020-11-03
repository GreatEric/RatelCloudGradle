package com.ratel.common.core.lock;

/**
 * RatelCloud
 * @ClassName: LockException
 * @Package: com.ratel.common.core.lock
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: 分布式锁异常
 * @Version: 1.0
 */
public class LockException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public LockException(String message) {
        super(message);
    }
}
