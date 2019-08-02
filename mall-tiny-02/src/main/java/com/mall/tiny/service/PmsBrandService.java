package com.mall.tiny.service;

import com.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @Author: yanyiheng
 * @Description:
 * @Date: created in 2019/7/29 19:50
 * @Modified By:
 */
public interface PmsBrandService {

    /**
     * 获取全部的品牌
     */
    List<PmsBrand> listAllBrand();

    /**
     *  创建品牌
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 更新品牌
     */
    int updateBrand(Long id, PmsBrand pmsBrand);

    /**
     *  删除品牌
     */
    int deleteBrand(Long id);

    /**
     *  根据分页获取品牌列表
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     *  根据Id获取具体某一品牌
     */
    PmsBrand getBrand(Long id);

}

