package com.mengcc.ms.adminuser.service;

import com.mengcc.ms.adminuser.model.domain.SysModule;

import java.util.List;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 系统模块服务
 */
public interface ISysModuleService {

    /**
     * 保存系统模块信息
     */
    void saveSysModule(SysModule sysModule);

    /**
     * 更新系统模块信息
     * @param sysModule
     */
    void updateSysModule(SysModule sysModule);

    /**
     * 根据模块编码删除模块信息
     * @param moduleCode 模块编码
     */
    void deleteSysModule(String moduleCode);

    /**
     * 查询所有系统模块信息
     * @return
     */
    List<SysModule> listAll();
}
