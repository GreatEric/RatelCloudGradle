package com.ratel.product.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.product.api.dtos.PmsBrandDTO;
import com.ratel.product.api.pojos.PmsBrand;

/**
 * RatelCloud
 *
 * @ClassName: PmsBrandService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand Service
 * @Version: 1.0
 */
public interface PmsBrandService extends SuperService<PmsBrand> {

    void savePmsBrand(PmsBrand pmsBrand, QueryWrapper<PmsBrand> queryWrapper);

    PageUtils<PmsBrandDTO> pageAllPmsBrands(Page page, QueryWrapper<PmsBrand> queryWrapper);
}
