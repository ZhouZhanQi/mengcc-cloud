package com.mengcc.ms.adminuser.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhouzq
 * @date 2019/9/17
 * @desc 后台用户信息表
 */
@Data
@ApiModel("后台用户信息表")
@TableName("user_manager")
public class UserManager {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键自增Id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("手机号码")
    private String mobilePhone;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("创建时间")
    private LocalDateTime ctime;
}
