package com.pcx.wcnserver.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pcx.wcnserver.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Long>{

	@Query(nativeQuery = true, value = "select name from user ")
	List<String> findAllUserName();
	
	User findByName(String name);

}
