package com.bjpowernode.gamll.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.gmall.bean.PmsSkuImage;
import com.bjpowernode.gmall.bean.PmsSkuInfo;
import com.bjpowernode.gmall.service.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:SkuController
 * Package:com.bjpowernode.gamll.manage.controller
 * Description:
 *
 * @date:2020/2/17 23:56)
 * @author:Lan
 */
@Controller
@CrossOrigin
public class SkuController {

    @Reference
    private SkuService skuService;

    @RequestMapping("/saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo){

        //将spuId封装给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());

        //处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if (StringUtils.isBlank(skuDefaultImg)){
            skuDefaultImg = pmsSkuInfo.getSkuImageList().get(0).getImgUrl();
            List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
            for (PmsSkuImage pmsSkuImage : skuImageList) {
                pmsSkuImage.setIsDefault("1");
                break;
            }
            pmsSkuInfo.setSkuDefaultImg(skuDefaultImg);
        }


        //保存sku
        String success = skuService.saveSkuInfo(pmsSkuInfo);

        return success;
    }

}
