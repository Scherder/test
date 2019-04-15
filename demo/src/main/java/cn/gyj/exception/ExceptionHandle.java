package cn.gyj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyj.model.ExceptionEnum;
import cn.gyj.model.Result;
import cn.gyj.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result exceptionGet(Exception e) {
		if(e instanceof DescribeException) {
			DescribeException de = (DescribeException) e;
			return ResultUtil.error(de.getCode(),de.getMessage());
		}
		System.out.println("【系统异常】");
		return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
	}
}
