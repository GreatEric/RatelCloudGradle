package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsOrderRefundReasonDTO;
import com.ratel.order.api.pojos.OmsOrderRefundReason;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundReasonService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason Service
 * @Version: 1.0
 */
public interface OmsOrderRefundReasonService extends SuperService<OmsOrderRefundReason> {

    void saveOmsOrderRefundReason(OmsOrderRefundReason omsOrderRefundReason, QueryWrapper<OmsOrderRefundReason> queryWrapper);

    PageUtils<OmsOrderRefundReasonDTO> pageAllOmsOrderRefundReasons(Page page, QueryWrapper<OmsOrderRefundReason> queryWrapper);
}
