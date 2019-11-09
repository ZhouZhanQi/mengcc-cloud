package com.mengcc.ms.adminuser.api;

import com.mengcc.core.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouzq
 * @date 2019/11/9
 * @desc 后台用户单点登录
 */
@Api(tags = {"后台用户单点登录"})
@RestController
@RequestMapping(value = "/admin/sso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminSsoApi {


    @ApiOperation("后台用户登录")
    @PostMapping("/login")
    public ResponseVo adminUserLogin() {

        return ResponseVo.success();
    }

}
