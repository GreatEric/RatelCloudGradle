package com.ratel.common.core.validator;

import com.ratel.common.core.exception.BizException;
import org.apache.commons.lang3.StringUtils;

/**
 * RatelCloud
 * @ClassName: Assert
 * @Package: com.ratel.common.core.validator
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 18/09/20
 * @Description: 断言处理
 * @Version: 1.0
 */
public abstract class Assert {
    public Assert() {
    }

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BizException(message, new Object[0]);
        }
    }

    public static void isNull(Object object, String message) {
        if (null == object) {
            throw new BizException(message, new Object[0]);
        }
    }

    public static void isNull(Object object, int code) {
        if (null == object) {
            throw new BizException(code);
        }
    }

    public static void isFalse(boolean boo, String message) {
        if (!boo) {
            throw new BizException(message, new Object[0]);
        }
    }

    public static void isFalse(boolean boo, int code) {
        if (!boo) {
            throw new BizException(code);
        }
    }

    public static void notBlank(String str, String message) {
        if (StringUtils.isNotBlank(str)) {
            throw new BizException(message, new Object[0]);
        }
    }

    public static void notNull(Object object, String message) {
        if (null != object) {
            throw new BizException(message, new Object[0]);
        }
    }

    public static void notFalse(boolean boo, String message) {
        if (boo) {
            throw new BizException(message, new Object[0]);
        }
    }

    public static void notFalse(boolean boo, int code) {
        if (boo) {
            throw new BizException(code);
        }
    }

    public static void isBlank(String str, String message, Object... args) {
        if (StringUtils.isBlank(str)) {
            throw new BizException(String.format(message, args), new Object[0]);
        }
    }

    public static void isBlank(String str, int code) {
        if (StringUtils.isBlank(str)) {
            throw new BizException(code);
        }
    }


    public static void isNull(Object object, String message, Object... args) {
        if (null == object) {
            throw new BizException(String.format(message, args), new Object[0]);
        }
    }

    public static void isFalse(boolean boo, String message, Object... args) {
        if (!boo) {
            throw new BizException(String.format(message, args), new Object[0]);
        }
    }

    public static void notBlank(String str, String message, Object... args) {
        if (StringUtils.isNotBlank(str)) {
            throw new BizException(String.format(message, args), new Object[0]);
        }
    }

    public static void notNull(Object object, String message, Object... args) {
        if (null != object) {
            throw new BizException(String.format(message, args), new Object[0]);
        }
    }

    public static void notNull(Object object, int code) {
        if (null != object) {
            throw new BizException(code);
        }
    }

    public static void notFalse(boolean boo, String message, Object... args) {
        if (boo) {
            throw new BizException(String.format(message, args), new Object[0]);
        }
    }
}