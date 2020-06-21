package com.bjpowernode.gmall.service;

import com.bjpowernode.gmall.bean.PmsProductImage;
import com.bjpowernode.gmall.bean.PmsProductInfo;
import com.bjpowernode.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * ClassName:SpuService
 * Package:com.bjpowernode.gmall.service
 * Description:
 *
 * @date:2020/2/14 1:19)
 * @author:Lan
 */
public interface SpuService {

    //根据三级分类ID查询Spu
    List<PmsProductInfo> spuList(String catalog3Id);

    //添加Spu
    String saveSpuInfo(PmsProductInfo pmsProductInfo);

    //根据商品spuID查询商品Spu
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    //根据商品spuID查询商品图片信息
    List<PmsProductImage> spuImageList(String spuId);
}
