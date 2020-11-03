package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsOrderSettingDTO;
import com.ratel.order.api.pojos.OmsOrderSetting;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderSettingService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderSetting Service
 * @Version: 1.0
 */
public interface OmsOrderSettingService extends SuperService<OmsOrderSetting> {

    void saveOmsOrderSetting(OmsOrderSetting omsOrderSetting, QueryWrapper<OmsOrderSetting> queryWrapper);

    PageUtils<OmsOrderSettingDTO> pageAllOmsOrderSettings(Page page, QueryWrapper<OmsOrderSetting> queryWrapper);
}
