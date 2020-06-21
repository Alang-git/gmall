package com.bjpowernode.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.gmall.bean.PmsSkuInfo;
import com.bjpowernode.gmall.service.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:ItemController
 * Package:com.bjpowernode.gmall.item.controller
 * Description:
 *
 * @date:2020/2/22 11:00)
 * @author:Lan
 */
@Controller
@CrossOrigin
public class ItemController {

    @Reference
    private SkuService skuService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {

        modelMap.put("hello", "Hello Thymeleaf!!!");

        return "index";
    }

    @RequestMapping("/{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap) {

        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);
        modelMap.put("skuInfo", pmsSkuInfo);

        return "item";
    }

}
