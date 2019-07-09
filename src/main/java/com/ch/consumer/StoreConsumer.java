package com.ch.consumer;

import com.ch.service.ViewTransferShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableJms
@Component
public class StoreConsumer {

    @Autowired
    ViewTransferShopService viewTransferShopService;

    @JmsListener(destination = "updateStoreLon")
    public void customer(String msg) {
        log.info("收到修改店铺经纬度MQ，id:[{}]", msg);
        try {
            viewTransferShopService.updateShopLon(Long.valueOf(msg));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("处理修改店铺经纬度MQ失败, orderId[{}]", msg);
        }
    }
}
