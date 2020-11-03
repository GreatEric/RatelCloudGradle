package com.ratel.common.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * RatelCloud
 * @ClassName: TenantContextHolder
 * @Package: com.ratel.common.core.context
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: 租户holder
 * @Version: 1.0
 */
public class TenantContextHolder {
    /**
     * 支持父子线程之间的数据传递
     */
    private static final ThreadLocal<String> CONTEXT = new TransmittableThreadLocal<>();

    public static void setTenant(String tenant) {
        CONTEXT.set(tenant);
    }

    public static String getTenant() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
