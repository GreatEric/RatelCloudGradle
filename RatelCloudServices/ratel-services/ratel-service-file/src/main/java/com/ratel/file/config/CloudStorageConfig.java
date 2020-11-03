package com.ratel.file.config;

import com.ratel.common.core.validator.group.AliyunGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * RatelCloud
 *
 * @ClassName: CloudStorageConfig
 * @Package: com.ratel.file.config
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/20
 * @Description: 云存储配置信息
 * @Version: 1.0
 */
@Data
@Component
public class CloudStorageConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Range(min = 1, max = 3, message = "Type错误")
    private Integer type;

    //阿里云绑定的域名
    @NotBlank(message = "阿里云绑定的域名不能为空", groups = AliyunGroup.class)
    @URL(message = "阿里云绑定的域名格式不正确", groups = AliyunGroup.class)
    private String aliyunDomain;
    //阿里云路径前缀
    private String aliyunPrefix;
    //阿里云EndPoint
    @NotBlank(message = "阿里云EndPoint不能为空", groups = AliyunGroup.class)
    private String aliyunEndPoint;
    //阿里云AccessKeyId
    @NotBlank(message = "阿里云AccessKeyId不能为空", groups = AliyunGroup.class)
    private String aliyunAccessKeyId;
    //阿里云AccessKeySecret
    @NotBlank(message = "阿里云AccessKeySecret不能为空", groups = AliyunGroup.class)
    private String aliyunAccessKeySecret;
    //阿里云BucketName
    @NotBlank(message = "阿里云BucketName不能为空", groups = AliyunGroup.class)
    private String aliyunBucketName;
}
