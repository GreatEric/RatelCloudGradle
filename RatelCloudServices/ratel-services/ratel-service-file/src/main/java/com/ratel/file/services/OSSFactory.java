package com.ratel.file.services;

import com.ratel.common.core.enums.StorageServiceEnum;
import com.ratel.file.config.CloudStorageConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * RatelCloud
 *
 * @ClassName: OSSFactory
 * @Package: com.ratel.file.services
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/20
 * @Description: 文件上传Factory
 * @Version: 1.0
 */
@Component
public final class OSSFactory {

    private static OSSFactory instance;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static CloudStorageService build() {
        if (null != instance) {
            CloudStorageConfig config = instance.getCloudStorageConfig();
            //通过config.type获取OSS服务，方便未来扩展
            if (config.getType() == StorageServiceEnum.ALIYUN.getValue()) {
                return new AliyunCloudStorageService(config);
            }
        }
        return null;
    }

    private CloudStorageConfig getCloudStorageConfig() {
        //目前只有一种OSS服务商
        CloudStorageConfig config = new CloudStorageConfig();
        config.setType(1);
        config.setAliyunAccessKeyId("LTAI4G7VQLbXRCy7RRYvWiGc");
        config.setAliyunAccessKeySecret("EIr9mfOunHxgAiJ4nPkjnnf9SRvxeC");
        config.setAliyunBucketName("sasstestbucket");
        config.setAliyunDomain("sasstestbucket.oss-ap-southeast-2.aliyuncs.com");
        config.setAliyunEndPoint("oss-ap-southeast-2.aliyuncs.com");
        config.setAliyunPrefix("product");

        return config;
    }
}
