package com.bjpowernode.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.gmall.bean.UmsMember;
import com.bjpowernode.gmall.bean.UmsMemberReceiveAddress;
import com.bjpowernode.gmall.service.UserSevice;
import com.bjpowernode.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * ClassName:UserSeviceImpl
 * Package:com.bjpowernode.gmall.user.service.impl
 * Description:
 *
 * @date:2019/12/25 14:56)
 * @author:Lan
 */
@Service
public class UserSeviceImpl implements UserSevice {

    @Autowired
    private com.bjpowernode.gmall.user.mapper.UmsMemberMapper UmsMemberMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        return UmsMemberMapper.selectAllUser();
    }

    @Override
    public List<UmsMemberReceiveAddress> getUmsMemberReceiverAddress(String memberId) {

        return umsMemberReceiveAddressMapper.selectUmsMemberReceiverAddress(memberId);
    }
}
