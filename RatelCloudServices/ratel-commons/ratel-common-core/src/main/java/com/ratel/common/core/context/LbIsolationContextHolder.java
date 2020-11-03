package com.ratel.common.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * RatelCloud
 * @ClassName: LbIsolationContextHolder
 * @Package: com.ratel.common.core.context
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: 负载均衡策略Holder
 * @Version: 1.0
 */
public class LbIsolationContextHolder {
    private static final ThreadLocal<String> VERSION_CONTEXT = new TransmittableThreadLocal<>();

    public static void setVersion(String version) {
        VERSION_CONTEXT.set(version);
    }

    public static String getVersion() {
        return VERSION_CONTEXT.get();
    }

    public static void clear() {
        VERSION_CONTEXT.remove();
    }
}
