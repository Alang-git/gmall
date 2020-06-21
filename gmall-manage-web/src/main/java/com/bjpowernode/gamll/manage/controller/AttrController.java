package com.bjpowernode.gamll.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.gmall.bean.PmsBaseAttrInfo;
import com.bjpowernode.gmall.bean.PmsBaseAttrValue;
import com.bjpowernode.gmall.bean.PmsBaseSaleAttr;
import com.bjpowernode.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:AttrController
 * Package:com.bjpowernode.gamll.manage.controller
 * Description:
 *
 * @date:2020/2/12 14:58)
 * @author:Lan
 */
@Controller
@CrossOrigin
public class AttrController {

    @Reference
    private AttrService attrService;


    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(@RequestParam(required = true) String catalog3Id){

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.attrInfoList(catalog3Id);

        return pmsBaseAttrInfos;
    }

    @RequestMapping(value = "/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        String result = attrService.saveAttrInfo(pmsBaseAttrInfo);

        return result;
    }

    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam(required = true) String attrId){

        List<PmsBaseAttrValue> pmsBaseAttrValues = attrService.getAttrValueList(attrId);

        return pmsBaseAttrValues;
    }


    /**
     * 查询销售字典表
     * @return
     */
    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attrService.baseSaleAttrList();

        return pmsBaseSaleAttrs;
    }


}
