package com.mengcc.ms.adminuser.api;

import com.mengcc.core.vo.ResponseVo;
import com.mengcc.ms.adminuser.model.dto.AdminUserDTO;
import com.mengcc.ms.adminuser.model.enums.UserStateEnum;
import com.mengcc.ms.adminuser.service.IUserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author zhouzq
 * @date 2019/9/19
 * @desc 后台用户接口
 */
@Api(tags = {"后台用户管理接口"})
@RestController
@RequestMapping(value = "/admin/manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminUserApi {

    @Autowired
    private IUserManagerService userManagerService;

    @ApiOperation(value = "保存用户信息", notes = "后台用户添加")
    @PostMapping("/users")
    public ResponseVo userManagerAdd(@RequestBody AdminUserDTO adminUser) {
        userManagerService.saveUserManager(adminUser);
        return ResponseVo.success();
    }

    @ApiOperation(value = "更新用户信息", notes = "后台用户更新")
    @PutMapping("/users")
    public ResponseVo userManagerEdit(@RequestBody AdminUserDTO adminUser) {
        userManagerService.updateUserManager(adminUser);
        return ResponseVo.success();
    }

    @ApiOperation(value = "删除用户信息", notes = "后台用户删除")
    @DeleteMapping("/users/{userId}")
    public ResponseVo userManagerDelete(@NotNull(message = "用户Id不能为空") @PathVariable ("userId") Long userId) {
        userManagerService.updateUserManager(userId, UserStateEnum.DELETE);
        return ResponseVo.success();
    }

    @ApiOperation(value = "启用/禁用 用户", notes = "用户状态变更")
    @PatchMapping("/users/{userId}/{state}")
    public ResponseVo changeUserManagerState(@NotNull(message = "用户Id不能为空") @PathVariable ("userId") Long userId, @NotNull(message = "变更状态不能为空") @PathVariable("state") UserStateEnum state) {
        userManagerService.updateUserManager(userId, state);
        return ResponseVo.success();
    }

}
