package com.ratel.common.core.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * RatelCloud
 * @ClassName: MailServiceImpl
 * @Package: com.ratel.common.services
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 15/09/20
 * @Description: 邮件发送服务类
 * @Version: 1.0
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {
    private MailProperties mailProperties;

    private JavaMailSender javaMailSender;

    public MailServiceImpl(){
        mailProperties = getMailProperties();
        javaMailSender = getJavaMailSender();
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("cheryleric0828@gmail.com");
        mailSender.setPassword("lz20180828");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public MailProperties getMailProperties(){
        MailProperties mailProperties = new MailProperties();
        mailProperties.setUsername("cheryleric0828@gmail.com");
        return mailProperties;
    }

     /**
      * @Author: Eric
      * @Date: 9:17 PM 15/09/20
      * @Description: 发送简单文本的邮件
      * @Param: to
      * @Param: subject
      * @Param: content
      * @Return:
      */
    @Override
    public boolean send(String to, String subject, String content) {
        log.info("Sending email to "+to);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailProperties.getUsername());
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try {
            javaMailSender.send(simpleMailMessage);
            log.info("Send the mail success ...");
        } catch (Exception e) {
            log.error("Send mail error: ", e);
            return false;
        }
        return true;
    }

     /**
      * @Author: Eric
      * @Date: 9:20 PM 15/09/20
      * @Description: 发送 html 的邮件
      * @Param:
      * @Return:
      */
    @Override
    public boolean sendWithHtml(String to, String subject, String html) {
        log.info("Sending email to "+to);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getUsername());
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(html, true);

            javaMailSender.send(mimeMessage);
            log.info("Send the mail success ...");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Send mail error: ", e);
            return false;
        }

        return true;
    }

     /**
      * @Author: Eric
      * @Date: 9:21 PM 15/09/20
      * @Description: 发送带有图片的 html 的邮件
      * @Param:
      * @Return:
      */
    @Override
    public boolean sendWithImageHtml(String to, String subject, String html, String[] cids, String[] filePaths) {
        log.info("Sending email to "+to);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getUsername());
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(html, true);

            for (int i = 0; i < cids.length; i++) {
                FileSystemResource file = new FileSystemResource(filePaths[i]);
                // addInline() 方法 cid 需要 html 中的 cid (Content ID) 对应，才能设置图片成功，
                mimeMessageHelper.addInline(cids[i], file);
            }

            javaMailSender.send(mimeMessage);
            log.info("Send the mail success ...");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Send mail error: ", e);
            return false;
        }
        return true;
    }

     /**
      * @Author: Eric
      * @Date: 9:22 PM 15/09/20
      * @Description: 发送带有附件的邮件
      * @Param:
      * @Return:
      */
    @Override
    public boolean sendWithWithEnclosure(String to, String subject, String content, String[] filePaths) {
        log.info("Sending email to "+to);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getUsername());
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content);

            for (int i = 0; i < filePaths.length; i++) {
                FileSystemResource file = new FileSystemResource(filePaths[i]);
                String attachementFileName = "附件" + (i + 1);
                mimeMessageHelper.addAttachment(attachementFileName, file);
            }

            javaMailSender.send(mimeMessage);
            log.info("Send the mail success ...");
        } catch (Exception e) {
            log.error("Send mail error: ", e);
            return false;
        }
        return true;
    }
}