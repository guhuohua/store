//
//package com.ch.ch;
//
//import com.alibaba.fastjson.JSON;
//import com.ch.base.ResponseResult;
//import com.ch.dao.*;
//import com.ch.service.UploadService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
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
//    @Autowired
//    CommerciaEstatMapper commerciaEstatMapper;
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
//    @Test
//    public void testUploadImag1e(){
//        for (int i = 0; i <1200 ; i++) {
//            int random=(int)(Math.random()*10+1);
//            System.out.println(random);
//        }
//
//
//    }
//
//
//    @Test
//    public void testUploadImage2(){
//        //ResponseResult result = uploadService.uploadAddress("/Users/changhan/Downloads/937626DDEC847DB3040A2E7D069F222A.jpg");
//        //System.out.println(JSON.toJSON(result));
//        List<String> category = commerciaEstatMapper.findCategory();
//        for (String s : category) {
//            if (s.length()>4){
//                String[] split = s.split("、");
//                String s1 = split[1];
//                String trim = s1.trim();
//                //System.out.println(trim);
//                String substring = trim.substring(2, trim.length() - 1);
//                double v = Float.parseFloat(substring);
//
//                int floor =(int) Math.floor(v);
//                System.out.println(floor);
//
//
//            }else {
//                System.out.println(0);
//            }
//        }
//
//
//
//    }
//}


