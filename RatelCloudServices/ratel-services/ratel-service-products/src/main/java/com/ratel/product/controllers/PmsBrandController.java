package com.ratel.product.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.utils.Debugger;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.product.api.dtos.PmsBrandDTO;
import com.ratel.product.api.forms.PmsBrandQueryForm;
import com.ratel.product.api.pojos.PmsBrand;
import com.ratel.product.services.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: PmsBrand
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand Controller
 * @Version: 1.0
 */
@Api(tags = "PmsBrand管理")
@Slf4j
@RestController
@RequestMapping("/pmsBrand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 02:23:29
     * @Description: 新增PmsBrand
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增PmsBrand")
    @PostMapping("/add")
    public Rsp add(@RequestBody PmsBrand pmsBrand) {

        ValidatorUtils.validateEntity(pmsBrand, AddGroup.class);

        pmsBrandService.save(pmsBrand);

        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 02:23:29
     * @Description: 分页查询所有PmsBrand信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有PmsBrand 或者按不同字段分页检索PmsBrand")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody PmsBrandQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<PmsBrandDTO> page = pmsBrandService.pageAllPmsBrands(form.buildPage(), form.buildWrapper());

        Debugger.printJson("所有品牌",page);
        return Rsp.builder()
                .success()
                .add("page", page)
                .build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 02:23:29
     * @Description: 更新PmsBrand信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新PmsBrand")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody PmsBrand pmsBrand) {
        pmsBrandService.updateById(pmsBrand);
        return Rsp.builder().success().build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 02:23:29
     * @Description: 删除PmsBrand
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除PmsBrand")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        pmsBrandService.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 02:23:29
     * @Description: 根据PmsBrand ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据PmsBrand ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        return Rsp.builder()
                .success()
                .add("brand",pmsBrandService.getById(id))
                .build();
    }
}

