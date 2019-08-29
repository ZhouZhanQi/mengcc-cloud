package com.mengcc.ms.adminuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.mengcc.core.utils.StringUtils;
import com.mengcc.ms.adminuser.mapper.SysInfoMapper;
import com.mengcc.ms.adminuser.model.domain.SysInfo;
import com.mengcc.ms.adminuser.service.ISysInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.Wrapper;

/**
 * @author zhouzq
 * @date 2019/8/29
 * @desc 系统信息服务实现类
 */
@Service
public class SysInfoServiceImpl implements ISysInfoService {

    @Autowired
    private SysInfoMapper sysInfoMapper;

    @Override
    public void saveSysInfo(SysInfo sysInfo) {
        sysInfoMapper.insert(sysInfo);
    }

    @Override
    public void updateSysInfo(SysInfo sysInfo) {
        Preconditions.checkArgument(!StringUtils.isAllBlank(sysInfo.getSysName(), sysInfo.getRemark()), "更新系统信息参数缺失");
        UpdateWrapper<SysInfo> updateWrapper = new UpdateWrapper<>();

        if (!StringUtils.isBlank(sysInfo.getSysName())) {
            updateWrapper.set("sysName", sysInfo.getSysName());
        }

        if (!StringUtils.isBlank(sysInfo.getRemark())) {
            updateWrapper.set("remark", sysInfo.getRemark());
        }

        updateWrapper.eq("sysCode", sysInfo.getSysCode());
        sysInfoMapper.update(new SysInfo(), updateWrapper);
    }
}
