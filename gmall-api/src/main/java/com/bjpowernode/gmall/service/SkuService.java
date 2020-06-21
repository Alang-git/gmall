package com.bjpowernode.gmall.service;

import com.bjpowernode.gmall.bean.PmsSkuInfo;

/**
 * ClassName:SkuService
 * Package:com.bjpowernode.gmall.service
 * Description:
 *
 * @date:2020/2/18 0:58)
 * @author:Lan
 */
public interface SkuService {
    String saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    //根据skuId查Sku
    PmsSkuInfo getSkuById(String skuId);
}
