package com.pcx.wcnserver.service;

import java.util.List;

import com.pcx.wcnserver.entity.Friendly;
import com.pcx.wcnserver.entity.User;

public interface IUserService {
	public String loginUser(String username,String password);

	public String register(String username, String password) throws Exception;

	public List<User> getUser();

	public List<Friendly> getMyFriends(int id);

	public int getUserIdByUserName(String username);

	public String addFriends(int a_id, int b_id);
}
