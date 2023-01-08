package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("whatsAppService")
public class WhatsAppService implements MessageService{

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben WhatsApp servisiyim, size mesaj gönderiyorum : " + message.getMessage());

    }
}
