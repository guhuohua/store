package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.*;
import com.ch.entity.*;
import com.ch.model.FastTransferShopParam;
import com.ch.model.ViewTransferShopListParam;
import com.ch.model.ViewTransferShopParam;
import com.ch.service.SolrService;
import com.ch.service.ViewTransferShopService;
import com.ch.util.GetLatAndLngByBaidu;
import com.ch.util.IdUtil;
import com.github.pagehelper.PageHelper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ViewTransferShopServiceImpl implements ViewTransferShopService {

    @Autowired
    TransferShopMapper transferShopMapper;

    @Autowired
    TransferImageMapper transferImageMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SolrClient solrClient;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    BusinessTypeMapper businessTypeMapper;

    @Autowired
    PropertyTypeMapper propertyTypeMapper;

    @Autowired
    ShopTypeMapper shopTypeMapper;

    @Autowired
    BsCityMapper bsCityMapper;

    @Autowired
    DecorateTypeMapper decorateTypeMapper;

    @Autowired
    OrientationMapper orientationMapper;

    @Autowired
    LoopLineMapper loopLineMapper;

    @Autowired
    SubwayLineMapper subwayLineMapper;

    @Autowired
    BsAreaMapper bsAreaMapper;

    @Autowired
    BsStreetMapper bsStreetMapper;

    @Autowired
    BsProvinceMapper bsProvinceMapper;

    @Autowired
    TransferShopBusinessMapper transferShopBusinessMapper;

    @Autowired
    FastTransferShopMapper fastTransferShopMapper;

    @Autowired
    ShopRentTypeMapper shopRentTypeMapper;

    @Autowired
    HouseCollectMapper houseCollectMapper;

    @Autowired
    SolrService solrService;

    @Autowired
    TransferShopBaseIconMapper transferShopBaseIconMapper;

    @Autowired
    TransferIconMapper transferIconMapper;

    @Override
    @Transactional
    public ResponseResult  addTransferShop(ViewTransferShopParam param, Long userId) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = new TransferShop();
        StringBuffer sb = new StringBuffer();
        BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(param.getProvinceId());
        if (BeanUtils.isNotEmpty(bsProvince)) {
            sb.append(bsProvince.getProvinceName());
        }
        BsCity bsCity = bsCityMapper.selectByPrimaryKey(param.getCityId());
        if (BeanUtils.isNotEmpty(bsCity)) {
            sb.append(bsCity.getCityName());
        }
        BsArea bsArea = bsAreaMapper.selectByPrimaryKey(param.getAreaId());
        if (BeanUtils.isNotEmpty(bsArea)) {
            sb.append(bsArea.getAreaName());
        }
        sb.append(param.getAddress());

        List<String> coordinate = GetLatAndLngByBaidu.getCoordinate(sb.toString());
        if (BeanUtils.isEmpty(coordinate.get(0)) && BeanUtils.isEmpty(coordinate.get(1))) {
            result.setCode(600);
            result.setError("获取不到该地址的经纬度");
            result.setError_description("获取不到该地址的经纬度");
            return result;
        }
        transferShop.setLon(coordinate.get(0));
        transferShop.setLat(coordinate.get(1));
        transferShop.setId(IdUtil.getId());
        transferShop.setClientId(userId);
        transferShop.setTel(param.getTel());
        transferShop.setImage(param.getImage());
        transferShop.setUpdateTime(new Date());
        transferShop.setRecommendType(0);
        transferShop.setAreaId(param.getAreaId());
        transferShop.setStreetId(param.getStreetId());
        transferShop.setProvinceId(param.getProvinceId());
        transferShop.setAddress(param.getAddress());
        transferShop.setContacts(param.getContacts());
        transferShop.setStatus(0);
        transferShop.setCreateTime(new Date());
        transferShop.setCheckStatus(2);
        transferShop.setPublishedTime(new Date());
        transferShop.setFakeTel("15629013877");
        transferShop.setShopSn((IdUtil.getId() + 1) + "");
        transferShop.setTitle(param.getTitle());
        transferShop.setCityId(param.getCityId());

        transferShop.setPropertyTypeId(param.getPropertyTypeId());
        transferShop.setShopTypeId(param.getShopTypeId());
        transferShop.setRent(param.getRent());
        transferShop.setArea(param.getArea());
        transferShop.setTransferStatus(param.getTransferStatus());
        transferShop.setDecorateTypeId(param.getDecorateTypeId());
        transferShop.setRequirementDetails(param.getRequirementDetails());
        transferShop.setAccessoryRequirements(param.getAccessoryRequirements());
        transferShop.setGateWidth(param.getGateWidth());
        transferShop.setTransferFee(param.getTransferFee());
        transferShop.setShopSn(IdUtil.getId() + "");
        transferShop.setServiceType(param.getServiceType());
        transferShop.setMediumStatus(0);
        transferShop.setShopReadme(param.getShopReadme());
        transferShop.setFloorNumber(param.getFloorNumber());
        transferShop.setOrientationId(param.getOrientationId());
        transferShop.setLoopLineId(param.getLoopLineId());
        transferShop.setSubwayLineId(param.getSubwayLineId());
        transferShop.setShopRentTypeId(param.getShopRentTypeId());
        transferShop.setHigh(param.getHigh());
        transferShop.setDepth(param.getDepth());
        transferShopMapper.insert(transferShop);
        if (BeanUtils.isNotEmpty(param.getTransferShopBaseIcons()) && param.getTransferShopBaseIcons().size() > 0) {
            for (TransferShopBaseIcon transferShopBaseIcon:param.getTransferShopBaseIcons()) {
                transferShopBaseIcon.setId(IdUtil.getId());
                transferShopBaseIcon.setTransferShopId(transferShop.getId());
                transferShopBaseIconMapper.insert(transferShopBaseIcon);
            }
        }
        List<TransferImage> transferImages = param.getTransferImages();
        for (TransferImage transferImage : transferImages) {
            transferImage.setId(IdUtil.getId());
            transferImage.setTransferShopId(transferShop.getId().toString());
            transferImageMapper.insert(transferImage);
        }
        for (Long id : param.getBusinessTypeIds()) {
            TransferShopBusiness transferShopBusiness = new TransferShopBusiness();
            transferShopBusiness.setId(IdUtil.getId());
            transferShopBusiness.setBusinessTypeId(id);
            transferShopBusiness.setTransferShopId(transferShop.getId());
            transferShopBusinessMapper.insert(transferShopBusiness);
        }
        result.setData(transferShop.getId());
        return result;
    }

    @Override
    public ResponseResult transferShopList(ViewTransferShopListParam param) {
        ResponseResult result = new ResponseResult();
        int start = (param.getStart() - 1) * param.getRows();
        SolrQuery solrQuery = new SolrQuery();
        StringBuilder params = new StringBuilder("storeType:" + param.getStoreType());
        if (BeanUtils.isNotEmpty(param.getStoreName())) {
            if (params != null) {
                params.append(" AND (storeName:* " + param.getStoreName() + "*)");
            } else {
                params = new StringBuilder();
                params.append("storeName:*" + param.getStoreName() + "*");
            }
        }
        if (BeanUtils.isNotEmpty(param.getStoreCategory())) {
            if (params != null) {
                params.append(" AND (storeCategory:" + param.getStoreCategory() + ")");
            } else {
                params = new StringBuilder();
                params.append("storeCategory:" + param.getStoreCategory());
            }
        }
        if (BeanUtils.isNotEmpty(param.getProvinceId())) {
            if (params != null) {
                params.append(" AND (provinceId:" + param.getProvinceId() + ")");
            } else {
                params = new StringBuilder();
                params.append("provinceId:" + param.getProvinceId());
            }
        }
        if (BeanUtils.isNotEmpty(param.getStreetId())) {
            if (params != null) {
                params.append(" AND (streetId:" + param.getStreetId() + ")");
            } else {
                params = new StringBuilder();
                params.append("streetId:" + param.getStreetId());
            }
        }
        if (BeanUtils.isNotEmpty(param.getCityId())) {
            if (params != null) {
                params.append(" AND (cityId:" + param.getCityId() + ")");
            } else {
                params = new StringBuilder();
                params.append("cityId:" + param.getCityId());
            }
        }
        if (BeanUtils.isNotEmpty(param.getAreaId())) {
            if (params != null) {
                params.append(" AND (areaId:" + param.getAreaId() + ")");
            } else {
                params = new StringBuilder();
                params.append("areaId:" + param.getAreaId());
            }
        }
        if (null != param.getStoreStatus()) {
            if (params != null) {
                params.append(" AND (storeStatus:" + param.getStoreStatus() + ")");
            } else {
                params = new StringBuilder();
                params.append("storeStatus:" + param.getStoreStatus());
            }
        }
        if (BeanUtils.isNotEmpty(param.getClientId())) {
            if (params != null) {
                params.append(" AND (userId:" + param.getClientId() + ")");
            } else {
                params = new StringBuilder();
                params.append("userId:" + param.getClientId());
            }
        }
        solrQuery.addSort("createTime", SolrQuery.ORDER.desc);
        if ("TIME".equals(param.getSort())) {
            solrQuery.addSort("createTime", SolrQuery.ORDER.asc);
        }
        if ("MAXPRICE".equals(param.getSort())) {
            solrQuery.addSort("originalPrice", SolrQuery.ORDER.desc);
        }
        if ("MINPRICE".equals(param.getSort())) {
            solrQuery.addSort("originalPrice", SolrQuery.ORDER.asc);
        }
        if ("MAXAREA".equals(param.getSort())) {
            solrQuery.addSort("storeArea", SolrQuery.ORDER.desc);
        }
        if ("MINAREA".equals(param.getSort())) {
            solrQuery.addSort("storeArea", SolrQuery.ORDER.asc);
        }
        if (null != param.getMaxArea() && null != param.getMinArea()) {
            if (0 == param.getStoreType()) {
                solrQuery.setFilterQueries("storeArea:[" + param.getMinArea() + " TO " + param.getMaxArea() + "]");
            } else {
                solrQuery.setFilterQueries("minStoreArea:[" + param.getMinArea() + " TO " + param.getMaxArea() + "]");
            }
        }
        if (null != param.getMaxRent() && null != param.getMinRent()) {
            if (0 == param.getStoreType()) {
                solrQuery.setFilterQueries("presentPrice:[" + param.getMinRent() + " TO " + param.getMaxRent() + "]");
            } else {
                solrQuery.setFilterQueries("originalPrice:[" + param.getMinRent() + " TO " + param.getMaxRent() + "]");
            }

        }
        if (params != null) {
            solrQuery.setQuery(params.toString());
        }
        solrQuery.setStart(start);
        solrQuery.setRows(param.getRows());
        try {
            QueryResponse query = solrClient.query(solrQuery);
            SolrDocumentList results = query.getResults();
            result.setData(results);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResponseResult transferShopInfo(Long userId, Long storeId) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        ViewTransferShopDTO viewTransferShopDTO = new ViewTransferShopDTO();
        if (BeanUtils.isNotEmpty(transferShop)) {
            modelMapper.map(transferShop, viewTransferShopDTO);
            if (BeanUtils.isNotEmpty(userId)) {
                HouseCollectExample houseCollectExample = new HouseCollectExample();
                houseCollectExample.createCriteria().andClientIdEqualTo(userId).andTransferShopIdEqualTo(storeId);
                List<HouseCollect> houseCollects = houseCollectMapper.selectByExample(houseCollectExample);
                if (houseCollects.size() > 0) {
                    viewTransferShopDTO.setCollection(1);
                }
            }
            viewTransferShopDTO.setLongitude(transferShop.getLon());
            viewTransferShopDTO.setLatitude(transferShop.getLat());
            viewTransferShopDTO.setUsername(transferShop.getContacts());
            viewTransferShopDTO.setHigh(transferShop.getHigh());
            viewTransferShopDTO.setDepth(transferShop.getDepth());
            TransferImageExample transferImageExample = new TransferImageExample();
            transferImageExample.createCriteria().andTransferShopIdEqualTo(transferShop.getId().toString());
            List<TransferImage> transferImages = transferImageMapper.selectByExample(transferImageExample);
            viewTransferShopDTO.setTransferImageList(transferImages);
            TransferShopBusinessExample example = new TransferShopBusinessExample();
            example.createCriteria().andTransferShopIdEqualTo(storeId);
            List<TransferShopBusiness> transferShopBusinesses = transferShopBusinessMapper.selectByExample(example);
            List<String> type = new ArrayList<>();
            for (TransferShopBusiness transferShopBusiness : transferShopBusinesses) {
                BusinessType businessType = businessTypeMapper.selectByPrimaryKey(transferShopBusiness.getBusinessTypeId());
                if (BeanUtils.isNotEmpty(businessType)) {
                    type.add(businessType.getBusinessType());
                }
            }
            ShopRentType shopRentType = shopRentTypeMapper.selectByPrimaryKey(transferShop.getShopRentTypeId());
            if (BeanUtils.isNotEmpty(shopRentType)) {
                viewTransferShopDTO.setShopRentType(shopRentType.getShopRentType());
            }
            viewTransferShopDTO.setBusinessTypes(type);
            PropertyType propertyType = propertyTypeMapper.selectByPrimaryKey(transferShop.getPropertyTypeId());
            if (BeanUtils.isNotEmpty(propertyType)) {
                viewTransferShopDTO.setPropertyType(propertyType.getPropertyType());
            }
            ShopType shopType = shopTypeMapper.selectByPrimaryKey(transferShop.getShopTypeId());
            if (BeanUtils.isNotEmpty(shopType)) {
                viewTransferShopDTO.setShopType(shopType.getShopType());
            }
            DecorateType decorateType = decorateTypeMapper.selectByPrimaryKey(transferShop.getDecorateTypeId());
            if (BeanUtils.isNotEmpty(decorateType)) {
                viewTransferShopDTO.setDecorateType(decorateType.getDecorateType());
            }
            Orientation orientation = orientationMapper.selectByPrimaryKey(transferShop.getOrientationId());
            if (BeanUtils.isNotEmpty(orientation)) {
                viewTransferShopDTO.setOrientation(orientation.getOrientationDesc());
            }
            LoopLine loopLine = loopLineMapper.selectByPrimaryKey(transferShop.getLoopLineId());
            if (BeanUtils.isNotEmpty(loopLine)) {
                viewTransferShopDTO.setLoopLine(loopLine.getLoopLineDesc());
            }
            SubwayLine subwayLine = subwayLineMapper.selectByPrimaryKey(transferShop.getSubwayLineId());
            if (BeanUtils.isNotEmpty(subwayLine)) {
                viewTransferShopDTO.setSubwayLine(subwayLine.getSubwayLineDesc());
            }
            BsCity bsCity = bsCityMapper.selectByPrimaryKey(transferShop.getCityId());
            if (BeanUtils.isNotEmpty(bsCity)) {
                viewTransferShopDTO.setCity(bsCity.getCityName());
            }
            BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
            if (BeanUtils.isNotEmpty(bsArea)) {
                viewTransferShopDTO.setAreaName(bsArea.getAreaName());
            }
            BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(transferShop.getStreetId());
            if (BeanUtils.isNotEmpty(bsStreet)) {
                viewTransferShopDTO.setStreet(bsStreet.getStreetName());
            }
            BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(transferShop.getProvinceId());
            if (BeanUtils.isNotEmpty(bsProvince)) {
                viewTransferShopDTO.setProvince(bsProvince.getProvinceName());
            }
            Client client = clientMapper.selectByPrimaryKey(transferShop.getClientId());
            if (BeanUtils.isNotEmpty(client)) {
                viewTransferShopDTO.setHeadImg(client.getHeader());
                viewTransferShopDTO.setOpenId(client.getOpenId());
            }
            List<ViewBaseIcon> viewBaseIcons = new ArrayList<>();
            TransferShopBaseIconExample transferShopBaseIconExample = new TransferShopBaseIconExample();
            transferShopBaseIconExample.createCriteria().andTransferShopIdEqualTo(transferShop.getId());
            List<TransferShopBaseIcon> transferShopBaseIcons = transferShopBaseIconMapper.selectByExample(transferShopBaseIconExample);
            for (TransferShopBaseIcon icon:transferShopBaseIcons) {
                TransferIcon transferIcon = transferIconMapper.selectByPrimaryKey(icon.getBaseIconId());
                ViewBaseIcon viewBaseIcon = new ViewBaseIcon();
                if (BeanUtils.isNotEmpty(transferIcon)) {
                    viewBaseIcon.setName(transferIcon.getName());
                    viewBaseIcon.setIcon(transferIcon.getImageUrl());
                    viewBaseIcon.setBaseIconId(transferIcon.getId());
                    viewBaseIcons.add(viewBaseIcon);
                }
            }
            viewTransferShopDTO.setViewBaseIcons(viewBaseIcons);
            viewTransferShopDTO.setTel(null);
            result.setData(viewTransferShopDTO);
        }
        return result;
    }

    @Override
    public ResponseResult fastTransferShop(FastTransferShopParam param) {
        ResponseResult result = new ResponseResult();
        FastTransferShop fastTransferShop = new FastTransferShop();
        fastTransferShop.setId(IdUtil.getId());
        fastTransferShop.setContacts(param.getContacts());
        fastTransferShop.setCreateDate(new Date());
        fastTransferShop.setAllocationStatus(0);
        fastTransferShop.setDescribe(param.getDescribe());
        fastTransferShop.setTel(param.getTel());
        fastTransferShop.setType(param.getType());
        fastTransferShopMapper.insert(fastTransferShop);
        return result;
    }

    @Override
    public ResponseResult myTransferShopList(Long id) {
        ResponseResult result = new ResponseResult();
        TransferShopExample transferShopExample = new TransferShopExample();
        transferShopExample.setOrderByClause(" create_time desc");
        transferShopExample.createCriteria().andClientIdEqualTo(Long.valueOf(id));
        List<TransferShop> transferShops = transferShopMapper.selectByExample(transferShopExample);
        List<ViewMyTransferShopLIstDTO> viewMyTransferShopLIstDTOS = new ArrayList<>();
        for (TransferShop transferShop : transferShops) {
            ViewMyTransferShopLIstDTO viewMyTransferShopLIstDTO = new ViewMyTransferShopLIstDTO();
            viewMyTransferShopLIstDTO.setId(transferShop.getId());
            viewMyTransferShopLIstDTO.setArea(transferShop.getArea());
            viewMyTransferShopLIstDTO.setCheckStatus(transferShop.getCheckStatus());
            viewMyTransferShopLIstDTO.setRent(transferShop.getRent());
            viewMyTransferShopLIstDTO.setTitle(transferShop.getTitle());
            viewMyTransferShopLIstDTO.setStoreImg(transferShop.getImage());
            viewMyTransferShopLIstDTO.setDoneStatus(transferShop.getStatus());
            BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(transferShop.getProvinceId());
            if (BeanUtils.isNotEmpty(bsProvince)) {
                viewMyTransferShopLIstDTO.setProvince(bsProvince.getProvinceName());
            }
            BsCity bsCity = bsCityMapper.selectByPrimaryKey(transferShop.getCityId());
            if (BeanUtils.isNotEmpty(bsCity)) {
                viewMyTransferShopLIstDTO.setCity(bsCity.getCityName());
            }
            BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
            if (BeanUtils.isNotEmpty(bsArea)) {
                viewMyTransferShopLIstDTO.setAreaName(bsArea.getAreaName());
            }
            BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(transferShop.getStreetId());
            if (BeanUtils.isNotEmpty(bsStreet)) {
                viewMyTransferShopLIstDTO.setStreet(bsStreet.getStreetName());
            }
            viewMyTransferShopLIstDTOS.add(viewMyTransferShopLIstDTO);
        }
        result.setData(viewMyTransferShopLIstDTOS);
        return result;
    }

    @Override
    public ResponseResult myBrowseTransferShopList(Long id) {
        ResponseResult result = new ResponseResult();
        List<ViewBrowseTransferShopDTO> viewBrowseTransferShopDTOS = transferShopMapper.myList(id);
        result.setData(viewBrowseTransferShopDTOS);
        return result;
    }

    @Override
    public ResponseResult myHouseCollectTransferShopList(Long userId) {
        ResponseResult result = new ResponseResult();
        List<ViewBrowseTransferShopDTO> viewBrowseTransferShopDTOS = transferShopMapper.myHouseCollectList(userId);
        result.setData(viewBrowseTransferShopDTOS);
        return result;
    }

    @Override
    public ResponseResult nearbyShop(String lon, String lat) {
        ResponseResult result = new ResponseResult();
        List<ViewNearbyShopDTO> viewNearbyShopDTOS = transferShopMapper.nearbyShop(lon, lat);
        result.setData(viewNearbyShopDTOS);
        return result;
    }

    @Override
    public ResponseResult dealTransferShopList(Integer pageNum, Integer pageSize) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(pageNum, pageSize);
        List<ViewDealDTO> viewDealDTOS = transferShopMapper.dealList();
        result.setData(viewDealDTOS);
        return result;
    }

    @Override
    public ResponseResult intermediaryList(Long userId, Integer pageNum, Integer pageSize) {
        ResponseResult result = new ResponseResult();
        PageHelper.startPage(pageNum, pageSize);
        List<ViewDealDTO> viewDealDTOS = transferShopMapper.intermediaryList(userId);
        result.setData(viewDealDTOS);
        return result;
    }

    @Override
    public ResponseResult countTodayShop() {
        ResponseResult result = new ResponseResult();
        result.setData(transferShopMapper.countTodayShop());
        return result;
    }

    @Override
    public ResponseResult deleteShop(Long id) {
        ResponseResult result = new ResponseResult();
        int i = transferShopMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            SolrDTO solrDTO = new SolrDTO();
            solrDTO.setTransferShopId(id);
            solrService.lowerShelf(solrDTO);
        }
        return result;
    }

    @Override
    public ResponseResult updateShop(ViewTransferShopParam param, Long userId) {
        ResponseResult result = new ResponseResult();
        TransferShopExample transferShopExample = new TransferShopExample();
        transferShopExample.createCriteria().andIdEqualTo(param.getId()).andClientIdEqualTo(userId);
        List<TransferShop> transferShops = transferShopMapper.selectByExample(transferShopExample);
        if (transferShops.stream().findFirst().isPresent()) {
            TransferShop transferShop = transferShops.stream().findFirst().get();
            if (transferShop.getCheckStatus() == 0) {
                result.setCode(600);
                result.setError("请审核过后在完善店铺信息");
                result.setError_description("请审核过后在完善店铺信息");
                return result;
            }
            transferShop.setPropertyTypeId(param.getPropertyTypeId());
            transferShop.setShopTypeId(param.getShopTypeId());
            transferShop.setTransferStatus(param.getTransferStatus());
            transferShop.setDecorateTypeId(param.getDecorateTypeId());
            transferShop.setRequirementDetails(param.getRequirementDetails());
            transferShop.setAccessoryRequirements(param.getAccessoryRequirements());
            transferShop.setGateWidth(param.getGateWidth());
            transferShop.setTransferFee(param.getTransferFee());
            transferShop.setShopSn(IdUtil.getId() + "");
            transferShop.setServiceType(param.getServiceType());
            transferShop.setMediumStatus(0);
            transferShop.setShopReadme(param.getShopReadme());
            transferShop.setFloorNumber(param.getFloorNumber());
            transferShop.setOrientationId(param.getOrientationId());
            transferShop.setLoopLineId(param.getLoopLineId());
            transferShop.setSubwayLineId(param.getSubwayLineId());
            transferShop.setShopRentTypeId(param.getShopRentTypeId());
            transferShop.setDepth(param.getDepth());
            transferShop.setHigh(param.getHigh());
            transferShopMapper.updateByPrimaryKey(transferShop);
            if (BeanUtils.isNotEmpty(param.getTransferShopBaseIcons()) && param.getTransferShopBaseIcons().size() > 0) {
                for (TransferShopBaseIcon transferShopBaseIcon:param.getTransferShopBaseIcons()) {
                    transferShopBaseIcon.setId(IdUtil.getId());
                    transferShopBaseIcon.setTransferShopId(transferShop.getId());
                    transferShopBaseIconMapper.insert(transferShopBaseIcon);
                }
            }
            transferShopMapper.updateByPrimaryKey(transferShop);
        }
        return result;
    }

    @Override
    public ResponseResult updateShopInfo(Long userId, Long storeId) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        ViewTransferShopInfoDTO viewTransferShopDTO = new ViewTransferShopInfoDTO();
        if (BeanUtils.isNotEmpty(transferShop)) {
            modelMapper.map(transferShop, viewTransferShopDTO);
            if (BeanUtils.isNotEmpty(userId)) {
                HouseCollectExample houseCollectExample = new HouseCollectExample();
                houseCollectExample.createCriteria().andClientIdEqualTo(userId).andTransferShopIdEqualTo(storeId);
                List<HouseCollect> houseCollects = houseCollectMapper.selectByExample(houseCollectExample);
                if (houseCollects.size() > 0) {
                    viewTransferShopDTO.setCollection(1);
                }
            }
            viewTransferShopDTO.setLongitude(transferShop.getLon());
            viewTransferShopDTO.setLatitude(transferShop.getLat());
            viewTransferShopDTO.setUsername(transferShop.getContacts());
            viewTransferShopDTO.setHigh(transferShop.getHigh());
            viewTransferShopDTO.setDepth(transferShop.getDepth());
            TransferImageExample transferImageExample = new TransferImageExample();
            transferImageExample.createCriteria().andTransferShopIdEqualTo(transferShop.getId().toString());
            List<TransferImage> transferImages = transferImageMapper.selectByExample(transferImageExample);
            viewTransferShopDTO.setTransferImageList(transferImages);
            TransferShopBusinessExample example = new TransferShopBusinessExample();
            example.createCriteria().andTransferShopIdEqualTo(storeId);
            List<TransferShopBusiness> transferShopBusinesses = transferShopBusinessMapper.selectByExample(example);
            List<String> type = new ArrayList<>();
            for (TransferShopBusiness transferShopBusiness : transferShopBusinesses) {
                BusinessType businessType = businessTypeMapper.selectByPrimaryKey(transferShopBusiness.getBusinessTypeId());
                if (BeanUtils.isNotEmpty(businessType)) {
                    type.add(businessType.getBusinessType());
                }
            }
            viewTransferShopDTO.setShopRentType(transferShop.getShopRentTypeId());
            viewTransferShopDTO.setBusinessTypes(type);
            viewTransferShopDTO.setPropertyType(transferShop.getPropertyTypeId());
            viewTransferShopDTO.setShopType(transferShop.getShopTypeId());
            viewTransferShopDTO.setDecorateType(transferShop.getDecorateTypeId());
            viewTransferShopDTO.setOrientation(transferShop.getOrientationId());
            viewTransferShopDTO.setLoopLine(transferShop.getLoopLineId());
            viewTransferShopDTO.setSubwayLine(transferShop.getSubwayLineId());
            List<Integer> addressArea = new ArrayList<>();
            addressArea.add(transferShop.getProvinceId());
            addressArea.add(transferShop.getCityId());
            addressArea.add(transferShop.getAreaId());
            addressArea.add(transferShop.getStreetId());
            viewTransferShopDTO.setAddressIndex(addressArea);
            BsCity bsCity = bsCityMapper.selectByPrimaryKey(transferShop.getCityId());
            if (BeanUtils.isNotEmpty(bsCity)) {
                viewTransferShopDTO.setCity(bsCity.getCityName());
            }
            BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
            if (BeanUtils.isNotEmpty(bsArea)) {
                viewTransferShopDTO.setAreaName(bsArea.getAreaName());
            }
            BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(transferShop.getStreetId());
            if (BeanUtils.isNotEmpty(bsStreet)) {
                viewTransferShopDTO.setStreet(bsStreet.getStreetName());
            }
            BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(transferShop.getProvinceId());
            if (BeanUtils.isNotEmpty(bsProvince)) {
                viewTransferShopDTO.setProvince(bsProvince.getProvinceName());
            }
            List<ViewBaseIcon> viewBaseIcons = new ArrayList<>();
            TransferShopBaseIconExample transferShopBaseIconExample = new TransferShopBaseIconExample();
            transferShopBaseIconExample.createCriteria().andTransferShopIdEqualTo(transferShop.getId());
            List<TransferShopBaseIcon> transferShopBaseIcons = transferShopBaseIconMapper.selectByExample(transferShopBaseIconExample);
            for (TransferShopBaseIcon icon:transferShopBaseIcons) {
                TransferIcon transferIcon = transferIconMapper.selectByPrimaryKey(icon.getBaseIconId());
                ViewBaseIcon viewBaseIcon = new ViewBaseIcon();
                if (BeanUtils.isNotEmpty(transferIcon)) {
                    viewBaseIcon.setName(transferIcon.getName());
                    viewBaseIcon.setIcon(transferIcon.getImageUrl());
                    viewBaseIcon.setBaseIconId(transferIcon.getId());
                    viewBaseIcons.add(viewBaseIcon);
                }
            }
            viewTransferShopDTO.setViewBaseIcons(viewBaseIcons);
            viewTransferShopDTO.setTel(null);
            result.setData(viewTransferShopDTO);
        }
        return result;
    }
}
