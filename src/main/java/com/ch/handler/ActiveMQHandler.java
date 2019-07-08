package com.ch.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Slf4j
@Component
public class ActiveMQHandler {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    public void updateStoreLon(String queueName, Long id) {
        log.info("====>>> 非延迟任务:" + queueName + ",data:" + id);
        //获取连接工厂
        ConnectionFactory connectionFactory = jmsMessagingTemplate.getConnectionFactory();
        try {
            //获取连接
            assert connectionFactory != null;
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //获取session, true开启事务，false关闭事务
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 创建一个消息队列
            Destination destination = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            TextMessage message = session.createTextMessage(id.toString());
            //发送
            producer.send(message);
            session.commit();
            producer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
