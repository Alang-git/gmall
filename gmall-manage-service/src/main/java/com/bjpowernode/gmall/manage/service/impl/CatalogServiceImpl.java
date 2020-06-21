package com.bjpowernode.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.gmall.bean.PmsBaseCatalog1;
import com.bjpowernode.gmall.bean.PmsBaseCatalog2;
import com.bjpowernode.gmall.bean.PmsBaseCatalog3;
import com.bjpowernode.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.bjpowernode.gmall.manage.mapper.PmsBasecatalog2Mapper;
import com.bjpowernode.gmall.manage.mapper.PmsBasecatalog3Mapper;
import com.bjpowernode.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName:CatalogServiceImpl
 * Package:com.bjpowernode.gmall.manage.service.impl
 * Description:
 *
 * @date:2020/2/12 0:23)
 * @author:Lan
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    private PmsBasecatalog2Mapper pmsBasecatalog2Mapper;

    @Autowired
    private PmsBasecatalog3Mapper pmsBasecatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getAllCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        return pmsBasecatalog2Mapper.select(pmsBaseCatalog2);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        return pmsBasecatalog3Mapper.select(pmsBaseCatalog3);
    }
}
