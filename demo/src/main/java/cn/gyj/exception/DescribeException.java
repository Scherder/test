package cn.gyj.exception;

import cn.gyj.model.ExceptionEnum;

public class DescribeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	public DescribeException(ExceptionEnum ee) {
		super(ee.getMessage());
		this.code = ee.getCode();
	}
	
	public DescribeException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
