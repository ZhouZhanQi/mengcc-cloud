package com.mengcc.ms.adminuser.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhouzq
 * @date 2019/9/20
 * @desc 用户角色信息表
 */
@Data
@ApiModel("用户角色信息表")
@TableName("user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 5305809270167371093L;

    @TableId(type = IdType.INPUT)
    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private LocalDateTime ctime;
}
