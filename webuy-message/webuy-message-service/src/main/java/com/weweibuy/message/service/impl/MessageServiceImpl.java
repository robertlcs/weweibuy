package com.weweibuy.message.service.impl;

import com.weweibuy.message.common.model.po.WebuyMessage;
import com.weweibuy.message.common.model.po.WebuyMessageExample;
import com.weweibuy.message.service.MessageService;
import com.weweibuy.message.service.base.impl.BaseServiceImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消息服务类
 * @ClassName MessageServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/10/14 16:10
 **/
@Service
public class MessageServiceImpl  extends BaseServiceImpl<WebuyMessage, WebuyMessageExample> implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息到 broker, 跟改消息为已发送
     * @param message
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendMessage(WebuyMessage message) {
        WebuyMessage message1 = new WebuyMessage();
        message1.setMessageStatus((byte)1);
        message1.setId(message.getId());
        updateByPrimaryKeySelective(message1);
    }
}
