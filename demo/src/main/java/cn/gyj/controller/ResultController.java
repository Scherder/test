package cn.gyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyj.exception.ExceptionHandle;
import cn.gyj.model.ExceptionEnum;
import cn.gyj.model.Result;
import cn.gyj.model.user;
import cn.gyj.util.ResultUtil;

@RestController
@RequestMapping("/result")
public class ResultController {

	@Autowired
	private ExceptionHandle exceptionHandle;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/test/{name}/{pwd}")
	public Result test(@PathVariable String name, @PathVariable String pwd) throws Exception {
		Result result = ResultUtil.success();
		if(name.equals("gyj")) {
			result = ResultUtil.success(new user(name, pwd));
		}else if(name.equals("abc")){
			result = ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
		}else {
			int i = 1/0;
			System.out.println(i);
		}
		return result;
	}
}
