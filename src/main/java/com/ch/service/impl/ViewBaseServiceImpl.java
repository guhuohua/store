package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.entity.*;
import com.ch.service.ViewBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewBaseServiceImpl implements ViewBaseService {

    @Autowired
    BusinessTypeMapper businessTypeMapper;

    @Autowired
    BsProvinceMapper bsProvinceMapper;

    @Autowired
    BsCityMapper bsCityMapper;

    @Autowired
    BsAreaMapper bsAreaMapper;

    @Autowired
    BsStreetMapper bsStreetMapper;

    @Autowired
    ShopRentTypeMapper shopRentTypeMapper;

    @Autowired
    ShopTypeMapper shopTypeMapper;

    @Autowired
    PropertyTypeMapper propertyTypeMapper;

    @Autowired
    OrientationMapper orientationMapper;

    @Autowired
    LoopLineMapper loopLineMapper;

    @Autowired
    SubwayLineMapper subwayLineMapper;

    @Override
    public ResponseResult businessTypeList() {
        ResponseResult result = new ResponseResult();
        List<BusinessType> businessTypes = businessTypeMapper.selectByExample(null);
        result.setData(businessTypes);
        return result;
    }

    @Override
    public ResponseResult provinceList() {
        ResponseResult result = new ResponseResult();
        BsProvinceExample bsProvinceExample = new BsProvinceExample();
        bsProvinceExample.setOrderByClause("sort");
        List<BsProvince> bsProvinces = bsProvinceMapper.selectByExample(bsProvinceExample);
        result.setData(bsProvinces);
        return result;
    }

    @Override
    public ResponseResult findCityByProvinceCode(String code) {
        ResponseResult result = new ResponseResult();
        BsCityExample bsCityExample = new BsCityExample();
        bsCityExample.setOrderByClause("sort");
        bsCityExample.createCriteria().andProvinceCodeEqualTo(code);
        List<BsCity> bsCities = bsCityMapper.selectByExample(bsCityExample);
        result.setData(bsCities);
        return result;
    }

    @Override
    public ResponseResult findAreaByCityCode(String code) {
        ResponseResult result = new ResponseResult();
        BsAreaExample bsAreaExample = new BsAreaExample();
        bsAreaExample.setOrderByClause("sort");
        bsAreaExample.createCriteria().andCityCodeEqualTo(code);
        List<BsArea> bsAreas = bsAreaMapper.selectByExample(bsAreaExample);
        result.setData(bsAreas);
        return result;
    }

    @Override
    public ResponseResult findStweetByAreaCode(String code) {
        ResponseResult result = new ResponseResult();
        BsStreetExample bsStreetExample = new BsStreetExample();
        bsStreetExample.setOrderByClause("sort");
        bsStreetExample.createCriteria().andAreaCodeEqualTo(code);
        List<BsStreet> bsStreets = bsStreetMapper.selectByExample(bsStreetExample);
        result.setData(bsStreets);
        return result;
    }

    @Override
    public ResponseResult shopRentTypeList() {
        ResponseResult result = new ResponseResult();
        List<ShopRentType> shopRentTypes = shopRentTypeMapper.selectByExample(null);
        result.setData(shopRentTypes);
        return result;
    }

    @Override
    public ResponseResult shopTypeList() {
        ResponseResult result = new ResponseResult();
        List<ShopType> shopTypes = shopTypeMapper.selectByExample(null);
        result.setData(shopTypes);
        return result;
    }

    @Override
    public ResponseResult propertyTypeList() {
        ResponseResult result = new ResponseResult();
        List<PropertyType> propertyTypes = propertyTypeMapper.selectByExample(null);
        result.setData(propertyTypes);
        return result;
    }

    @Override
    public ResponseResult orientation() {
        ResponseResult result = new ResponseResult();
        List<Orientation> orientations = orientationMapper.selectByExample(null);
        result.setData(orientations);
        return result;
    }

    @Override
    public ResponseResult lookLineList() {
        ResponseResult result = new ResponseResult();
        List<LoopLine> loopLines = loopLineMapper.selectByExample(null);
        result.setData(loopLines);
        return result;
    }

    @Override
    public ResponseResult subwayLineList() {
        ResponseResult result = new ResponseResult();
        List<SubwayLine> subwayLines = subwayLineMapper.selectByExample(null);
        result.setData(subwayLines);
        return result;
    }
}
