package com.bjpowernode.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.gmall.bean.PmsSkuAttrValue;
import com.bjpowernode.gmall.bean.PmsSkuImage;
import com.bjpowernode.gmall.bean.PmsSkuInfo;
import com.bjpowernode.gmall.bean.PmsSkuSaleAttrValue;
import com.bjpowernode.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.bjpowernode.gmall.manage.mapper.PmsSkuImageMapper;
import com.bjpowernode.gmall.manage.mapper.PmsSkuInfoMapper;
import com.bjpowernode.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.bjpowernode.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName:SkuServiceImpl
 * Package:com.bjpowernode.gmall.manage.service.impl
 * Description:
 *
 * @date:2020/2/18 0:59)
 * @author:Lan
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public String saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        String success = "success";

        try {
            //保存商品sku详细信息
            int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
            String skuId = pmsSkuInfo.getId();

            //保存平台属性关联
            List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
            for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
                pmsSkuAttrValue.setSkuId(skuId);

                pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
            }

            //保存销售属性关联
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                pmsSkuSaleAttrValue.setSkuId(skuId);

                pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);

            }

            //保存图片
            List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
            for (PmsSkuImage pmsSkuImage : skuImageList) {
                pmsSkuImage.setSkuId(skuId);
                pmsSkuImageMapper.insertSelective(pmsSkuImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = "erro";
        }finally {

            return success;

        }

    }

    @Override
    public PmsSkuInfo getSkuById(String skuId) {

        //获取商品对象
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);

        PmsSkuInfo skuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfo);

        //获取商品图片
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> pmsSkuImages = pmsSkuImageMapper.select(pmsSkuImage);

        skuInfo.setSkuImageList(pmsSkuImages);

        return skuInfo;
    }
}