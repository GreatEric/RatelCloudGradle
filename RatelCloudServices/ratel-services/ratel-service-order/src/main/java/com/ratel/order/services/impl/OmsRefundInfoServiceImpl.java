package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsRefundInfoDTO;
import com.ratel.order.api.pojos.OmsRefundInfo;
import com.ratel.order.mappers.OmsRefundInfoMapper;
import com.ratel.order.services.OmsRefundInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsRefundInfoServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsRefundInfo ServiceImpl
 * @Version: 1.0
 */
@Service("omsRefundInfoService")
public class OmsRefundInfoServiceImpl extends SuperServiceImpl<OmsRefundInfoMapper, OmsRefundInfo> implements OmsRefundInfoService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsRefundInfo(OmsRefundInfo omsRefundInfo, QueryWrapper<OmsRefundInfo> queryWrapper) {
        /*try {
            super.saveIdempotency(omsRefundInfo, lock, LOCK_KEY + omsRefundInfo.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsRefundInfoDTO> pageAllOmsRefundInfos(Page page, QueryWrapper<OmsRefundInfo> queryWrapper) {
        PageUtils<OmsRefundInfoDTO> pageUtils = new PageUtils<OmsRefundInfoDTO>(baseMapper.pageAllOmsRefundInfos(page, queryWrapper));
        return pageUtils;
    }
}
