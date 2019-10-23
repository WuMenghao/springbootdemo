package com.example.xl.demo.exceptions;


import com.example.xl.demo.enums.ResultEnum;
import org.apache.commons.lang.StringUtils;

/**
 * 自定义异常类
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 异常代码
	 */
	private Integer code;
	/**
	 * 异常信息
	 */
	private String message;

	public SystemException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.message = resultEnum.getMessage();
		this.code = resultEnum.getCode();
	}

	public SystemException(ResultEnum resultEnum,String message) {
		super(message);
		this.message = StringUtils.isNotBlank(message) ? message : resultEnum.getMessage();
		this.code = resultEnum.getCode();
	}

	public SystemException(String message) {
		super(message);
		this.message = message;
		this.code = ResultEnum.FAILURE.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
