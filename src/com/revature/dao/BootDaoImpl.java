package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Boot;

public class BootDaoImpl implements BootDao {

	private List<Boot> bootCollection;

	public BootDaoImpl() {
		bootCollection = new ArrayList<>();
		bootCollection.add(new Boot(1, "Timberland", 9, "Brown", false));
		bootCollection.add(new Boot(2, "Martin's", 10, "Grey", false));
		bootCollection.add(new Boot(3, "Ambleside", 5, "Cognac", true));
		bootCollection.add(new Boot(4, "Combat Boot", 6, "Black", true));
		bootCollection.add(new Boot(5, "Riding Boot", 8, "Brown", true));
		bootCollection.add(new Boot(6, "Chukka Boot", 9, "Tan", false));
		bootCollection.add(new Boot(7, "Cowboy Boot", 13, "Brown", false));
		bootCollection.add(new Boot(8, "Jackboot", 10, "Green", false));
		bootCollection.add(new Boot(9, "Cowgirl Boot", 7, "Bourbon", true));
		bootCollection.add(new Boot(10, "Pullon", 5, "Grey", true));
	}

	@Override
	public List<Boot> getAllBoots() {
		return this.bootCollection;
	}

	@Override
	public Boot getBootById(int bootId) {
		for (Boot b : this.bootCollection) {
			if (b.getBootId() == bootId) {
				return b;
			}
		}
		return null;
	}

	@Override
	public int addBoot(Boot boot) {
		try {
			this.bootCollection.add(boot);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int updateBoot(Boot boot) {
		try {
			for (Boot b : this.bootCollection) {
				if (b == boot) {
					b.setBootType(boot.getBootType());
					b.setBootSize(boot.getBootSize());
					b.setBootColor(boot.getBootColor());
					b.setBootGender(boot.getBootGender());
					return 1;
				}
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteBoot(int bootId) {
		try {
			this.bootCollection.removeIf(b -> b.getBootId() == bootId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
