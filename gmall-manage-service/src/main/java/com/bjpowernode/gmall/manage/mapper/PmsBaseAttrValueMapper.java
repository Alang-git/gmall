package com.bjpowernode.gmall.manage.mapper;

import com.bjpowernode.gmall.bean.PmsBaseAttrValue;
import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName:PmsBaseAttrValueMapper
 * Package:com.bjpowernode.gmall.manage.mapper
 * Description:
 *
 * @date:2020/2/12 16:58)
 * @author:Lan
 */
public interface PmsBaseAttrValueMapper extends Mapper<PmsBaseAttrValue> {

    //添加平台属性值
    int saveAttrValue(PmsBaseAttrValue pmsBaseAttrValue);
}
