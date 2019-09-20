package com.mengcc.ms.adminuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengcc.ms.adminuser.model.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouzq
 * @date 2019/9/20
 * @desc 用户角色数据库操作
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
