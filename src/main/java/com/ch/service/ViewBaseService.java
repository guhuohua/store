package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.model.ViewBrowseParam;
import com.ch.model.ViewFeedBackParam;
import com.ch.model.ViewWXLoginParam;

public interface ViewBaseService {

    /**
     * 发布店铺时经营范围数据
     * @return
     */
    ResponseResult businessTypeList();

    /**
     * 查询所有省级信息
     * @return
     */
    ResponseResult provinceList();

    /**
     * 根据省级code查询市级
     * @param code
     * @return
     */
    ResponseResult findCityByProvinceCode(String code);

    /**
     * 根据市级code查询区级
     * @param code
     * @return
     */
    ResponseResult findAreaByCityCode(String code);

    /**
     * 根据区级查询街道信息
     * @param code
     * @return
     */
    ResponseResult findStweetByAreaCode(String code);

    /**
     * 小程序发布店铺时店铺租铺类型
     * @return
     */
    ResponseResult shopRentTypeList();


    /**
     * 小程序发布店铺时店铺店铺类型
     * @return
     */
    ResponseResult shopTypeList();

    /**
     * 小程序发布店铺时店铺物业类型
     * @return
     */
    ResponseResult propertyTypeList();

    /**
     * 小程序发布店铺时店铺朝向
     * @return
     */
    ResponseResult orientation();


    /**
     * 小程序发布店铺时店铺环线
     * @return
     */
    ResponseResult lookLineList();


    /**
     * 小程序发布店铺时店铺地铁
     * @return
     */
    ResponseResult subwayLineList();

    /**
     * 小程序发布店铺时装修类型
     * @return
     */
    ResponseResult decorateType();

    /**
     * 小程序首页轮播图
     * @return
     */
    ResponseResult advert();


    /**
     * 微信授权登录
     * @param param
     * @return
     */
    ResponseResult wxLogin(ViewWXLoginParam param);

    /**
     * 保存用户浏览记录
     * @param userId
     */
    void saveBrowse(Long userId, ViewBrowseParam param);

    /**
     * 删除用户浏览记录
     * @param userId
     * @param param
     */
    void deleteBrowse(Long userId, ViewBrowseParam param);


    /**
     * 用户收藏
     * @param userId
     * @param param
     * @return
     */
    ResponseResult saveCollection(Long userId, ViewBrowseParam param);

    /**
     * 取消用户收藏
     * @param userId
     * @param param
     * @return
     */
    ResponseResult deleteCollection(Long userId, ViewBrowseParam param);


    /**
     * 意见反馈
     * @param userId
     * @param param
     * @return
     */
    ResponseResult feedBack(Long userId, ViewFeedBackParam param);


    /**
     * 重新同步所有solr
     */
    void solr();

    /**
     * 根据店铺ID同步solr
     * @param storeId
     */
    void solrByStoreId(Long storeId);
}
