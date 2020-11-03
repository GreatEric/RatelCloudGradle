package ${mapperPackage};
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ratel.common.core.mapper.SuperMapper;

/**
 * ${company}
 * @ClassName: ${Table}Mapper
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table} Mapper
 * @Version: 1.0
 */
@Mapper
public interface ${Table}Mapper extends SuperMapper<${Table}> {
    IPage<${Table}DTO> pageAll${Table}s(Page page, @Param(Constants.WRAPPER) Wrapper<${Table}> wrapper);
}
