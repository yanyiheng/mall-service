package com.mall.tiny.controller;

import com.mall.tiny.common.CommonResult;
import com.mall.tiny.mbg.model.PmsBrand;
import com.mall.tiny.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "PmsBrandController", description = "商品品牌管理")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ResponseBody
    @ApiOperation(value = "获取所有品牌列表")
    @RequestMapping(value = "getAllBrandList", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getAllBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ResponseBody
    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "createBrand",  method = RequestMethod.GET)
    public CommonResult<Integer> addBrand(PmsBrand pmsBrand) {
        return CommonResult.success(pmsBrandService.createBrand(pmsBrand));
    }

}
