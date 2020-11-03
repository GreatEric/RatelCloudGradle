package com.ratel.common.core.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public final class MailFactory {
    public static int GMAIL = 1;
    public static int TENCENT = 2;

    private static MailFactory instance;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static MailService build(int type) {
        if (null != instance) {
            MailService service = null;
            MailSender sender = instance.getMailSender();
            switch (type) {
                case 1:
                    service = new GmailService(sender.getGmailSender());
                    break;
                case 2:
                    service = new TencentMailService(sender.getTencentMailSender());
                    break;
                default:
                    service = new GmailService(sender.getGmailSender());
                    break;
            }
            return service;
        }
        return null;
    }

    private MailSender getMailSender() {
        MailSender sender = new MailSender();
        return sender;
    }
}
