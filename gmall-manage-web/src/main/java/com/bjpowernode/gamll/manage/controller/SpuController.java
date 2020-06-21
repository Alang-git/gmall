package com.bjpowernode.gamll.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.gmall.bean.PmsProductImage;
import com.bjpowernode.gmall.bean.PmsProductInfo;
import com.bjpowernode.gmall.bean.PmsProductSaleAttr;
import com.bjpowernode.gmall.service.SpuService;
import com.bjpowernode.gmall.util.PmsUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ClassName:SpuController
 * Package:com.bjpowernode.gamll.manage.controller
 * Description:
 *
 * @date:2020/2/14 1:14)
 * @author:Lan
 */
@Controller
@CrossOrigin
public class SpuController {


    @Reference
    private SpuService spuService;


    /**
     * 根据三级分类ID查询Spu
     * @param catalog3Id
     * @return
     */
    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(@RequestParam(required = true) String catalog3Id){

        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    /**
     * 添加Spu
     * @param pmsProductInfo
     * @return
     */
    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody(required = true) PmsProductInfo pmsProductInfo){

        String success = spuService.saveSpuInfo(pmsProductInfo);

        return success;
    }


    /**
     * 上传文件或者视频
     * @return
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "file",required = false)MultipartFile multipartFile){


        //调用方法将图片、 视频或者音频上传到文件存储服务器，并返回文件存储路径
        String imgUrl = PmsUploadUtil.uploadImage(multipartFile);

        System.out.println(imgUrl);

        return imgUrl;
    }


    @RequestMapping("/spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(@RequestParam(required = true) String spuId){

        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }

    @RequestMapping("/spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(@RequestParam(required = true) String spuId){
        List<PmsProductImage> pmsProductImages = spuService.spuImageList(spuId);

        return pmsProductImages;
    }


}
