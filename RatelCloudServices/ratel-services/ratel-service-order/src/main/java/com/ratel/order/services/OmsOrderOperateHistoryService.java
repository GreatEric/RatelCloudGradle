package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsOrderOperateHistoryDTO;
import com.ratel.order.api.pojos.OmsOrderOperateHistory;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderOperateHistoryService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory Service
 * @Version: 1.0
 */
public interface OmsOrderOperateHistoryService extends SuperService<OmsOrderOperateHistory> {

    void saveOmsOrderOperateHistory(OmsOrderOperateHistory omsOrderOperateHistory, QueryWrapper<OmsOrderOperateHistory> queryWrapper);

    PageUtils<OmsOrderOperateHistoryDTO> pageAllOmsOrderOperateHistorys(Page page, QueryWrapper<OmsOrderOperateHistory> queryWrapper);
}
