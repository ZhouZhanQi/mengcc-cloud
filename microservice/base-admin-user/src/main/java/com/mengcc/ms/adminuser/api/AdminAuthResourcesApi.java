package com.mengcc.ms.adminuser.api;

import com.google.common.base.Preconditions;
import com.mengcc.core.utils.StringUtils;
import com.mengcc.core.validate.UpdateGroup;
import com.mengcc.core.vo.ResponseVo;
import com.mengcc.ms.adminuser.model.domain.SysAction;
import com.mengcc.ms.adminuser.model.domain.SysInfo;
import com.mengcc.ms.adminuser.model.domain.SysModule;
import com.mengcc.ms.adminuser.service.ISysActionService;
import com.mengcc.ms.adminuser.service.ISysInfoService;
import com.mengcc.ms.adminuser.service.ISysModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ISysModuleService sysModuleService;

    @Autowired
    private ISysActionService sysActionService;

    @ApiOperation(value = "保存系统信息", notes = "系统信息录入")
    @PostMapping("/systems")
    public ResponseVo sysInfoSave(@Valid @RequestBody SysInfo sysInfo){
        sysInfoService.saveSysInfo(sysInfo);
        return ResponseVo.success();
    }

    @ApiOperation(value = "更新系统信息", notes = "系统信息变更")
    @PatchMapping("/systems")
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

    @ApiOperation(value = "保存系统模块信息", notes = "系统模块信息录入")
    @PostMapping("/modules")
    public ResponseVo sysModuleSave(@Valid @RequestBody SysModule sysModule) {
        sysModuleService.saveSysModule(sysModule);
        return ResponseVo.success();
    }

    @ApiOperation(value = "更新系统模块信息", notes = "系统模块信息变更")
    @PatchMapping("/modules")
    public ResponseVo sysModuleUpdate(@Validated(UpdateGroup.class) @RequestBody SysModule sysModule) {
        sysModuleService.updateSysModule(sysModule);
        return ResponseVo.success();
    }

    @ApiOperation(value = "删除系统模块信息", notes = "系统模块信息删除")
    @DeleteMapping("/modules/{moduleCode}")
    public ResponseVo sysModuleDelete(@PathVariable ("moduleCode") String moduleCode) {
        sysModuleService.deleteSysModule(moduleCode);
        return ResponseVo.success();
    }

    @ApiOperation(value = "根据系统编码，获取系统模块信息", notes = "系统模块信息")
    @GetMapping("/modules/{sysCode}")
    public ResponseVo<List<SysModule>> sysModuleList(@PathVariable ("sysCode") String sysCode) {
        return ResponseVo.success(filterSysModule(sysCode));
    }


    @ApiOperation(value = "保存模块操作信息", notes = "模块操作信息保存")
    @PostMapping("/actions")
    public ResponseVo sysActionSave(@Valid @RequestBody SysAction sysAction) {
        sysActionService.saveSysAction(sysAction);
        return ResponseVo.success();
    }

    @ApiOperation(value = "更新模块操作信息", notes = "模块操作信息变更")
    @PatchMapping("/actions")
    public ResponseVo sysActionUpdate(@Validated(UpdateGroup.class) @RequestBody SysAction sysAction) {
        sysActionService.updateSysAction(sysAction);
        return ResponseVo.success();
    }

    @ApiOperation(value = "删除模块操作信息", notes = "模块操作信息变更")
    @DeleteMapping("/actions/{actionCode}")
    public ResponseVo sysActionDelete(@PathVariable ("actionCode") String actionCode) {
        sysActionService.deleteSysAction(actionCode);
        return ResponseVo.success();
    }


    @ApiOperation(value = "根据系统编码，获取系统模块信息", notes = "系统模块信息")
    @GetMapping("/modules/{modelCode}")
    public ResponseVo<List<SysAction>> sysActionList(@PathVariable ("modelCode") String modelCode) {
        return ResponseVo.success(filterSysAction(modelCode));
    }


    //根据系统编码过滤系统模块信息
    private List<SysModule> filterSysModule(String sysCode) {
        Preconditions.checkArgument(StringUtils.isNoneBlank(sysCode), "系统编码不能为空");
        return sysModuleService.listAll().stream()
                .filter(sysModule -> sysCode.equals(sysModule.getSysCode()))
                .sorted(Comparator.comparing(SysModule::getOrderNum))
                .collect(Collectors.toList());
    }

    //根据模块编码过滤系统操作信息
    private List<SysAction> filterSysAction(String modelCode) {
        Preconditions.checkArgument(StringUtils.isNoneBlank(modelCode), "模块编码不能为空");
        return sysActionService.listAll().stream()
                .filter(sysAction -> modelCode.equals(sysAction.getModuleCode()))
                .collect(Collectors.toList());
    }
}
