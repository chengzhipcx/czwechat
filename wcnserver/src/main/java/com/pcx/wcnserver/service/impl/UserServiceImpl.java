package com.pcx.wcnserver.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcx.wcnserver.Dao.FriendlyDao;
import com.pcx.wcnserver.Dao.UserDao;
import com.pcx.wcnserver.common.Md5Utils;
import com.pcx.wcnserver.entity.Friendly;
import com.pcx.wcnserver.entity.User;
import com.pcx.wcnserver.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private FriendlyDao friendlyDao;

	public String loginUser(String username, String password) {
		// 查找所有的用户名进行比对
		List<String> usernameAll = userDao.findAllUserName();
		if (usernameAll == null || !usernameAll.contains(username)) {
			return "用户不存在，请先注册";
		}
		// 根据用户名查找用户
		User findByName = userDao.findByName(username);
		if (!findByName.getPassword().equals(Md5Utils.encode(password))) {
			return "密码错误，请确认密码";
		}
		return "ok";
	}

	public String register(String username, String password) throws Exception {
		// 查找所有的用户名进行比对
		List<String> usernameAll = userDao.findAllUserName();
		if (usernameAll == null || !usernameAll.contains(username)) {
			User user = new User();
			user.setName(username);
			user.setPassword(Md5Utils.generateMd5(password));
			userDao.save(user);
			return "注册成功！";
		} else {
			return "该用户名已经存在，请更换";
		}
	}

	public List<User> getUser() {
		List<User> findAll = userDao.findAll();
		return findAll;
	}

	public List<Friendly> getMyFriends(int id) {
		return friendlyDao.findAllUserFrinends(id + "");
	}

	public int getUserIdByUserName(String username) {
		List<String> usernameAll = userDao.findAllUserName();
		if (usernameAll == null || !usernameAll.contains(username)) {
			return 0;
		}
		// 根据用户名查找用户
		User findByName = userDao.findByName(username);
		long lid = findByName.getId();
		int id = (int) lid;
		return id;
	}
	
	@Transactional
	public String addFriends(int a_id, int b_id) {
		// 查找所有的用户名进行比对
		Friendly friendly=friendlyDao.findByABid(a_id+"",b_id+"");
		if (friendly != null ) {
			return "二位已是好友了,还加个啥玩意？";
		}
		Friendly f = new Friendly();
		f.setA_id(a_id+"");
		f.setB_id(b_id+"");
		f.setB_name("新加好友！");
		friendlyDao.save(f);
		return "恭喜已成功建立关系，喜欢就去追吧~";
	}
}
