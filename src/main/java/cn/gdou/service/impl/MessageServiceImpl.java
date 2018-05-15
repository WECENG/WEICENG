package cn.gdou.service.impl;

import cn.gdou.model.Message;
import cn.gdou.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private Message message;

    @Override
    public String getMessage() {
        return message.getDate()+":  "+message.getContent();
    }

    @Override
    public void setMessage(String message) {
        this.message.setContent(message);
    }
}
