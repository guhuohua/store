//
//package com.ch.ch;
//
//import com.alibaba.fastjson.JSON;
//import com.ch.base.ResponseResult;
//import com.ch.dao.LookShopMapper;
//import com.ch.dao.SysUserMapper;
//import com.ch.dao.TransferShopMapper;
//import com.ch.dao.WangMapper;
//import com.ch.service.UploadService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ChApplicationTests {
//
//    @Autowired
//    TransferShopMapper transferShopMapper;
//    @Autowired
//    WangMapper wangMapper;
//    @Autowired
//    LookShopMapper lookShopMapper;
//    @Autowired
//    SysUserMapper sysUserMapper;
//
//    @Autowired
//    UploadService uploadService;
//
//
//
//    @Test
//    public void testUploadImage(){
//        ResponseResult result = uploadService.uploadAddress("/Users/changhan/Downloads/937626DDEC847DB3040A2E7D069F222A.jpg");
//        System.out.println(JSON.toJSON(result));
//
//    }
//
//
//
//
//}
//
//
