package com.ch.base;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(solrCoreName = "collection1")
public class StoreSolrSchema {

    @Field
    @Id
    private String id;

    @Field
    private Long lookShopId;
    @Field
    private Long transferShopId;



    @Field
    private String storeImg;

    @Field
    private String storeName;

    @Field
    private Long originalPrice;

    @Field
    private Long presentPrice;

    @Field
    private String storeAddress;

    @Field
    private String username;

    /**
     * 店铺区域
     */
    @Field
    private Integer storeCategory;

    /**
     * 面积
     */
    @Field
    private Long storeArea;

    @Field
    private Integer sort;

    @Field
    private Integer provinceId;

    @Field
    private Integer areaId;

    @Field
    private Integer cityId;

    @Field
    private Integer streetId;

    /**
     * 0代表转铺，1代表找铺
     */
    @Field
    private Integer storeType;

    @Field
    private String longitude;

    @Field
    private String latitude;

    @Field
    private Long createTime;

    @Field
    private Integer storeStatus;

    @Field
    private Long maxStoreArea;

    @Field
    private Long minStoreArea;

    @Field
    private Long userId;

    @Field
    private String storeAttribute;

    @Field
    private Long dealDate;

    private Long loopLineId;

    private Long subwayLineId;

}
