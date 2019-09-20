package com.mengcc.ms.adminuser.model.vo;

import com.mengcc.core.utils.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhouzq
 * @date 2019/9/20
 * @desc 角色关联权限请求参数
 */
@ApiModel("角色关联权限请求参数")
@Data
public class AdminRoleLinkActionReqVo implements Serializable {

    @ApiModelProperty(value = "角色编码", required = true)
    private String roleCode;

    @ApiModelProperty(value = "权限编码列表", required = true)
    private List<String> actionList;

}
