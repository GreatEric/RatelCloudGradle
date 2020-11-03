package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsOrderDTO;
import com.ratel.order.api.forms.OmsOrderQueryForm;
import com.ratel.order.api.pojos.OmsOrder;
import com.ratel.order.services.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrder
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrder Controller
 * @Version: 1.0
 */
@Api(tags = "OmsOrder管理")
@Slf4j
@RestController
@RequestMapping("/omsOrder")
public class OmsOrderController {

    @Autowired
    private OmsOrderService omsOrderService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsOrder
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsOrder")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsOrder omsOrder) {

        ValidatorUtils.validateEntity(omsOrder, AddGroup.class);

        omsOrderService.save(omsOrder);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsOrder信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsOrder 或者按不同字段分页检索OmsOrder")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsOrderDTO> page = omsOrderService.pageAllOmsOrders(form.buildPage(), form.buildWrapper());

        return Rsp.builder()
                .success()
                .add("list", page.getList())
                .build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 更新OmsOrder信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsOrder")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsOrder omsOrder) {
        omsOrderService.updateById(omsOrder);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsOrder
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsOrder")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsOrderService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsOrder ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsOrder ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsOrderService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

