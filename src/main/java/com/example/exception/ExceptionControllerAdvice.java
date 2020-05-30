package com.example.exception;

import com.example.vo.ResultVO;
import com.example.constant.enums.ResultCode;
import com.example.exception.exceptions.APIException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author shf
 * @Date 2020/5/15 8:41
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,error.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e){
        return new ResultVO<>(ResultCode.FAILED, e.getMessage());
    }
    @ExceptionHandler(NumberFormatException.class)
    public ResultVO<String> numberFormatExceptionHandler(NumberFormatException e){
        return new ResultVO<>(ResultCode.FAILED,e.getMessage());
    }
}
