package com.bjpowernode.gmall.user.web.controller;


import com.bjpowernode.gmall.bean.UmsMember;
import com.bjpowernode.gmall.bean.UmsMemberReceiveAddress;
import com.bjpowernode.gmall.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName:UserController
 * Package:com.bjpowernode.gmall.user.controller
 * Description:
 *
 * @date:2019/12/25 14:47)
 * @author:Lan
 */
@Controller
public class UserController {

    @Autowired
    private UserSevice userSevice;

    @RequestMapping("index")
    public @ResponseBody String index(){
        return "Hello World";
    }

    //查询所有用户信息
    @RequestMapping("getAllUser")
    public @ResponseBody List<UmsMember> getAllUser(){

        List<UmsMember> umsMemberList = userSevice.getAllUser();

        return umsMemberList;
    }

    @RequestMapping("getUmsMemberReceiverAddress")
    public @ResponseBody List<UmsMemberReceiveAddress> getUmsMemberReceiverAddress(String memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList = userSevice.getUmsMemberReceiverAddress(memberId);

        return umsMemberReceiveAddressList;
    }



}
