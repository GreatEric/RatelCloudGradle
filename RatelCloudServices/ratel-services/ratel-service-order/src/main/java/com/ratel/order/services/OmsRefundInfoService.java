package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsRefundInfoDTO;
import com.ratel.order.api.pojos.OmsRefundInfo;

/**
 * RatelCloud
 *
 * @ClassName: OmsRefundInfoService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsRefundInfo Service
 * @Version: 1.0
 */
public interface OmsRefundInfoService extends SuperService<OmsRefundInfo> {

    void saveOmsRefundInfo(OmsRefundInfo omsRefundInfo, QueryWrapper<OmsRefundInfo> queryWrapper);

    PageUtils<OmsRefundInfoDTO> pageAllOmsRefundInfos(Page page, QueryWrapper<OmsRefundInfo> queryWrapper);
}
