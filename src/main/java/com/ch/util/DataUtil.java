package com.ch.util;

import com.ch.dao.LookShopMapper;
import com.ch.dao.SysUserMapper;
import com.ch.dao.TransferShopMapper;
import com.ch.dao.WangMapper;
import com.ch.entity.TransferShop;
import com.ch.entity.Wang;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {
    @Autowired
    TransferShopMapper transferShopMapper;
    @Autowired
    WangMapper wangMapper;
    @Autowired
    LookShopMapper lookShopMapper;
    @Autowired
    SysUserMapper sysUserMapper;


    public void testUploadImage() {
        List<Wang> wangs = wangMapper.selectByExample(null);
        for (Wang wang : wangs) {
            TransferShop transferShop = new TransferShop();
            transferShop.setId(IdUtil.getId());
            transferShop.setTitle(wang.getTitle());
            String rent = wang.getRent();
            String area = wang.getArea();
            String floor = wang.getFloor();
            String regEx = "[^0-9]";

            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(rent);
            Matcher m1 = p.matcher(area);
            transferShop.setRent(Long.valueOf(m.replaceAll("")));
            transferShop.setArea(Integer.valueOf(m1.replaceAll("")));
            transferShop.setFloorNumber(Integer.valueOf(floor.substring(0, 1)));
            transferShop.setAddress(wang.getAddress());
            transferShop.setContacts(wang.getName().substring(0, wang.getName().length() - 2));
            transferShop.setTel(wang.getTel());
            String category = wang.getCategory();
            String[] split = category.split("、");
            Matcher m3 = p.matcher(split[0]);
            Matcher m4 = p.matcher(split[1]);
            Matcher m5 = p.matcher(split[2]);
            transferShop.setGateWidth(Long.valueOf(m3.replaceAll("")));
            transferShop.setDepth(Integer.valueOf(m4.replaceAll("")));
            transferShop.setHigh(Integer.valueOf(m5.replaceAll("")));

        }

    }
}
