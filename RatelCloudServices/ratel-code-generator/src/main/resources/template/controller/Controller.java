package ${controllerPackage};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.group.AddGroup;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.common.core.entities.Rsp;

import ${servicePackage}.${Table}Service;
import ${pojoPackage}.${Table};
import ${dtoPackage}.${Table}DTO;
import ${formPackage}.${Table}QueryForm;
/**
 * ${company}
 * @ClassName: ${Table}
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table} Controller
 * @Version: 1.0
 */
@Api(tags = "${Table}管理")
@Slf4j
@RestController
@RequestMapping("/${table}")
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    /**
     * ${company}
     *
     * @Author: Eric
     * @Date: ${createTime}
     * @Description: 新增${Table}
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "新增${Table}")
    @PostMapping("/add")
    public Rsp add(@RequestBody ${Table} ${table}) {

        ValidatorUtils.validateEntity(${table}, AddGroup.class);

        ${table}Service.save(${table});

        return Rsp.builder().success().build();
    }

    /**
     * ${company}
     *
     * @Author: Eric
     * @Date: ${createTime}
     * @Description: 分页查询所有${Table}信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有${Table} 或者按不同字段分页检索${Table}")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody ${Table}QueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<${Table}DTO> page = ${table}Service.pageAll${Table}s(form.buildPage(), form.buildWrapper());

        return Rsp.builder()
                .success()
                .add("list", page.getList())
                .build();
    }

    /**
     * ${company}
     *
     * @Author: Eric
     * @Date: ${createTime}
     * @Description: 更新${Table}信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "更新${Table}")
    @PutMapping(value = "/update")
    public Rsp update(@RequestBody ${Table} ${table}) {
        ${table}Service.updateById(${table});
        return Rsp.builder().success().build();
    }

    /**
     * ${company}
     *
     * @Author: Eric
     * @Date: ${createTime}
     * @Description: 删除${Table}
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除${Table}")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        ${table}Service.removeById(id);
        return Rsp.builder().success().build();
    }


    /**
     * ${company}
     *
     * @Author: Eric
     * @Date: ${createTime}
     * @Description: 根据${Table} ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据${Table} ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        ${table}Service.getById(id);
        return Rsp.builder()
                .success()
                .build();
    }
}

