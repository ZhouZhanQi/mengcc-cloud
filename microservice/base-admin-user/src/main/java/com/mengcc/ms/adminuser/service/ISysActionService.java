package com.mengcc.ms.adminuser.service;

import com.mengcc.ms.adminuser.model.domain.SysAction;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 系统模块操作服务
 */
public interface ISysActionService {

    /**
     * 保存模块操作信息
     * @param sysAction
     */
    void saveSysAction(SysAction sysAction);

    /**
     * 更新模块操作信息
     * @param sysAction
     */
    void updateSysAction(SysAction sysAction);

    /**
     * 根据操作编码删除模块操作信息
     * @param actionCode
     */
    void deleteSysAction(String actionCode);

}
