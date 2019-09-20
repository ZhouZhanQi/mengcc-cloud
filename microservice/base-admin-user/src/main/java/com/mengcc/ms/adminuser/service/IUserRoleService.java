package com.mengcc.ms.adminuser.service;

import com.mengcc.ms.adminuser.model.domain.UserRole;

import java.util.List;

/**
 * @author zhouzq
 * @date 2019/9/20
 * @desc 用户角色服务
 */
public interface IUserRoleService {


    /**
     * 保存用户角色信息
     * @param userRole
     */
    void saveUserRole(UserRole  userRole);

    /**
     * 更新用户角色信息
     * @param userRole
     */
    void updateUserRole(UserRole userRole);

    /**
     * 根据角色编码删除角色信息
     * @param roleCode
     */
    void deleteUserRole(String roleCode);


    /**
     *  角色关联操作权限
     * @param roleCode 角色编码
     * @param actionList 权限编码列表
     */
    void linkActions(String roleCode, List<String> actionList);
}
