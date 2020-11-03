package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsRefundInfoDTO;
import com.ratel.order.api.forms.OmsRefundInfoQueryForm;
import com.ratel.order.api.pojos.OmsRefundInfo;
import com.ratel.order.services.OmsRefundInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsRefundInfo
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsRefundInfo Controller
 * @Version: 1.0
 */
@Api(tags = "OmsRefundInfo管理")
@Slf4j
@RestController
@RequestMapping("/omsRefundInfo")
public class OmsRefundInfoController {

    @Autowired
    private OmsRefundInfoService omsRefundInfoService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsRefundInfo
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsRefundInfo")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsRefundInfo omsRefundInfo) {

        ValidatorUtils.validateEntity(omsRefundInfo, AddGroup.class);

        omsRefundInfoService.save(omsRefundInfo);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsRefundInfo信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsRefundInfo 或者按不同字段分页检索OmsRefundInfo")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsRefundInfoQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsRefundInfoDTO> page = omsRefundInfoService.pageAllOmsRefundInfos(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsRefundInfo信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsRefundInfo")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsRefundInfo omsRefundInfo) {
        omsRefundInfoService.updateById(omsRefundInfo);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsRefundInfo
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsRefundInfo")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsRefundInfoService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsRefundInfo ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsRefundInfo ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsRefundInfoService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

