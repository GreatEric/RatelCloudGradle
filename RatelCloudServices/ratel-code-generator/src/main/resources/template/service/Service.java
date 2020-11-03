package ${servicePackage};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.ratel.common.core.service.SuperService;
import com.ratel.common.core.mybatishelper.PageUtils;

import ${pojoPackage}.${Table};
import ${dtoPackage}.${Table}DTO;

/**
 * ${company}
 * @ClassName: ${Table}Service
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table} Service
 * @Version: 1.0
 */
public interface ${Table}Service extends SuperService<${Table}> {

    void save${Table}(${Table} ${table}, QueryWrapper<${Table}> queryWrapper);

    PageUtils<${Table}DTO> pageAll${Table}s(Page page, QueryWrapper<${Table}> queryWrapper);
}
