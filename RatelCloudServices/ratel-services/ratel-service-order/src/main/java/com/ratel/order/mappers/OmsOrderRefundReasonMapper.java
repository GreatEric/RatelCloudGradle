package com.ratel.order.mappers;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ratel.common.core.mapper.SuperMapper;
import com.ratel.order.api.dtos.OmsOrderRefundReasonDTO;
import com.ratel.order.api.pojos.OmsOrderRefundReason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * RatelCloud
 *
 * @ClassName: OmsOrderRefundReasonMapper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/10/2020 01:48:24
 * @Description: OmsOrderRefundReason Mapper
 * @Version: 1.0
 */
@Mapper
public interface OmsOrderRefundReasonMapper extends SuperMapper<OmsOrderRefundReason> {
    IPage<OmsOrderRefundReasonDTO> pageAllOmsOrderRefundReasons(Page page, @Param(Constants.WRAPPER) Wrapper<OmsOrderRefundReason> wrapper);
}
