package com.bjpowernode.gmall.user.mapper;

import com.bjpowernode.gmall.bean.UmsMember;

import java.util.List;

public interface UmsMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);

    //查询所有的用户信息
    List<UmsMember> selectAllUser();
}