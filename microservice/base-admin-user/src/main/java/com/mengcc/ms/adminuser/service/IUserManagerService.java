package com.mengcc.ms.adminuser.service;

import com.mengcc.ms.adminuser.model.dto.AdminUserDTO;
import com.mengcc.ms.adminuser.model.enums.UserStateEnum;

/**
 * @author zhouzq
 * @date 2019/9/19
 * @desc 后台用户服务
 */
public interface IUserManagerService {

    /**
     * 保存后台用户信息
     * @param adminUser
     */
    void saveUserManager(AdminUserDTO adminUser);

    /**
     * 更新后台用户信息
     * @param adminUser
     */
    void updateUserManager(AdminUserDTO adminUser);

    /**
     * 删除后台用户信息
     * @param userId
     */
    void updateUserManager(Long userId, UserStateEnum state);
}
