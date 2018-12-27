package com.revature.dao;

import java.util.List;

import com.revature.bean.Boot;

public interface BootDao {
	
	List<Boot> getAllBoots();
	Boot getBootById(int bootId);
	int addBoot(Boot boot);
	int updateBoot(Boot boot);
	int deleteBoot(int bootId);

}
