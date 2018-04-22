package com.pcx.wcnserver.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pcx.wcnserver.entity.Friendly;

@Repository
public interface FriendlyDao extends JpaRepository<Friendly,Long>{

	@Query( value = "from Friendly where a_id=?1")
	List<Friendly> findAllUserFrinends(String id);

	@Query( value = "from Friendly where a_id=?1 and b_id=?2")
	Friendly findByABid(String a_id, String b_id);
	

}
