package com.ratel.file.services;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.ratel.common.core.utils.Debugger;
import com.ratel.file.config.CloudStorageConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * RatelCloud
 *
 * @ClassName: AliyunCloudStorageService
 * @Package: com.ratel.file.services
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/20
 * @Description: 阿里云存储
 * @Version: 1.0
 */
public class AliyunCloudStorageService extends CloudStorageService {

    /*private OSSClient client;*/
    private OSS client;

    public AliyunCloudStorageService(CloudStorageConfig config) {
        this.config = config;
        init();
    }

    private void init() {
        client = new OSSClientBuilder().build(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(), config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {

        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {

        PutObjectRequest putObjectRequest = new PutObjectRequest(config.getAliyunBucketName(), path, inputStream);
        client.putObject(putObjectRequest);
        client.shutdown();

        return config.getAliyunDomain() + "/" + path;
    }

    /**
     * @Author: Eric
     * @Date: 10:01 pm
     * @Description: 默认目录上传
     * @Param:
     * @Return:
     */
    @Override
    public String uploadSuffix(byte[] data, String suffix) {

        return upload(data, getPath(config.getAliyunPrefix(), suffix));
    }

    /**
     * @Author: Eric
     * @Date: 10:01 pm
     * @Description: 指定目录上传
     * @Param:
     * @Return:
     */
    @Override
    public String uploadSuffix(byte[] data, String suffix, String folderPath) {
        return upload(data, getPath(folderPath, suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {

        return upload(inputStream, getPath(config.getAliyunPrefix(), suffix));
    }

    /**
     * @Author: Eric
     * @Date: 10:01 pm
     * @Description: 删除
     * @Param:
     * @Return:
     */
    @Override
    public Boolean delObj(String bucketName, String objectName) {
        Debugger.sysprint("Delete", objectName);
        client.deleteObject(bucketName, objectName);
        Boolean flag = client.doesObjectExist(bucketName, objectName);
        client.shutdown();

        return flag;
    }

    /**
     * @Author: Eric
     * @Date: 10:02 pm
     * @Description: 等比缩放
     * @Param:
     * @Return:
     */
    @Override
    public void zoomImg(String bucketName, String objectName, int ratio) {
        String style = "image/resize,p_" + ratio;
        GetObjectRequest request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        client.getObject(request, new File("example-resize.jpg"));
        client.shutdown();
    }

    public CloudStorageConfig getconfiguration() {
        return this.config;
    }
}
