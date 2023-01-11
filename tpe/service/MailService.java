package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mailService")
@Scope("prototype") // getBean() her çağrıldığında yeni obje getir.
public class MailService implements MessageService{

    @Value("${app.email}")
    private String email;  // email = "email@email.com"


    // Field Injection
//    @Autowired // Dependency Injection
//    @Qualifier("fileRepository")
//    private Repository repository;

    // Setter Injection
//    private Repository repository;
//
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }

    //Constructor Injection
    private Repository repository;
    @Autowired // Trick : Eğer class içinde 1 tane constructor varsa @Autowired a gerek yok.
    public MailService(@Qualifier("fileRepository") Repository repository) {
        this.repository = repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben Mail servisiyim, size mesaj gönderiyorum : " + message.getMessage());
        repository.saveMessage(message);
    }
}
