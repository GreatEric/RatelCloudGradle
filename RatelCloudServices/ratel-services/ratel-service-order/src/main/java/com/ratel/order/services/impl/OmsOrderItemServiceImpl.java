package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsOrderItemDTO;
import com.ratel.order.api.pojos.OmsOrderItem;
import com.ratel.order.mappers.OmsOrderItemMapper;
import com.ratel.order.services.OmsOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderItemServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderItem ServiceImpl
 * @Version: 1.0
 */
@Service("omsOrderItemService")
public class OmsOrderItemServiceImpl extends SuperServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements OmsOrderItemService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsOrderItem(OmsOrderItem omsOrderItem, QueryWrapper<OmsOrderItem> queryWrapper) {
        /*try {
            super.saveIdempotency(omsOrderItem, lock, LOCK_KEY + omsOrderItem.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsOrderItemDTO> pageAllOmsOrderItems(Page page, QueryWrapper<OmsOrderItem> queryWrapper) {
        PageUtils<OmsOrderItemDTO> pageUtils = new PageUtils<OmsOrderItemDTO>(baseMapper.pageAllOmsOrderItems(page, queryWrapper));
        return pageUtils;
    }
}
