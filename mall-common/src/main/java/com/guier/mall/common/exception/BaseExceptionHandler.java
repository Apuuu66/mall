package com.guier.mall.common.exception;

import com.guier.mall.common.entity.StatusCode;
import com.guier.mall.common.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {

    /***
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        return new Result(false, StatusCode.REMOTEERROR, e.getMessage());
    }
}
