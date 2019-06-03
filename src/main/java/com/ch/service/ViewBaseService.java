package com.ch.service;

import com.ch.base.ResponseResult;

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
}
