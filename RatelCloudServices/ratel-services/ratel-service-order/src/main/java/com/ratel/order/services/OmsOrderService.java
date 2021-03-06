package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsOrderDTO;
import com.ratel.order.api.pojos.OmsOrder;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrder Service
 * @Version: 1.0
 */
public interface OmsOrderService extends SuperService<OmsOrder> {

    void saveOmsOrder(OmsOrder omsOrder, QueryWrapper<OmsOrder> queryWrapper);

    PageUtils<OmsOrderDTO> pageAllOmsOrders(Page page, QueryWrapper<OmsOrder> queryWrapper);
}
