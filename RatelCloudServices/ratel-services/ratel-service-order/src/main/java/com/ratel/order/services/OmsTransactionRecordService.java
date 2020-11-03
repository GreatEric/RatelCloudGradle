package com.ratel.order.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mybatishelper.PageUtils;
import com.ratel.common.core.service.SuperService;
import com.ratel.order.api.dtos.OmsTransactionRecordDTO;
import com.ratel.order.api.pojos.OmsTransactionRecord;

/**
 * RatelCloud
 *
 * @ClassName: OmsTransactionRecordService
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsTransactionRecord Service
 * @Version: 1.0
 */
public interface OmsTransactionRecordService extends SuperService<OmsTransactionRecord> {

    void saveOmsTransactionRecord(OmsTransactionRecord omsTransactionRecord, QueryWrapper<OmsTransactionRecord> queryWrapper);

    PageUtils<OmsTransactionRecordDTO> pageAllOmsTransactionRecords(Page page, QueryWrapper<OmsTransactionRecord> queryWrapper);
}
