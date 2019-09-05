package com.mengcc.ms.adminuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.base.Preconditions;
import com.mengcc.core.exceptions.DataUpdateException;
import com.mengcc.core.utils.StringUtils;
import com.mengcc.ms.adminuser.mapper.SysModuleMapper;
import com.mengcc.ms.adminuser.model.domain.SysInfo;
import com.mengcc.ms.adminuser.model.domain.SysModule;
import com.mengcc.ms.adminuser.service.ISysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 系统模块服务实现类
 */
@Service
public class SysModuleServiceImpl implements ISysModuleService {

    @Autowired
    private SysModuleMapper sysModuleMapper;

    @Override
    public void saveSysModule(SysModule sysModule) {
        sysModuleMapper.insert(sysModule);
    }

    @Override
    public void updateSysModule(SysModule sysModule) {
        Preconditions.checkArgument(!(StringUtils.isBlank(sysModule.getModuleName()) && sysModule.getOrderNum() != null), "更新模块信息参数缺失");

        UpdateWrapper<SysModule> updateWrapper = new UpdateWrapper<>();
        if (StringUtils.isNotBlank(sysModule.getModuleName())) {
            updateWrapper.set("moduleName", sysModule.getModuleName());
        }
        if (sysModule.getOrderNum() != null) {
            updateWrapper.set("orderNum", sysModule.getOrderNum());
        }
        updateWrapper.eq("moduleCode", sysModule.getModuleCode());

        int updateCount = sysModuleMapper.update(new SysModule(), updateWrapper);
        if (updateCount != 1) {
            throw new DataUpdateException("更新系统信息出错");
        }
    }

    @Override
    public void deleteSysModule(String moduleCode) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(moduleCode), "模块编码不能为空");
        sysModuleMapper.deleteById(moduleCode);
    }

    @Override
    public List<SysModule> listAll() {
        Wrapper<SysModule> wrapper = new QueryWrapper<>();
        return sysModuleMapper.selectList(wrapper);
    }
}
