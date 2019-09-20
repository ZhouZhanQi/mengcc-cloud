package com.mengcc.ms.adminuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.mengcc.core.exceptions.DataUpdateException;
import com.mengcc.core.utils.StringUtils;
import com.mengcc.ms.adminuser.mapper.UserRoleMapper;
import com.mengcc.ms.adminuser.model.domain.UserRole;
import com.mengcc.ms.adminuser.service.IUserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouzq
 * @date 2019/9/20
 * @desc 用户角色服务实现类
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void saveUserRole(UserRole userRole) {
        userRole.setCtime(LocalDateTime.now());
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        Preconditions.checkArgument(!StringUtils.isAllBlank(userRole.getRoleName(), userRole.getRemark()), "更新角色信息参数缺失");
        UpdateWrapper<UserRole> updateWrapper = new UpdateWrapper<>();
        if (StringUtils.isNotBlank(userRole.getRoleName())) {
            updateWrapper.set("roleName", userRole.getRoleName());
        }

        if (StringUtils.isNotBlank(userRole.getRemark())) {
            updateWrapper.set("remark", userRole.getRemark());
        }

        updateWrapper.eq("roleCode", userRole.getRoleCode());

        int updateCount = userRoleMapper.update(userRole, updateWrapper);
        if (updateCount != 1) {
            throw new DataUpdateException("更新用户角色信息失败");
        }
    }

    @Override
    public void deleteUserRole(String roleCode) {
        Preconditions.checkArgument(StringUtils.isNotBlank(roleCode), "角色编码不能为空");
        userRoleMapper.deleteById(roleCode);
        //todo delete user_access user_role_access
    }

    @Override
    public void linkActions(String roleCode, List<String> actionList) {
        Preconditions.checkArgument(StringUtils.isNotBlank(roleCode), "角色编码不能为空");
        Preconditions.checkArgument(!CollectionUtils.isEmpty(actionList), "权限编码列表不能为空");
        //todo save action link
    }
}
