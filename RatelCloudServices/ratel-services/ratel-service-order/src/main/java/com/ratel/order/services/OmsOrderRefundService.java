package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsOrderRefundDTO;
import com.ratel.order.api.pojos.OmsOrderRefund;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefund Service
 * @Version: 1.0
 */
public interface OmsOrderRefundService extends SuperService<OmsOrderRefund> {

    void saveOmsOrderRefund(OmsOrderRefund omsOrderRefund, QueryWrapper<OmsOrderRefund> queryWrapper);

    PageUtils<OmsOrderRefundDTO> pageAllOmsOrderRefunds(Page page, QueryWrapper<OmsOrderRefund> queryWrapper);
}
