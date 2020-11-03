package com.ratel.common.core.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.validation.MessageInterpolator;
import java.util.Locale;

public class MessageInterpolatorAdapter implements MessageInterpolator {

    private MessageInterpolator defaultInterpolator;
    public MessageInterpolatorAdapter(MessageInterpolator interpolator) {
        this.defaultInterpolator = interpolator;
    }

    /**
     * 将用户的 locale 信息传递给消息解释器,而不是使用默认的 JVM locale 信息
     */
    @Override
    public String interpolate(String message, Context context) {
        return defaultInterpolator.interpolate(message, context, getRequestLocale());
    }

    @Override
    public String interpolate(String message, Context context, Locale locale) {
        return defaultInterpolator.interpolate(message, context, locale);
    }

    private Locale getRequestLocale() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            return LocaleContextHolder.getLocale();
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String acceptLang = StringUtils.isBlank(request.getHeader("lang")) ? request.getParameter("lang") : request.getHeader("lang");
        if (StringUtils.isBlank(acceptLang)) {
            return LocaleContextHolder.getLocale();
        }
        acceptLang = acceptLang.substring(0,2);
        if (acceptLang.equals("zh")) {
            return new Locale("zh");
        } else {
            return new Locale("en");
        }
    }
}
