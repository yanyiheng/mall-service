package com.mall.tiny.controller;

import com.mall.tiny.common.CommonResult;
import com.mall.tiny.dto.UmsVerifyAuthCodeParam;
import com.mall.tiny.service.impl.UmsMemberServiceIml;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yanyiheng
 * @Description: 会员登录注册
 * @Date: created in 2019/8/2 15:28
 * @Modified By:
 */
@Controller
@RequestMapping("/sso")
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
public class UmsMemberController {

    @Autowired
    private UmsMemberServiceIml memberServiceIml;

    @ResponseBody
    @ApiOperation(value = "获取短信验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.POST)
    public CommonResult getAuthCode(@RequestBody UmsVerifyAuthCodeParam param) {
        return memberServiceIml.generateAuthCode(param.telephone);
    }

    @ResponseBody
    @ApiOperation(value = "校验短信验证码")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    public CommonResult verityAuthCode(@RequestBody UmsVerifyAuthCodeParam param) {
        return memberServiceIml.verifyAuthCode(param.telephone, param.authCode);
    }
}
