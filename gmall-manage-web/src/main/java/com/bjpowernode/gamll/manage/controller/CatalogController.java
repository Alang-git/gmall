package com.bjpowernode.gamll.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.gmall.bean.PmsBaseCatalog1;
import com.bjpowernode.gmall.bean.PmsBaseCatalog2;
import com.bjpowernode.gmall.bean.PmsBaseCatalog3;
import com.bjpowernode.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:CatalogController
 * Package:com.bjpowernode.gamll.manage.controller
 * Description:
 *
 * @date:2020/2/12 0:08)
 * @author:Lan
 */
@Controller
@CrossOrigin   //springMVC跨域注解，解决跨域问题
public class CatalogController {

    @Reference
    private CatalogService catalogService;
    /**
     *获取一级分类信息
     * @return
     */
    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> catalog1s = catalogService.getAllCatalog1();

        return catalog1s;
    }

    @RequestMapping("/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam(required = true) String catalog1Id){

        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);

        return  catalog2s;
    }

    @RequestMapping("/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam(required=true) String catalog2Id){

            List<PmsBaseCatalog3> catalog3s = catalogService.getCatalog3(catalog2Id);

        return catalog3s;
    }

}
