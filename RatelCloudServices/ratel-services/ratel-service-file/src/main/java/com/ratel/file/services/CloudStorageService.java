package com.ratel.file.services;

import com.ratel.file.config.CloudStorageConfig;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

/**
 * RatelCloud
 * @ClassName: CloudStorageService
 * @Package: com.ratel.file.services
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/20
 * @Description: 云存储
 * @Version: 1.0
 */
public abstract class CloudStorageService {

    /**
     * 云存储配置信息
     */
    CloudStorageConfig config;

    public CloudStorageConfig getconfiguration() {
        return config;
    }

    /**
     * 文件路径
     *
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回上传路径
     */
    public String getPath(String prefix, String suffix) {
        //文件路径
        String path = "oss" + System.currentTimeMillis();

        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }
        return path + suffix;
    }

    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param path 文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(byte[] data, String path);

    /**
     * 文件上传
     *
     * @param data   文件字节数组
     * @param suffix 后缀
     * @return 返回http地址
     */
    public abstract String uploadSuffix(byte[] data, String suffix);

    /**
     * 文件上传
     *
     * @param data   文件字节数组
     * @param suffix 后缀
     * @return 返回http地址
     */
    public abstract String uploadSuffix(byte[] data, String suffix, String folderPath);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param suffix      后缀
     * @return 返回http地址
     */
    public abstract String uploadSuffix(InputStream inputStream, String suffix);

    public abstract Boolean delObj(String bucketName, String objectName);

    public abstract void zoomImg(String bucketName, String objectName, int ratio);

}
