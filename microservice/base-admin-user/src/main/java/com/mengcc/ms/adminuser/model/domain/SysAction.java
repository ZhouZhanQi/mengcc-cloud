package com.mengcc.ms.adminuser.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    @ApiModelProperty(value = "操作编码", required = true)
    private String actionCode;

    @ApiModelProperty(value = "操作名称", required = true)
    private String actionName;

    @ApiModelProperty(value = "操作请求地址", required = true)
    private String actionUrl;

    @ApiModelProperty(value = "系统模块编码", required = true)
    private String moduleCode;

    @ApiModelProperty(value = "备注")
    private String remark;
}
