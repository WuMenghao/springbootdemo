package com.example.xl.demo.enums;


/**
 * 响应枚举值
 *
 */
public enum ResultEnum {
	
	SUCCESS(200,"成功"),
	FAILURE(1000,"失败"),
    SYSTEM_EXCEPTION(9999,"系统异常"),
	
	USER_NOT_LOGIN(403,"用户未登录"),
	USER_NOT_POWER(404,"用户未授权"),
	USER_EXIST(405,"用户已存在"),
	USER_NOT_EXIST(406,"用户不存在"),


    REQUEST_PARAM_ERROR(1001,"请求参数错误"),
    REQUEST_PARAM_LACK(1002,"请求参数缺失"),
    TIME_FORMAT_ERROR(1003,"时间格式错误"),
    ;
    /**
     * 响应代码
     */
    private Integer code;
    
    /**
     * 响应信息
     */
    private String message;
    
    ResultEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code=code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message=message;
    }
}
