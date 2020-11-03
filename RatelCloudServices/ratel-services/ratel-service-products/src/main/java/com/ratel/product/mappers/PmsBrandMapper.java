package com.ratel.product.mappers;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mapper.SuperMapper;
import com.ratel.product.api.dtos.PmsBrandDTO;
import com.ratel.product.api.pojos.PmsBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * RatelCloud
 *
 * @ClassName: PmsBrandMapper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand Mapper
 * @Version: 1.0
 */
@Mapper
public interface PmsBrandMapper extends SuperMapper<PmsBrand> {
    IPage<PmsBrandDTO> pageAllPmsBrands(Page page, @Param(Constants.WRAPPER) Wrapper<PmsBrand> wrapper);
}
