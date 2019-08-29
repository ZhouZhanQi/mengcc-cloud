package com.mengcc.ms.adminuser.api;

import com.mengcc.core.validate.UpdateGroup;
import com.mengcc.core.vo.ResponseVo;
import com.mengcc.ms.adminuser.model.domain.SysInfo;
import com.mengcc.ms.adminuser.service.ISysInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author zhouzq
 * @date 2019/8/29
 * @desc 后台权限资源接口
 */
@Api(tags = {"后台权限资源接口"})
@RestController
@RequestMapping(value = "/admin/auth/resources", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminAuthResourcesApi {

    @Autowired
    private ISysInfoService sysInfoService;

    @ApiOperation(value = "保存系统信息", notes = "系统信息录入")
    @PostMapping("/systems")
    public ResponseVo sysInfoSave(@Valid @RequestBody SysInfo sysInfo){
        sysInfoService.saveSysInfo(sysInfo);
        return ResponseVo.success();
    }

    @ApiOperation(value = "更新系统信息", notes = "系统信息变更")
    @PutMapping("/systems")
    public ResponseVo sysInfoUpdate(@Validated(UpdateGroup.class) @RequestBody SysInfo sysInfo){
        sysInfoService.updateSysInfo(sysInfo);
        return ResponseVo.success();
    }

    @ApiOperation(value = "删除系统信息", notes = "系统信息删除（物理删除）")
    @DeleteMapping("/systems/{sysCode}")
    public ResponseVo sysInfoDel(@PathVariable("sysCode") @NotBlank(message = "系统编码不能为空") String sysCode){
        sysInfoService.deleteSysInfo(sysCode);
        return ResponseVo.success();
    }
}
