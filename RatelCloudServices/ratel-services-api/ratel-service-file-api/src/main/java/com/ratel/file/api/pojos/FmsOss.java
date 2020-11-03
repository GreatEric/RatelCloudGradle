package com.ratel.file.api.pojos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ratel.common.core.entities.SuperEntity;
import com.ratel.common.core.enums.FileTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * RatelCloud
 *
 * @ClassName: FmsOss
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 21:22:40
 * @Description: FmsOss实体
 * @Version: 1.0
 */
@ApiModel(description = "FmsOss实体", value = "FmsOss")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("fms_oss")
public class FmsOss extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户ID", required = false)
    private Long bussinessId;
    @ApiModelProperty(value = "文件名", required = false)
    private String fileName;
    @ApiModelProperty(value = "文件类型:1->图片;2->文件;3->视频", required = false)
    private FileTypeEnum fileType;
    @ApiModelProperty(value = "文件扩展名", required = false)
    private String fileExtension;
    @ApiModelProperty(value = "文件存储路径", required = false)
    private String folderPath;
    @ApiModelProperty(value = "资源访问路径", required = false)
    private String url;
    @ApiModelProperty(value = "删除标志: 0->正常;1->已删除", required = false)
    private Boolean isDeleted;
    @ApiModelProperty(value = "节点名称", required = false)
    private String endPoint;
    @ApiModelProperty(value = "文件存储位置", required = false)
    private String bucketName;
    @ApiModelProperty(value = "是否使用加密: 0->不加密;1->加密", required = false)
    private Boolean isEncrypted;
}
