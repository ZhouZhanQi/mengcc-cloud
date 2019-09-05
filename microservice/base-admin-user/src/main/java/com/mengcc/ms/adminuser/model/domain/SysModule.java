package com.mengcc.ms.adminuser.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mengcc.core.validate.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.io.Serializable;

/**
 * @author zhouzq
 * @date 2019/9/5
 * @desc 系统模块
 */
@Data
@ApiModel("系统模块")
@TableName("sys_module")
public class SysModule implements Serializable {

    private static final long serialVersionUID = -3854217497567077455L;

    @TableId(type = IdType.INPUT)
    @NotBlank(message = "模块编码不能为空", groups = {Default.class, UpdateGroup.class})
    @Size(min = 6, max = 32, message = "模块编码长度错误， 最小长度6，最大长度32", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "模块编码", required = true)
    private String moduleCode;

    @NotBlank(message = "模块名称不能为空", groups = {Default.class})
    @Size(max = 64, message = "模块名称长度错误，最大长度64", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty(value = "模块名称")
    private String moduleName;

    @NotBlank(message = "系统编码不能为空", groups = {Default.class})
    @Size(min = 6, max = 32, message = "系统编码长度错误，最小长度6，最大长度32", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty("系统编码")
    private String sysCode;

    @NotNull(message = "排序序号不能为空", groups = {Default.class})
    @Min(value = 0, message = "排序序号最小值为0", groups = {Default.class, UpdateGroup.class})
    @ApiModelProperty("排序序号")
    private Short orderNum;


}
