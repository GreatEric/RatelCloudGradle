package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsOrderRefundReasonDTO;
import com.ratel.order.api.forms.OmsOrderRefundReasonQueryForm;
import com.ratel.order.api.pojos.OmsOrderRefundReason;
import com.ratel.order.services.OmsOrderRefundReasonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundReason
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason Controller
 * @Version: 1.0
 */
@Api(tags = "OmsOrderRefundReason管理")
@Slf4j
@RestController
@RequestMapping("/omsOrderRefundReason")
public class OmsOrderRefundReasonController {

    @Autowired
    private OmsOrderRefundReasonService omsOrderRefundReasonService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsOrderRefundReason
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsOrderRefundReason")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsOrderRefundReason omsOrderRefundReason) {

        ValidatorUtils.validateEntity(omsOrderRefundReason, AddGroup.class);

        omsOrderRefundReasonService.save(omsOrderRefundReason);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsOrderRefundReason信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsOrderRefundReason 或者按不同字段分页检索OmsOrderRefundReason")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderRefundReasonQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsOrderRefundReasonDTO> page = omsOrderRefundReasonService.pageAllOmsOrderRefundReasons(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsOrderRefundReason信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsOrderRefundReason")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsOrderRefundReason omsOrderRefundReason) {
        omsOrderRefundReasonService.updateById(omsOrderRefundReason);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsOrderRefundReason
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsOrderRefundReason")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsOrderRefundReasonService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsOrderRefundReason ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsOrderRefundReason ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsOrderRefundReasonService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

