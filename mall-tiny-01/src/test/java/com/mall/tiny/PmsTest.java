package com.mall.tiny;

import com.mall.tiny.mbg.model.PmsBrand;
import com.mall.tiny.service.PmsBrandService;
import com.mall.tiny.service.impl.PmsBrandServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: yanyiheng
 * @Description:
 * @Date: created in 2019/7/30 13:39
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsTest {
    @Autowired
    private PmsBrandService pmsBrandService;

    @Test
    public void testBrand() {
        List<PmsBrand> listData = pmsBrandService.listAllBrand();
        System.out.println(listData);
    }
}
