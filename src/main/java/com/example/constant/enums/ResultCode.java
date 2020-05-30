package com.example.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author shf
 * @Date 2020/5/15 9:41
 */
@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(200,"执行成功"),
    FAILED(400,"响应失败"),
    VALIDATE_FAILED(403,"参数效验失败"),
    ERROR(401,"未知错误"),
    DELETE(202,"删除成功"),
    UPDATE(201,"修改成功"),
    SAVE(203,"添加成功");
    private final int code;
    private final String msg;
}
