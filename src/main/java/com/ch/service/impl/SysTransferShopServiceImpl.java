/**
 * Author: 常富文
 * Date:   2019/6/5 10:25
 * Description:
 */

package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.dao.*;
import com.ch.dto.ShowShopDto;
import com.ch.dto.SolrDTO;
import com.ch.dto.SysTransferShopDTO;
import com.ch.dto.UpdateStatusDTO;
import com.ch.entity.*;
import com.ch.service.SolrService;
import com.ch.service.SysTransferShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SysTransferShopServiceImpl implements SysTransferShopService {

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
    SolrService solrService;
    @Autowired
    ShopRentTypeMapper shopRentTypeMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserShopMapper sysUserShopMapper;


    @Override

    public ResponseResult showTransferShopList(ShowShopDto showShopDto) {
        ResponseResult result = new ResponseResult();
        //List<SysTransferShopDTO> transferShops = new ArrayList<>();
        PageHelper.startPage(showShopDto.getPageNum(), showShopDto.getPageSize());
        List<SysTransferShopDTO> list = transferShopMapper.list(showShopDto.getUsername(), showShopDto.getTel(), showShopDto.getDoneStatus(), showShopDto.getRecommendType(), showShopDto.getCheckStatus());
        PageInfo<SysTransferShopDTO> page = new PageInfo<>(list);
        result.setData(page);
        return result;
        //if (BeanUtils.isNotEmpty(showShopDto.getUsername())){
        //     transferShops = transferShopMapper.list(showShopDto.getUsername(), showShopDto.getTel(), showShopDto.getDoneStatus(), showShopDto.getRecommendType(),showShopDto.getCheckStatus());
        //    PageInfo<SysTransferShopDTO> page = new PageInfo<>(transferShops);
        //    result.setData(page);
        //    return result;
        //}
        //if (BeanUtils.isNotEmpty(showShopDto.getTel())){
        //    transferShops = transferShopMapper.list(showShopDto.getUsername(), showShopDto.getTel(), showShopDto.getDoneStatus(), showShopDto.getRecommendType(),showShopDto.getCheckStatus());
        //    PageInfo<SysTransferShopDTO> page = new PageInfo<>(transferShops);
        //    result.setData(page);
        //    return result;
        //}
        //if (null != showShopDto.getDoneStatus()){
        //    transferShops = transferShopMapper.list(showShopDto.getUsername(), showShopDto.getTel(), showShopDto.getDoneStatus(), showShopDto.getRecommendType(),showShopDto.getCheckStatus());
        //    PageInfo<SysTransferShopDTO> page = new PageInfo<>(transferShops);
        //    result.setData(page);
        //    return result;
        //}
        //  if (null != showShopDto.getRecommendType()){
        //      transferShops = transferShopMapper.list(showShopDto.getUsername(), showShopDto.getTel(), showShopDto.getDoneStatus(), showShopDto.getRecommendType(),showShopDto.getCheckStatus());
        //      PageInfo<SysTransferShopDTO> page = new PageInfo<>(transferShops);
        //      result.setData(page);
        //      return result;
        //  }
        //
        //if (null != showShopDto.getCheckStatus()){
        //    transferShops = transferShopMapper.list(showShopDto.getUsername(), showShopDto.getTel(), showShopDto.getDoneStatus(), showShopDto.getRecommendType(),showShopDto.getCheckStatus());
        //    PageInfo<SysTransferShopDTO> page = new PageInfo<>(transferShops);
        //    result.setData(page);
        //    return result;
        //}
        //else {
        //   transferShops = transferShopMapper.findAll();
        //    PageInfo<SysTransferShopDTO> page = new PageInfo<>(transferShops);
        //    result.setData(page);
        //    return result;
        //}


       /* List<SysTransferShopDTO> sysTransferShopDTOS = new ArrayList<>();
        for (TransferShop transferShop : transferShops) {
            ResponseResult result1 = transferShopInfo(transferShop.getId());
            SysTransferShopDTO data =(SysTransferShopDTO) result1.getData();
            sysTransferShopDTOS.add(data);
        }*/


    }

    @Override

    public ResponseResult updateStatus(UpdateStatusDTO updateStatusDTO) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(updateStatusDTO.getStoreId());
        if (updateStatusDTO.getStatus() == 1) {
            transferShop.setCheckTime(new Date());


        }
        if (updateStatusDTO.getStatus() == 0) {
            transferShop.setCheckTime(new Date());
            transferShop.setReasons(updateStatusDTO.getReasons());
        }
        transferShop.setCheckStatus(updateStatusDTO.getStatus());
        transferShopMapper.updateByPrimaryKey(transferShop);
        SolrDTO solrDTO = new SolrDTO();
        solrDTO.setTransferShopId(updateStatusDTO.getStoreId());
        solrService.addSolr(solrDTO);

        if (BeanUtils.isNotEmpty(updateStatusDTO.getUserId())) {
            SysUserShop sysUserShop = new SysUserShop();
            sysUserShop.setSysUserId(updateStatusDTO.getUserId());
            sysUserShop.setTransferShopId(transferShop.getId().toString());
            sysUserShopMapper.insert(sysUserShop);
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(updateStatusDTO.getUserId());
            sysUser.setServiceCount(sysUser.getServiceCount() + 1);
            sysUserMapper.updateByPrimaryKey(sysUser);
        }

        return result;
    }

    @Override
    public ResponseResult updateCategory(UpdateStatusDTO updateStatusDTO) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(updateStatusDTO.getStoreId());
        transferShop.setRecommendType(updateStatusDTO.getStatus());
        transferShopMapper.updateByPrimaryKey(transferShop);
        SolrDTO solrDTO = new SolrDTO();
        solrDTO.setTransferShopId(transferShop.getId());
        solrService.addSolr(solrDTO);
        return result;
    }

    @Override
    public ResponseResult transferShopInfo(Long storeId) {
        ResponseResult result = new ResponseResult();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(storeId);
        SysTransferShopDTO sysTransferShopDTO = new SysTransferShopDTO();
        modelMapper.map(transferShop, sysTransferShopDTO);
        sysTransferShopDTO.setUsername(transferShop.getContacts());
        TransferImageExample transferImageExample = new TransferImageExample();
        transferImageExample.createCriteria().andTransferShopIdEqualTo(transferShop.getId().toString());
        List<TransferImage> transferImages = transferImageMapper.selectByExample(transferImageExample);
        sysTransferShopDTO.setTransferImageList(transferImages);
        TransferShopBusinessExample example = new TransferShopBusinessExample();
        example.createCriteria().andTransferShopIdEqualTo(storeId);
        List<TransferShopBusiness> transferShopBusinesses = transferShopBusinessMapper.selectByExample(example);
        StringBuilder type = new StringBuilder();
        for (TransferShopBusiness transferShopBusiness : transferShopBusinesses) {
            BusinessType businessType = businessTypeMapper.selectByPrimaryKey(transferShopBusiness.getBusinessTypeId());
            if (BeanUtils.isNotEmpty(businessType)) {
                //type.add(businessType.getBusinessType());
                type.append(businessType.getBusinessType() + ",");
            }
        }
        sysTransferShopDTO.setBusinessTypes(type.toString());
        PropertyType propertyType = propertyTypeMapper.selectByPrimaryKey(transferShop.getPropertyTypeId());
        if (BeanUtils.isNotEmpty(propertyType)) {
            sysTransferShopDTO.setPropertyType(propertyType.getPropertyType());
        }
        ShopType shopType = shopTypeMapper.selectByPrimaryKey(transferShop.getShopTypeId());
        if (BeanUtils.isNotEmpty(shopType)) {
            sysTransferShopDTO.setShopType(shopType.getShopType());
        }
        ShopRentType shopRentType = shopRentTypeMapper.selectByPrimaryKey(transferShop.getShopRentTypeId());
        if (BeanUtils.isNotEmpty(shopRentType)) {
            sysTransferShopDTO.setShopRentType(shopRentType.getShopRentType());
        }

        DecorateType decorateType = decorateTypeMapper.selectByPrimaryKey(transferShop.getDecorateTypeId());
        if (BeanUtils.isNotEmpty(decorateType)) {
            sysTransferShopDTO.setDecorateType(decorateType.getDecorateType());
        }
        Orientation orientation = orientationMapper.selectByPrimaryKey(transferShop.getOrientationId());
        if (BeanUtils.isNotEmpty(orientation)) {
            sysTransferShopDTO.setOrientation(orientation.getOrientationDesc());
        }
        LoopLine loopLine = loopLineMapper.selectByPrimaryKey(transferShop.getLoopLineId());
        if (BeanUtils.isNotEmpty(loopLine)) {
            sysTransferShopDTO.setLoopLine(loopLine.getLoopLineDesc());
        }
        SubwayLine subwayLine = subwayLineMapper.selectByPrimaryKey(transferShop.getSubwayLineId());
        if (BeanUtils.isNotEmpty(subwayLine)) {
            sysTransferShopDTO.setSubwayLine(subwayLine.getSubwayLineDesc());
        }
        BsCity bsCity = bsCityMapper.selectByPrimaryKey(transferShop.getCityId());
        if (BeanUtils.isNotEmpty(bsCity)) {
            sysTransferShopDTO.setCity(bsCity.getCityName());
        }
        BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
        if (BeanUtils.isNotEmpty(bsArea)) {
            sysTransferShopDTO.setAreaName(bsArea.getAreaName());
        }
        BsStreet bsStreet = bsStreetMapper.selectByPrimaryKey(transferShop.getStreetId());
        if (BeanUtils.isNotEmpty(bsStreet)) {
            sysTransferShopDTO.setStreet(bsStreet.getStreetName());
        }
        BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(transferShop.getProvinceId());
        if (BeanUtils.isNotEmpty(bsProvince)) {
            sysTransferShopDTO.setProvince(bsProvince.getProvinceName());
        }
        result.setData(sysTransferShopDTO);
        return result;
    }

    @Override
    public ResponseResult findAgent() {
        ResponseResult result = new ResponseResult();
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo("中介");
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(example);
        SysRole sysRole = null;
        if (sysRoles.size() > 0) {
            sysRole = sysRoles.get(0);

        }

        SysUserRoleExample example1 = new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andRoleIdEqualTo(sysRole.getRoleId());
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(example1);
        List<SysUser> sysUsers = new ArrayList<>();
        for (SysUserRole sysUserRole : sysUserRoles) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(sysUserRole.getUserId());
            if (BeanUtils.isNotEmpty(sysUser)) {
                sysUsers.add(sysUser);
            }

        }
        result.setData(sysUsers);

        return result;
    }

}
