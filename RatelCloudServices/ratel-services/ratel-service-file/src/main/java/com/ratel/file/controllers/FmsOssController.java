package com.ratel.file.controllers;

import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.enums.FileTypeEnum;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.validator.ValidatorUtils;
import com.ratel.file.api.dtos.FmsOssDTO;
import com.ratel.file.api.forms.FileUploadForm;
import com.ratel.file.api.forms.FmsOssQueryForm;
import com.ratel.file.api.pojos.FmsOss;
import com.ratel.file.services.FmsOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * RatelCloud
 *
 * @ClassName: FmsOss
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 21:22:40
 * @Description: FmsOss Controller
 * @Version: 1.0
 */
@Api(tags = "FmsOss管理")
@Slf4j
@RestController
@RequestMapping("/fmsOss")
public class FmsOssController {

    @Autowired
    private FmsOssService fmsOssService;

    /*@Autowired
    private RedisRepository redisRepository;*/

    /*@Autowired
    private DistributedLock locker;*/

    @ApiOperation(value = "图片上传")
    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rsp upload(FileUploadForm form) throws Exception {
        ValidatorUtils.validateEntity(form);

        String url = null;
        if (StringUtils.isBlank(form.getFolderPath())) {
            url = fmsOssService.save(form.getFile(), FileTypeEnum.IMAGE, form.getBussinessId());
        } else {
            url = fmsOssService.save(form.getFile(), FileTypeEnum.IMAGE, form.getFolderPath(), form.getBussinessId());
        }

        return Rsp.builder()
                .success()
                .add("result", "https://"+url)
                .build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 21:22:40
     * @Description: 分页查询所有FmsOss信息
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "分页查询所有FmsOss 或者按不同字段分页检索FmsOss")
    @PostMapping(value = "/pageAll")
    public Rsp pageAll(@RequestBody FmsOssQueryForm form) {
        form.setSidx("id");
        form.setOrder("DESC");
        PageUtils<FmsOssDTO> page = fmsOssService.pageAllFmsOsss(form.buildPage(), form.buildWrapper());

        return Rsp.builder()
                .success()
                .add("list", page.getList())
                .build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 21:22:40
     * @Description: 删除FmsOss
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "删除FmsOss")
    @DeleteMapping(value = "/del/{id}")
    public Rsp del(@PathVariable Long id) {
        FmsOss oss = fmsOssService.getById(id);

        String bucketName = oss.getBucketName();
        String folder = oss.getFolderPath();
        String objName = oss.getFileName();

        fmsOssService.delObj(bucketName, folder, objName);
        fmsOssService.removeById(id);

        return Rsp.builder()
                .success()
                .add("result", "file has been delected successfully")
                .build();
    }

    @ApiOperation(value = "图片缩放")
    @GetMapping(value = "/zoom/{id}/{ratio}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rsp zoom(@PathVariable(value = "id") Long id, @PathVariable(value = "ratio") int ratio) {
        FmsOss oss = fmsOssService.getById(id);

        String bucketName = oss.getBucketName();
        String folder = oss.getFolderPath();
        String objName = oss.getFileName();

        fmsOssService.zoomImg(bucketName, folder, objName, ratio);

        return Rsp.builder()
                .success()
                .add("result", "file has been zoomed successfully")
                .build();
    }

    /**
     * RatelCloud
     *
     * @Author: Eric
     * @Date: 16/10/2020 21:22:40
     * @Description: 根据FmsOss ID查询详情
     * @Param:
     * @Return:
     */
    @ApiOperation(value = "根据FmsOss ID查询详情")
    @GetMapping(value = "/info/{id}")
    public Rsp info(@PathVariable Long id) {
        FmsOss ossInfo = fmsOssService.getById(id);
        return Rsp.builder()
                .success()
                .add("ossInfo", ossInfo)
                .build();
    }
}

