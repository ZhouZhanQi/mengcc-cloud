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

/**
 * @author zhouzq
 * @date 2019/8/29
 * @desc 系统信息表
 */
@Data
@ApiModel("系统信息表")
@TableName("sys_info")
public class SysInfo {

    @TableId(type = IdType.INPUT)
    @NotBlank(message = "系统编码不能为空", groups = {Default.class, UpdateGroup.class})
    @Size(min = 6, max = 32, message = "系统编码长度错误，最小长度6，最大长度32")
    @ApiModelProperty(value = "系统编码", required = true)
    private String sysCode;

    @NotBlank(message = "系统名称不能为空")
    @Size(max = 64, message = "系统名称长度错误，最小长度1，最大长度64", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "系统名称")
    private String sysName;

    @Max(value = 128, message = "备注最大长度128", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty("备注")
    private String remark;
}
