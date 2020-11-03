package com.ratel.common.core.email;

/**
 * RatelCloud
 * @ClassName: MailService
 * @Package: com.ratel.common.services
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 15/09/20
 * @Description: 邮件发送服务
 * @Version: 1.0
 */
public interface MailService {

     /**
      * @Author: Eric
      * @Date: 9:24 PM 15/09/20
      * @Description: 发送简单文本的邮件
      * @Param:
      * @Return:
      */
    boolean send(String to, String subject, String content);

     /**
      * @Author: Eric
      * @Date: 9:24 PM 15/09/20
      * @Description: 发送 html 的邮件
      * @Param:
      * @Return:
      */
    boolean sendWithHtml(String to, String subject, String html);

     /**
      * @Author: Eric
      * @Date: 9:24 PM 15/09/20
      * @Description: 发送带有图片的 html 的邮件
      * @Param:
      * @Return:
      */
    boolean sendWithImageHtml(String to, String subject, String html, String[] cids, String[] filePaths);

     /**
      * @Author: Eric
      * @Date: 9:24 PM 15/09/20
      * @Description: 发送带有附件的邮件
      * @Param:
      * @Return:
      */
    boolean sendWithWithEnclosure(String to, String subject, String content, String[] filePaths);
}
