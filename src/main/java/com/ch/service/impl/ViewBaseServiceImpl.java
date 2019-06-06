package com.ch.service.impl;

import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.entity.*;
import com.ch.model.ViewWXLoginParam;
import com.ch.service.ViewBaseService;
import com.ch.util.IdUtil;
import com.ch.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    DecorateTypeMapper decorateTypeMapper;

    @Autowired
    AdvertMapper advertMapper;

    @Autowired
    ClientMapper clientMapper;

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

    @Override
    public ResponseResult decorateType() {
        ResponseResult result = new ResponseResult();
        List<DecorateType> decorateTypes = decorateTypeMapper.selectByExample(null);
        result.setData(decorateTypes);
        return result;
    }

    @Override
    public ResponseResult advert() {
        ResponseResult result = new ResponseResult();
        AdvertExample advertExample = new AdvertExample();
        advertExample.createCriteria().andStatusEqualTo(1);
        List<Advert> adverts = advertMapper.selectByExample(advertExample);
        result.setData(adverts);
        return result;
    }

    @Override
    public ResponseResult wxLogin(ViewWXLoginParam param) {
        ResponseResult result = new ResponseResult();
        ClientExample clientExample = new ClientExample();
        clientExample.createCriteria().andOpenIdEqualTo(param.getOpenId());
        List<Client> clients = clientMapper.selectByExample(clientExample);
        if (clients.size() > 0) {
            Client client = clients.stream().findFirst().get();
            result.setData(TokenUtil.sign(client.getId().intValue()));
            client.setQuitTime(new Date());
            clientMapper.updateByPrimaryKey(client);
        } else {
            Client client = new Client();
            client.setId(IdUtil.getId());
            client.setNickName(param.getNickName());
            client.setHeader(param.getHeader());
            client.setGender(param.getGender());
            client.setOpenId(param.getOpenId());
            client.setSuccessCount(0);
            client.setQuitTime(new Date());
            client.setCollectCount(0);
            client.setTransferCount(0);
            client.setSearchAreaCount(0);
            client.setBrowseCount(0);
            clientMapper.insert(client);
            result.setData(TokenUtil.sign(client.getId().intValue()));
        }
        return result;
    }
}
