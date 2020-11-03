package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsOrderItemDTO;
import com.ratel.order.api.forms.OmsOrderItemQueryForm;
import com.ratel.order.api.pojos.OmsOrderItem;
import com.ratel.order.services.OmsOrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderItem
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderItem Controller
 * @Version: 1.0
 */
@Api(tags = "OmsOrderItem管理")
@Slf4j
@RestController
@RequestMapping("/omsOrderItem")
public class OmsOrderItemController {

    @Autowired
    private OmsOrderItemService omsOrderItemService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsOrderItem
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsOrderItem")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsOrderItem omsOrderItem) {

        ValidatorUtils.validateEntity(omsOrderItem, AddGroup.class);

        omsOrderItemService.save(omsOrderItem);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsOrderItem信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsOrderItem 或者按不同字段分页检索OmsOrderItem")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderItemQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsOrderItemDTO> page = omsOrderItemService.pageAllOmsOrderItems(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsOrderItem信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsOrderItem")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsOrderItem omsOrderItem) {
        omsOrderItemService.updateById(omsOrderItem);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsOrderItem
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsOrderItem")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsOrderItemService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsOrderItem ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsOrderItem ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsOrderItemService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

