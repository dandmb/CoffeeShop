package com.dmb.coffee.shop.system.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailUtils {

    @Autowired
    private JavaMailSender mailSender;

    @Value("$(spring.mail.username)")
    private String fromMail;
    public void sendDimpleMail(String to, String subject, String text, List<String> list){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        if (list !=null && list.size()>0){

            message.setCc(getCcArray(list));
        }
        mailSender.send(message);

    }
    private String[] getCcArray(List<String> ccList){
        String[] cc=new String[ccList.size()];
        for (int i=0;i<ccList.size();i++){
            cc[i]= ccList.get(i);
        }
        return cc;
    }

}
