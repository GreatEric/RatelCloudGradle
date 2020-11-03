package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsOrderItemDTO;
import com.ratel.order.api.pojos.OmsOrderItem;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderItemService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderItem Service
 * @Version: 1.0
 */
public interface OmsOrderItemService extends SuperService<OmsOrderItem> {

    void saveOmsOrderItem(OmsOrderItem omsOrderItem, QueryWrapper<OmsOrderItem> queryWrapper);

    PageUtils<OmsOrderItemDTO> pageAllOmsOrderItems(Page page, QueryWrapper<OmsOrderItem> queryWrapper);
}
