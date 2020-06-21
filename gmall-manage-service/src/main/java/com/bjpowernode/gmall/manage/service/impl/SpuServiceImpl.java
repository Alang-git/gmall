package com.bjpowernode.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.gmall.bean.PmsProductImage;
import com.bjpowernode.gmall.bean.PmsProductInfo;
import com.bjpowernode.gmall.bean.PmsProductSaleAttr;
import com.bjpowernode.gmall.bean.PmsProductSaleAttrValue;
import com.bjpowernode.gmall.manage.mapper.PmsProductIfoMapper;
import com.bjpowernode.gmall.manage.mapper.PmsProductImageMapper;
import com.bjpowernode.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.bjpowernode.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.bjpowernode.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName:SpuServiceImpl
 * Package:com.bjpowernode.gmall.manage.service.impl
 * Description:
 *
 * @date:2020/2/14 1:19)
 * @author:Lan
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductIfoMapper pmsProductIfoMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    /**
     * 根据三级分类ID查询Spu
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);

        List<PmsProductInfo> pmsProductInfos = pmsProductIfoMapper.select(pmsProductInfo);

        return pmsProductInfos;
    }

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {

        String success = "success";
        try {
            //保存商品信息
            pmsProductIfoMapper.insertSelective(pmsProductInfo);

            //生成商品主键
            String productId = pmsProductInfo.getId();

            //保存商品图片信息
            List<PmsProductImage> pmsProductImageList = pmsProductInfo.getSpuImageList();
            for (PmsProductImage pmsProductImage : pmsProductImageList) {
                pmsProductImage.setProductId(productId);

                pmsProductImageMapper.insertSelective(pmsProductImage);
            }


            //保存商品销售属性
            List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
            for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrList) {
                pmsProductSaleAttr.setProductId(productId);
                pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);


                //保存商品销售属性值
                List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
                for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttrValueList) {
                    pmsProductSaleAttrValue.setProductId(productId);
                    pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = "erro";
        }


        return success;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {

        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);

        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);

        for (PmsProductSaleAttr productSaleAttr : pmsProductSaleAttrs) {


            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());

            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);

            productSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }

        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);

        List<PmsProductImage> pmsProductImages = pmsProductImageMapper.select(pmsProductImage);
        return pmsProductImages;
    }

}
