package com.ratel.product.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.product.api.dtos.PmsBrandDTO;
import com.ratel.product.api.pojos.PmsBrand;
import com.ratel.product.mappers.PmsBrandMapper;
import com.ratel.product.services.PmsBrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: PmsBrandServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 02:23:29
 * @Description: PmsBrand ServiceImpl
 * @Version: 1.0
 */
@Service("pmsBrandService")
public class PmsBrandServiceImpl extends SuperServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void savePmsBrand(PmsBrand pmsBrand, QueryWrapper<PmsBrand> queryWrapper) {
        /*try {
            super.saveIdempotency(pmsBrand, lock, LOCK_KEY + pmsBrand.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<PmsBrandDTO> pageAllPmsBrands(Page page, QueryWrapper<PmsBrand> queryWrapper) {
        PageUtils<PmsBrandDTO> pageUtils = new PageUtils<PmsBrandDTO>(baseMapper.pageAllPmsBrands(page, queryWrapper));
        return pageUtils;
    }
}
