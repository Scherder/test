package cn.gyj.util;

import cn.gyj.model.ExceptionEnum;
import cn.gyj.model.Result;

public class ResultUtil {

	public static Result success(Object obj) {
		return new Result(0, "success", obj);
	}
	
	public static Result success() {
		return success(null);
	}
	
	public static Result error(Integer code, String message) {
		return new Result(code, message, null);
	}
	
	public static Result error(ExceptionEnum ee) {
		return new Result(ee.getCode(), ee.getMessage(), null);
	}
}
