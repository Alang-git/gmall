package com.bjpowernode.gmall.service;

import com.bjpowernode.gmall.bean.PmsBaseCatalog1;
import com.bjpowernode.gmall.bean.PmsBaseCatalog2;
import com.bjpowernode.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * ClassName:CatalogService
 * Package:com.bjpowernode.gmall.service
 * Description:
 *
 * @date:2020/2/12 0:23)
 * @author:Lan
 */

public interface CatalogService {
    //获取一级分类信息
    List<PmsBaseCatalog1> getAllCatalog1();

    //获取二级分类信息
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    //获取三级分类信息
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
