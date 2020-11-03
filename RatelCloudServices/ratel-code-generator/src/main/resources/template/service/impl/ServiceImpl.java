package ${serviceImplPackage};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratel.common.core.service.impl.SuperServiceImpl;
import com.ratel.common.core.mybatishelper.PageUtils;

import ${servicePackage}.${Table}Service;
import ${pojoPackage}.${Table};
import ${dtoPackage}.${Table}DTO;
import ${mapperPackage}.${Table}Mapper;

/**
 * ${company}
 * @ClassName: ${Table}ServiceImpl
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table} ServiceImpl
 * @Version: 1.0
 */
@Service("${table}Service")
public class ${Table}ServiceImpl extends SuperServiceImpl<${Table}Mapper, ${Table}> implements ${Table}Service {
    private final static String LOCK_KEY = "id";
    /*@Autowired
    private DistributedLock lock;*/

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save${Table}(${Table} ${table}, QueryWrapper<${Table}> queryWrapper) {
        /*try {
            super.saveIdempotency(${table}, lock, LOCK_KEY + ${table}.getOrderSerial(), queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public PageUtils<${Table}DTO> pageAll${Table}s(Page page, QueryWrapper<${Table}> queryWrapper) {
        PageUtils<${Table}DTO> pageUtils = new PageUtils<${Table}DTO>(baseMapper.pageAll${Table}s(page, queryWrapper));
        return pageUtils;
    }
}
