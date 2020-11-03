package com.ratel.order.api.feign.fallback;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.entities.StatusEntity;
import com.ratel.order.api.feign.OmsOrderItemApiService;
import com.ratel.order.api.forms.OmsOrderItemQueryForm;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * RatelCloud
 * @ClassName: MemberApiServiceFallbackFactory
 * @Package: com.ratel.order.api.feign.fallback
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class OmsOrderItemApiServiceFallbackFactory implements FallbackFactory<OmsOrderItemApiService> {
    @Override
    public OmsOrderItemApiService create(Throwable throwable) {
        return new OmsOrderItemApiService() {
            @Override
            public Rsp pageAll(OmsOrderItemQueryForm form) {
                StatusEntity msg = new StatusEntity();
                msg.setCode(500);
                msg.setMsg("OrderItemService Error");
                return Rsp.builder().error(msg).build();
            }
        };
    }
}
