package com.ratel.common.core.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * RatelCloud
 *
 * @ClassName: MailService
 * @Package: com.ratel.common.core.mail
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 14/10/20
 * @Description: 邮件发送服务类
 * @Version: 1.0
 */
@Slf4j
public abstract class MailService {
    /**
     * 邮箱发送器
     */
    JavaMailSender sender;

    /**
     * 获取邮箱发送器
     */
    public JavaMailSender getSender() {
        return sender;
    }

    /**
     * 发送简单文本的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @return
     */
    public abstract boolean send(String from, String to, String subject, String content);

    /**
     * 发送 html 的邮件
     *
     * @param to
     * @param subject
     * @param html
     * @return
     */
    public abstract boolean sendWithHtml(String from, String to, String subject, String html);

    /**
     * 发送带有图片的 html 的邮件
     *
     * @param to
     * @param subject
     * @param html
     * @param cids
     * @param filePaths
     * @return
     */
    public abstract boolean sendWithImageHtml(String from, String to, String subject, String html, String[] cids, String[] filePaths);


    /**
     * 发送带有附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filePaths
     * @return
     */
    public abstract boolean sendWithWithEnclosure(String from, String to, String subject, String content, String[] filePaths);
}
