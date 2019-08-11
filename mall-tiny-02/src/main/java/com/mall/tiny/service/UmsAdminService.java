package com.mall.tiny.service;

import com.mall.tiny.dto.UmsPermission;
import com.mall.tiny.mbg.model.UmsAdmin;

import java.util.List;

/**
 * @Author: yanyiheng
 * @Description: 后管权限service
 * @Date: created in 2019/8/4 9:48
 * @Modified By:
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String userName);

    /**
     * 注册
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 登录
     */
    String login(String userName, String password);


    /**
     * 获取用户权限
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
