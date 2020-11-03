package com.ratel.order.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.order.api.dtos.OmsTransactionRecordDTO;
import com.ratel.order.api.pojos.OmsTransactionRecord;
import com.ratel.order.mappers.OmsTransactionRecordMapper;
import com.ratel.order.services.OmsTransactionRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RatelCloud
 *
 * @ClassName: OmsTransactionRecordServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsTransactionRecord ServiceImpl
 * @Version: 1.0
 */
@Service("omsTransactionRecordService")
public class OmsTransactionRecordServiceImpl extends SuperServiceImpl<OmsTransactionRecordMapper, OmsTransactionRecord> implements OmsTransactionRecordService {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOmsTransactionRecord(OmsTransactionRecord omsTransactionRecord, QueryWrapper<OmsTransactionRecord> queryWrapper) {
        /*try {
            super.saveIdempotency(omsTransactionRecord, lock, LOCK_KEY + omsTransactionRecord.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<OmsTransactionRecordDTO> pageAllOmsTransactionRecords(Page page, QueryWrapper<OmsTransactionRecord> queryWrapper) {
        PageUtils<OmsTransactionRecordDTO> pageUtils = new PageUtils<OmsTransactionRecordDTO>(baseMapper.pageAllOmsTransactionRecords(page, queryWrapper));
        return pageUtils;
    }
}
