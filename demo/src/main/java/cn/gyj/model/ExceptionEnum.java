package cn.gyj.model;

public enum ExceptionEnum {
	UNKNOW_ERROR(-1,"未知错误"),
	USER_NOT_FIND(-101,"用户不存在"),
	;
	private Integer code;
	private String message;
	
	private ExceptionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
