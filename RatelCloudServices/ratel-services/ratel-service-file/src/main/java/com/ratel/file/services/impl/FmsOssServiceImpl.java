package com.ratel.file.services.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.enums.FileTypeEnum;
import com.ratel.common.core.exception.BizException;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.file.api.dtos.FmsOssDTO;
import com.ratel.file.api.pojos.FmsOss;
import com.ratel.file.mappers.FmsOssMapper;
import com.ratel.file.services.AliyunCloudStorageService;
import com.ratel.file.services.CloudStorageService;
import com.ratel.file.services.FmsOssService;
import com.ratel.file.services.OSSFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * RatelCloud
 *
 * @ClassName: FmsOssServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 21:22:40
 * @Description: FmsOss ServiceImpl
 * @Version: 1.0
 */
@Service("fmsOssService")
public class FmsOssServiceImpl extends SuperServiceImpl<FmsOssMapper, FmsOss> implements FmsOssService {
    private final static String LOCK_KEY = "id";

    @Value("${ratelcloud.tempfolder}")
    private String tempImgPath;

    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveFmsOss(FmsOss fmsOss, QueryWrapper<FmsOss> queryWrapper) {
        /*try {
            super.saveIdempotency(fmsOss, lock, LOCK_KEY + fmsOss.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<FmsOssDTO> pageAllFmsOsss(Page page, QueryWrapper<FmsOss> queryWrapper) {
        PageUtils<FmsOssDTO> pageUtils = new PageUtils<FmsOssDTO>(baseMapper.pageAllFmsOsss(page, queryWrapper));
        return pageUtils;
    }

    /**
     * @Author: Eric
     * @Date: 10:12 pm
     * @Description: 使用默认目录上传
     * @Param:
     * @Return:
     */
    @Override
    public String save(MultipartFile file, FileTypeEnum type, Long bussinessId) throws Exception {
        if (null == file || file.isEmpty()) {
            throw new BizException("上传文件不能为空");
        }
        //上传文件
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        if (null != originalFilename) {
            int index = originalFilename.lastIndexOf(".");
            if (index >= 0) {
                suffix = originalFilename.substring(index);
            }
        }

        byte[] bytes = file.getBytes();
        String fileName = UUID.randomUUID().toString() + suffix;
        String filePath = tempImgPath + "/" + fileName;
        FileCopyUtils.copy(bytes, new File(filePath));//将图片写入临时目
        //压缩图片
        /*if (filePath.endsWith("jpg") || filePath.endsWith("png") || filePath.endsWith("jpeg") || filePath.endsWith("bmp") || filePath.endsWith("gif")) {
            Img.from(FileUtil.file(filePath)).setQuality(0.2).write(FileUtil.file(filePath));
        }*/

        CloudStorageService service = (AliyunCloudStorageService) OSSFactory.build();
        String url = service.uploadSuffix(new FileReader(filePath).readBytes(), suffix);

        //保存文件信息
        FmsOss oss = new FmsOss();
        oss.setBussinessId(bussinessId);
        oss.setFileExtension(suffix.substring(1, suffix.length()).toUpperCase());
        oss.setFileName(url.substring(url.lastIndexOf("/") + 1, url.length()));
        oss.setUrl(url);
        oss.setFileType(type);
        oss.setIsDeleted(false);
        oss.setBucketName(service.getconfiguration().getAliyunBucketName());
        oss.setEndPoint(service.getconfiguration().getAliyunEndPoint());
        oss.setIsEncrypted(false);

        super.save(oss);

        //删除临时文件
        FileUtil.del(filePath);
        return url;
    }

    /**
     * @Author: Eric
     * @Date: 10:12 pm
     * @Description: 指定上传文件夹上传
     * @Param:
     * @Return:
     */
    @Override
    public String save(MultipartFile file, FileTypeEnum type, String folderPath, Long bussinessId) throws Exception {
        if (null == file || file.isEmpty()) {
            throw new BizException("上传文件不能为空");
        }
        //上传文件
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        if (null != originalFilename) {
            int index = originalFilename.lastIndexOf(".");
            if (index >= 0) {
                suffix = originalFilename.substring(index);
            }
        }

        byte[] bytes = file.getBytes();
        String fileName = UUID.randomUUID().toString() + suffix;
        String filePath = tempImgPath + "/" + fileName;
        FileCopyUtils.copy(bytes, new File(filePath));//将图片写入临时目

        CloudStorageService service = (AliyunCloudStorageService) OSSFactory.build();
        String url = service.uploadSuffix(new FileReader(filePath).readBytes(), suffix, folderPath);

        //保存文件信息
        FmsOss oss = new FmsOss();
        oss.setBussinessId(bussinessId);
        oss.setFileExtension(suffix.substring(1, suffix.length()).toUpperCase());
        oss.setFileName(url.substring(url.lastIndexOf("/") + 1, url.length()));
        oss.setUrl(url);
        oss.setFolderPath(folderPath);
        oss.setFileType(type);
        oss.setIsDeleted(false);
        oss.setBucketName(service.getconfiguration().getAliyunBucketName());
        oss.setEndPoint(service.getconfiguration().getAliyunEndPoint());
        oss.setIsEncrypted(false);

        super.save(oss);

        //删除临时文件
        FileUtil.del(filePath);
        return url;
    }

    @Override
    public String saveImg(MultipartFile file, String suffix) throws Exception {
        if (null == file || file.isEmpty()) {
            throw new BizException("上传文件不能为空");
        }
        String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

        //保存文件信息
        FmsOss oss = new FmsOss();
        oss.setUrl(url);
        oss.setFileType(FileTypeEnum.IMAGE);
        super.save(oss);
        return url;
    }

    @Override
    public boolean delObj(String bucketName, String folder, String objName) {
        if (StringUtils.isBlank(folder)) {
            return OSSFactory.build().delObj(bucketName, objName);
        } else {
            return OSSFactory.build().delObj(bucketName, folder + "/" + objName);
        }
    }

    @Override
    public void zoomImg(String bucketName, String folder, String objName, int ratio) {
        if (StringUtils.isBlank(folder)) {
            OSSFactory.build().zoomImg(bucketName, objName, ratio);
        } else {
            OSSFactory.build().zoomImg(bucketName, folder + "/" + objName, ratio);
        }
    }
}
