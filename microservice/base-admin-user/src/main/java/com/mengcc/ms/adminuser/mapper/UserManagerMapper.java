package com.mengcc.ms.adminuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengcc.ms.adminuser.model.domain.UserManager;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouzq
 * @date 2019/9/19
 * @desc 后台用户信息数据库映射
 */
@Mapper
public interface UserManagerMapper extends BaseMapper<UserManager> {
}
