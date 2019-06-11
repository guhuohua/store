/**
 * Author: 常富文
 * Date:   2019/6/5 14:30
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.ShowShopDto;

import com.ch.dto.ViewLookShopInfoDTO;
import com.ch.entity.*;
import com.ch.service.SysLookShopService;
import com.ch.service.ViewLookShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysLookShopServiceImpl implements SysLookShopService {

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

    @Autowired
    DecorateTypeMapper decorateTypeMapper;
    @Autowired
    ViewLookShopService viewLookShopService;


    @Override
    public ResponseResult showLookShopList(ShowShopDto showShopDto) {
        ResponseResult result = new ResponseResult();
        List<ViewLookShopInfoDTO> viewLookShopInfoDTOs = new ArrayList<>();
        PageHelper.startPage(showShopDto.getPageNum(), showShopDto.getPageSize());
        if (BeanUtils.isNotEmpty(showShopDto.getContacts()) || BeanUtils.isNotEmpty(showShopDto.getTel()) || BeanUtils.isNotEmpty(showShopDto.getStatus())){
             viewLookShopInfoDTOs = lookShopMapper.list(showShopDto.getContacts(),showShopDto.getTel(),showShopDto.getStatus());
        }else {
           viewLookShopInfoDTOs = lookShopMapper.findAll();
        }


        /* List<ViewLookShopInfoDTO> viewLookShopInfoDTOs = new ArrayList<>();
        for (LookShop lookShop : LookShops) {
            ResponseResult result1 = viewLookShopService.lookShopInfo(lookShop.getId());
            ViewLookShopInfoDTO data =(ViewLookShopInfoDTO) result1.getData();
            viewLookShopInfoDTOs.add(data);
        }*/
        PageInfo<ViewLookShopInfoDTO> page = new PageInfo<>(viewLookShopInfoDTOs);
        result.setData(page);
        return result;
    }

    @Override
    public ResponseResult lookShopInfo(Long id) {
        ResponseResult result = new ResponseResult();
        ViewLookShopInfoDTO viewLookShopInfoDTO = new ViewLookShopInfoDTO();
        LookShop lookShop = lookShopMapper.selectByPrimaryKey(id);
        viewLookShopInfoDTO.setUsername(lookShop.getContacts());
        modelMapper.map(lookShop, viewLookShopInfoDTO);
        viewLookShopInfoDTO.setUsername(lookShop.getContacts());
        LookShopBusinessExample lookShopBusinessExample = new LookShopBusinessExample();
        lookShopBusinessExample.createCriteria().andLookShopIdEqualTo(id);
        List<LookShopBusiness> lookShopBusinesses = lookShopBusinessMapper.selectByExample(lookShopBusinessExample);
        List<String> lookShopBusName = new ArrayList<>();
        StringBuilder type = new StringBuilder();
        for (LookShopBusiness lookShopBusiness:lookShopBusinesses) {
            BusinessType businessType = businessTypeMapper.selectByPrimaryKey(lookShopBusiness.getBusinessTypeId());
            if (BeanUtils.isNotEmpty(businessType)) {
                lookShopBusName.add(businessType.getBusinessType());
                type.append(businessType.getBusinessType()+",");
            }
        }
        viewLookShopInfoDTO.setBusinessType(type.toString());
        //viewLookShopInfoDTO.setBusinessTypes(lookShopBusName);
        PropertyType propertyType = propertyTypeMapper.selectByPrimaryKey(lookShop.getPropertyTypeId());
        if (BeanUtils.isNotEmpty(propertyType)) {
            viewLookShopInfoDTO.setPropertyType(propertyType.getPropertyType());
        }
        ShopType shopType = shopTypeMapper.selectByPrimaryKey(lookShop.getShopTypeId());
        if (BeanUtils.isNotEmpty(shopType)) {
            viewLookShopInfoDTO.setShopType(shopType.getShopType());
        }
        BsCity bsCity = bsCityMapper.selectByPrimaryKey(lookShop.getCityId());
        if (BeanUtils.isNotEmpty(bsCity)) {
            viewLookShopInfoDTO.setCity(bsCity.getCityName());
        }
        BsArea bsArea = bsAreaMapper.selectByPrimaryKey(lookShop.getAreaId());
        if (BeanUtils.isNotEmpty(bsArea)) {
            viewLookShopInfoDTO.setArea(bsArea.getAreaName());
        }
        BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(lookShop.getStreetId());
        if (BeanUtils.isNotEmpty(bsStreet)) {
            viewLookShopInfoDTO.setStreet(bsStreet.getStreetName());
        }
        BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(lookShop.getProvinceId());
        if (BeanUtils.isNotEmpty(bsProvince)) {
            viewLookShopInfoDTO.setProvince(bsProvince.getProvinceName());
        }
        DecorateType decorateType = decorateTypeMapper.selectByPrimaryKey(lookShop.getDecorateTypeId());
        if (BeanUtils.isNotEmpty(decorateType)) {
            viewLookShopInfoDTO.setDecorateType(decorateType.getDecorateType());
        }
        result.setData(viewLookShopInfoDTO);
        return result;
    }

}
