package com.mengcc.ms.adminuser.api;

/**
 * @author zhouzq
 * @date 2019/9/20
 * @desc
 */

import com.mengcc.core.utils.StringUtils;
import com.mengcc.core.vo.ResponseVo;
import com.mengcc.ms.adminuser.model.domain.UserRole;
import com.mengcc.ms.adminuser.model.vo.AdminRoleLinkActionReqVo;
import com.mengcc.ms.adminuser.service.IUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author zhouzq
 * @date 2019/9/19
 * @desc 后台用户接口
 */
@Api(tags = {"后台用户角色管理接口"})
@RestController
@RequestMapping(value = "/admin/manager", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminRoleApi {

    @Autowired
    private IUserRoleService userRoleService;

    @ApiOperation(value = "保存角色信息", notes = "后台角色添加")
    @PostMapping("/roles")
    public ResponseVo userRoleAdd(@Valid @RequestBody UserRole userRole) {
        userRoleService.saveUserRole(userRole);
        return ResponseVo.success();
    }

    @ApiOperation(value = "更新角色信息", notes = "后台角色信息更新")
    @PutMapping("/roles")
    public ResponseVo userRoleEdit(@RequestBody UserRole userRole) {
        userRoleService.updateUserRole(userRole);
        return ResponseVo.success();
    }

    @ApiOperation(value = "删除角色信息", notes = "后台角色信息删除")
    @DeleteMapping("/roles/{roleCode}")
    public ResponseVo userRoleDelete(@PathVariable("roleCode") @NotBlank(message = "角色编码不能为空") String roleCode) {
        userRoleService.deleteUserRole(roleCode);
        return ResponseVo.success();
    }

    @ApiModelProperty(value = "角色关联系统操作权限", notes = "关联操作信息")
    @PostMapping("/roles/{roleCode}/actions")
    public ResponseVo userRoleLinkActions(@PathVariable("roleCode") @NotBlank(message = "角色编码不能为空") String roleCode, @RequestBody AdminRoleLinkActionReqVo reqVo) {
        userRoleService.linkActions(roleCode, reqVo.getActionList());
        return ResponseVo.success();
    }
}
