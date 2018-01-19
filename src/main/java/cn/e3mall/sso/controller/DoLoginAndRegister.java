package cn.e3mall.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EmallResult;
import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.service.LoginAndRegisterService;

@Controller
public class DoLoginAndRegister {

	@Autowired
	private LoginAndRegisterService loginAndRegister;
	
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public EmallResult registerUser(TbUser user){
	return	loginAndRegister.createUser(user);
	}
	
	//登陆controller
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public EmallResult loginUser(String username,String password,
			HttpServletRequest request,HttpServletResponse response){
		EmallResult result = loginAndRegister.loginUser(username, password);
	String token= (String)result.getData();
	//把token的值写到cookie中，方面下次请求得时候携带cookie
	CookieUtils.setCookie(request, response, "token", token);
		return	result;
	}
	
}
