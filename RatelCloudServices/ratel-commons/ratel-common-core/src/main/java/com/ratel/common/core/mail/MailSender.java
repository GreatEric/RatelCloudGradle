package com.ratel.common.core.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailSender {
    private JavaMailSender gmailSender;
    private JavaMailSender tencentMailSender;

    public JavaMailSender getGmailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);

        /*mailSender.setUsername("o2pluscloud@gmail.com");
        mailSender.setPassword("Host123~");*/

        mailSender.setUsername("cheryleric0828@gmail.com");
        mailSender.setPassword("LZ20180828@#$");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.debug", "true");

        gmailSender = mailSender;
        return gmailSender;
    }

    public JavaMailSender getTencentMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(465);

        mailSender.setUsername("2305938446@qq.com");
        mailSender.setPassword("ijdcnmkwjdgcecgd");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.debug", "true");

        tencentMailSender = mailSender;
        return tencentMailSender;
    }
}
