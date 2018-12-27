package com.revature.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.bean.Boot;

public class BootDaoImpl implements BootDao {

	private List<Boot> bootCollection;
	private List<Integer> bootIdCollection;

	public BootDaoImpl() {
		bootCollection = new ArrayList<>();
		bootIdCollection = new ArrayList<>();
		bootCollection.add(new Boot(1, "Timberland", 9, "Brown", "Men's"));
		bootCollection.add(new Boot(2, "Martin's", 10, "Grey", "Men's"));
		bootCollection.add(new Boot(3, "Ambleside", 5, "Cognac", "Women's"));
		bootCollection.add(new Boot(4, "Combat Boot", 6, "Black", "Women's"));
		bootCollection.add(new Boot(5, "Riding Boot", 8, "Brown", "Women's"));
		bootCollection.add(new Boot(6, "Chukka Boot", 9, "Tan", "Men's"));
		bootCollection.add(new Boot(7, "Cowboy Boot", 13, "Brown", "Men's"));
		bootCollection.add(new Boot(8, "Jackboot", 10, "Green", "Men's"));
		bootCollection.add(new Boot(9, "Cowgirl Boot", 7, "Bourbon", "Women's"));
		bootCollection.add(new Boot(10, "Pullon", 5, "Grey", "Women's"));
		bootCollection.add(new Boot(11, "Cowboy", 8, "Red", "Children's"));
		bootCollection.add(new Boot(12, "Rain Boot", 4, "Green", "Children's"));
		bootCollection.add(new Boot(13, "Ankle Boot", 6, "Salmon", "Children's"));
		bootCollection.add(new Boot(14, "Knee-High", 7, "Light Grey", "Children's"));
		bootCollection.add(new Boot(15, "Winter Boot", 5, "Cyan", "Children's"));
		bootCollection.add(new Boot(16, "Hiking Boot", 10, "Yellow", "Children's"));
		this.refreshIdCollection();
	}
	
	public void refreshIdCollection() {
		this.bootIdCollection = new ArrayList<>();
		for (Boot b: this.bootCollection) {
			this.bootIdCollection.add(b.getBootId());
		}
		Collections.sort(this.bootIdCollection);
	}
	
	public int getNewId() {
		return this.bootIdCollection.get(this.bootIdCollection.size() - 1) + 1;
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
			int newId = this.getNewId();
			boot.setBootId(newId);
			this.bootCollection.add(boot);
			this.refreshIdCollection();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int updateBoot(Boot boot) {
		try {
			for (Boot b : this.bootCollection) {
				if (b.getBootId() == boot.getBootId()) {
					b.setBootType(boot.getBootType());
					b.setBootSize(boot.getBootSize());
					b.setBootColor(boot.getBootColor());
					b.setBootStyle(boot.getBootStyle());
					return 1;
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteBoot(int bootId) {
		try {
			int numBefore = this.bootCollection.size();
			this.bootCollection.removeIf(b -> b.getBootId() == bootId);
			int numAfter = this.bootCollection.size();
			if (numBefore > numAfter) {
				this.refreshIdCollection();
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
