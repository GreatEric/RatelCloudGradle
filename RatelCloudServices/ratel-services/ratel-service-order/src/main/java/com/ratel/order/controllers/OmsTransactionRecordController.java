package com.ratel.order.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.order.api.dtos.OmsTransactionRecordDTO;
import com.ratel.order.api.forms.OmsTransactionRecordQueryForm;
import com.ratel.order.api.pojos.OmsTransactionRecord;
import com.ratel.order.services.OmsTransactionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: OmsTransactionRecord
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsTransactionRecord Controller
 * @Version: 1.0
 */
@Api(tags = "OmsTransactionRecord管理")
@Slf4j
@RestController
@RequestMapping("/omsTransactionRecord")
public class OmsTransactionRecordController {

    @Autowired
    private OmsTransactionRecordService omsTransactionRecordService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 新增OmsTransactionRecord
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增OmsTransactionRecord")
    @PostMapping("/add")
    public Rsp add(@RequestBody OmsTransactionRecord omsTransactionRecord) {

        ValidatorUtils.validateEntity(omsTransactionRecord, AddGroup.class);

        omsTransactionRecordService.save(omsTransactionRecord);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 分页查询所有OmsTransactionRecord信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有OmsTransactionRecord 或者按不同字段分页检索OmsTransactionRecord")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody OmsTransactionRecordQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<OmsTransactionRecordDTO> page = omsTransactionRecordService.pageAllOmsTransactionRecords(form.buildPage(), form.buildWrapper());

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
     * @Description: 更新OmsTransactionRecord信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新OmsTransactionRecord")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody OmsTransactionRecord omsTransactionRecord) {
        omsTransactionRecordService.updateById(omsTransactionRecord);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 删除OmsTransactionRecord
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除OmsTransactionRecord")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        omsTransactionRecordService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 01:48:24
     * @Description: 根据OmsTransactionRecord ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据OmsTransactionRecord ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        omsTransactionRecordService.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

