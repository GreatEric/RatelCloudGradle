package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsOrderOperateHistoryDTO;
import com.ratel.order.api.forms.OmsOrderOperateHistoryQueryForm;
import com.ratel.order.api.pojos.OmsOrderOperateHistory;
import com.ratel.order.services.OmsOrderOperateHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderOperateHistory
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory Controller
 * @Version: 1.0
 */
@Api(tags = "OmsOrderOperateHistory管理")
@Slf4j
@RestController
@RequestMapping("/omsOrderOperateHistory")
public class OmsOrderOperateHistoryController {

    @Autowired
    private OmsOrderOperateHistoryService omsOrderOperateHistoryService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsOrderOperateHistory
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsOrderOperateHistory")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsOrderOperateHistory omsOrderOperateHistory) {

        ValidatorUtils.validateEntity(omsOrderOperateHistory, AddGroup.class);

        omsOrderOperateHistoryService.save(omsOrderOperateHistory);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsOrderOperateHistory信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsOrderOperateHistory 或者按不同字段分页检索OmsOrderOperateHistory")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderOperateHistoryQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsOrderOperateHistoryDTO> page = omsOrderOperateHistoryService.pageAllOmsOrderOperateHistorys(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsOrderOperateHistory信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsOrderOperateHistory")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsOrderOperateHistory omsOrderOperateHistory) {
        omsOrderOperateHistoryService.updateById(omsOrderOperateHistory);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsOrderOperateHistory
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsOrderOperateHistory")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsOrderOperateHistoryService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsOrderOperateHistory ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsOrderOperateHistory ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsOrderOperateHistoryService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

