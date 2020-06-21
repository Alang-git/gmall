package com.bjpowernode.gmall.service;

import com.bjpowernode.gmall.bean.PmsBaseAttrInfo;
import com.bjpowernode.gmall.bean.PmsBaseAttrValue;
import com.bjpowernode.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * ClassName:AttrService
 * Package:com.bjpowernode.gmall.service
 * Description:
 *
 * @date:2020/2/12 15:08)
 * @author:Lan
 */
public interface AttrService {
    //根据三级分类ID获取产品
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    //增加或修改产品属性和产品属性值
    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    //根据平台属性标识获取平台属性值
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    //查询销售字典表
    List<PmsBaseSaleAttr> baseSaleAttrList();

}
