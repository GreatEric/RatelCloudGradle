package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsOrderSettingDTO;
import com.ratel.order.api.pojos.OmsOrderSetting;
import com.ratel.order.mappers.OmsOrderSettingMapper;
import com.ratel.order.services.OmsOrderSettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderSettingServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderSetting ServiceImpl
 * @Version: 1.0
 */
@Service("omsOrderSettingService")
public class OmsOrderSettingServiceImpl extends SuperServiceImpl<OmsOrderSettingMapper, OmsOrderSetting> implements OmsOrderSettingService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsOrderSetting(OmsOrderSetting omsOrderSetting, QueryWrapper<OmsOrderSetting> queryWrapper) {
        /*try {
            super.saveIdempotency(omsOrderSetting, lock, LOCK_KEY + omsOrderSetting.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsOrderSettingDTO> pageAllOmsOrderSettings(Page page, QueryWrapper<OmsOrderSetting> queryWrapper) {
        PageUtils<OmsOrderSettingDTO> pageUtils = new PageUtils<OmsOrderSettingDTO>(baseMapper.pageAllOmsOrderSettings(page, queryWrapper));
        return pageUtils;
    }
}
