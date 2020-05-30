package com.example.vo;

import com.example.constant.enums.ResultCode;
import lombok.Getter;

/**
 * @Author shf
 * @Date 2020/5/15 9:35
 */
@Getter
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS,data);
    }
    public  ResultVO(ResultCode resultCode,T data){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
        this.data=data;
    }
}

