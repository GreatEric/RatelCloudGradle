package com.ratel.common.feign.rules;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.loadbalancer.*;
import com.ratel.common.core.constants.CommonConstant;
import com.ratel.common.core.context.LbIsolationContextHolder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RatelCloud
 * @ClassName: VersionIsolationRule
 * @Package: com.ratel.common.feign.rules
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: 根据实例版本号隔离规则
 *
 * 详细用法：https://mp.weixin.qq.com/s/9XQ-SIbYsov3KBx9TGFN0g
 * 实例获取规则顺序如下(不满足则走下一个规则):
 * 1.相同版本号的实例
 * 2.无版本号的实例
 * 3.所有实例中轮询
 *
 * @Version: 1.0
 */
public class VersionIsolationRule extends RoundRobinRule {
    private final static String KEY_DEFAULT = "default";
    /**
     * 优先根据版本号取实例
     */
    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        String version;
        if (key != null && !KEY_DEFAULT.equals(key)) {
            version = key.toString();
        } else {
            version = LbIsolationContextHolder.getVersion();
        }

        List<Server> targetList = null;
        List<Server> upList = lb.getReachableServers();
        if (StrUtil.isNotEmpty(version)) {
            //取指定版本号的实例
            targetList = upList.stream().filter(
                    server -> version.equals(
                            ((NacosServer) server).getMetadata().get(CommonConstant.METADATA_VERSION)
                    )
            ).collect(Collectors.toList());
        }

        if (CollUtil.isEmpty(targetList)) {
            //只取无版本号的实例
            targetList = upList.stream().filter(
                    server -> {
                        String metadataVersion = ((NacosServer) server).getMetadata().get(CommonConstant.METADATA_VERSION);
                        return StrUtil.isEmpty(metadataVersion);
                    }
            ).collect(Collectors.toList());
        }

        if (CollUtil.isNotEmpty(targetList)) {
            return getServer(targetList);
        }
        return super.choose(lb, key);
    }

    /**
     * 随机取一个实例
     */
    private Server getServer(List<Server> upList) {
        int nextInt = RandomUtil.randomInt(upList.size());
        return upList.get(nextInt);
    }
}
