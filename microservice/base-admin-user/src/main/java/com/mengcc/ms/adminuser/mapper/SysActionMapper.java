package com.mengcc.ms.adminuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengcc.ms.adminuser.model.domain.SysAction;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 系统模块操作数据库操作
 */
@Mapper
public interface SysActionMapper extends BaseMapper<SysAction> {
}
