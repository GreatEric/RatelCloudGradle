package com.ratel.common.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

/**
 * RatelCloud
 * @ClassName: MsgEnum
 * @Package: com.ratel.common.enums
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 15/09/20
 * @Description: 自定义消息枚举
 * https://baomidou.com/guide/enum.html#jackson
 * @Version: 1.0
 */
@Getter
public enum StatusCodeEnum {
    /************************************************ 标准错误代码: start **************************************************/
    DataFormatError(400,""),
    /**
     * Token验证失败
     */
    InvalidToken(401, ""),
    /**
     * Not Found
     */
    NotFound(404,""),
    /************************************************ 标准错误代码: end **************************************************/

    /********************************************** 自定义错误代码: start **************************************************/
    /**
     * 请求成功
     */
    Success(1000, ""),
    /**
     * 验证码验证失败
     */
    InvalidCaptcha(1001,""),
    /**
     * 用户名或密码错误
     */
    IncorrectAccountOrPwd(1002,""),
    /**
     * 账户被锁定
     */
    AccountLocked(1003,""),
    /**
     * 数据已存在
     */
    RecordAlreadyExists(1004,""),
    /**
     * 没有权限
     */
    PermissionDenied(1005,""),
    /**
     * 未知异常
     */
    UnknownException(1006,""),
    /**
     * 令牌生成失败
     */
    TokenGenerationFailed(1007,""),
    /**
     * 超出权限
     */
    PermissionExceeded(1008,""),
    /**
     * 数据插入出错
     */
    DataInsertError(1009,""),
    /**
     * 数据插入出错
     */
    AccountNotExist(1010,""),
    /**
     * 验证邮件已过期
     */
    RetrieveEmailExpired(1011,""),
    /**
     * SID不完整
     */
    IncompleteSID(1012,""),
    /**
     * SID不正确
     */
    InvalidSID(1013,""),
    /**
     * 无效链接
     */
    InvalidLink(1014,""),
    /**
     * 验证失败
     */
    VerificationFailed(1015,""),
    /**
     * 用户名为空
     */
    EmptyAccoutField(1016,""),
    /**
     * 密码为空
     */
    EmptyPWDField(1017,""),
    /**
     * 账户已经存在
     */
    AccountAlreadyExists(1018,""),
    /**
     * 确认邮件已经发送
     */
    ConfirmationEmailHasAlreadyBeenSent(1019,""),
    /**
     * 已经绑定手机号
     */
    AlreadyBoundPhone(1020,""),
    /**
     * CrownCode字段为空
     */
    EmptyCrownCodeField(1021,""),
    /**
     * 手机号字段为空
     */
    EmptyPhoneNumField(1022,""),
    /**
     * 手机号已经存在
     */
    PhoneNumberHasBeenBound(1023,""),
    /**
     * 手机号格式错误
     */
    InvalidPhoneNumberFormat(1024,""),
    /**
     * vendorcode 字段为空
     */
    EmptyVendorCodeField(1025,""),
    /**
     * 手机号或者邮箱已经存在
     */
    EmailOrPhoneNumAlreadyExists(1026,""),
    /**
     * 分布式锁为空
     */
    NullDistributedLock(1027,""),
    /**
     * 锁等待超时
     */
    LockWaitingTimeOut(1028,""),
    /**
     * 包含非法字符
     */
    ContainsIllegalCharacters(1029,""),
    /**
     * 未定义的查询关系
     */
    UndefinedQueryRelationship(1030,"");
    /********************************************** 自定义错误代码: end **************************************************/

    private final int value;
    private final String msg;

    private StatusCodeEnum(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    @JsonCreator
    public static StatusCodeEnum getByValue(Integer value) {
        if (null != value) {
            for (StatusCodeEnum o : StatusCodeEnum.values()) {
                if (o.value == value) {
                    return o;
                }
            }
        }
        return null;
    }
}