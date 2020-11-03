package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsOrderRefundDTO;
import com.ratel.order.api.forms.OmsOrderRefundQueryForm;
import com.ratel.order.api.pojos.OmsOrderRefund;
import com.ratel.order.services.OmsOrderRefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefund
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefund Controller
 * @Version: 1.0
 */
@Api(tags = "OmsOrderRefund管理")
@Slf4j
@RestController
@RequestMapping("/omsOrderRefund")
public class OmsOrderRefundController {

    @Autowired
    private OmsOrderRefundService omsOrderRefundService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsOrderRefund
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsOrderRefund")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsOrderRefund omsOrderRefund) {

        ValidatorUtils.validateEntity(omsOrderRefund, AddGroup.class);

        omsOrderRefundService.save(omsOrderRefund);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsOrderRefund信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsOrderRefund 或者按不同字段分页检索OmsOrderRefund")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderRefundQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsOrderRefundDTO> page = omsOrderRefundService.pageAllOmsOrderRefunds(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsOrderRefund信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsOrderRefund")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsOrderRefund omsOrderRefund) {
        omsOrderRefundService.updateById(omsOrderRefund);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsOrderRefund
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsOrderRefund")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsOrderRefundService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsOrderRefund ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsOrderRefund ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsOrderRefundService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

