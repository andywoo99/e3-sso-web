package cn.e3mall.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EmallResult;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.sso.service.TokenService;

@Controller
public class TokenController {
@Autowired
private TokenService tokenService;

@RequestMapping(value="/user/token/{token}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public String getUserByToken(@PathVariable String token,String callback){
	EmallResult result = tokenService.getUserByToken(token);
	//响应前，判断是否是jsonp请求，如果是，则返回一段js代码
	//callback(data);
	if (StringUtils.isNotBlank(callback)) {
		return callback+"("+JsonUtils.objectToJson(result)+");";
	}
	
	return JsonUtils.objectToJson(result);
}
}
