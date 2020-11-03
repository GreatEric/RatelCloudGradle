package com.ratel.order.api.feign;

import com.ratel.common.core.entities.Rsp;
import com.ratel.order.api.feign.fallback.OmsOrderItemApiServiceFallbackFactory;
import com.ratel.order.api.forms.OmsOrderItemQueryForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RatelCloud
 *
 * @ClassName: MemberApiService
 * @Package:
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 19/09/20
 * @Description: TODO
 * @Version: 1.0
 */
@FeignClient(name = "ratel-service-order", fallbackFactory = OmsOrderItemApiServiceFallbackFactory.class, decode404 = true)
public interface OmsOrderItemApiService {
    @PostMapping(value = "/omsOrderItem/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderItemQueryForm form);
}
