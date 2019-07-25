package com.ch.service.impl;

import com.ch.base.BeanUtils;
import com.ch.base.ResponseResult;
import com.ch.base.UploadName;
import com.ch.config.UploadImgProperties;
import com.ch.dao.*;
import com.ch.dto.SolrDTO;
import com.ch.entity.*;
import com.ch.service.SolrService;
import com.ch.service.UploadService;
import com.ch.service.ViewTransferShopService;
import com.ch.util.ExcelHelper;
import com.ch.util.GaoDeUtil;
import com.ch.util.IdUtil;
import com.ch.util.OSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Autowired
    OSSUtil ossUtil;

    @Autowired
    BsAreaMapper bsAreaMapper;

    @Autowired
    BsStreetMapper streetMapper;

    @Autowired
    ShopRentTypeMapper shopRentTypeMapper;

    @Autowired
    ShopTypeMapper shopTypeMapper;

    @Autowired
    PropertyTypeMapper propertyTypeMapper;

    @Autowired
    DecorateTypeMapper decorateTypeMapper;

    @Autowired
    OrientationMapper orientationMapper;

    @Autowired
    LoopLineMapper loopLineMapper;

    @Autowired
    SubwayLineMapper subwayLineMapper;

    @Autowired
    TransferShopMapper transferShopMapper;

    @Autowired
    TransferImageMapper transferImageMapper;

    @Autowired
    TransferShopBaseIconMapper transferShopBaseIconMapper;

    @Autowired
    TransferShopBusinessMapper transferShopBusinessMapper;

    @Autowired
    ViewTransferShopService viewTransferShopService;

    @Autowired
    BsProvinceMapper bsProvinceMapper;

    @Autowired
    BsCityMapper bsCityMapper;

    @Autowired
    UploadImgProperties uploadImgProperties;

    @Autowired
    BusinessTypeMapper businessTypeMapper;

    @Autowired
    SolrService solrService;

    @Autowired
    LookShopMapper lookShopMapper;

    @Autowired
    LookShopBusinessMapper lookShopBusinessMapper;

    @Override
    public ResponseResult uploadFile(MultipartFile file) {
        ResponseResult result = new ResponseResult();
        UploadName uploadName = new UploadName();
        String upload = ossUtil.upload(file);
        uploadName.setUrl(upload);
        uploadName.setName(file.getOriginalFilename());
        result.setData(uploadName);
        return result;
    }

    @Override
    public UploadName upload(MultipartFile file) {
        UploadName result = new UploadName();
        String upload = ossUtil.upload(file);
        result.setUrl(upload);
        result.setName(file.getOriginalFilename());
        return result;
    }

    @Override
    @Transactional
    public ResponseResult uploadExcel(MultipartFile file) {
        ResponseResult result = new ResponseResult();
        long startTime=System.currentTimeMillis();
        long id = IdUtil.getId();
        long date = 1561360888000l;
        int k = 0;
        int p = 0;
        String fileSuffix = FilenameUtils.getExtension(file.getOriginalFilename());
        if (fileSuffix.toLowerCase().equals("xls") || fileSuffix.toLowerCase().equals("xlsx")) {
            try {
                List<String> list = ExcelHelper.exportListFromExcel(file.getInputStream(), fileSuffix, 0);
                for (int i = 1; i < list.size(); i++) {
                    id++;
                    k++;
                    p++;
                    System.out.println(i);
                    if (k % 20 == 0) {
                        date+= 86400000l;
                       // System.out.println("时间戳为:" + date);
                    }
                    String[] str = list.get(i).split("\\|", -1);
                    TransferShop transferShop = new TransferShop();
                    List<TransferImage> transferImages = new ArrayList<>();
                    List<TransferShopBusiness> transferShopBusinesses = new ArrayList<>();
                    List<TransferShopBaseIcon> transferShopBaseIcons = new ArrayList<>();
                    transferShop.setId(id);
                    transferShop.setClientId(234352265583616l);
                    if (BeanUtils.isNotEmpty(str[1])) {
                        transferShop.setTitle(str[1]);
                    } else {
                        result.setCode(600);
                        result.setError("标题不能为空");
                        result.setError_description("标题不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[2])) {
                        String[] split = str[2].split("\\/");
                        String url = "";
                        for (String name:split) {
                            TransferImage transferImage2 = new TransferImage();
                            transferImage2.setId(IdUtil.getId());
                            MultipartFile mulFileByPath2 = getMulFileByPath(uploadImgProperties.getImg() + name);
                            UploadName upload2 = upload(mulFileByPath2);
                            transferImage2.setImageUrl(upload2.getUrl());
                            transferImage2.setTransferShopId(transferShop.getId().toString());
                            transferImages.add(transferImage2);
                            url = upload2.getUrl();
                        }
                        transferShop.setImage(url);
                    } else {
                        result.setCode(600);
                        result.setError("图片不能为空");
                        result.setError_description("图片不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[3])) {
                        String[] split = str[3].split("\\/");
                        for (String name:split) {
                            BusinessTypeExample businessTypeExample = new BusinessTypeExample();
                            businessTypeExample.createCriteria().andBusinessTypeEqualTo(name);
                            List<BusinessType> businessTypes = businessTypeMapper.selectByExample(businessTypeExample);
                            if (BeanUtils.isNotEmpty(businessTypes)) {
                                TransferShopBusiness transferShopBusiness = new TransferShopBusiness();
                                transferShopBusiness.setId(IdUtil.getId());
                                transferShopBusiness.setBusinessTypeId(businessTypes.get(0).getId());
                                transferShopBusiness.setTransferShopId(transferShop.getId());
                                transferShopBusinesses.add(transferShopBusiness);
                            } else {
                                BusinessType businessType = new BusinessType();
                                businessType.setId(IdUtil.getId());
                                businessType.setBusinessType(name);
                                businessType.setParentId(1000L);
                                businessTypeMapper.insert(businessType);
                                TransferShopBusiness transferShopBusiness = new TransferShopBusiness();
                                transferShopBusiness.setId(IdUtil.getId());
                                transferShopBusiness.setBusinessTypeId(businessType.getId());
                                transferShopBusiness.setTransferShopId(transferShop.getId());
                                transferShopBusinesses.add(transferShopBusiness);
                            }
                        }
                    } else {
                        result.setCode(600);
                        result.setError("经营范围不能为空");
                        result.setError_description("经营范围不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[4])) {
                        transferShop.setArea(Integer.valueOf(str[4]));
                    } else {
                        result.setCode(600);
                        result.setError("面积不能为空");
                        result.setError_description("面积不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[5])) {
                        transferShop.setRent(Long.valueOf(str[5]));
                    } else {
                        result.setCode(600);
                        result.setError("租金不能为空");
                        result.setError_description("租金不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[6])) {
                        BsAreaExample bsAreaExample = new BsAreaExample();
                        bsAreaExample.createCriteria().andAreaNameLike("%" + str[6] + "%");
                        List<BsArea> bsAreas = bsAreaMapper.selectByExample(bsAreaExample);
                        if (bsAreas.stream().findFirst().isPresent()) {
                            transferShop.setAreaId(bsAreas.stream().findFirst().get().getAreaId());
                            transferShop.setProvinceId(17);
                            transferShop.setCityId(169);
                        }
                    } else {
                        result.setCode(600);
                        result.setError("区不能为空");
                        result.setError_description("区不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[7])) {
                        BsStreetExample streetExample = new BsStreetExample();
                        streetExample.createCriteria().andStreetNameLike("%" + str[7] + "%");
                        List<BsStreet> bsStreets = streetMapper.selectByExample(streetExample);
                        if (bsStreets.stream().findFirst().isPresent()) {
                            transferShop.setStreetId(bsStreets.stream().findFirst().get().getStreetId());
                        }
                    } else {
                        result.setCode(600);
                        result.setError("街道不能为空");
                        result.setError_description("街道不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[8])) {
                        transferShop.setAddress(str[8]);
                    } else {
                        result.setCode(600);
                        result.setError("店铺详细地址不能为空");
                        result.setError_description("店铺详细地址不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[9])) {
                        transferShop.setContacts(str[9]);
                    } else {
                        result.setCode(600);
                        result.setError("联系人不能为空");
                        result.setError_description("联系人不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[10])) {
                        transferShop.setTel(str[10]);
                        transferShop.setFakeTel("15629013877");
                    } else {
                        result.setCode(600);
                        result.setError("联系人手机号不能为空");
                        result.setError_description("联系人手机号不能为空");
                        return result;
                    }
                    transferShop.setRecommendType(0);
                    transferShop.setStatus(0);
                    transferShop.setCheckStatus(1);

                    transferShop.setCreateTime(new Date(date));
                    transferShop.setUpdateTime(new Date(date));
                    transferShop.setShopSn((IdUtil.getId() + 1) + "");
                    transferShop.setMediumStatus(0);
                    if (BeanUtils.isNotEmpty(str[11])) {
                        ShopRentTypeExample shopRentTypeExample = new ShopRentTypeExample();
                        shopRentTypeExample.createCriteria().andShopRentTypeEqualTo(str[11]);
                        List<ShopRentType> shopRentTypes = shopRentTypeMapper.selectByExample(shopRentTypeExample);
                        if (shopRentTypes.stream().findFirst().isPresent()) {
                            transferShop.setShopRentTypeId(shopRentTypes.stream().findFirst().get().getId());
                        } else {
                            ShopRentType shopRentType = new ShopRentType();
                            shopRentType.setId(IdUtil.getId());
                            shopRentType.setShopRentType(str[11]);
                            shopRentTypeMapper.insert(shopRentType);
                            transferShop.setShopRentTypeId(shopRentType.getId());
                        }
                    }
                    if (BeanUtils.isNotEmpty(str[12])) {
                        transferShop.setStartFloor(Integer.parseInt(str[12]));
                    }
                    if (BeanUtils.isNotEmpty(str[13])) {
                        /*PropertyTypeExample propertyTypeExample = new PropertyTypeExample();
                        propertyTypeExample.createCriteria().andPropertyTypeEqualTo(str[13]);
                        List<PropertyType> propertyTypes = propertyTypeMapper.selectByExample(propertyTypeExample);
                        if (propertyTypes.stream().findFirst().isPresent()) {
                            transferShop.setPropertyTypeId(propertyTypes.get(0).getId());
                        } else {
                            PropertyType propertyType = new PropertyType();
                            propertyType.setId(id);
                            propertyType.setPropertyType(str[13]);
                            propertyTypeMapper.insert(propertyType);
                            transferShop.setPropertyTypeId(propertyType.getId());
                        }*/
                        transferShop.setEndFloor(Integer.parseInt(str[13]));
                    }
                    if (BeanUtils.isNotEmpty(str[14])) {
                        DecorateTypeExample decorateTypeExample = new DecorateTypeExample();
                        decorateTypeExample.createCriteria().andDecorateTypeEqualTo(str[14]);
                        List<DecorateType> decorateTypes = decorateTypeMapper.selectByExample(decorateTypeExample);
                        if (BeanUtils.isNotEmpty(decorateTypes)) {
                            transferShop.setDecorateTypeId(decorateTypes.get(0).getId());
                        } else {
                            DecorateType decorateType = new DecorateType();
                            decorateType.setId(id);
                            decorateType.setDecorateType(str[14]);
                            decorateTypeMapper.insert(decorateType);
                            transferShop.setDecorateTypeId(decorateType.getId());
                        }
                    }
                    if (BeanUtils.isNotEmpty(str[15])) {
                        transferShop.setGateWidth(Long.valueOf(str[15]));
                    }
                    if (BeanUtils.isNotEmpty(str[16])) {
                       /* OrientationExample orientationExample = new OrientationExample();
                        orientationExample.createCriteria().andOrientationDescEqualTo(str[16]);
                        List<Orientation> orientations = orientationMapper.selectByExample(orientationExample);
                        if (BeanUtils.isNotEmpty(orientations)) {
                            transferShop.setOrientationId(orientations.get(0).getId());
                        } else {
                            Orientation orientation = new Orientation();
                            orientation.setId(id);
                            orientation.setOrientationDesc(str[16]);
                            orientationMapper.insert(orientation);
                            transferShop.setOrientationId(orientatiflon.getId());
                        }*/
                        transferShop.setFloorNumber(Integer.valueOf(str[16]));

                    }
                    if (BeanUtils.isNotEmpty(str[17])) {
                        transferShop.setHigh(Integer.valueOf(str[17]));
                    }
                    if (BeanUtils.isNotEmpty(str[18])) {
                        transferShop.setDepth(Integer.valueOf(str[18]));
                    }
                    if (BeanUtils.isNotEmpty(str[19])) {
                        String[] split = str[19].split("\\/");
                        for (int j = 0; j < split.length; j++) {
                            id++;
                            TransferShopBaseIcon transferShopBaseIcon = new TransferShopBaseIcon();
                            transferShopBaseIcon.setId(id++);
                            transferShopBaseIcon.setTransferShopId(transferShop.getId());
                            transferShopBaseIcon.setBaseIconId(Long.valueOf(split[j]));
                            transferShopBaseIcons.add(transferShopBaseIcon);
                        }
                    }
                    if (BeanUtils.isNotEmpty(str[20])) {
                        transferShop.setTransferFee(Long.parseLong(str[20]));
                    }


                    transferShopMapper.insert(transferShop);
                    System.out.println(transferShop);

                    for (TransferImage transferImage:transferImages) {
                        transferImageMapper.insert(transferImage);
                    }
                    for (TransferShopBusiness transferShopBusines:transferShopBusinesses) {
                        transferShopBusinessMapper.insert(transferShopBusines);
                    }
                    for (TransferShopBaseIcon transferShopBaseIcon:transferShopBaseIcons) {
                        transferShopBaseIconMapper.insert(transferShopBaseIcon);
                    }
                    updateShopLon(transferShop.getId());
                    SolrDTO solrDTO = new SolrDTO();
                    solrDTO.setTransferShopId(transferShop.getId());
                    solrService.addSolr(solrDTO);

                }
            } catch (IOException e) {
                log.error("上传excel失败", e.getMessage());
            }
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        return result;
    }

    private static MultipartFile getMulFileByPath(String picPath) {
        FileItem fileItem = createFileItem(picPath);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        return mfile;
    }

    private static FileItem createFileItem(String filePath) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        FileItem item = factory.createItem(textFieldName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                    != -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public ResponseResult uploadAddress(String address) {
        ResponseResult result = new ResponseResult();
        MultipartFile mulFileByPath = getMulFileByPath(address);
        UploadName upload = upload(mulFileByPath);
        result.setData(upload);
        return result;
    }

    private void updateShopLon(Long id) {
        StringBuffer sb = new StringBuffer();
        TransferShop transferShop = transferShopMapper.selectByPrimaryKey(id);
        BsProvince bsProvince = bsProvinceMapper.selectByPrimaryKey(transferShop.getProvinceId());
        if (BeanUtils.isNotEmpty(bsProvince)) {
            sb.append(bsProvince.getProvinceName());
        }
        BsCity bsCity = bsCityMapper.selectByPrimaryKey(transferShop.getCityId());
        if (BeanUtils.isNotEmpty(bsCity)) {
            sb.append(bsCity.getCityName());
        }
        BsArea bsArea = bsAreaMapper.selectByPrimaryKey(transferShop.getAreaId());
        if (BeanUtils.isNotEmpty(bsArea)) {
            sb.append(bsArea.getAreaName());
        }
        sb.append(transferShop.getAddress());
        List<String> lon = GaoDeUtil.getLon(sb.toString());
        if (lon.size()>1){
            transferShop.setLon(lon.get(0));
            transferShop.setLat(lon.get(1));
        }
        transferShopMapper.updateByPrimaryKey(transferShop);
    }


    @Override
    @Transactional
    public ResponseResult uploadLookShop(MultipartFile file) {
        ResponseResult result = new ResponseResult();
        long id = IdUtil.getId();
        long date = 1561360888000l;
        int k = 0;
        int p = 0;
        String fileSuffix = FilenameUtils.getExtension(file.getOriginalFilename());
        if (fileSuffix.toLowerCase().equals("xls") || fileSuffix.toLowerCase().equals("xlsx")) {
            try {
                List<String> list = ExcelHelper.exportListFromExcel(file.getInputStream(), fileSuffix, 0);
                for (int i = 1; i < list.size(); i++) {

                    k++;
                    p++;
                   // System.out.println(i);
                    if (k % 20 == 0) {
                        date+= 86400000l;
                        // System.out.println("时间戳为:" + date);
                    }
                    String[] str = list.get(i).split("\\|", -1);
                    LookShop lookShop = new LookShop();
                    List<LookShopBusiness> lookShopBusinessList = new ArrayList<>();
                    lookShop.setId(id++);
                    lookShop.setCraeateTime(new Date(date));

                    if (BeanUtils.isNotEmpty(str[1])) {
                        lookShop.setTitle(str[1]);
                    } else {
                        result.setCode(600);
                        result.setError("找铺标题不能为空");
                        result.setError_description("找铺标题不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[2])) {
                        lookShop.setContacts(str[2]);
                    } else {
                        result.setCode(600);
                        result.setError("找铺姓名不能为空");
                        result.setError_description("找铺姓名不能为空");
                        return result;
                    }
                    lookShop.setClientId(234352265583616l);
                    lookShop.setProvinceId(17);
                    lookShop.setCityId(169);
                    lookShop.setAreaId(4096);
                   /* if (BeanUtils.isNotEmpty(str[3])) {
                        BsAreaExample bsAreaExample = new BsAreaExample();
                        bsAreaExample.createCriteria().andAreaNameLike("%" + str[3] + "%");
                        List<BsArea> bsAreas = bsAreaMapper.selectByExample(bsAreaExample);
                        if (bsAreas.stream().findFirst().isPresent()) {
                            lookShop.setAreaId(bsAreas.stream().findFirst().get().getAreaId());
                            lookShop.setProvinceId(17);
                            lookShop.setCityId(169);
                            lookShop.setAreaId(4096
                            );
                        }
                    } else {
                        result.setCode(600);
                        result.setError("找铺期望区域不能为空");
                        result.setError_description("找铺期望区域不能为空");
                        return result;
                    }*/
                    if (BeanUtils.isNotEmpty(str[4])) {
                        BsStreetExample streetExample = new BsStreetExample();
                        streetExample.createCriteria().andStreetNameLike("%" + str[4] + "%");
                        List<BsStreet> bsStreets = streetMapper.selectByExample(streetExample);
                        if (bsStreets.stream().findFirst().isPresent()) {
                            lookShop.setStreetId(bsStreets.stream().findFirst().get().getStreetId());
                        }
                    } else {
                        result.setCode(600);
                        result.setError("街道不能为空");
                        result.setError_description("街道不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[5])) {
                        lookShop.setTopRent(Long.valueOf(str[5]));
                    } else {
                        result.setCode(600);
                        result.setError("最大租金不能为空");
                        result.setError_description("最大租金不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[6])) {
                        lookShop.setSmallRent(Long.valueOf(str[6]));
                    } else {
                        result.setCode(600);
                        result.setError("最小租金不能为空");
                        result.setError_description("最小租金不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[7])) {
                        lookShop.setTopArea(Long.valueOf(str[7]));
                    } else {
                        result.setCode(600);
                        result.setError("最大面积不能为空");
                        result.setError_description("最大面积不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[8])) {
                        lookShop.setSmallArea(Long.valueOf(str[8]));
                    } else {
                        result.setCode(600);
                        result.setError("最小面积不能为空");
                        result.setError_description("最小面积不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[9])) {
                        lookShop.setTel(str[9]);
                    } else {
                        result.setCode(600);
                        result.setError("联系电话不能为空");
                        result.setError_description("联系电话不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[10])) {
                        String[] split = str[10].split("\\/");
                        for (String name:split) {
                            BusinessTypeExample businessTypeExample = new BusinessTypeExample();
                            businessTypeExample.createCriteria().andBusinessTypeLike("%"+name+"%");
                            List<BusinessType> businessTypes = businessTypeMapper.selectByExample(businessTypeExample);
                            if (BeanUtils.isNotEmpty(businessTypes)) {
                                LookShopBusiness lookShopBusiness = new LookShopBusiness();
                                lookShopBusiness.setId(id++);
                                lookShopBusiness.setBusinessTypeId(businessTypes.get(0).getId());
                                lookShopBusiness.setLookShopId(lookShop.getId());
                                lookShopBusinessList.add(lookShopBusiness);
                            } else {
                                BusinessType businessType = new BusinessType();
                                businessType.setId(IdUtil.getId());
                                businessType.setBusinessType(name);
                                businessType.setParentId(1000L);
                                businessTypeMapper.insert(businessType);
                                LookShopBusiness lookShopBusiness = new LookShopBusiness();
                                lookShopBusiness.setId(id++);
                                lookShopBusiness.setBusinessTypeId(businessType.getId());
                                lookShopBusiness.setLookShopId(lookShop.getId());
                                lookShopBusinessList.add(lookShopBusiness);
                            }
                        }
                    } else {
                        result.setCode(600);
                        result.setError("计划经营不能为空");
                        result.setError_description("计划经营不能为空");
                        return result;
                    }
                    if (BeanUtils.isNotEmpty(str[11])) {
                        lookShop.setStartFloor(Integer.valueOf(str[11]));
                    }
                    if (BeanUtils.isNotEmpty(str[12])) {
                        lookShop.setEndFloor(Integer.valueOf(str[12]));
                    }
                    if (BeanUtils.isNotEmpty(str[13])) {
                        lookShop.setFloor((str[13]));
                    }
                    if (BeanUtils.isNotEmpty(str[14])) {
                        lookShop.setRequirementDetails((str[14]));
                    }
                    lookShopMapper.insert(lookShop);
                    for (LookShopBusiness lookShopBusiness:lookShopBusinessList) {
                        lookShopBusinessMapper.insert(lookShopBusiness);
                    }
                    SolrDTO solrDTO = new SolrDTO();
                    solrDTO.setLookShopId(lookShop.getId());
                    solrService.addSolr(solrDTO);
                }
            } catch (IOException e) {
                log.error("上传excel异常", e);
            }
        }
        return result;
    }
}
