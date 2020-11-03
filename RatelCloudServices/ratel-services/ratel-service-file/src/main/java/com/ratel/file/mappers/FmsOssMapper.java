package com.ratel.file.mappers;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mapper.SuperMapper;
import com.ratel.file.api.dtos.FmsOssDTO;
import com.ratel.file.api.pojos.FmsOss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * RatelCloud
 *
 * @ClassName: FmsOssMapper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 21:22:40
 * @Description: FmsOss Mapper
 * @Version: 1.0
 */
@Mapper
public interface FmsOssMapper extends SuperMapper<FmsOss> {
    IPage<FmsOssDTO> pageAllFmsOsss(Page page, @Param(Constants.WRAPPER) Wrapper<FmsOss> wrapper);
}
