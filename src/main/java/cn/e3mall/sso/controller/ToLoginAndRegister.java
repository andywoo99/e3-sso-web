package cn.e3mall.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EmallResult;
import cn.e3mall.sso.service.InputCheckService;

@Controller
public class ToLoginAndRegister {
	@Autowired
	private InputCheckService inputCheck;
	
@RequestMapping("/page/login")
public String toLogin(){
	return "login";
}
@RequestMapping("/page/register")
public String toRegister(){
	return "register";
}
@RequestMapping("/user/check/{param}/{type}")
@ResponseBody
public EmallResult checkCount(@PathVariable String param,@PathVariable Integer type ){
	
	return inputCheck.checkCount(param, type);
}
}
