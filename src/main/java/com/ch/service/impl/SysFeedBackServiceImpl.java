package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.FeedBackMapper;
import com.ch.dto.SysBaseDTO;
import com.ch.entity.FeedBack;
import com.ch.service.SysFeedBackService;
import com.ch.util.DeteUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysFeedBackServiceImpl implements SysFeedBackService {


    @Autowired
    FeedBackMapper feedBackMapper;


    @Override
    public ResponseResult list(SysBaseDTO sysBaseDTO) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(sysBaseDTO.getPageNum(), sysBaseDTO.getPageSize());
        List<FeedBack> feedBacks = feedBackMapper.selectByExample(null);
        for (FeedBack feedBack : feedBacks) {
            feedBack.setForMatTime(DeteUtil.forMat(feedBack.getCreateDate()));
        }
        PageInfo<FeedBack> page = new PageInfo<>(feedBacks);
        result.setData(page);
        return result;
    }


    @Override
    public ResponseResult dele(Long id) {
        ResponseResult result = new ResponseResult();
        feedBackMapper.deleteByPrimaryKey(id);
        return result;
    }
}
