package com.mengcc.ms.adminuser.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhouzq
 * @date 2019/9/17
 * @desc 后台用户信息
 */
@Data
@ApiModel("后台用户信息")
public class AdminUserDTO {

    @ApiModelProperty(value = "用户Id", required = true, example = "1")
    private Long userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("确认密码")
    private String confirmPassword;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("手机号码")
    private String mobilePhone;

    @ApiModelProperty("部门")
    private String department;

    /**
     * 校验密码
     * @return
     */
    public boolean validatePassword() {
        return this.password.equals(this.confirmPassword);
    }
}
