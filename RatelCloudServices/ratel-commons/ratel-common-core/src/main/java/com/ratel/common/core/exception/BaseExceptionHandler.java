package com.ratel.common.core.exception;

import com.ratel.common.core.entities.I18n;
import com.ratel.common.core.entities.Rsp;
import com.ratel.common.core.entities.StatusEntity;
import com.ratel.common.core.enums.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * RatelCloud
 * @ClassName: BaseExceptionHandler
 * @Package: com.ratel.common.core.exception
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 16/09/20
 * @Description: 自定义异常处理基类
 * @Version: 1.0
 */
@Slf4j
public class BaseExceptionHandler {
     /**
      * @Author: Eric
      * @Date: 11:42 PM 16/09/20
      * @Description: 处理自定义的业务异常
      * @Param:
      * @Return:
      */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Rsp bizExceptionHandler(HttpServletRequest req, BizException e){
        StatusEntity entity = I18n.getMsg(e.getCode());
        log.error(entity.getMsg());
        return Rsp.builder().error(entity).build();
    }

     /**
      * @Author: Eric
      * @Date: 11:42 PM 16/09/20
      * @Description: 处理空指针的异常
      * @Param:
      * @Return:
      */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Rsp exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("Null pointer exception:",e);
        return Rsp.builder().error(I18n.getMsg(StatusCodeEnum.DataFormatError.getValue())).build();
    }

     /**
      * @Author: Eric
      * @Date: 11:43 PM 16/09/20
      * @Description: 处理其他异常
      * @Param:
      * @Return:
      */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Rsp exceptionHandler(HttpServletRequest req, Exception e){
        log.error("Unknown exception:",e);
        return Rsp.builder().error(I18n.getMsg(StatusCodeEnum.UnknownException.getValue())).build();
    }

    /*==============================================================================================================*/

    /**
     * IllegalArgumentException异常处理返回json
     * 返回状态码:400
     *//*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    public Rsp badRequestException(IllegalArgumentException e) {
        return defHandler("参数解析失败", e);
    }

    *//**
     * AccessDeniedException异常处理返回json
     * 返回状态码:403
     *//*
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class})
    public Result badMethodExpressException(AccessDeniedException e) {
        return defHandler("没有权限请求当前方法", e);
    }

    *//**
     * 返回状态码:405
     *//*
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return defHandler("不支持当前请求方法", e);
    }

    *//**
     * 返回状态码:415
     *//*
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return defHandler("不支持当前媒体类型", e);
    }

    *//**
     * SQLException sql异常处理
     * 返回状态码:500
     *//*
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class})
    public Result handleSQLException(SQLException e) {
        return defHandler("服务运行SQLException异常", e);
    }

    *//**
     * BusinessException 业务异常处理
     * 返回状态码:500
     *//*
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public Result handleException(BusinessException e) {
        return defHandler("业务异常", e);
    }

    *//**
     * IdempotencyException 幂等性异常
     * 返回状态码:200
     *//*
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IdempotencyException.class)
    public Result handleException(IdempotencyException e) {
        return Result.failed(e.getMessage());
    }

    *//**
     * 所有异常统一处理
     * 返回状态码:500
     *//*
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return defHandler("未知异常", e);
    }

    private Result defHandler(String msg, Exception e) {
        log.error(msg, e);
        return Result.failed(msg);
    }*/
}
