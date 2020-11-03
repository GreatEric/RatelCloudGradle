package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsOrderDTO;
import com.ratel.order.api.pojos.OmsOrder;
import com.ratel.order.mappers.OmsOrderMapper;
import com.ratel.order.services.OmsOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrder ServiceImpl
 * @Version: 1.0
 */
@Service("omsOrderService")
public class OmsOrderServiceImpl extends SuperServiceImpl<OmsOrderMapper, OmsOrder> implements OmsOrderService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsOrder(OmsOrder omsOrder, QueryWrapper<OmsOrder> queryWrapper) {
        /*try {
            super.saveIdempotency(omsOrder, lock, LOCK_KEY + omsOrder.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsOrderDTO> pageAllOmsOrders(Page page, QueryWrapper<OmsOrder> queryWrapper) {
        PageUtils<OmsOrderDTO> pageUtils = new PageUtils<OmsOrderDTO>(baseMapper.pageAllOmsOrders(page, queryWrapper));
        return pageUtils;
    }
}
