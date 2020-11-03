package com.ratel.file.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.enums.FileTypeEnum;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.file.api.dtos.FmsOssDTO;
import com.ratel.file.api.pojos.FmsOss;
import org.springframework.web.multipart.MultipartFile;

/**
 * RatelCloud
 *
 * @ClassName: FmsOssService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 21:22:40
 * @Description: FmsOss Service
 * @Version: 1.0
 */
public interface FmsOssService extends SuperService<FmsOss> {

    void saveFmsOss(FmsOss fmsOss, QueryWrapper<FmsOss> queryWrapper);

    PageUtils<FmsOssDTO> pageAllFmsOsss(Page page, QueryWrapper<FmsOss> queryWrapper);

    String save(MultipartFile file, FileTypeEnum type, Long bussinessId) throws Exception;

    String save(MultipartFile file, FileTypeEnum type,String folderPath, Long bussinessId) throws Exception;

    String saveImg(MultipartFile file, String suffix) throws Exception;

    boolean delObj(String bucketName,String folder, String objName);

    void zoomImg(String bucketName,String folder, String objName,int ratio);
}
