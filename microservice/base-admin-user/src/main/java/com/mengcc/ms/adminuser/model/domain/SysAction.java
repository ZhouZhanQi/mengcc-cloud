package com.mengcc.ms.adminuser.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mengcc.core.validate.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.io.Serializable;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 模块操作信息表
 */
@Data
@ApiModel("模块操作信息表")
@TableName("sys_action")
public class SysAction implements Serializable {

    private static final long serialVersionUID = -5925236978502610573L;

    @TableId(type = IdType.INPUT)
    @NotBlank(message = "操作编码不能为空", groups = {Default.class, UpdateGroup.class})
    @Size(min = 6, max = 32, message = "操作编码长度错误，最小长度6，最大长度32", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "操作编码", required = true)
    private String actionCode;

    @NotBlank(message = "操作名称不能为空")
    @Size(max = 64, message = "操作名称长度错误，最大长度64", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "操作名称", required = true)
    private String actionName;

    @NotBlank(message = "操作请求地址不能为空")
    @Size(max = 64, message = "操作请求地址长度错误，最大长度64", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "操作请求地址", required = true)
    private String actionUrl;

    @NotBlank(message = "系统模块编码不能为空", groups = {Default.class})
    @Size(min = 6, max = 32, message = "系统模块编码长度错误，最小长度6，最大长度32", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "系统模块编码", required = true)
    private String moduleCode;

    @Max(value = 128, message = "备注最大长度128", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "备注")
    private String remark;
}
