package com.mall.tiny.controller;

import com.mall.tiny.common.CommonResult;
import com.mall.tiny.mbg.model.PmsBrand;
import com.mall.tiny.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: yanyiheng
 * @Description: 品牌管理Controller
 * @Date: created in 2019/7/29 19:50
 * @Modified By:
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @RequestMapping(value = "getAllBrandList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getAllBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

}
