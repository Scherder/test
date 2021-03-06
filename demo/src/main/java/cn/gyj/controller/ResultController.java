package cn.gyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.gyj.model.ExceptionEnum;
import cn.gyj.model.Result;
import cn.gyj.model.User;
import cn.gyj.service.DemoService;
import cn.gyj.util.ResultUtil;

@RestController
@RequestMapping("/result")
public class ResultController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/test/{name}/{pwd}")
	public Result test(@PathVariable String name, @PathVariable String pwd) {
		Result result = ResultUtil.success();
		if(name.equals("gyj")) {
			result = ResultUtil.success(new User(name, pwd));
		}else if(name.equals("abc")){
			result = ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
		}else {
			int i = 1/0;
			System.out.println(i);
		}
		return result;
	}
	
	@RequestMapping("/test1/{name}/{pwd}")
	public Result test1(@PathVariable String name, @PathVariable String pwd) {
		return demoService.checkUser(new User(name, pwd));
	}
}
