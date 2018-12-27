package com.revature.service;

import java.util.List;

import com.revature.bean.Boot;
import com.revature.dao.BootDao;
import com.revature.dao.BootDaoImpl;

public class BootService {

	private BootDao bd;

	public BootService() {
		super();
		bd = new BootDaoImpl();
	}

	public List<Boot> getAllBoots() {
		return bd.getAllBoots();
	}

	public Boot getBootById(int bootId) {
		return bd.getBootById(bootId);
	}

	public boolean addBoot(Boot boot) {
		if (boot.getBootSize() < 0) {
			return false;
		}

		if (bd.addBoot(boot) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateBoot(Boot boot) {
		if (boot.getBootSize() < 0) {
			return false;
		}

		if (bd.updateBoot(boot) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteBoot(Boot boot) {
		if (bd.deleteBoot(boot.getBootId()) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
