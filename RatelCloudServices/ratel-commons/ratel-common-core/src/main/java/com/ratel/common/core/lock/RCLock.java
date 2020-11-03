package com.ratel.common.core.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * RatelCloud
 * @ClassName: RCLock
 * @Package: com.ratel.common.core.lock
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: 锁对象抽象
 * @Version: 1.0
 */
@AllArgsConstructor
public class RCLock implements AutoCloseable {
    @Getter
    private final Object lock;

    private final DistributedLock locker;

    @Override
    public void close() throws Exception {
        locker.unlock(lock);
    }
}
