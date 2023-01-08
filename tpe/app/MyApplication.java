package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Siparişler kargoya verildi");

        // !! Config dosyamı gösterdim

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    // bean talep ediyoruz, interface yapısı olunca hangi child'ı bean olarak oluşturacağını anlıyamadığı için
        // exception fırlatır.

//    MessageService service = context.getBean(MessageService.class);

    MessageService service = context.getBean("mailService", MessageService.class);
    MessageService service2 = context.getBean("mailService", MessageService.class);

    if (service==service2){
        System.out.println("Aynı");
    }else {
        System.out.println("Farklı");
    }



    service.sendMessage(message);

    context.close();  // programı kapatırken oluşan beanları yok ediyoruz.

    }
}
