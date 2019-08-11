package com.mall.tiny.dao;

import com.mall.tiny.dto.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yanyiheng
 * @Description: 后台用户与角色管理自定义Dao
 * @Date: created in 2019/8/11 21:46
 * @Modified By:
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括加减权限)
     */
    List<UmsPermission> getPerissionList(@Param("adminId") Long  adminId);
}
