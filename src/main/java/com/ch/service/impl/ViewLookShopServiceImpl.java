package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.SolrDTO;
import com.ch.dto.ViewLookShopInfoDTO;
import com.ch.dto.ViewMyLookShopDTO;
import com.ch.entity.*;
import com.ch.model.ViewLookShopAddParam;
import com.ch.service.SolrService;
import com.ch.service.ViewLookShopService;
import com.ch.util.GetLatAndLngByBaidu;
import com.ch.util.IdUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    DecorateTypeMapper decorateTypeMapper;

    @Autowired
    FastLookShopMapper fastLookShopMapper;

    @Autowired
    SolrService solrService;

    @Autowired
    ShopRentTypeMapper shopRentTypeMapper;

    @Autowired
    ClientMapper clientMapper;

    @Override
    @Transactional
    public ResponseResult addLookShop(ViewLookShopAddParam param, Long userId) {
        ResponseResult result = new ResponseResult();
        LookShop lookShop = new LookShop();
        List<String> coordinate = GetLatAndLngByBaidu.getCoordinate(param.getAddress());
        if (BeanUtils.isEmpty(coordinate)) {
            result.setCode(600);
            result.setError("获取不到该地址的经纬度");
            result.setError_description("获取不到该地址的经纬度");
            return result;
        }
        lookShop.setLongitude(coordinate.get(0));
        lookShop.setLatitude(coordinate.get(1));
        lookShop.setId(IdUtil.getId());
        lookShop.setCityId(param.getCityId());
        lookShop.setClientId(userId);
        lookShop.setTel(param.getTel());
        lookShop.setPropertyTypeId(param.getPropertyTypeId());
        lookShop.setShopTypeId(param.getShopTypeId());
        lookShop.setSmallRent(param.getSmallRent());
        lookShop.setTopRent(param.getTopRent());
        lookShop.setSmallArea(param.getSmallArea());
        lookShop.setTopArea(param.getTopArea());
        lookShop.setTransferStatus(param.getTransferStatus());
        lookShop.setTitle(param.getTitle());
        lookShop.setCityId(param.getCityId());
        lookShop.setDecorateTypeId(param.getDecorateTypeId());
        lookShop.setRequirementDetails(param.getRequirementDetails());
        lookShop.setAccessoryRequirements(param.getAccessoryRequirements());
        lookShop.setGateWidth(param.getGateWidth());
        lookShop.setShopRentTypeId(param.getShopRentTypeId());
        lookShop.setServiceType(param.getServiceType());
        lookShop.setMediumStatus(0);
        lookShop.setShopReadme(param.getShopReadme());
        lookShop.setFloor(param.getFloor());
        lookShop.setOrientationId(param.getOrientationId());
        lookShop.setLoopLineId(param.getLoopLineId().toString());
        lookShop.setSubwayLineId(param.getSubwayLineId().toString());
        lookShop.setUpdateTime(new Date());
        lookShop.setCraeateTime(new Date());
        lookShop.setAreaId(param.getAreaId());
        lookShop.setStreetId(param.getStreetId());
        lookShop.setProvinceId(param.getProvinceId());
        lookShop.setAddress(param.getAddress());
        lookShop.setContacts(param.getContacts());
        lookShop.setShopRentTypeId(param.getShopRentTypeId());
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
        SolrDTO solrDTO = new SolrDTO();
        solrDTO.setLookShopId(lookShop.getId());
        solrService.addSolr(solrDTO);
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
        for (LookShopBusiness lookShopBusiness:lookShopBusinesses) {
            BusinessType businessType = businessTypeMapper.selectByPrimaryKey(lookShopBusiness.getBusinessTypeId());
            if (BeanUtils.isNotEmpty(businessType)) {
                lookShopBusName.add(businessType.getBusinessType());
            }
        }
        viewLookShopInfoDTO.setBusinessTypes(lookShopBusName);
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
        ShopRentType shopRentType = shopRentTypeMapper.selectByPrimaryKey(lookShop.getShopRentTypeId());
        if (BeanUtils.isNotEmpty(shopRentType)) {
            viewLookShopInfoDTO.setShopRentType(shopRentType.getShopRentType());
        }

        Client client = clientMapper.selectByPrimaryKey(Long.valueOf(lookShop.getClientId()));
        if (BeanUtils.isNotEmpty(client)) {
            viewLookShopInfoDTO.setHeadImg(client.getHeader());
        }
        result.setData(viewLookShopInfoDTO);
        return result;
    }

    @Override
    public ResponseResult myLookShopList(Long id) {
        ResponseResult result = new ResponseResult();
        LookShopExample lookShopExample = new LookShopExample();
        lookShopExample.createCriteria().andClientIdEqualTo(id);
        List<LookShop> lookShops = lookShopMapper.selectByExample(lookShopExample);
        List<ViewMyLookShopDTO> viewMyLookShopDTOS = new ArrayList<>();
        for (LookShop lookShop:lookShops) {
            ViewMyLookShopDTO viewMyLookShopDTO = new ViewMyLookShopDTO();
            viewMyLookShopDTO.setId(lookShop.getId());
            viewMyLookShopDTO.setTitle(lookShop.getTitle());
            viewMyLookShopDTO.setMaxArea(lookShop.getTopArea());
            viewMyLookShopDTO.setMinArea(lookShop.getSmallArea());
            viewMyLookShopDTO.setMaxPrice(lookShop.getTopRent());
            viewMyLookShopDTO.setMinPrice(lookShop.getSmallRent());
            BsArea bsArea = bsAreaMapper.selectByPrimaryKey(lookShop.getAreaId());
            StringBuffer stringBuffer = new StringBuffer();
            if (BeanUtils.isNotEmpty(bsArea)) {
                stringBuffer.append(bsArea.getAreaName());
            }
            BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(lookShop.getStreetId());
            if (BeanUtils.isNotEmpty(bsStreet)) {
                stringBuffer.append("-").append(bsStreet.getStreetName());
            }
            viewMyLookShopDTO.setAddress(stringBuffer.toString());
            Client client = clientMapper.selectByPrimaryKey(Long.valueOf(lookShop.getClientId()));
            if (BeanUtils.isNotEmpty(client)) {
                viewMyLookShopDTO.setName(lookShop.getContacts());
                viewMyLookShopDTO.setHeadImg(client.getHeader());
            }
            String format = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(lookShop.getCraeateTime());
            viewMyLookShopDTO.setCreateTime(format);
            viewMyLookShopDTOS.add(viewMyLookShopDTO);
        }
        result.setData(viewMyLookShopDTOS);
        return result;
    }
}
