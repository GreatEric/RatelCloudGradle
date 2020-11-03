package com.ratel.composition.ecommerce.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.order.api.feign.OmsOrderItemApiService;
import com.ratel.order.api.forms.OmsOrderItemQueryForm;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "Mall管理")
@Slf4j
@RestController
@RequestMapping("/ecommerce")
public class MallController {
    @Autowired
    private OmsOrderItemApiService omsOrderItemApiService;

    @PostMapping(value = "/getOrderItems")
    public Rsp getOrderItems(@RequestBody OmsOrderItemQueryForm form) {
        return omsOrderItemApiService.pageAll(form);
    }
}
