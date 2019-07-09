package com.ch.service.impl;

import com.alibaba.fastjson.JSON;
import com.ch.base.BeanUtils;
import com.ch.base.MD5;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.*;
import com.ch.entity.*;
import com.ch.model.ViewBrowseParam;
import com.ch.model.ViewFeedBackParam;
import com.ch.model.ViewWXLoginParam;
import com.ch.service.SolrService;
import com.ch.service.ViewBaseService;
import com.ch.util.IdUtil;
import com.ch.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
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

    @Autowired
    HouseCollectMapper houseCollectMapper;

    @Autowired
    BrowsingHistoryMapper browsingHistoryMapper;

    @Autowired
    LookShopMapper lookShopMapper;

    @Autowired
    TransferShopMapper transferShopMapper;

    @Autowired
    FeedBackMapper feedBackMapper;

    @Autowired
    SolrService solrService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    TransferIconMapper transferIconMapper;

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserBusinessMapper sysUserBusinessMapper;

    @Autowired
    SuccessCaseMapper successCaseMapper;

    @Override
    public ResponseResult businessTypeList() {
        ResponseResult result = new ResponseResult();
        List<BusinessType> businessTypes = businessTypeMapper.selectByExample(null);
        List<BusinessType> rootMenu = new ArrayList<BusinessType>();
        for (BusinessType nav : businessTypes) {
            if (nav.getParentId() == 0) {
                rootMenu.add(nav);
            }
        }
        //为根菜单设置子菜单，getClild是递归调用的
        for (BusinessType nav : rootMenu) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<BusinessType> childList = getChild(nav.getId(), businessTypes);
            nav.setChildren(childList);//给根节点设置子节点
        }
        result.setData(rootMenu);
        return result;
    }

    public List<BusinessType> getChild(Long id, List<BusinessType> allMenu) {
        //子菜单
        List<BusinessType> childList = new ArrayList<BusinessType>();
        for (BusinessType nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if ((nav.getParentId() != null) && nav.getParentId().equals(id)) {
                childList.add(nav);
            }
        }
        //递归
        for (BusinessType nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<BusinessType>();
        }
        return childList;
    }


    @Override
    public ResponseResult provinceList() {
        ResponseResult result = new ResponseResult();
        List<BsProvince> bsProvinces = (List<BsProvince>) redisTemplate.boundHashOps("provinceList").get("province");
        if (null == bsProvinces) {
            BsProvinceExample bsProvinceExample = new BsProvinceExample();
            bsProvinceExample.setOrderByClause("sort");
            bsProvinceExample.createCriteria().andProvinceIdEqualTo(17);
            bsProvinces = bsProvinceMapper.selectByExample(bsProvinceExample);
            redisTemplate.boundHashOps("provinceList").put("province", bsProvinces);
            result.setData(bsProvinces);
        } else {
            result.setData(bsProvinces);
        }
        return result;
    }

    @Override
    public ResponseResult findCityByProvinceCode(String code) {
        code = "420100";
        ResponseResult result = new ResponseResult();
        List<BsCity> bsCities = (List<BsCity>) redisTemplate.boundHashOps("cityList").get(code);
        if (null == bsCities) {
            BsCityExample bsCityExample = new BsCityExample();
            bsCityExample.setOrderByClause("sort");
            bsCityExample.createCriteria().andCityCodeEqualTo(code);
            bsCities = bsCityMapper.selectByExample(bsCityExample);
            redisTemplate.boundHashOps("cityList").put(code, bsCities);
            result.setData(bsCities);
        } else {
            result.setData(bsCities);
        }

        return result;
    }

    @Override
    public ResponseResult findAreaByCityCode(String code) {
        ResponseResult result = new ResponseResult();
        List<BsArea> bsAreas = (List<BsArea>) redisTemplate.boundHashOps("areaList").get(code);
        if (null == bsAreas) {
            BsAreaExample bsAreaExample = new BsAreaExample();
            bsAreaExample.setOrderByClause("sort");
            bsAreaExample.createCriteria().andCityCodeEqualTo(code);
            bsAreas = bsAreaMapper.selectByExample(bsAreaExample);
            redisTemplate.boundHashOps("areaList").put(code, bsAreas);
            result.setData(bsAreas);
        } else {
            result.setData(bsAreas);
        }

        return result;
    }

    @Override
    public ResponseResult findStweetByAreaCode(String code) {
        ResponseResult result = new ResponseResult();
        List<BsStreet> bsStreets = (List<BsStreet>) redisTemplate.boundHashOps("stweetList").get(code);
        if (null == bsStreets) {
            BsStreetExample bsStreetExample = new BsStreetExample();
            bsStreetExample.setOrderByClause("sort");
            bsStreetExample.createCriteria().andAreaCodeEqualTo(code);
            bsStreets = bsStreetMapper.selectByExample(bsStreetExample);
            redisTemplate.boundHashOps("stweetList").put(code, bsStreets);
            result.setData(bsStreets);
        } else {
            result.setData(bsStreets);
        }

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
            result.setData(TokenUtil.sign(client.getId()));
            if (BeanUtils.isNotEmpty(param.getNickName())) {
                client.setNickName(param.getNickName());
            }
            if (BeanUtils.isNotEmpty(param.getHeader())) {
                client.setHeader(param.getHeader());
            }
            if (BeanUtils.isNotEmpty(param.getGender())) {
                client.setGender(param.getGender());
            }
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
            result.setData(TokenUtil.sign(client.getId()));
        }
        return result;
    }


    @Override
    @Transactional
    public void saveBrowse(Long userId, ViewBrowseParam param) {
        log.info("进入保存浏览记录" + JSON.toJSONString(param));
        if (null != param.getLookShopId()) {
            LookShopExample lookShopExample = new LookShopExample();
            lookShopExample.createCriteria().andIdEqualTo(param.getLookShopId()).andClientIdEqualTo(userId);
            List<LookShop> lookShops = lookShopMapper.selectByExample(lookShopExample);
            if (lookShops.size() > 0) {
                log.info("自己的发布找铺，不予保存");
                return;
            }
        }
        if (null != param.getTransferShopId()) {
            TransferShopExample transferShopExample = new TransferShopExample();
            transferShopExample.createCriteria().andIdEqualTo(param.getTransferShopId()).andClientIdEqualTo(userId);
            List<TransferShop> transferShops = transferShopMapper.selectByExample(transferShopExample);
            if (transferShops.size() > 0) {
                log.info("自己的发布转铺，不予保存");
                return;
            }
        }
        int i = browsingHistoryMapper.seleteExits(userId, param.getLookShopId(), param.getTransferShopId());
        List<BrowsingHistory> browsingHistories = browsingHistoryMapper.selectByclientId(userId);
        if (browsingHistories.size() > 50) {
            for (int j = 49; j < browsingHistories.size(); j++) {
                browsingHistoryMapper.deleteByPrimaryKey(browsingHistories.get(j).getId());
            }
        }
        if (i == 0) {
            BrowsingHistory history = new BrowsingHistory();
            history.setId(IdUtil.getId());
            history.setClientId(userId);
            history.setCreateDate(new Date());
            if (BeanUtils.isNotEmpty(param.getLookShopId())) {
                history.setLookShopId(param.getLookShopId());
            }
            if (BeanUtils.isNotEmpty(param.getTransferShopId())) {
                history.setTransferShopId(param.getTransferShopId());
            }
            if (BeanUtils.isNotEmpty(param.getSysUserId())) {
                history.setSysUserId(param.getSysUserId());
            }
            if (BeanUtils.isNotEmpty(param.getSuccessCaseId())) {
                history.setSuccessCaseId(param.getSuccessCaseId());
            }
            browsingHistoryMapper.insert(history);
            log.info("保存成功，" + history.getId());
        }
    }

    @Override
    public void deleteBrowse(Long userId, ViewBrowseParam param) {
        BrowsingHistoryExample browsingHistoryExample = new BrowsingHistoryExample();
        BrowsingHistoryExample.Criteria criteria = browsingHistoryExample.createCriteria();
        criteria.andClientIdEqualTo(userId);
        if (BeanUtils.isNotEmpty(param.getLookShopId())) {
            criteria.andLookShopIdEqualTo(param.getLookShopId());
        }
        if (BeanUtils.isNotEmpty(param.getTransferShopId())) {
            criteria.andTransferShopIdEqualTo(param.getTransferShopId());
        }
        if (BeanUtils.isNotEmpty(param.getSysUserId())) {
            criteria.andSysUserIdEqualTo(param.getSysUserId());
        }
        if (BeanUtils.isNotEmpty(param.getSuccessCaseId())) {
            criteria.andSuccessCaseIdEqualTo(param.getSuccessCaseId());
        }
        browsingHistoryMapper.deleteByExample(browsingHistoryExample);
    }


    @Override
    public ResponseResult saveCollection(Long userId, ViewBrowseParam param) {
        ResponseResult result = new ResponseResult();
        HouseCollect houseCollect = new HouseCollect();
        houseCollect.setId(IdUtil.getId());
        houseCollect.setCreateDate(new Date());
        houseCollect.setClientId(userId);
        if (BeanUtils.isNotEmpty(param.getTransferShopId())) {
            houseCollect.setTransferShopId(param.getTransferShopId());
        }
        if (BeanUtils.isNotEmpty(param.getLookShopId())) {
            houseCollect.setLookShopId(param.getLookShopId());
        }
        houseCollectMapper.insert(houseCollect);
        return result;
    }

    @Override
    public ResponseResult deleteCollection(Long userId, ViewBrowseParam param) {
        ResponseResult result = new ResponseResult();
        HouseCollectExample example = new HouseCollectExample();
        HouseCollectExample.Criteria criteria = example.createCriteria();
        criteria.andClientIdEqualTo(userId);
        if (BeanUtils.isNotEmpty(param.getLookShopId())) {
            criteria.andLookShopIdEqualTo(param.getLookShopId());
        }
        if (BeanUtils.isNotEmpty(param.getTransferShopId())) {
            criteria.andTransferShopIdEqualTo(param.getTransferShopId());
        }
        houseCollectMapper.deleteByExample(example);
        return result;
    }

    @Override
    public ResponseResult feedBack(Long userId, ViewFeedBackParam param) {
        ResponseResult result = new ResponseResult();
        FeedBack feedBack = new FeedBack();
        feedBack.setId(IdUtil.getId());
        feedBack.setClientId(userId);
        feedBack.setContacts(param.getContacts());
        feedBack.setTel(param.getTel());
        feedBack.setDetail(param.getDetail());
        feedBack.setCreateDate(new Date());
        feedBackMapper.insert(feedBack);
        return result;
    }

    @Override
    public ResponseResult generateSignature() {
        ResponseResult result = new ResponseResult();
        long time = new Date().getTime();
        String s = "appkey=c15e97a8225d5572f2a8aa47&timestamp=" + time + "&random_str=qwertyuiopasdfghjklzxcvbnm_3541w&key=941b5e2749704dea9b66c743";
        String s1 = MD5.getInstance().getMD5(s);
        IMDTO imdto = new IMDTO();
        imdto.setTime(time);
        imdto.setSign(s1);
        result.setData(imdto);
        return result;
    }


    @Override
    public void solr() {
        solrService.deleteAll();
        TransferShopExample transferShopExample = new TransferShopExample();
        transferShopExample.createCriteria().andCheckStatusEqualTo(1).andStatusNotEqualTo(1);
        List<TransferShop> transferShops = transferShopMapper.selectByExample(transferShopExample);
        for (TransferShop transferShop : transferShops) {
            SolrDTO solrDTO = new SolrDTO();
            solrDTO.setTransferShopId(transferShop.getId());
            solrService.addSolr(solrDTO);
        }

        LookShopExample lookShopExample = new LookShopExample();
        lookShopExample.createCriteria().andStatusNotEqualTo(1);
        List<LookShop> lookShops = lookShopMapper.selectByExample(lookShopExample);
        for (LookShop lookShop : lookShops) {
            SolrDTO solrDTO = new SolrDTO();
            solrDTO.setLookShopId(lookShop.getId());
            solrService.addSolr(solrDTO);
        }
    }


    @Override
    public void solrByStoreId(Long storeId) {
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        SolrDTO solrDTO = new SolrDTO();
        if (BeanUtils.isNotEmpty(transferShop)) {
            solrDTO.setTransferShopId(storeId);
        } else {
            solrDTO.setLookShopId(storeId);
        }
        solrService.addSolr(solrDTO);
    }

    @Override
    public ResponseResult baseIcon() {
        ResponseResult result = new ResponseResult();
        TransferIconExample transferIconExample = new TransferIconExample();
        transferIconExample.createCriteria().andStatusEqualTo("1");
        List<TransferIcon> transferIcons = transferIconMapper.selectByExample(transferIconExample);
        result.setData(transferIcons);
        return result;
    }

    @Override
    public ResponseResult expertOnline(Long businessId, Integer pageNum, Integer pageSize) {
        ResponseResult result = new ResponseResult();
        pageNum -= 1;
        ViewExpertOnline viewExpertOnline = new ViewExpertOnline();
        List<ViewExpertOnlineDTO> viewExpertOnlineDTOS = sysUserMapper.expertOnlineList(businessId, pageNum * pageSize, pageSize);
        int count = sysUserMapper.expertOnlineListCount();
        viewExpertOnline.setTotal(count);
        for (ViewExpertOnlineDTO dto : viewExpertOnlineDTOS) {
            SysUserBusinessExample sysUserBusinessExample = new SysUserBusinessExample();
            sysUserBusinessExample.createCriteria().andSysUserIdEqualTo(dto.getId());
            StringBuffer sb = new StringBuffer();
            List<SysUserBusiness> sysUserBusinesses = sysUserBusinessMapper.selectByExample(sysUserBusinessExample);
            for (int i = 0; i < sysUserBusinesses.size(); i++) {
                BusinessType businessType = businessTypeMapper.selectByPrimaryKey(sysUserBusinesses.get(i).getBusinessTypeId());
                if (BeanUtils.isNotEmpty(businessType)) {
                    sb.append(businessType.getBusinessType());
                }
                if (i != sysUserBusinesses.size() - 1) {
                    sb.append(",");
                }
            }
            dto.setBusiness(sb.toString());
        }
        viewExpertOnline.setData(viewExpertOnlineDTOS);
        result.setData(viewExpertOnline);
        return result;
    }

    @Override
    public ResponseResult expertInfo(Long id) {
        ResponseResult result = new ResponseResult();
        ViewExpertInfoDTO viewExpertInfoDTO = new ViewExpertInfoDTO();
        viewExpertInfoDTO = sysUserMapper.info(id);
        viewExpertInfoDTO.setArea("武汉");
        viewExpertInfoDTO.setStar(5);
        SysUserBusinessExample sysUserBusinessExample = new SysUserBusinessExample();
        sysUserBusinessExample.createCriteria().andSysUserIdEqualTo(id);
        StringBuffer sb = new StringBuffer();
        List<SysUserBusiness> sysUserBusinesses = sysUserBusinessMapper.selectByExample(sysUserBusinessExample);
        for (int i = 0; i < sysUserBusinesses.size(); i++) {
            BusinessType businessType = businessTypeMapper.selectByPrimaryKey(sysUserBusinesses.get(i).getBusinessTypeId());
            if (BeanUtils.isNotEmpty(businessType)) {
                sb.append(businessType.getBusinessType());
            }
            if (i != sysUserBusinesses.size() - 1) {
                sb.append(",");
            }
        }
        viewExpertInfoDTO.setBusiness(sb.toString());

        result.setData(viewExpertInfoDTO);
        return result;
    }
}
