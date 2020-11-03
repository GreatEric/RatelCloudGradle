package com.ratel.file.api.forms;

import com.ratel.common.core.enums.FileTypeEnum;
import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.mybatishelper.QueryField;
import com.ratel.file.api.pojos.FmsOss;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * RatelCloud
 *
 * @ClassName: FmsOssQueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 21:22:40
 * @Description: FmsOss查询表单
 * @Version: 1.0
 */
@ApiModel(description = "FmsOssQueryForm", value = "FmsOssQueryForm")
@Setter
@Getter
public class FmsOssQueryForm extends PageForm<FmsOss> {
    @QueryField(tableAlias = "fms", column = "id", condition = RelationEnum.EQUAL)
    private Long id;
    @QueryField(tableAlias = "fms", column = "bussiness_id", condition = RelationEnum.EQUAL)
    private Long bussinessId;
    @QueryField(tableAlias = "fms", column = "file_name", condition = RelationEnum.EQUAL)
    private String fileName;
    @QueryField(tableAlias = "fms", column = "file_type", condition = RelationEnum.EQUAL)
    private FileTypeEnum fileType;
    @QueryField(tableAlias = "fms", column = "file_extension", condition = RelationEnum.EQUAL)
    private String fileExtension;
    @QueryField(tableAlias = "fms", column = "folder_path", condition = RelationEnum.EQUAL)
    private String folderPath;
    @QueryField(tableAlias = "fms", column = "url", condition = RelationEnum.EQUAL)
    private String url;
    @QueryField(tableAlias = "fms", column = "is_deleted", condition = RelationEnum.EQUAL)
    private Boolean isDeleted;
    @QueryField(tableAlias = "fms", column = "end_point", condition = RelationEnum.EQUAL)
    private String endPoint;
    @QueryField(tableAlias = "fms", column = "bucket_name", condition = RelationEnum.EQUAL)
    private String bucketName;
    @QueryField(tableAlias = "fms", column = "is_encrypted", condition = RelationEnum.EQUAL)
    private Boolean isEncrypted;
    @QueryField(tableAlias = "fms", column = "create_time", condition = RelationEnum.EQUAL)
    private Timestamp createTime;
    @QueryField(tableAlias = "fms", column = "modify_time", condition = RelationEnum.EQUAL)
    private Timestamp modifyTime;
}
