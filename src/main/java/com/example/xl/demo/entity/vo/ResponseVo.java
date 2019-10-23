package com.example.xl.demo.entity.vo;


import com.example.xl.demo.enums.ResultEnum;
import com.example.xl.demo.exceptions.SystemException;

import java.io.Serializable;

/**
 * 请求响应VO
 *
 * @author wmh
 */
public class ResponseVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 响应码 */
	private Integer code;

	/** 响应信息 */
	private String message;

	/** 响应数据 */
	private Object data;

	private ResponseVo(ResultEnum resultEnum,Object data) {
		this.code=resultEnum.getCode();
		this.message=resultEnum.getMessage();
		this.data=data;
	}

	private ResponseVo(Integer code,String message,Object data) {
		this.code=code;
		this.message=message;
		this.data=data;
	}

	public static ResponseVo exception(SystemException exp) {
		return new ResponseVo(exp.getCode(),exp.getMessage(),null);
	}


	public static ResponseVo success(Object data) {
		return new ResponseVo(ResultEnum.SUCCESS,data);
	}

	public static ResponseVo success() {
		return new ResponseVo(ResultEnum.SUCCESS,null);
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data=data;
	}
}
