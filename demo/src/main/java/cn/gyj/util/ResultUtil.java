package cn.gyj.util;

import cn.gyj.model.ExceptionEnum;
import cn.gyj.model.Result;

public class ResultUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Result success(Object obj) {
		Result result = new Result();
		result.setStatus(0);
		result.setMessage("success");
		result.setData(obj);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static Result success() {
		return success(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result error(Integer code, String message) {
		Result result = new Result();
		result.setStatus(code);
		result.setMessage(message);
		result.setData(null);
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Result error(ExceptionEnum ee) {
		Result result = new Result();
		result.setStatus(ee.getCode());
		result.setMessage(ee.getMessage());
		result.setData(null);
		return result;
	}
}
