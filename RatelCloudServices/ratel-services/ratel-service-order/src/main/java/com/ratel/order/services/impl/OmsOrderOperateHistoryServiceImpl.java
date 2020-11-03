package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsOrderOperateHistoryDTO;
import com.ratel.order.api.pojos.OmsOrderOperateHistory;
import com.ratel.order.mappers.OmsOrderOperateHistoryMapper;
import com.ratel.order.services.OmsOrderOperateHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderOperateHistoryServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory ServiceImpl
 * @Version: 1.0
 */
@Service("omsOrderOperateHistoryService")
public class OmsOrderOperateHistoryServiceImpl extends SuperServiceImpl<OmsOrderOperateHistoryMapper, OmsOrderOperateHistory> implements OmsOrderOperateHistoryService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsOrderOperateHistory(OmsOrderOperateHistory omsOrderOperateHistory, QueryWrapper<OmsOrderOperateHistory> queryWrapper) {
        /*try {
            super.saveIdempotency(omsOrderOperateHistory, lock, LOCK_KEY + omsOrderOperateHistory.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsOrderOperateHistoryDTO> pageAllOmsOrderOperateHistorys(Page page, QueryWrapper<OmsOrderOperateHistory> queryWrapper) {
        PageUtils<OmsOrderOperateHistoryDTO> pageUtils = new PageUtils<OmsOrderOperateHistoryDTO>(baseMapper.pageAllOmsOrderOperateHistorys(page, queryWrapper));
        return pageUtils;
    }
}
