package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsOrderRefundDTO;
import com.ratel.order.api.pojos.OmsOrderRefund;
import com.ratel.order.mappers.OmsOrderRefundMapper;
import com.ratel.order.services.OmsOrderRefundService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefund ServiceImpl
 * @Version: 1.0
 */
@Service("omsOrderRefundService")
public class OmsOrderRefundServiceImpl extends SuperServiceImpl<OmsOrderRefundMapper, OmsOrderRefund> implements OmsOrderRefundService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsOrderRefund(OmsOrderRefund omsOrderRefund, QueryWrapper<OmsOrderRefund> queryWrapper) {
        /*try {
            super.saveIdempotency(omsOrderRefund, lock, LOCK_KEY + omsOrderRefund.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsOrderRefundDTO> pageAllOmsOrderRefunds(Page page, QueryWrapper<OmsOrderRefund> queryWrapper) {
        PageUtils<OmsOrderRefundDTO> pageUtils = new PageUtils<OmsOrderRefundDTO>(baseMapper.pageAllOmsOrderRefunds(page, queryWrapper));
        return pageUtils;
    }
}
