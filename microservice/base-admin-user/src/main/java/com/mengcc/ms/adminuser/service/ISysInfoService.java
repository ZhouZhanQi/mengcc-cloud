package com.mengcc.ms.adminuser.service;

import com.mengcc.ms.adminuser.model.domain.SysInfo;

/**
 * @author zhouzq
 * @date 2019/8/29
 * @desc 系统信息服务
 */
public interface ISysInfoService {

    /**
     * 保存系统信息
     * @param sysInfo
     */
    void saveSysInfo(SysInfo sysInfo);


    /**
     * 更新系统信息
     * @param sysInfo
     */
    void updateSysInfo(SysInfo sysInfo);
}
