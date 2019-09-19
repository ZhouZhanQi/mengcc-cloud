package com.mengcc.ms.adminuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.mengcc.core.exceptions.DataUpdateException;
import com.mengcc.core.utils.SecurityUtils;
import com.mengcc.core.utils.StringUtils;
import com.mengcc.ms.adminuser.mapper.UserManagerMapper;
import com.mengcc.ms.adminuser.model.domain.UserManager;
import com.mengcc.ms.adminuser.model.dto.AdminUserDTO;
import com.mengcc.ms.adminuser.model.enums.UserStateEnum;
import com.mengcc.ms.adminuser.service.IUserManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author zhouzq
 * @date 2019/9/19
 * @desc 后天用户服务实现类
 */
@Service
public class UserManagerServiceImpl implements IUserManagerService {

    @Autowired
    private UserManagerMapper userManagerMapper;

    @Override
    public void saveUserManager(AdminUserDTO adminUser) {
        Preconditions.checkArgument(adminUser.validatePassword(), "两次输入密码不一致");

        UserManager userManager = new UserManager();
        BeanUtils.copyProperties(adminUser, userManager);
        //密码加密
        userManager.setPassword(SecurityUtils.md5Encrypt(adminUser.getPassword()));
        //默认状态
        userManager.setState(UserStateEnum.NORMAL);
        userManager.setCtime(LocalDateTime.now());
        userManagerMapper.insert(userManager);
    }

    @Override
    public void updateUserManager(AdminUserDTO adminUser) {
        //校验参数
        Preconditions.checkArgument(!StringUtils.isAllBlank(adminUser.getUsername(), adminUser.getPassword(),
                adminUser.getRealName(), adminUser.getDepartment(), adminUser.getMobilePhone()), "更新后台用户信息参数缺失");

        UpdateWrapper<UserManager> updateWrapper = new UpdateWrapper<>();
        if (StringUtils.isNotBlank(adminUser.getUsername())) {
            updateWrapper.set("username", adminUser.getUsername());
        }

        if (StringUtils.isNotBlank(adminUser.getPassword())) {
            Preconditions.checkArgument(adminUser.validatePassword(), "两次输入密码不一致");
            updateWrapper.set("password", SecurityUtils.md5Encrypt(adminUser.getPassword()));
        }

        if (StringUtils.isNotBlank(adminUser.getRealName())) {
            updateWrapper.set("realName", adminUser.getRealName());
        }

        if (StringUtils.isNotBlank(adminUser.getDepartment())) {
            updateWrapper.set("department", adminUser.getDepartment());
        }

        if (StringUtils.isNotBlank(adminUser.getMobilePhone())) {
            updateWrapper.set("mobilePhone", adminUser.getMobilePhone());
        }

        updateWrapper.eq("userId", adminUser.getUserId());
        int updateCount = userManagerMapper.update(new UserManager(), updateWrapper);

        if (updateCount != 1) {
            throw new DataUpdateException("更新用户信息出错");
        }
    }

    @Override
    public void updateUserManager(Long userId, UserStateEnum state) {
        UpdateWrapper<UserManager> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("state", state);
        updateWrapper.eq("userId", userId);
        int updateCount = userManagerMapper.update(new UserManager(), updateWrapper);

        String errMsg = state.equals(UserStateEnum.DELETE) ? "删除用户失败" : "用户状态变更失败";
        if (updateCount != 1) {
            throw new DataUpdateException(errMsg);
        }
    }
}
