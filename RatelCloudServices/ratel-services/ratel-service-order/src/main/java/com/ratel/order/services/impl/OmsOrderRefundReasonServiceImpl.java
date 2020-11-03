package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsOrderRefundReasonDTO;
import com.ratel.order.api.pojos.OmsOrderRefundReason;
import com.ratel.order.mappers.OmsOrderRefundReasonMapper;
import com.ratel.order.services.OmsOrderRefundReasonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundReasonServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason ServiceImpl
 * @Version: 1.0
 */
@Service("omsOrderRefundReasonService")
public class OmsOrderRefundReasonServiceImpl extends SuperServiceImpl<OmsOrderRefundReasonMapper, OmsOrderRefundReason> implements OmsOrderRefundReasonService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsOrderRefundReason(OmsOrderRefundReason omsOrderRefundReason, QueryWrapper<OmsOrderRefundReason> queryWrapper) {
        /*try {
            super.saveIdempotency(omsOrderRefundReason, lock, LOCK_KEY + omsOrderRefundReason.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsOrderRefundReasonDTO> pageAllOmsOrderRefundReasons(Page page, QueryWrapper<OmsOrderRefundReason> queryWrapper) {
        PageUtils<OmsOrderRefundReasonDTO> pageUtils = new PageUtils<OmsOrderRefundReasonDTO>(baseMapper.pageAllOmsOrderRefundReasons(page, queryWrapper));
        return pageUtils;
    }
}
