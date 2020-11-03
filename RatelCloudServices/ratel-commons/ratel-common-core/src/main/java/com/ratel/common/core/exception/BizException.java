package com.ratel.common.core.exception;

public class BizException extends BaseException {
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_ERROR_CODE = 500;

    public BizException(int code) {
        super(code);
    }

    public BizException(String msg, Object... args) {
        super(500, null != args && args.length != 0 ? String.format(msg, args) : msg);
    }

    public BizException(int code, String msg, Object... args) {
        super(code, null != args && args.length != 0 ? String.format(msg, args) : msg);
    }

    public BizException(Throwable e, String msg, Object... args) {
        super(e, 500, null != args && args.length != 0 ? String.format(msg, args) : msg);
    }

    public BizException(Throwable e, int code, String msg, Object... args) {
        super(e, code, null != args && args.length != 0 ? String.format(msg, args) : msg);
    }
}
