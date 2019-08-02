package com.mall.tiny.service;

import com.mall.tiny.common.CommonResult;

/**
 * @Author: yanyiheng
 * @Description: 会员管理
 * @Date: created in 2019/7/29 19:50
 * @Modified By:
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     *  判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
