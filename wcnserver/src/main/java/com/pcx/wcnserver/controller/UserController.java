package com.pcx.wcnserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcx.wcnserver.common.MsgEntity;
import com.pcx.wcnserver.entity.Friendly;
import com.pcx.wcnserver.entity.User;
import com.pcx.wcnserver.service.IUserService;

/**
 * @author 
 *
 */
@Controller
@RequestMapping("/user")
public class UserController{

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = { "/login"})
	@ResponseBody
	public MsgEntity login(String username,String password) {
		MsgEntity msgEntity =new MsgEntity(1, userService.loginUser(username, password),userService.getUserIdByUserName(username));
		return msgEntity;
	}
	
	@RequestMapping(value = { "/register"})
	@ResponseBody
	public MsgEntity register(String username,String password) throws Exception {
		MsgEntity msgEntity =new MsgEntity(1, userService.register(username, password),"");
		return msgEntity;
	}
	
	@RequestMapping(value = { "/getFriends"})
	@ResponseBody
	public MsgEntity getFriends(int id) throws Exception {
		List<User> list = userService.getUser();
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		for (User user : list) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("id", user.getId());
			item.put("name", user.getName());
			item.put("phone",user.getName());
			item.put("amount", user.getName());
			data.add(item);
		}
		MsgEntity msgEntity =new MsgEntity(1, "ok",data);
		return msgEntity;
	}
	
	
	@RequestMapping(value = { "/getMyFriends"})
	@ResponseBody
	public MsgEntity getMyFriends(int id) throws Exception {
		List<Friendly> list = userService.getMyFriends(id);
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		for (Friendly user : list) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("id", user.getId());
			item.put("name", user.getB_id());
			item.put("phone",user.getB_name());
			item.put("amount", user.getB_name());
			data.add(item);
		}
		MsgEntity msgEntity =new MsgEntity(1, "ok",data);
		return msgEntity;
	}
	
	@RequestMapping(value = { "/addFriends"})
	@ResponseBody
	public MsgEntity addFriends(int a_id,int b_id) throws Exception {
		String s= userService.addFriends(a_id,b_id);
		MsgEntity msgEntity =new MsgEntity(1, s,null);
		return msgEntity;
	}
}