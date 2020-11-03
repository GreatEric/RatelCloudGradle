package com.ratel.common.core.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * RatelCloud
 * @ClassName: I18n
 * @Package: com.ratel.common.msg
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 15/09/20
 * @Description: I18N国际化消息
 * @Version: 1.0
 */
@Component
public class I18n {
    @Autowired
    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        I18n.messageSource = messageSource;
    }

     /**
      * @Author: Eric
      * @Date: 10:15 PM 15/09/20
      * @Description: 获取当前语言
      * @Param:
      * @Return:
      */
    public static Locale getCurrentRequestLocale(){
        Locale locale = LocaleContextHolder.getLocale();
        return locale;
    }

     /**
      * @Author: Eric
      * @Date: 10:15 PM 15/09/20
      * @Description: 获取指定request的语言
      * @Param:
      * @Return:
      */
    public static Locale getSpecifiedRequestLocale(HttpServletRequest request){
        Locale locale = RequestContextUtils.getLocale(request);
        return locale;
    }

     /**
      * @Author: Eric
      * @Date: 10:15 PM 15/09/20
      * @Description: 获取单个国际化翻译值
      * @Param:
      * @Return:
      */
    public static StatusEntity getMsg(int code) {
        StatusEntity msg = new StatusEntity();
        msg.setCode(code);
        try {
            msg.setMsg(messageSource.getMessage(String.valueOf(code), null, LocaleContextHolder.getLocale()));
            return msg;
        } catch (Exception e) {
            msg.setMsg(String.valueOf(code));
            return msg;
        }
    }
}
