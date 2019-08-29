package com.mengcc.ms.adminuser.api;

import com.mengcc.core.validate.UpdateGroup;
import com.mengcc.ms.adminuser.model.domain.SysInfo;
import com.mengcc.ms.adminuser.service.ISysInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zhouzq
 * @date 2019/8/29
 * @desc 后台权限资源接口
 */
@Api(tags = {"后台权限资源接口"})
@RestController
@RequestMapping("/admin/auth/resources")
public class AdminAuthResourcesApi {

    @Autowired
    private ISysInfoService sysInfoService;

    @ApiOperation(value = "保存系统信息", notes = "系统信息录入")
    @PostMapping("/systems")
    public Object sysInfoSave(@Valid @RequestBody SysInfo sysInfo){
        sysInfoService.saveSysInfo(sysInfo);
        return null;
    }

    @ApiOperation(value = "更新系统信息", notes = "系统信息变更")
    @PutMapping("/systems")
    public Object sysInfoUpdate(@Validated(UpdateGroup.class) @RequestBody SysInfo sysInfo){
        sysInfoService.updateSysInfo(sysInfo);
        return null;
    }
}
