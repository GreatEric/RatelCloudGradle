package com.ratel.order.mappers;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mapper.SuperMapper;
import com.ratel.order.api.dtos.OmsOrderOperateHistoryDTO;
import com.ratel.order.api.pojos.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderOperateHistoryMapper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderOperateHistory Mapper
 * @Version: 1.0
 */
@Mapper
public interface OmsOrderOperateHistoryMapper extends SuperMapper<OmsOrderOperateHistory> {
    IPage<OmsOrderOperateHistoryDTO> pageAllOmsOrderOperateHistorys(Page page, @Param(Constants.WRAPPER) Wrapper<OmsOrderOperateHistory> wrapper);
}
