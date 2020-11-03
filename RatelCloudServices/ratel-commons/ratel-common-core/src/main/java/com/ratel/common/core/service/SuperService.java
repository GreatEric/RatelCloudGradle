package com.ratel.common.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.common.core.lock.DistributedLock;


/**
 * RatelCloud
 * @ClassName: SuperService
 * @Package: com.ratel.common.core
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 17/09/20
 * @Description: Service接口父类
 * @Version: 1.0
 */
public interface SuperService<T> extends IService<T> {
    /**
     * 幂等性新增记录
     * 例子如下：
     * String username = sysUser.getUsername();
     * boolean result = super.saveIdempotency(sysUser, lock
     *                 , LOCK_KEY_USERNAME+username
     *                 , new QueryWrapper<SysUser>().eq("username", username));
     *
     * @param entity       实体对象
     * @param locker       锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    boolean saveIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper, String msg) throws Exception;

    boolean saveIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper) throws Exception;

    /**
     * 幂等性新增或更新记录
     * 例子如下：
     * String username = sysUser.getUsername();
     * boolean result = super.saveOrUpdateIdempotency(sysUser, lock
     *                 , LOCK_KEY_USERNAME+username
     *                 , new QueryWrapper<SysUser>().eq("username", username));
     *
     * @param entity       实体对象
     * @param locker       锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    boolean saveOrUpdateIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper, String msg) throws Exception;

    boolean saveOrUpdateIdempotency(T entity, DistributedLock locker, String lockKey, Wrapper<T> countWrapper) throws Exception;
}
