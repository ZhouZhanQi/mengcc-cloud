package com.mengcc.ms.adminuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.mengcc.core.exceptions.DataUpdateException;
import com.mengcc.core.utils.StringUtils;
import com.mengcc.ms.adminuser.mapper.SysActionMapper;
import com.mengcc.ms.adminuser.model.domain.SysAction;
import com.mengcc.ms.adminuser.service.ISysActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 系统模块操作服务实现类
 */
@Service
public class SysActionServiceImpl implements ISysActionService {

    @Autowired
    private SysActionMapper sysActionMapper;

    @Override
    public void saveSysAction(SysAction sysAction) {
        sysActionMapper.insert(sysAction);
    }

    @Override
    public void updateSysAction(SysAction sysAction) {
        Preconditions.checkArgument(!StringUtils.isAllBlank(sysAction.getActionName(), sysAction.getActionUrl(), sysAction.getRemark()), "更新模块操作信息参数确实");

        UpdateWrapper<SysAction> updateWrapper = new UpdateWrapper<>();
        if (StringUtils.isNotBlank(sysAction.getActionName())) {
            updateWrapper.set("actionName", sysAction.getActionName());
        }
        if (StringUtils.isNotBlank(sysAction.getActionUrl())) {
            updateWrapper.set("actionUrl", sysAction.getActionUrl());
        }
        if (StringUtils.isNotBlank(sysAction.getRemark())) {
            updateWrapper.set("remark", sysAction.getRemark());
        }
        updateWrapper.eq("actionCode", sysAction.getActionCode());

        int updateCount = sysActionMapper.update(new SysAction(), updateWrapper);
        if (updateCount != 1) {
            throw new DataUpdateException("更新模块操作信息出错");
        }
    }

    @Override
    public void deleteSysAction(String actionCode) {
        Preconditions.checkArgument(StringUtils.isNotBlank(actionCode), "模块操作编码不能为空");
        sysActionMapper.deleteById(actionCode);
    }
}
