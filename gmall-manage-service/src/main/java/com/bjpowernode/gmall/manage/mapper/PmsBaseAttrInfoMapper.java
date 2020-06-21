package com.bjpowernode.gmall.manage.mapper;

import com.bjpowernode.gmall.bean.PmsBaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName:PmsBaseAttrInfoMapper
 * Package:com.bjpowernode.gmall.manage.mapper
 * Description:
 *
 * @date:2020/2/12 15:24)
 * @author:Lan
 */
public interface PmsBaseAttrInfoMapper extends Mapper<PmsBaseAttrInfo> {

    //添加平台属性
    int saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
