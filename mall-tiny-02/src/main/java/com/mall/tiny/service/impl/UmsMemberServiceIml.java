package com.mall.tiny.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.mall.tiny.common.CommonResult;
import com.mall.tiny.service.RedisService;
import com.mall.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author: yanyiheng
 * @Description: 用户会员登录注册管理
 * @Date: created in 2019/8/2 15:33
 * @Modified By:
 */
@Service
public class UmsMemberServiceIml implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_AUTH_CODE;


    /**
     *  获取短息验证码
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, REDIS_KEY_EXPIRE_AUTH_CODE);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    /**
     * 校验短信验证码
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtil.isEmpty(authCode)) {
            return CommonResult.failure("请输入短信验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "短信验证成功");
        } else {
            return CommonResult.failure("验证码输入不正确");
        }
    }
}
