package com.bjpowernode.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.gmall.bean.PmsBaseAttrInfo;
import com.bjpowernode.gmall.bean.PmsBaseAttrValue;
import com.bjpowernode.gmall.bean.PmsBaseSaleAttr;
import com.bjpowernode.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.bjpowernode.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.bjpowernode.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.bjpowernode.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ClassName:AttrServiceImpl
 * Package:com.bjpowernode.gmall.manage.service.impl
 * Description:
 *
 * @date:2020/2/12 15:14)
 * @author:Lan
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;


    /**
     * 根据三级分类ID获取产品
     * @param catalog3Id
     * @return
     */
    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        for (PmsBaseAttrInfo baseAttrInfo : pmsBaseAttrInfos) {

            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(baseAttrInfo.getId());

            List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);

            baseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }

        return pmsBaseAttrInfos;
    }


    /**
     * 增加或修改产品属性和产品属性值
     * @param pmsBaseAttrInfo
     * @return
     */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        String id = pmsBaseAttrInfo.getId();
        String result = "success";

        try {
            if (id == null){

                //id为null，新增
                    //增加产品属性
                    pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            /*
                通用mapper：insert   不管属性值是否为空或者为null，统统保存。
                            insertSelective 只保存有值的属性。没值得属性不保存
            */

                    //增加产品属性值
                    List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
                    for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                        pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());

                        pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
                    }

            }else {

                //id不为null，修改

                //修改平台属性：根据平台属性ID修改

                Example example = new Example(PmsBaseAttrValue.class);
                example.createCriteria().andEqualTo("id",id);
                pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo, example);

                //修改平台属性值：先根据平台属性ID删除，再新增。

                //先删除
                PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
                pmsBaseAttrValue.setAttrId(id);
                pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);

                //再新增
                List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
                for (PmsBaseAttrValue baseAttrValue : attrValueList) {
                    baseAttrValue.setAttrId(id);

                    pmsBaseAttrValueMapper.insertSelective(baseAttrValue);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "erro";
        }

        return result;
    }

    /**
     * 根据平台属性标识获取平台属性值
     * @param attrId
     * @return
     */
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);

        return pmsBaseAttrValues;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrMapper.selectAll();

        return pmsBaseSaleAttrs;
    }

}
