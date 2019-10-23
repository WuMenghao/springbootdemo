package com.example.xl.demo.handler;


import com.example.xl.demo.entity.vo.ResponseVo;
import com.example.xl.demo.enums.ResultEnum;
import com.example.xl.demo.exceptions.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger =LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVo defaultErrorHandler(HttpServletRequest request,HttpServletRequest req,Exception e) {
        logger.error(">>>>>>系统异常：", e);
        SystemException exp = new SystemException(ResultEnum.SYSTEM_EXCEPTION, "系统繁忙，请稍后重试");
        return ResponseVo.exception(exp);
    }
}
