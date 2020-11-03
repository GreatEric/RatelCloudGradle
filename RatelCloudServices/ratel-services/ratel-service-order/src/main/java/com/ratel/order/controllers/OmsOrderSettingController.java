package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsOrderSettingDTO;
import com.ratel.order.api.forms.OmsOrderSettingQueryForm;
import com.ratel.order.api.pojos.OmsOrderSetting;
import com.ratel.order.services.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderSetting
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderSetting Controller
 * @Version: 1.0
 */
@Api(tags = "OmsOrderSetting管理")
@Slf4j
@RestController
@RequestMapping("/omsOrderSetting")
public class OmsOrderSettingController {

    @Autowired
    private OmsOrderSettingService omsOrderSettingService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsOrderSetting
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsOrderSetting")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsOrderSetting omsOrderSetting) {

        ValidatorUtils.validateEntity(omsOrderSetting, AddGroup.class);

        omsOrderSettingService.save(omsOrderSetting);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsOrderSetting信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsOrderSetting 或者按不同字段分页检索OmsOrderSetting")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsOrderSettingQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsOrderSettingDTO> page = omsOrderSettingService.pageAllOmsOrderSettings(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsOrderSetting信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsOrderSetting")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsOrderSetting omsOrderSetting) {
        omsOrderSettingService.updateById(omsOrderSetting);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsOrderSetting
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsOrderSetting")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsOrderSettingService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsOrderSetting ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsOrderSetting ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsOrderSettingService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

