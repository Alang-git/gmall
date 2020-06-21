package com.bjpowernode.gmall.service;



import com.bjpowernode.gmall.bean.UmsMember;
import com.bjpowernode.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * ClassName:UserSevice
 * Package:com.bjpowernode.gmall.user.service
 * Description:
 *
 * @date:2019/12/25 14:55)
 * @author:Lan
 */

public interface UserSevice {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getUmsMemberReceiverAddress(String memberId);

}
