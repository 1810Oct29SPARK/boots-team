package com.revature.bean;

public class Boot {
	
	private int bootId;
	private String bootType;
	private int bootSize;
	private String bootColor;
	private boolean bootGender;

	public Boot() {
		super();
	}

	public Boot(int bootId) {
		super();
		this.bootId = bootId;
	}

	public Boot(int bootId, String bootType, int bootSize, String bootColor, boolean bootGender) {
		super();
		this.bootId = bootId;
		this.bootType = bootType;
		this.bootSize = bootSize;
		this.bootColor = bootColor;
		this.bootGender = bootGender;
	}

	public int getBootId() {
		return bootId;
	}

	public void setBootId(int bootId) {
		this.bootId = bootId;
	}

	public String getBootType() {
		return bootType;
	}

	public void setBootType(String bootType) {
		this.bootType = bootType;
	}

	public int getBootSize() {
		return bootSize;
	}

	public void setBootSize(int bootSize) {
		this.bootSize = bootSize;
	}

	public String getBootColor() {
		return bootColor;
	}

	public void setBootColor(String bootColor) {
		this.bootColor = bootColor;
	}

	public boolean getBootGender() {
		return bootGender;
	}

	public void setBootGender(boolean bootGender) {
		this.bootGender = bootGender;
	}

	@Override
	public String toString() {
		return "Boot [bootId=" + bootId + ", bootType=" + bootType + ", bootSize=" + bootSize + ", bootColor="
				+ bootColor + ", bootGender=" + bootGender + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boot other = (Boot) obj;
		if (bootId != other.bootId)
			return false;
		return true;
	}

}
