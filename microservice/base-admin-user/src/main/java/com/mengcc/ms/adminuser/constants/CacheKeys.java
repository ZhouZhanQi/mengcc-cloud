package com.mengcc.ms.adminuser.constants;

/**
 * @author zhouzq
 * @date 2019/8/28
 * @desc 缓存key
 */
public class CacheKeys {

    /**
     * 缓存前缀
     */
    public static final String PREFIX = "mengcc:adminuser:";

    /**
     * 角色已授权的操作列表, 完整key为: 前缀 + ROLE_GRANTED_ACTIONS + 角色编码
     */
    public static final String ROLE_GRANTED_ACTIONS = "role-granted-actions:";

    /**
     * 所有系统信息
     */
    public static final String SYS_ALL = "sysinfo-all";

    /**
     * 所有模块信息
     */
    public static final String MODULE_ALL = "module-all";

    /**
     * 所有操作信息
     */
    public static final String ACTION_ALL = "action-all";

    /**
     * 所有角色信息
     */
    public static final String ROLE_ALL = "role-all";

}
