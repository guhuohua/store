package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.ViewLookShopInfoDTO;
import com.ch.entity.*;
import com.ch.model.ViewLookShopAddParam;
import com.ch.service.ViewLookShopService;
import com.ch.util.IdUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewLookShopServiceImpl implements ViewLookShopService {

    @Autowired
    LookShopMapper lookShopMapper;

    @Autowired
    LookShopBusinessMapper lookShopBusinessMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BusinessTypeMapper businessTypeMapper;

    @Autowired
    PropertyTypeMapper propertyTypeMapper;

    @Autowired
    ShopTypeMapper shopTypeMapper;

    @Autowired
    BsAreaMapper bsAreaMapper;

    @Autowired
    BsStreetMapper bsStreetMapper;

    @Autowired
    BsProvinceMapper bsProvinceMapper;

    @Autowired
    BsCityMapper bsCityMapper;

    @Override
    @Transactional
    public ResponseResult addLookShop(ViewLookShopAddParam param) {
        ResponseResult result = new ResponseResult();
        LookShop lookShop = new LookShop();
        modelMapper.map(param, lookShop);
        lookShop.setId(IdUtil.getId());
        lookShop.setStatus(0);
        lookShop.setMediumStatus(0);
        lookShopMapper.insert(lookShop);
        for (Long id:param.getBusinessTypeIds()) {
            LookShopBusiness lookShopBusiness = new LookShopBusiness();
            lookShopBusiness.setId(IdUtil.getId());
            lookShopBusiness.setLookShopId(lookShop.getId());
            lookShopBusiness.setBusinessTypeId(id);
            lookShopBusinessMapper.insert(lookShopBusiness);
        }
        return result;
    }

    @Override
    public ResponseResult lookShopInfo(Long id) {
        ResponseResult result = new ResponseResult();
        ViewLookShopInfoDTO viewLookShopInfoDTO = new ViewLookShopInfoDTO();
        LookShop lookShop = lookShopMapper.selectByPrimaryKey(id);
        modelMapper.map(lookShop, viewLookShopInfoDTO);
        LookShopBusinessExample lookShopBusinessExample = new LookShopBusinessExample();
        lookShopBusinessExample.createCriteria().andLookShopIdEqualTo(id);
        List<LookShopBusiness> lookShopBusinesses = lookShopBusinessMapper.selectByExample(lookShopBusinessExample);
        List<String> lookShopBusName = new ArrayList<>();
        for (LookShopBusiness lookShopBusiness:lookShopBusinesses) {
            BusinessType businessType = businessTypeMapper.selectByPrimaryKey(lookShopBusiness.getBusinessTypeId());
            if (BeanUtils.isNotEmpty(businessType)) {
                lookShopBusName.add(businessType.getBusinessType());
            }
        }
        viewLookShopInfoDTO.setBusinessType(lookShopBusName);
        PropertyType propertyType = propertyTypeMapper.selectByPrimaryKey(lookShop.getPropertyTypeId());
        if (BeanUtils.isNotEmpty(propertyType)) {
            viewLookShopInfoDTO.setPropertyType(propertyType.getPropertyType());
        }
        ShopType shopType = shopTypeMapper.selectByPrimaryKey(lookShop.getShopTypeId());
        if (BeanUtils.isNotEmpty(shopType)) {
            viewLookShopInfoDTO.setShopType(shopType.getShopType());
        }
//        BsCity bsCity = bsCityMapper.selectByPrimaryKey(lookShop.getCityId());
//        if (BeanUtils.isNotEmpty(bsCity)) {
//            viewTransferShopDTO.setCity(bsCity.getCityName());
//        }
//        BsArea bsArea = bsAreaMapper.selectByPrimaryKey(lookShop.getAreaId());
//        if (BeanUtils.isNotEmpty(bsArea)) {
//            viewTransferShopDTO.setAreaName(bsArea.getAreaName());
//        }
//        BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(lookShop.getStreetId());
//        if (BeanUtils.isNotEmpty(bsStreet)) {
//            viewTransferShopDTO.setStreet(bsStreet.getStreetName());
//        }
//        BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(lookShop.getProvinceId());
//        if (BeanUtils.isNotEmpty(bsProvince)) {
//            viewTransferShopDTO.setProvince(bsProvince.getProvinceName());
//        }
        return result;
    }
}
