package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.IconMapper;
import com.ch.entity.Icon;
import com.ch.entity.IconExample;
import com.ch.service.ViewIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewIconServiceImpl implements ViewIconService {

    @Autowired
    IconMapper iconMapper;

    @Override
    public ResponseResult iconList() {
        ResponseResult result = new ResponseResult();
        IconExample iconExample = new IconExample();
        iconExample.createCriteria().andStatusEqualTo(1);
        List<Icon> icons = iconMapper.selectByExample(iconExample);
        result.setData(icons);
        return result;
    }
}
