package com.ratel.file.api.forms;

import com.ratel.common.core.enums.FileTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class FileUploadForm implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "bussiness id不为能空")
    private Long bussinessId;

    @NotNull(message = "上传文件不为能空")
    private MultipartFile file;

    private FileTypeEnum fileType;

    @NotNull(message = "上传文件路劲不为能空")
    private String folderPath;
}
